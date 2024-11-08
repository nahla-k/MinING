grammar MinING;

LBRACE: '{';          // Represents the `{` symbol for opening a block
RBRACE: '}';          // Represents the `}` symbol for closing a block
EQUAL: '=';           // Represents the assignment operator `=`
SEMICOLON: ';';       // Represents the end of an instruction `;`
AND: '&&';            // Represents logical AND
OR: '||';             // Represents logical OR
NOT: '!';             // Represents logical NOT
LT: '<';              // Represents less than `<`
LE: '<=';             // Represents less than or equal to `<=`
GT: '>';              // Represents greater than `>`
GE: '>=';             // Represents greater than or equal to `>=`
EQ: '==';             // Represents equality `==`
NEQ: '!=';            // Represents inequality `!=`
LPAREN: '(';          // Represents opening parenthesis `(`
RPAREN: ')';          // Represents closing parenthesis `)`
PLUS: '+';            // Represents addition `+`
MINUS: '-';           // Represents subtraction `-`
MULT: '*';            // Represents multiplication `*`
DIV: '/';             // Represents division `/`
TO: ':';
COMA: ',';
IF: 'IF';
ELSE: 'ELSE';
FOR: 'FOR';
WRITE: 'WRITE';
READ: 'READ';

COMMENT: '%%' ~[\r\n]* -> skip;
WS: [ \t\r\n]+ -> skip;

TYPE: 'INTEGER' | 'FLOAT' | 'CHAR';

NUM: INTEGER | FLOAT;

CONST: 'CONST';

prog: VAR_GLOBAL LBRACE declaration* RBRACE
     DECLARATION LBRACE declaration* RBRACE
     INSTRUCTION LBRACE instruction* RBRACE EOF; //i have to put eof or error handling won't work



declaration: TYPE VARLIST SEMICOLON
           | CONST TYPE VARLIST SEMICOLON;

expr: expr_logical;

expr_logical: expr_logical AND expr_logical
            | expr_logical OR expr_logical
            | NOT expr_logical
            | expr_comparison
            | expr_arith
            ;

expr_comparison: expr_arith (GT | LT | GE | LE | EQ | NEQ) expr_arith;

expr_arith: expr_arith (MULT | DIV) expr_arith
          | expr_arith (PLUS | MINUS) expr_arith
          | LPAREN expr_arith RPAREN
          | NUM
          | ID;

instruction: affectation | condition | boucle | entree | sortie;

sortie: WRITE LPAREN (STRING_LITERAL | ID) (COMA (STRING_LITERAL | ID))* RPAREN SEMICOLON;
entree: READ LPAREN   ID RPAREN SEMICOLON;
boucle: FOR LPAREN ID EQUAL (ID | INTEGER) TO (ID | INTEGER) TO (ID | INTEGER) block;
condition: IF LPAREN expr RPAREN block (ELSE block)? ;
affectation: ID EQUAL expr SEMICOLON;
block: LBRACE instruction* RBRACE;
VARLIST: ID (',' ID)*;

ID: [A-Z][a-z0-9]{0,7}
   | [A-Z][a-z0-9]{0,7} '[' INTEGER ']' ; //i have to make sure it's positive
INTEGER: [0-9]+
        | '(' [+-]? [0-9]+ ')'
        ; //i have to add a semantic action later to limit numbers
FLOAT: [0-9]+ '.' [0-9]+
     | '(' [+-]? [0-9]+ '.' [0-9] ')' ;
CHAR: '\'' . '\'';
STRING_LITERAL: '"' (~["\r\n])* '"';


VAR_GLOBAL: 'VAR_GLOBAL' ;
DECLARATION: 'DECLARATION';
INSTRUCTION: 'INSTRUCTION';


