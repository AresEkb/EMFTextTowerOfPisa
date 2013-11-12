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
	A ::= child ("a" child)+; // 1st floor
	B ::= child ("b" child)+; // 2nd floor
	C ::= child ("c" child)+;
	D ::= child ("d" child)+;
	E ::= child ("e" child)+;
	F ::= child ("f" child)+;
	G ::= child ("g" child)+;
	H ::= child ("h" child)+;
	I ::= child ("i" child)+;
	J ::= child ("j" child)+; // 10th floor. It takes 10 seconds
	K ::= child ("k" child)+; // 11th floor. It works but observably slower (30 seconds)
//	L ::= child ("l" child)+; // 12th floor. It still works but even more slowly (5 minutes)
							  // Also there is a following error for
							  // org.emftext.language.top.resource.top.mopp.TopParser:
							  // The code for the static initializer is exceeding the 65535 bytes limit
							  // Despite parser is generated it doesn't work.
//	M ::= child ("m" child)+; // 13th floor - impossible to build, the tower is too high
//	N ::= child ("n" child)+;
//	O ::= child ("o" child)+;
//	P ::= child ("p" child)+;
//	Q ::= child ("q" child)+;
//	R ::= child ("r" child)+;
//	S ::= child ("s" child)+;
//	T ::= child ("t" child)+;
//	U ::= child ("u" child)+;
//	V ::= child ("v" child)+;
//	W ::= child ("w" child)+;
//	X ::= child ("x" child)+;
//	Y ::= child ("y" child)+;
//	Z ::= child ("z" child)+;
	IntegerLiteral ::= value[INTEGER_LITERAL];
}
