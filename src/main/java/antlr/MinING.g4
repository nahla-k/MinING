grammar MinING;

LBRACE: '{';
RBRACE: '}';
EQUAL: '=';
SEMICOLON: ';';
AND: '&&';
OR: '||';
NOT: '!';
LT: '<';
LE: '<=';
GT: '>';
GE: '>=';
EQ: '==';
NEQ: '!=';
LPAREN: '(';
RPAREN: ')';
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
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



ID: [A-Z]([a-z]|[0-9])* ;

INTEGER: [0-9]+
        | '(' [+-]? [0-9]+ ')'
        ; //i have to add a semantic action later to limit numbers
FLOAT: [0-9]+ '.' [0-9]+
     | '(' [+-]? [0-9]+ '.' [0-9] ')' ;
CHAR: '\'' . '\'';
STRING_LITERAL: '"' (~["\r\n])* '"';


VAR_GLOBAL: 'VAR_GLOBAL' ;
DECLARATION: 'DECLARATION';
INSTRUCTIONS: 'INSTRUCTION';



prog: VAR_GLOBAL LBRACE globaldeclaration* RBRACE
     DECLARATION LBRACE localdeclaration* RBRACE
     INSTRUCTIONS block EOF; //i have to put eof or error handling won't work


globaldeclaration: declaration;
localdeclaration: declaration;
declaration: TYPE indexing (EQUAL initialValue)? (COMA indexing (EQUAL initialValue)?)* SEMICOLON
           | CONST TYPE indexing EQUAL (initialValue) (COMA indexing EQUAL initialValue)* SEMICOLON;
indexing
    : ID ('[' (expr_arith) ']')?
    ; //to be able to manage arrays with arithmetic expressions as indexes (used as an id for a normal variable too)
array_init: '[' (expr_arith) (',' (expr_arith))* ']' ;
expr: expr_logical;
initialValue:expr_arith|array_init|STRING_LITERAL;
expr_logical:expr_comparison
            |expr_logical AND expr_logical
            | expr_logical OR expr_logical
            | NOT expr_logical
            | LPAREN expr_logical RPAREN
            ;

expr_comparison: expr_arith op=(GT | LT | GE | LE | EQ | NEQ) expr_arith
               ;
//earlier means higher precedence, associativity is left bu default
expr_arith: expr_arith op= (MULT | DIV) expr_arith #MultDiv
    | expr_arith op= (PLUS | MINUS) expr_arith     #AddSub
    | LPAREN expr_arith RPAREN                     #parens
    | NUM                                          #num
    | CHAR                                         #char
    | indexing                                     #id
    ;

instruction: affectation | condition | boucle | entree | sortie ;

sortie: WRITE LPAREN (STRING_LITERAL | expr_arith) (COMA (STRING_LITERAL | expr_arith))* RPAREN SEMICOLON;
entree: READ LPAREN  indexing RPAREN SEMICOLON;
boucle: FOR LPAREN indexing EQUAL expr_arith TO expr_arith TO expr_arith RPAREN block;
condition: IF LPAREN expr RPAREN block (ELSE block)? ;
affectation: indexing EQUAL (expr_arith|STRING_LITERAL) SEMICOLON; //i'll add string for tableau char later
block: LBRACE (instruction)* RBRACE;


