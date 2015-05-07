grammar Logo; 

@header {
  package logoparsing;
}

INT : '0' | [1-9][0-9]* ;
DECL_VAR : '"'[a-z_]+ ;
USE_VAR : ':'[a-z_]+ ;
BOOLEAN_OPERATOR : '<' | '>'| '<=' | '>=' | '==' | '!=' ;
WS : [ \t\r\n]+ -> skip ;

programme : liste_instructions 
;
liste_instructions :
  (instruction)+   
;
instruction :
    'av' expr # av
  | 'td' expr # td
  | 'tg' expr # tg
  | 'lc' # lc
  | 'bc' # bc
  | 've' # ve
  | 're' expr # re
  | 'fpos' '[' expr expr ']' # fpos
  | 'fcc' expr # fcc
  | 'repete' expr '[' liste_instructions ']' # repete
  | 'donne' DECL_VAR expr # donneExpr
  | 'si' booleanExpr '[' liste_instructions ']' # si
  | 'si' booleanExpr '[' liste_instructions ']' '[' liste_instructions ']' # siSinon
  | 'tantque' booleanExpr '[' liste_instructions ']' # tantQue
;

booleanExpr: expr BOOLEAN_OPERATOR expr;

/*
booleanExpr:
  expr BOOLEAN_OPERATOR expr #booleanOperation
  | true #true
  | false #false
  | booleanExpr OR booleanExpr #or
  | booleanExpr AND booleanExpr #and
;
*/

expr:
	expr ('*' | '/' ) expr #mult
	| expr ('+' | '-' ) expr #sum
	| 'hasard' expr #hasard
	| atom #arule
	| USE_VAR #var
;

/* Chaque expression est prioritaire selon sa position dans la grammaire. Ainsi, mult est prioritaire sur sum, hasard et arule.
 sum est prioritaire sur hasard et arule. hasard est prioritaire sur arule. Ensuite avec l'associativé à gauche d'antlr, 
 on peut déduire la façon dont l'arbre est construit et ainsi l'ordre de traitement des expressions. Voir le compte-rendu. */
 
atom :
	INT #int
	| INT'.'INT #double
	| 'loop' #loop
	| '(' expr ')' #parent
;
