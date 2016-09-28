grammar Bot;

@header {

import org.jpavlich.bot.*;
import java.util.HashMap;
import java.util.Map;
import co.edu.javeriana.bot.ast.*;

}



@parser::members {

private Bot bot;
//private Map<String,Object> symbolTable=new HashMap<String,Object>();
public BotParser(TokenStream input, Bot bot) {
    this(input);
    this.bot = bot;
    
}

}

program: {
			ProgramInfo programInfo = new ProgramInfo(bot);
			List<ASTNode> sentences=new ArrayList<ASTNode>();
		}
		(s1=sentence{sentences.add($s1.node);})*
		{
			for(ASTNode n:sentences){
				n.execute(programInfo.getSymbolTable(),programInfo);
			}
		};

function returns [ASTNode node]: {
			
		}
		FUNCTION ID input_function definition
		{
			$node = new Function($ID.text,$definition.body);
		}
		;
		
definition returns [List<ASTNode> body]:
			{
				$body=new ArrayList<ASTNode>();
			}
			BRACKET_OPEN 
			(s1=sentence{$body.add($s1.node);})*
			BRACKET_CLOSE;
input_function:PAR_OPEN input (COMMA input)* PAR_CLOSE;
input:VAR ID;
sentence returns [ASTNode node] : function {$node=$function.node;}
								| var_decl {$node=$var_decl.node;}
								| var_assign {$node=$var_assign.node;}
								| println {$node=$println.node;}
								| print {$node=$print.node;}
								| command {$node=$command.node;}
								| motionCommand {$node=$motionCommand.node;}
								| while_loop {$node=$while_loop.node;}
								| conditional {$node=$conditional.node;}
								//| function_call {$node=$function_call.node;}
								//| read {$node=$read.node;}
								;
								
command returns[ASTNode node] : {String commandName="";} 
								(
								PICK {commandName=$PICK.text;}
								| DROP {commandName=$DROP.text;} 
								| LOOK {commandName=$LOOK.text;}
								) SEMICOLON
								{$node=new Command(commandName);}
								;
motionCommand returns[ASTNode node] : {String commandName="";} 
										(NORTH {commandName=$NORTH.text;}
										| EAST {commandName=$EAST.text;}
										| WEST {commandName=$WEST.text;}
										| SOUTH{commandName=$SOUTH.text;}
										)
										expression SEMICOLON
										{$node=new MotionCommand(commandName,$expression.node);}
										 ;

expression returns [ASTNode node] : t1=factorMUlT{$node=$t1.node;} 
									(PLUS t2=factorMUlT{$node=new Addition($node,$t2.node);}
									|MINUS t2=factorMUlT{$node=new Subtraction($node,$t2.node);}
									)*;
factorMUlT returns[ASTNode node] : t1=factorDIV{$node=$t1.node;} 
									(MULT t2=factorDIV{$node=new Multiplication($node,$t2.node);}
									)*;
factorDIV returns[ASTNode node] : t1=factorEXP{$node=$t1.node;} 
								(DIV t2=factorEXP{$node=new Division($node,$t2.node);}
								)*;
factorEXP returns[ASTNode node] : t1=term{$node=$t1.node;} 
								(EXP t2=term{$node=new Exponential($node,$t2.node);}
								)*;
								
term returns [ASTNode node]:
				NUMBER{$node=new Constant(Integer.parseInt($NUMBER.text));}
				| ID {$node=new VarRef($ID.text);}
				| BOOLEAN{$node=new Constant(Boolean.parseBoolean($BOOLEAN.text));}
				| PAR_OPEN expression PAR_CLOSE {$node=($expression.node);}
				| string {$node=($string.node);}
			;
string returns [ASTNode node]: 
				{$node=new Constant("");}
				QUOTATION_MARKS (id=ID{$node=new AdditionString($node,new Constant($id.text));})* QUOTATION_MARKS;

while_loop  returns [ASTNode node]: WHILE PAR_OPEN expression PAR_CLOSE definition  
			{
				$node = new WhileLoop($expression.node,$definition.body);
			}
			;

conditional returns [ASTNode node]: IF PAR_OPEN expression PAR_CLOSE 
				(body=definition)  	 
				ELSE 
				(elsebody=definition) 
				 {
				 	$node=new Conditional($expression.node,$body.body,$elsebody.body);
				 }
				  ;

println returns [ASTNode node]: PRINTLN expression SEMICOLON
			{
				$node=new Println($expression.node);
			};
print returns [ASTNode node]:PRINT expression SEMICOLON
			{
				$node=new Print($expression.node);
			};

var_decl returns [ASTNode node]: VAR (
								ID{$node=new VarDecl($ID.text);} SEMICOLON 
								| var_assign{$node=$var_assign.node;}
								);
var_assign returns [ASTNode node]: ID ASSIGN expression SEMICOLON 
		{$node=new VarAssign($ID.text,$expression.node);} ;

read:READ ID SEMICOLON;
function_call:ID PAR_OPEN input_function_ PAR_CLOSE SEMICOLON;
input_function_:expression (COMMA term)*;

//------------------
FUNCTION:'fun';
VAR:'var';
WHILE:'while';
IF:'if';
ELSE:'else'; 
BREAK:'break';
BOOLEAN: 'true' | 'false';

NORTH:'north';
EAST:'east';
WEST:'west';
SOUTH:'south';
DROP:'drop';
PICK:'pick';
LOOK:'look';
READ:'read';
PRINTLN:'println';
PRINT:'print';

PLUS:'+';
MINUS:'-';
MULT:'*';
DIV:'/';
EXP:'^';

AND:'and';
OR:'or';

NOT:'!';
GT:'>';
LG:'<';
GEQ:'>=';
LEQ:'<=';
EQ:'==';
NEQ:'<>';

ASSIGN:'=';

BRACKET_OPEN:'{';
BRACKET_CLOSE:'}';

PAR_OPEN:'(';
PAR_CLOSE:')';
QUOTATION_MARKS:'\"';
SEMICOLON:';';
COMMA:',';

ID:[a-zA-Z][a-zA-Z0-9]*;


NUMBER:[0-9]+;

WS
:
	[ \t\r\n]+ -> skip
;