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
				n.execute(programInfo.getSymbolTables(),programInfo);
			}
		};

function returns [ASTNode node]: {
			
		}
		FUNCTION ID input_function codeBlock SEMICOLON
		{
			$node = new Function($ID.text,$input_function.parameters,$codeBlock.body);
		}
		;
		
function_call returns [ASTNode node]:
			{
				List<ASTNode> expressions=new ArrayList<ASTNode>();
			}
			ID PAR_OPEN (e1=expression{expressions.add($e1.node);} (COMMA e2=expression{expressions.add($e2.node);})*)* PAR_CLOSE SEMICOLON
			{
				$node = new FunctionCall($ID.text,expressions);
			}
			;
function_call_whitout_semicolon returns [ASTNode node]:
			{
				List<ASTNode> expressions=new ArrayList<ASTNode>();
			}
			ID PAR_OPEN (e1=expression{expressions.add($e1.node);} (COMMA e2=expression{expressions.add($e2.node);})*)* PAR_CLOSE
			{
				$node = new FunctionCall($ID.text,expressions);
			}
			;

return_ returns [ASTNode node]: RETURN expression SEMICOLON
			{$node=new Return($expression.node);}
			;

codeBlock returns [CodeBlock body]:
			{
				$body=new CodeBlock();
			}
			BRACKET_OPEN 
			(s1=sentence{$body.add($s1.node);})*
			BRACKET_CLOSE;
input_function returns [List<String> parameters]: 
				{
					$parameters=new ArrayList<String>();
				}
				PAR_OPEN 
				in1=input{$parameters.add($in1.var_name);} (COMMA in2=input{$parameters.add($in2.var_name);})* PAR_CLOSE;
input returns [String var_name]: VAR ID{$var_name=$ID.text;};
sentence returns [ASTNode node] : function {$node=$function.node;}
								| var_decl {$node=$var_decl.node;}
								| var_assign {$node=$var_assign.node;}
								| println {$node=$println.node;}
								| print {$node=$print.node;}
								| while_loop {$node=$while_loop.node;}
								| conditional {$node=$conditional.node;}
								| function_call {$node=$function_call.node;}
								| read {$node=$read.node;}
								| pick {$node=$pick.node;}
								| drop {$node=$drop.node;}
								| look {$node=$look.node;}
								| north {$node=$north.node;}
								| south {$node=$south.node;}
								| west {$node=$west.node;}
								| east {$node=$east.node;}
								| expression {$node=$expression.node;}
								| return_ {$node=$return_.node;}
								;
								
pick returns[ASTNode node] : PICK SEMICOLON
								{$node=new Pick();}
								;
drop returns[ASTNode node] : DROP SEMICOLON
								{$node=new Drop();}
								;
look returns[ASTNode node] : LOOK SEMICOLON
								{$node=new Look();}
								;

north returns[ASTNode node] : NORTH expression SEMICOLON
								{$node=new North($expression.node);}
								;
								
south returns[ASTNode node] : SOUTH expression SEMICOLON
								{$node=new South($expression.node);}
								;
																
west returns[ASTNode node] : WEST expression SEMICOLON
								{$node=new West($expression.node);}
								;
								
east returns[ASTNode node] : EAST expression SEMICOLON
								{$node=new East($expression.node);}
								;									

expression returns [ASTNode node] : t1=factorAND{$node=$t1.node;} 
									(
									OR t2=factorAND{$node=new OR($node,$t2.node);}
									)*;
factorAND returns[ASTNode node] : t1=factorNOT{$node=$t1.node;} 
									(
									AND t2=factorNOT{$node=new AND($node,$t2.node);}
									)*;
factorNOT returns[ASTNode node] : ( NOT factorCOM {$node=new NOT($factorCOM.node);}
								  	|t2=factorCOM{$node=$t2.node;} 
									)
								;									
factorCOM returns[ASTNode node] : t1=factorSUM{$node=$t1.node;} 
									(GEQ t2=factorSUM{$node=new GEQ($node,$t2.node);}
									|LEQ t2=factorSUM{$node=new LEQ($node,$t2.node);}
									|NEQ t2=factorSUM{$node=new NEQ($node,$t2.node);}
									|LG t2=factorSUM{$node=new LG($node,$t2.node);}
									|GT t2=factorSUM{$node=new GT($node,$t2.node);}
									|EQ t2=factorSUM{$node=new EQ($node,$t2.node);}
									)*;

factorSUM returns[ASTNode node] : t1=factorMUlT{$node=$t1.node;} 
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
				NUMBER{$node=new Constant(Double.parseDouble($NUMBER.text));}
				|MINUS NUMBER{$node=new Constant(-Integer.parseInt($NUMBER.text));}
				| ID {$node=new VarRef($ID.text);}
				| BOOLEAN{$node=new Constant(Boolean.parseBoolean($BOOLEAN.text));}
				| PAR_OPEN expression PAR_CLOSE {$node=($expression.node);}
				| string {$node=($string.node);}
				| function_call_whitout_semicolon{$node=$function_call_whitout_semicolon.node;}
			;
string returns [ASTNode node]: 
				STRING{$node=new Constant(((String)$STRING.text).replace("\"",""));}
				;

while_loop  returns [ASTNode node]: WHILE PAR_OPEN expression PAR_CLOSE codeBlock SEMICOLON
			{
				$node = new WhileLoop($expression.node,$codeBlock.body);
			}
			;

conditional returns [ASTNode node]:IF PAR_OPEN expression PAR_CLOSE 
				(body=codeBlock) 
				(ELSE (elsebody=codeBlock) SEMICOLON
					 {
					 	$node=new Conditional($expression.node,$body.body,$elsebody.body);
					 }
				 |SEMICOLON
					 {
					 	$node=new Conditional($expression.node,$body.body,null);
					 }
				 )
				  ;

println returns [ASTNode node]: PRINTLN expression SEMICOLON
			{
				$node=new Println($expression.node);
			};
print returns [ASTNode node]:PRINT expression SEMICOLON
			{
				$node=new Print($expression.node);
			};
			
read returns [ASTNode node]:READ ID SEMICOLON
			{
				$node=new Read($ID.text);	
			};
			


var_decl returns [ASTNode node]: VAR (
								ID{$node=new VarDecl($ID.text,new Constant(0));} SEMICOLON 
								| ID ASSIGN expression SEMICOLON {$node=new VarDecl($ID.text,new VarAssign($ID.text,$expression.node));}
								);
								
								
								
var_assign returns [ASTNode node]: ID ASSIGN 
		(
		 expression SEMICOLON {$node=new VarAssign($ID.text,$expression.node);} 
		 )
		;



//------------------

STRING:'"' ~('"')* '"';
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
RETURN:'return';

PLUS:'+';
MINUS:'-';
MULT:'*';
DIV:'/';
EXP:'^';

AND:'and';
OR:'or';
NOT:'not';

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


NUMBER:[0-9]([0-9]*|'.'[0-9]*);

WS
:
	[ \t\r\n]+ -> skip
;