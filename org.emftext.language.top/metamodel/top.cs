SYNTAXDEF top
FOR <http://www.emftext.org/language/top>
START Expr

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
}

TOKENS {
	DEFINE INTEGER_LITERAL $'0'|(('+'|'-')?('1'..'9')('0'..'9')*)$;
}

RULES {
	Expr ::= child ("," child)*; // A Tower of Pisa' foundation
	A ::= child:B ("a" child:B)*; // 1st floor
	B ::= child:C ("b" child:C)*; // 2nd floor
	C ::= child:D ("c" child:D)*;
	D ::= child:E ("d" child:E)*;
	E ::= child:F ("e" child:F)*;
	F ::= child:G ("f" child:G)*;
	G ::= child:H ("g" child:H)*;
	H ::= child:I ("h" child:I)*;
	I ::= child:J ("i" child:J)*;
	J ::= child:K ("j" child:K)*; // 10th floor
	K ::= child:L ("k" child:L)*; // 11th floor
	L ::= child:M ("l" child:M)*; // 12th floor
	M ::= child:N ("m" child:N)*; // 13th floor
	N ::= child:O ("n" child:O)*;
	O ::= child:P ("o" child:P)*;
	P ::= child:Q ("p" child:Q)*;
	Q ::= child:R ("q" child:R)*;
	R ::= child:S ("r" child:S)*;
	S ::= child:T ("s" child:T)*;
	T ::= child:U ("t" child:U)*;
	U ::= child:V ("u" child:V)*;
	V ::= child:W ("v" child:W)*;
	W ::= child:X ("w" child:X)*;
	X ::= child:Y ("x" child:Y)*;
	Y ::= child:Z ("y" child:Z)*; // 26th floor - we did it!
	Z ::= child ("z" child)*;
	IntegerLiteral ::= value[INTEGER_LITERAL];
}
