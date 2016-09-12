grammar Bot;

@header {

import org.jpavlich.bot.*;

}



@parser::members {

private Bot bot;
//Map<String,Object> symbolTable=new HashMap<String,Object>();
public BotParser(TokenStream input, Bot bot) {
    this(input);
    this.bot = bot;
    
}

}

program: (sentence* function*  sentence*);

function: FUNCTION ID input_function definition;
definition:BRACKET_OPEN 
			sentence*
			BRACKET_CLOSE SEMICOLON;
input_function:PAR_OPEN input (COMMA input)* PAR_CLOSE;
input:VAR ID;
sentence: var_decl | var_assign | println | command | read | while_ | if_ | function_call | print;
command: north | east | pick | west | south | drop | look;

east returns [Object value]:EAST NUMBER{$value=Integer.parseInt($NUMBER.text);} SEMICOLON
	{bot.left((int)$value);};
north returns [Object value]:NORTH NUMBER{$value=Integer.parseInt($NUMBER.text);} SEMICOLON
	{bot.up((int)$value);};
west returns [Object value]:WEST NUMBER{$value=Integer.parseInt($NUMBER.text);} SEMICOLON
	{bot.right((int)$value);};
south returns [Object value]:SOUTH NUMBER{$value=Integer.parseInt($NUMBER.text);} SEMICOLON
	{bot.down((int)$value);};
pick:PICK SEMICOLON;
look:LOOK SEMICOLON;
drop:DROP SEMICOLON;

function_call:ID PAR_OPEN input_function_ PAR_CLOSE SEMICOLON;
input_function_:expression (COMMA expression)*;
expression:ID| NUMBER;
read:READ ID SEMICOLON;

while_: WHILE PAR_OPEN boolean_sentence PAR_CLOSE definition  ;
if_: IF PAR_OPEN boolean_sentence PAR_CLOSE definition  ;
boolean_sentence: boolean_condition ((AND|OR) boolean_condition )* ;
boolean_condition:PAR_OPEN* (NOT* element) | (element (NOT|GT|LG|GEQ|LEQ|EQ|NEQ) element) PAR_CLOSE*  ;
element: ID | math_operation;
math_operation: PAR_OPEN* (PLUS|MINUS)* (NUMBER|ID) PAR_CLOSE* ((PLUS|MINUS|MULT|DIV) PAR_OPEN* (NUMBER|ID) PAR_CLOSE* )* ;


println: PRINTLN print_ SEMICOLON;
print:PRINT print_ SEMICOLON;

var_decl: VAR   (ID SEMICOLON | var_assign);
var_assign: ID ASSIGN math_operation SEMICOLON ;

print_: ID | string ;
string: QUOTATION_MARKS ID* QUOTATION_MARKS;

//------------------
FUNCTION:'fun';
VAR:'var';
WHILE:'while';
IF:'if';

NORTH:'north';
EAST:'east';
PICK:'pick';
WEST:'west';
SOUTH:'south';
DROP:'drop';
READ:'read';
LOOK:'look';
PRINTLN:'println';
PRINT:'print';

PLUS:'+';
MINUS:'-';
MULT:'*';
DIV:'/';

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