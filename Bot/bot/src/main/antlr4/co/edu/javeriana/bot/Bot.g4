grammar Bot;

@header {

import org.jpavlich.bot.*;

}

@parser::members {

private Bot bot;

public BotParser(TokenStream input, Bot bot) {
    this(input);
    this.bot = bot;
}

}

start
:
	'hello' 'world' 
;

//PROGRAM:'program';
FUNCTION:'fun';
VAR:'var';
WHILE:'while';

NORTH:'north';
EAST:'east';
PICK:'pick';
WEST:'west';
SOUTH:'south';
DROP:'drop';
READ:'read';
PRINTLN:'println';

PLUS:'+';
MINUS:'-';
MULT:'*';
DIV:'/';

AND:'&&';
OR:'||';
NOT:'!';

GT:'>';
LG:'<';
GEQ:'>=';
LEQ:'<=';
EQ:'==';
NEQ:'<>';

ASSING:'=';

BRACKET_OPEN:'{';
BRACKET_CLOSE:'}';

PAR_OPEN:'(';
PAR_CLOSE:')';

SEMICOLON:';';

ID:[a-zA-Z][a-zA-Z0-9]*;
NUMBER:[0-9]+;

WS
:
	[ \t\r\n]+ -> skip
;