// $ANTLR 3.4

	package org.emftext.language.top.resource.top.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TopParser extends TopANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "INTEGER_LITERAL", "LINEBREAK", "TEXT", "WHITESPACE", "','", "'a'", "'b'", "'c'", "'d'", "'e'", "'f'", "'g'", "'h'", "'i'", "'j'", "'k'", "'l'", "'m'", "'n'", "'o'", "'p'", "'q'", "'r'", "'s'", "'t'", "'u'", "'v'", "'w'", "'x'", "'y'", "'z'"
    };

    public static final int EOF=-1;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int INTEGER_LITERAL=4;
    public static final int LINEBREAK=5;
    public static final int TEXT=6;
    public static final int WHITESPACE=7;

    // delegates
    public TopANTLRParserBase[] getDelegates() {
        return new TopANTLRParserBase[] {};
    }

    // delegators


    public TopParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public TopParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(84 + 1);
         

    }

    public String[] getTokenNames() { return TopParser.tokenNames; }
    public String getGrammarFileName() { return "Top.g"; }


    	private org.emftext.language.top.resource.top.ITopTokenResolverFactory tokenResolverFactory = new org.emftext.language.top.resource.top.mopp.TopTokenResolverFactory();
    	
    	/**
    	 * the index of the last token that was handled by collectHiddenTokens()
    	 */
    	private int lastPosition;
    	
    	/**
    	 * A flag that indicates whether the parser should remember all expected elements.
    	 * This flag is set to true when using the parse for code completion. Otherwise it
    	 * is set to false.
    	 */
    	private boolean rememberExpectedElements = false;
    	
    	private Object parseToIndexTypeObject;
    	private int lastTokenIndex = 0;
    	
    	/**
    	 * A list of expected elements the were collected while parsing the input stream.
    	 * This list is only filled if <code>rememberExpectedElements</code> is set to
    	 * true.
    	 */
    	private java.util.List<org.emftext.language.top.resource.top.mopp.TopExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.language.top.resource.top.mopp.TopExpectedTerminal>();
    	
    	private int mismatchedTokenRecoveryTries = 0;
    	/**
    	 * A helper list to allow a lexer to pass errors to its parser
    	 */
    	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
    	
    	/**
    	 * Another helper list to allow a lexer to pass positions of errors to its parser
    	 */
    	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
    	
    	/**
    	 * A stack for incomplete objects. This stack is used filled when the parser is
    	 * used for code completion. Whenever the parser starts to read an object it is
    	 * pushed on the stack. Once the element was parser completely it is popped from
    	 * the stack.
    	 */
    	java.util.List<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
    	
    	private int stopIncludingHiddenTokens;
    	private int stopExcludingHiddenTokens;
    	private int tokenIndexOfLastCompleteElement;
    	
    	private int expectedElementsIndexOfLastCompleteElement;
    	
    	/**
    	 * The offset indicating the cursor position when the parser is used for code
    	 * completion by calling parseToExpectedElements().
    	 */
    	private int cursorOffset;
    	
    	/**
    	 * The offset of the first hidden token of the last expected element. This offset
    	 * is used to discard expected elements, which are not needed for code completion.
    	 */
    	private int lastStartIncludingHidden;
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new org.emftext.language.top.resource.top.ITopCommand<org.emftext.language.top.resource.top.ITopTextResource>() {
    			public boolean execute(org.emftext.language.top.resource.top.ITopTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new org.emftext.language.top.resource.top.ITopProblem() {
    					public org.emftext.language.top.resource.top.TopEProblemSeverity getSeverity() {
    						return org.emftext.language.top.resource.top.TopEProblemSeverity.ERROR;
    					}
    					public org.emftext.language.top.resource.top.TopEProblemType getType() {
    						return org.emftext.language.top.resource.top.TopEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<org.emftext.language.top.resource.top.ITopQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	public void addExpectedElement(org.eclipse.emf.ecore.EClass eClass, int[] ids) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		int terminalID = ids[0];
    		int followSetID = ids[1];
    		org.emftext.language.top.resource.top.ITopExpectedElement terminal = org.emftext.language.top.resource.top.grammar.TopFollowSetProvider.TERMINALS[terminalID];
    		org.emftext.language.top.resource.top.mopp.TopContainedFeature[] containmentFeatures = new org.emftext.language.top.resource.top.mopp.TopContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = org.emftext.language.top.resource.top.grammar.TopFollowSetProvider.LINKS[ids[i]];
    		}
    		org.emftext.language.top.resource.top.grammar.TopContainmentTrace containmentTrace = new org.emftext.language.top.resource.top.grammar.TopContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		org.emftext.language.top.resource.top.mopp.TopExpectedTerminal expectedElement = new org.emftext.language.top.resource.top.mopp.TopExpectedTerminal(container, terminal, followSetID, containmentTrace);
    		setPosition(expectedElement, input.index());
    		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
    		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
    			// clear list of expected elements
    			this.expectedElements.clear();
    			this.expectedElementsIndexOfLastCompleteElement = 0;
    		}
    		lastStartIncludingHidden = startIncludingHiddenTokens;
    		this.expectedElements.add(expectedElement);
    	}
    	
    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
    	}
    	
    	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new org.emftext.language.top.resource.top.ITopCommand<org.emftext.language.top.resource.top.ITopTextResource>() {
    			public boolean execute(org.emftext.language.top.resource.top.ITopTextResource resource) {
    				org.emftext.language.top.resource.top.ITopLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharStart(target, locationMap.getCharStart(source));
    				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
    				locationMap.setColumn(target, locationMap.getColumn(source));
    				locationMap.setLine(target, locationMap.getLine(source));
    				return true;
    			}
    		});
    	}
    	
    	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new org.emftext.language.top.resource.top.ITopCommand<org.emftext.language.top.resource.top.ITopTextResource>() {
    			public boolean execute(org.emftext.language.top.resource.top.ITopTextResource resource) {
    				org.emftext.language.top.resource.top.ITopLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				if (source == null) {
    					return true;
    				}
    				locationMap.setCharStart(target, source.getStartIndex());
    				locationMap.setCharEnd(target, source.getStopIndex());
    				locationMap.setColumn(target, source.getCharPositionInLine());
    				locationMap.setLine(target, source.getLine());
    				return true;
    			}
    		});
    	}
    	
    	/**
    	 * Sets the end character index and the last line for the given object in the
    	 * location map.
    	 */
    	protected void setLocalizationEnd(java.util.Collection<org.emftext.language.top.resource.top.ITopCommand<org.emftext.language.top.resource.top.ITopTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new org.emftext.language.top.resource.top.ITopCommand<org.emftext.language.top.resource.top.ITopTextResource>() {
    			public boolean execute(org.emftext.language.top.resource.top.ITopTextResource resource) {
    				org.emftext.language.top.resource.top.ITopLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public org.emftext.language.top.resource.top.ITopTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new TopParser(new org.antlr.runtime3_4_0.CommonTokenStream(new TopLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new TopParser(new org.antlr.runtime3_4_0.CommonTokenStream(new TopLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new org.emftext.language.top.resource.top.util.TopRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public TopParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((TopLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((TopLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == org.emftext.language.top.Expr.class) {
    				return parse_org_emftext_language_top_Expr();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.A.class) {
    				return parse_org_emftext_language_top_A();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.B.class) {
    				return parse_org_emftext_language_top_B();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.C.class) {
    				return parse_org_emftext_language_top_C();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.D.class) {
    				return parse_org_emftext_language_top_D();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.E.class) {
    				return parse_org_emftext_language_top_E();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.F.class) {
    				return parse_org_emftext_language_top_F();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.G.class) {
    				return parse_org_emftext_language_top_G();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.H.class) {
    				return parse_org_emftext_language_top_H();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.I.class) {
    				return parse_org_emftext_language_top_I();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.J.class) {
    				return parse_org_emftext_language_top_J();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.K.class) {
    				return parse_org_emftext_language_top_K();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.L.class) {
    				return parse_org_emftext_language_top_L();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.M.class) {
    				return parse_org_emftext_language_top_M();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.N.class) {
    				return parse_org_emftext_language_top_N();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.O.class) {
    				return parse_org_emftext_language_top_O();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.P.class) {
    				return parse_org_emftext_language_top_P();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.Q.class) {
    				return parse_org_emftext_language_top_Q();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.R.class) {
    				return parse_org_emftext_language_top_R();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.S.class) {
    				return parse_org_emftext_language_top_S();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.T.class) {
    				return parse_org_emftext_language_top_T();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.U.class) {
    				return parse_org_emftext_language_top_U();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.V.class) {
    				return parse_org_emftext_language_top_V();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.W.class) {
    				return parse_org_emftext_language_top_W();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.X.class) {
    				return parse_org_emftext_language_top_X();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.Y.class) {
    				return parse_org_emftext_language_top_Y();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.Z.class) {
    				return parse_org_emftext_language_top_Z();
    			}
    			if (type.getInstanceClass() == org.emftext.language.top.IntegerLiteral.class) {
    				return parse_org_emftext_language_top_IntegerLiteral();
    			}
    		}
    		throw new org.emftext.language.top.resource.top.mopp.TopUnexpectedContentTypeException(typeObject);
    	}
    	
    	public int getMismatchedTokenRecoveryTries() {
    		return mismatchedTokenRecoveryTries;
    	}
    	
    	public Object getMissingSymbol(org.antlr.runtime3_4_0.IntStream arg0, org.antlr.runtime3_4_0.RecognitionException arg1, int arg2, org.antlr.runtime3_4_0.BitSet arg3) {
    		mismatchedTokenRecoveryTries++;
    		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
    	}
    	
    	public Object getParseToIndexTypeObject() {
    		return parseToIndexTypeObject;
    	}
    	
    	protected Object getTypeObject() {
    		Object typeObject = getParseToIndexTypeObject();
    		if (typeObject != null) {
    			return typeObject;
    		}
    		java.util.Map<?,?> options = getOptions();
    		if (options != null) {
    			typeObject = options.get(org.emftext.language.top.resource.top.ITopOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public org.emftext.language.top.resource.top.ITopParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<org.emftext.language.top.resource.top.ITopCommand<org.emftext.language.top.resource.top.ITopTextResource>>();
    		org.emftext.language.top.resource.top.mopp.TopParseResult parseResult = new org.emftext.language.top.resource.top.mopp.TopParseResult();
    		try {
    			org.eclipse.emf.ecore.EObject result =  doParse();
    			if (lexerExceptions.isEmpty()) {
    				parseResult.setRoot(result);
    			}
    		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
    			reportError(re);
    		} catch (java.lang.IllegalArgumentException iae) {
    			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
    				// can be caused if a null is set on EMF models where not allowed. this will just
    				// happen if other errors occurred before
    			} else {
    				iae.printStackTrace();
    			}
    		}
    		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
    			reportLexicalError(re);
    		}
    		parseResult.getPostParseCommands().addAll(postParseCommands);
    		return parseResult;
    	}
    	
    	public java.util.List<org.emftext.language.top.resource.top.mopp.TopExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.language.top.resource.top.ITopTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		org.emftext.language.top.resource.top.ITopParseResult result = parse();
    		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
    			org.antlr.runtime3_4_0.Lexer lexer = (org.antlr.runtime3_4_0.Lexer) tokenStream.getTokenSource();
    			int endChar = lexer.getCharIndex();
    			int endLine = lexer.getLine();
    			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
    		}
    		if (result != null) {
    			org.eclipse.emf.ecore.EObject root = result.getRoot();
    			if (root != null) {
    				dummyResource.getContentsInternal().add(root);
    			}
    			for (org.emftext.language.top.resource.top.ITopCommand<org.emftext.language.top.resource.top.ITopTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<org.emftext.language.top.resource.top.mopp.TopExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.emftext.language.top.resource.top.mopp.TopExpectedTerminal>();
    		java.util.List<org.emftext.language.top.resource.top.mopp.TopExpectedTerminal> newFollowSet = new java.util.ArrayList<org.emftext.language.top.resource.top.mopp.TopExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			org.emftext.language.top.resource.top.mopp.TopExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 110;
    		int i;
    		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
    			org.antlr.runtime3_4_0.CommonToken nextToken = (org.antlr.runtime3_4_0.CommonToken) tokenStream.get(i);
    			if (nextToken.getType() < 0) {
    				break;
    			}
    			if (nextToken.getChannel() == 99) {
    				// hidden tokens do not reduce the follow set
    			} else {
    				// now that we have found the next visible token the position for that expected
    				// terminals can be set
    				for (org.emftext.language.top.resource.top.mopp.TopExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (org.emftext.language.top.resource.top.mopp.TopExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<org.emftext.language.top.resource.top.util.TopPair<org.emftext.language.top.resource.top.ITopExpectedElement, org.emftext.language.top.resource.top.mopp.TopContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (org.emftext.language.top.resource.top.util.TopPair<org.emftext.language.top.resource.top.ITopExpectedElement, org.emftext.language.top.resource.top.mopp.TopContainedFeature[]> newFollowerPair : newFollowers) {
    							org.emftext.language.top.resource.top.ITopExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							org.emftext.language.top.resource.top.grammar.TopContainmentTrace containmentTrace = new org.emftext.language.top.resource.top.grammar.TopContainmentTrace(null, newFollowerPair.getRight());
    							org.emftext.language.top.resource.top.mopp.TopExpectedTerminal newFollowTerminal = new org.emftext.language.top.resource.top.mopp.TopExpectedTerminal(container, newFollower, followSetID, containmentTrace);
    							newFollowSet.add(newFollowTerminal);
    							expectedElements.add(newFollowTerminal);
    						}
    					}
    				}
    				currentFollowSet.clear();
    				currentFollowSet.addAll(newFollowSet);
    			}
    			followSetID++;
    		}
    		// after the last token in the stream we must set the position for the elements
    		// that were added during the last iteration of the loop
    		for (org.emftext.language.top.resource.top.mopp.TopExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(org.emftext.language.top.resource.top.mopp.TopExpectedTerminal expectedElement, int tokenIndex) {
    		int currentIndex = Math.max(0, tokenIndex);
    		for (int index = lastTokenIndex; index < currentIndex; index++) {
    			if (index >= input.size()) {
    				break;
    			}
    			org.antlr.runtime3_4_0.CommonToken tokenAtIndex = (org.antlr.runtime3_4_0.CommonToken) input.get(index);
    			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
    				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			}
    		}
    		lastTokenIndex = Math.max(0, currentIndex);
    		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
    	}
    	
    	public Object recoverFromMismatchedToken(org.antlr.runtime3_4_0.IntStream input, int ttype, org.antlr.runtime3_4_0.BitSet follow) throws org.antlr.runtime3_4_0.RecognitionException {
    		if (!rememberExpectedElements) {
    			return super.recoverFromMismatchedToken(input, ttype, follow);
    		} else {
    			return null;
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the parser into human readable messages.
    	 */
    	public void reportError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = e.getMessage();
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			String expectedTokenName = formatTokenName(mte.expecting);
    			String actualTokenName = formatTokenName(e.token.getType());
    			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
    			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
    			String expectedTokenName = formatTokenName(mtne.expecting);
    			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
    		}
    		// the resource may be null if the parser is used for code completion
    		final String finalMessage = message;
    		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
    			final org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
    			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
    		} else {
    			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the lexer into human readable messages.
    	 */
    	public void reportLexicalError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = "";
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			org.antlr.runtime3_4_0.EarlyExitException eee = (org.antlr.runtime3_4_0.EarlyExitException) e;
    			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
    			org.antlr.runtime3_4_0.MismatchedRangeException mre = (org.antlr.runtime3_4_0.MismatchedRangeException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
    		}
    		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
    	}
    	
    	private void startIncompleteElement(Object object) {
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.incompleteObjects.add((org.eclipse.emf.ecore.EObject) object);
    		}
    	}
    	
    	private void completedElement(Object object, boolean isContainment) {
    		if (isContainment && !this.incompleteObjects.isEmpty()) {
    			boolean exists = this.incompleteObjects.remove(object);
    			if (!exists) {
    			}
    		}
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
    			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
    		}
    	}
    	
    	private org.eclipse.emf.ecore.EObject getLastIncompleteElement() {
    		if (incompleteObjects.isEmpty()) {
    			return null;
    		}
    		return incompleteObjects.get(incompleteObjects.size() - 1);
    	}
    	



    // $ANTLR start "start"
    // Top.g:580:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_language_top_Expr ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        org.emftext.language.top.Expr c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Top.g:581:2: ( (c0= parse_org_emftext_language_top_Expr ) EOF )
            // Top.g:582:2: (c0= parse_org_emftext_language_top_Expr ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getExpr(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[0]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Top.g:587:2: (c0= parse_org_emftext_language_top_Expr )
            // Top.g:588:3: c0= parse_org_emftext_language_top_Expr
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_Expr_in_start82);
            c0=parse_org_emftext_language_top_Expr();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; }

            }


            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		retrieveLayoutInformation(element, null, null, false);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "start"



    // $ANTLR start "parse_org_emftext_language_top_Expr"
    // Top.g:596:1: parse_org_emftext_language_top_Expr returns [org.emftext.language.top.Expr element = null] : (a0_0= parse_org_emftext_language_top_ExprChild ) ( (a1= ',' (a2_0= parse_org_emftext_language_top_ExprChild ) ) )* ;
    public final org.emftext.language.top.Expr parse_org_emftext_language_top_Expr() throws RecognitionException {
        org.emftext.language.top.Expr element =  null;

        int parse_org_emftext_language_top_Expr_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.ExprChild a0_0 =null;

        org.emftext.language.top.ExprChild a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Top.g:599:2: ( (a0_0= parse_org_emftext_language_top_ExprChild ) ( (a1= ',' (a2_0= parse_org_emftext_language_top_ExprChild ) ) )* )
            // Top.g:600:2: (a0_0= parse_org_emftext_language_top_ExprChild ) ( (a1= ',' (a2_0= parse_org_emftext_language_top_ExprChild ) ) )*
            {
            // Top.g:600:2: (a0_0= parse_org_emftext_language_top_ExprChild )
            // Top.g:601:3: a0_0= parse_org_emftext_language_top_ExprChild
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_ExprChild_in_parse_org_emftext_language_top_Expr119);
            a0_0=parse_org_emftext_language_top_ExprChild();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createExpr();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.EXPR__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_0_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1]);
            	}

            // Top.g:626:2: ( (a1= ',' (a2_0= parse_org_emftext_language_top_ExprChild ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==8) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Top.g:627:3: (a1= ',' (a2_0= parse_org_emftext_language_top_ExprChild ) )
            	    {
            	    // Top.g:627:3: (a1= ',' (a2_0= parse_org_emftext_language_top_ExprChild ) )
            	    // Top.g:628:4: a1= ',' (a2_0= parse_org_emftext_language_top_ExprChild )
            	    {
            	    a1=(Token)match(input,8,FOLLOW_8_in_parse_org_emftext_language_top_Expr146); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createExpr();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_0_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getExpr(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[2]);
            	    			}

            	    // Top.g:642:4: (a2_0= parse_org_emftext_language_top_ExprChild )
            	    // Top.g:643:5: a2_0= parse_org_emftext_language_top_ExprChild
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_ExprChild_in_parse_org_emftext_language_top_Expr172);
            	    a2_0=parse_org_emftext_language_top_ExprChild();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createExpr();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.EXPR__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_0_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[3]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[4]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_language_top_Expr_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_Expr"



    // $ANTLR start "parse_org_emftext_language_top_A"
    // Top.g:677:1: parse_org_emftext_language_top_A returns [org.emftext.language.top.A element = null] : (a0_0= parse_org_emftext_language_top_B ) ( (a1= 'a' (a2_0= parse_org_emftext_language_top_B ) ) )* ;
    public final org.emftext.language.top.A parse_org_emftext_language_top_A() throws RecognitionException {
        org.emftext.language.top.A element =  null;

        int parse_org_emftext_language_top_A_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.B a0_0 =null;

        org.emftext.language.top.B a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Top.g:680:2: ( (a0_0= parse_org_emftext_language_top_B ) ( (a1= 'a' (a2_0= parse_org_emftext_language_top_B ) ) )* )
            // Top.g:681:2: (a0_0= parse_org_emftext_language_top_B ) ( (a1= 'a' (a2_0= parse_org_emftext_language_top_B ) ) )*
            {
            // Top.g:681:2: (a0_0= parse_org_emftext_language_top_B )
            // Top.g:682:3: a0_0= parse_org_emftext_language_top_B
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_B_in_parse_org_emftext_language_top_A232);
            a0_0=parse_org_emftext_language_top_B();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createA();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.A__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_1_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[5]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[6]);
            	}

            // Top.g:708:2: ( (a1= 'a' (a2_0= parse_org_emftext_language_top_B ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==9) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Top.g:709:3: (a1= 'a' (a2_0= parse_org_emftext_language_top_B ) )
            	    {
            	    // Top.g:709:3: (a1= 'a' (a2_0= parse_org_emftext_language_top_B ) )
            	    // Top.g:710:4: a1= 'a' (a2_0= parse_org_emftext_language_top_B )
            	    {
            	    a1=(Token)match(input,9,FOLLOW_9_in_parse_org_emftext_language_top_A259); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createA();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_1_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getA(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[7]);
            	    			}

            	    // Top.g:724:4: (a2_0= parse_org_emftext_language_top_B )
            	    // Top.g:725:5: a2_0= parse_org_emftext_language_top_B
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_B_in_parse_org_emftext_language_top_A285);
            	    a2_0=parse_org_emftext_language_top_B();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createA();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.A__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_1_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[8]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[9]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[10]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[11]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parse_org_emftext_language_top_A_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_A"



    // $ANTLR start "parse_org_emftext_language_top_B"
    // Top.g:761:1: parse_org_emftext_language_top_B returns [org.emftext.language.top.B element = null] : (a0_0= parse_org_emftext_language_top_C ) ( (a1= 'b' (a2_0= parse_org_emftext_language_top_C ) ) )* ;
    public final org.emftext.language.top.B parse_org_emftext_language_top_B() throws RecognitionException {
        org.emftext.language.top.B element =  null;

        int parse_org_emftext_language_top_B_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.C a0_0 =null;

        org.emftext.language.top.C a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Top.g:764:2: ( (a0_0= parse_org_emftext_language_top_C ) ( (a1= 'b' (a2_0= parse_org_emftext_language_top_C ) ) )* )
            // Top.g:765:2: (a0_0= parse_org_emftext_language_top_C ) ( (a1= 'b' (a2_0= parse_org_emftext_language_top_C ) ) )*
            {
            // Top.g:765:2: (a0_0= parse_org_emftext_language_top_C )
            // Top.g:766:3: a0_0= parse_org_emftext_language_top_C
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_C_in_parse_org_emftext_language_top_B345);
            a0_0=parse_org_emftext_language_top_C();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createB();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.B__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_2_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[12]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[13]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[14]);
            	}

            // Top.g:793:2: ( (a1= 'b' (a2_0= parse_org_emftext_language_top_C ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==10) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Top.g:794:3: (a1= 'b' (a2_0= parse_org_emftext_language_top_C ) )
            	    {
            	    // Top.g:794:3: (a1= 'b' (a2_0= parse_org_emftext_language_top_C ) )
            	    // Top.g:795:4: a1= 'b' (a2_0= parse_org_emftext_language_top_C )
            	    {
            	    a1=(Token)match(input,10,FOLLOW_10_in_parse_org_emftext_language_top_B372); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createB();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_2_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getB(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[15]);
            	    			}

            	    // Top.g:809:4: (a2_0= parse_org_emftext_language_top_C )
            	    // Top.g:810:5: a2_0= parse_org_emftext_language_top_C
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_C_in_parse_org_emftext_language_top_B398);
            	    a2_0=parse_org_emftext_language_top_C();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createB();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.B__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_2_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[16]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[17]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[18]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[19]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[20]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[21]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parse_org_emftext_language_top_B_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_B"



    // $ANTLR start "parse_org_emftext_language_top_C"
    // Top.g:848:1: parse_org_emftext_language_top_C returns [org.emftext.language.top.C element = null] : (a0_0= parse_org_emftext_language_top_D ) ( (a1= 'c' (a2_0= parse_org_emftext_language_top_D ) ) )* ;
    public final org.emftext.language.top.C parse_org_emftext_language_top_C() throws RecognitionException {
        org.emftext.language.top.C element =  null;

        int parse_org_emftext_language_top_C_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.D a0_0 =null;

        org.emftext.language.top.D a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Top.g:851:2: ( (a0_0= parse_org_emftext_language_top_D ) ( (a1= 'c' (a2_0= parse_org_emftext_language_top_D ) ) )* )
            // Top.g:852:2: (a0_0= parse_org_emftext_language_top_D ) ( (a1= 'c' (a2_0= parse_org_emftext_language_top_D ) ) )*
            {
            // Top.g:852:2: (a0_0= parse_org_emftext_language_top_D )
            // Top.g:853:3: a0_0= parse_org_emftext_language_top_D
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_D_in_parse_org_emftext_language_top_C458);
            a0_0=parse_org_emftext_language_top_D();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createC();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.C__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_3_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[22]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[23]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[24]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[25]);
            	}

            // Top.g:881:2: ( (a1= 'c' (a2_0= parse_org_emftext_language_top_D ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==11) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Top.g:882:3: (a1= 'c' (a2_0= parse_org_emftext_language_top_D ) )
            	    {
            	    // Top.g:882:3: (a1= 'c' (a2_0= parse_org_emftext_language_top_D ) )
            	    // Top.g:883:4: a1= 'c' (a2_0= parse_org_emftext_language_top_D )
            	    {
            	    a1=(Token)match(input,11,FOLLOW_11_in_parse_org_emftext_language_top_C485); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createC();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_3_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getC(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[26]);
            	    			}

            	    // Top.g:897:4: (a2_0= parse_org_emftext_language_top_D )
            	    // Top.g:898:5: a2_0= parse_org_emftext_language_top_D
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_D_in_parse_org_emftext_language_top_C511);
            	    a2_0=parse_org_emftext_language_top_D();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createC();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.C__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_3_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[27]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[28]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[29]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[30]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[31]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[32]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[33]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[34]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parse_org_emftext_language_top_C_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_C"



    // $ANTLR start "parse_org_emftext_language_top_D"
    // Top.g:938:1: parse_org_emftext_language_top_D returns [org.emftext.language.top.D element = null] : (a0_0= parse_org_emftext_language_top_E ) ( (a1= 'd' (a2_0= parse_org_emftext_language_top_E ) ) )* ;
    public final org.emftext.language.top.D parse_org_emftext_language_top_D() throws RecognitionException {
        org.emftext.language.top.D element =  null;

        int parse_org_emftext_language_top_D_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.E a0_0 =null;

        org.emftext.language.top.E a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Top.g:941:2: ( (a0_0= parse_org_emftext_language_top_E ) ( (a1= 'd' (a2_0= parse_org_emftext_language_top_E ) ) )* )
            // Top.g:942:2: (a0_0= parse_org_emftext_language_top_E ) ( (a1= 'd' (a2_0= parse_org_emftext_language_top_E ) ) )*
            {
            // Top.g:942:2: (a0_0= parse_org_emftext_language_top_E )
            // Top.g:943:3: a0_0= parse_org_emftext_language_top_E
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_E_in_parse_org_emftext_language_top_D571);
            a0_0=parse_org_emftext_language_top_E();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createD();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.D__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_4_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[35]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[36]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[37]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[38]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[39]);
            	}

            // Top.g:972:2: ( (a1= 'd' (a2_0= parse_org_emftext_language_top_E ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==12) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Top.g:973:3: (a1= 'd' (a2_0= parse_org_emftext_language_top_E ) )
            	    {
            	    // Top.g:973:3: (a1= 'd' (a2_0= parse_org_emftext_language_top_E ) )
            	    // Top.g:974:4: a1= 'd' (a2_0= parse_org_emftext_language_top_E )
            	    {
            	    a1=(Token)match(input,12,FOLLOW_12_in_parse_org_emftext_language_top_D598); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createD();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_4_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getD(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[40]);
            	    			}

            	    // Top.g:988:4: (a2_0= parse_org_emftext_language_top_E )
            	    // Top.g:989:5: a2_0= parse_org_emftext_language_top_E
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_E_in_parse_org_emftext_language_top_D624);
            	    a2_0=parse_org_emftext_language_top_E();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createD();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.D__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_4_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[41]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[42]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[43]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[44]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[45]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[46]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[47]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[48]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[49]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[50]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parse_org_emftext_language_top_D_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_D"



    // $ANTLR start "parse_org_emftext_language_top_E"
    // Top.g:1031:1: parse_org_emftext_language_top_E returns [org.emftext.language.top.E element = null] : (a0_0= parse_org_emftext_language_top_F ) ( (a1= 'e' (a2_0= parse_org_emftext_language_top_F ) ) )* ;
    public final org.emftext.language.top.E parse_org_emftext_language_top_E() throws RecognitionException {
        org.emftext.language.top.E element =  null;

        int parse_org_emftext_language_top_E_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.F a0_0 =null;

        org.emftext.language.top.F a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Top.g:1034:2: ( (a0_0= parse_org_emftext_language_top_F ) ( (a1= 'e' (a2_0= parse_org_emftext_language_top_F ) ) )* )
            // Top.g:1035:2: (a0_0= parse_org_emftext_language_top_F ) ( (a1= 'e' (a2_0= parse_org_emftext_language_top_F ) ) )*
            {
            // Top.g:1035:2: (a0_0= parse_org_emftext_language_top_F )
            // Top.g:1036:3: a0_0= parse_org_emftext_language_top_F
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_F_in_parse_org_emftext_language_top_E684);
            a0_0=parse_org_emftext_language_top_F();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createE();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.E__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_5_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[51]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[52]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[53]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[54]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[55]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[56]);
            	}

            // Top.g:1066:2: ( (a1= 'e' (a2_0= parse_org_emftext_language_top_F ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==13) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Top.g:1067:3: (a1= 'e' (a2_0= parse_org_emftext_language_top_F ) )
            	    {
            	    // Top.g:1067:3: (a1= 'e' (a2_0= parse_org_emftext_language_top_F ) )
            	    // Top.g:1068:4: a1= 'e' (a2_0= parse_org_emftext_language_top_F )
            	    {
            	    a1=(Token)match(input,13,FOLLOW_13_in_parse_org_emftext_language_top_E711); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createE();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_5_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getE(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[57]);
            	    			}

            	    // Top.g:1082:4: (a2_0= parse_org_emftext_language_top_F )
            	    // Top.g:1083:5: a2_0= parse_org_emftext_language_top_F
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_F_in_parse_org_emftext_language_top_E737);
            	    a2_0=parse_org_emftext_language_top_F();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createE();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.E__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_5_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[58]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[59]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[60]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[61]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[62]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[63]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[64]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[65]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[66]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[67]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[68]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[69]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_language_top_E_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_E"



    // $ANTLR start "parse_org_emftext_language_top_F"
    // Top.g:1127:1: parse_org_emftext_language_top_F returns [org.emftext.language.top.F element = null] : (a0_0= parse_org_emftext_language_top_G ) ( (a1= 'f' (a2_0= parse_org_emftext_language_top_G ) ) )* ;
    public final org.emftext.language.top.F parse_org_emftext_language_top_F() throws RecognitionException {
        org.emftext.language.top.F element =  null;

        int parse_org_emftext_language_top_F_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.G a0_0 =null;

        org.emftext.language.top.G a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Top.g:1130:2: ( (a0_0= parse_org_emftext_language_top_G ) ( (a1= 'f' (a2_0= parse_org_emftext_language_top_G ) ) )* )
            // Top.g:1131:2: (a0_0= parse_org_emftext_language_top_G ) ( (a1= 'f' (a2_0= parse_org_emftext_language_top_G ) ) )*
            {
            // Top.g:1131:2: (a0_0= parse_org_emftext_language_top_G )
            // Top.g:1132:3: a0_0= parse_org_emftext_language_top_G
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_G_in_parse_org_emftext_language_top_F797);
            a0_0=parse_org_emftext_language_top_G();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createF();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.F__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_6_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[70]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[71]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[72]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[73]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[74]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[75]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[76]);
            	}

            // Top.g:1163:2: ( (a1= 'f' (a2_0= parse_org_emftext_language_top_G ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Top.g:1164:3: (a1= 'f' (a2_0= parse_org_emftext_language_top_G ) )
            	    {
            	    // Top.g:1164:3: (a1= 'f' (a2_0= parse_org_emftext_language_top_G ) )
            	    // Top.g:1165:4: a1= 'f' (a2_0= parse_org_emftext_language_top_G )
            	    {
            	    a1=(Token)match(input,14,FOLLOW_14_in_parse_org_emftext_language_top_F824); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createF();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_6_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getF(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[77]);
            	    			}

            	    // Top.g:1179:4: (a2_0= parse_org_emftext_language_top_G )
            	    // Top.g:1180:5: a2_0= parse_org_emftext_language_top_G
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_G_in_parse_org_emftext_language_top_F850);
            	    a2_0=parse_org_emftext_language_top_G();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createF();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.F__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_6_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[78]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[79]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[80]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[81]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[82]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[83]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[84]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[85]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[86]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[87]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[88]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[89]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[90]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[91]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_language_top_F_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_F"



    // $ANTLR start "parse_org_emftext_language_top_G"
    // Top.g:1226:1: parse_org_emftext_language_top_G returns [org.emftext.language.top.G element = null] : (a0_0= parse_org_emftext_language_top_H ) ( (a1= 'g' (a2_0= parse_org_emftext_language_top_H ) ) )* ;
    public final org.emftext.language.top.G parse_org_emftext_language_top_G() throws RecognitionException {
        org.emftext.language.top.G element =  null;

        int parse_org_emftext_language_top_G_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.H a0_0 =null;

        org.emftext.language.top.H a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Top.g:1229:2: ( (a0_0= parse_org_emftext_language_top_H ) ( (a1= 'g' (a2_0= parse_org_emftext_language_top_H ) ) )* )
            // Top.g:1230:2: (a0_0= parse_org_emftext_language_top_H ) ( (a1= 'g' (a2_0= parse_org_emftext_language_top_H ) ) )*
            {
            // Top.g:1230:2: (a0_0= parse_org_emftext_language_top_H )
            // Top.g:1231:3: a0_0= parse_org_emftext_language_top_H
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_H_in_parse_org_emftext_language_top_G910);
            a0_0=parse_org_emftext_language_top_H();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createG();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.G__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_7_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[92]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[93]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[94]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[95]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[96]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[97]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[98]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[99]);
            	}

            // Top.g:1263:2: ( (a1= 'g' (a2_0= parse_org_emftext_language_top_H ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==15) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Top.g:1264:3: (a1= 'g' (a2_0= parse_org_emftext_language_top_H ) )
            	    {
            	    // Top.g:1264:3: (a1= 'g' (a2_0= parse_org_emftext_language_top_H ) )
            	    // Top.g:1265:4: a1= 'g' (a2_0= parse_org_emftext_language_top_H )
            	    {
            	    a1=(Token)match(input,15,FOLLOW_15_in_parse_org_emftext_language_top_G937); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createG();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_7_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getG(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[100]);
            	    			}

            	    // Top.g:1279:4: (a2_0= parse_org_emftext_language_top_H )
            	    // Top.g:1280:5: a2_0= parse_org_emftext_language_top_H
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_H_in_parse_org_emftext_language_top_G963);
            	    a2_0=parse_org_emftext_language_top_H();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createG();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.G__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_7_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[101]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[102]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[103]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[104]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[105]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[106]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[107]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[108]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[109]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[110]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[111]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[112]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[113]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[114]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[115]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[116]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_emftext_language_top_G_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_G"



    // $ANTLR start "parse_org_emftext_language_top_H"
    // Top.g:1328:1: parse_org_emftext_language_top_H returns [org.emftext.language.top.H element = null] : (a0_0= parse_org_emftext_language_top_I ) ( (a1= 'h' (a2_0= parse_org_emftext_language_top_I ) ) )* ;
    public final org.emftext.language.top.H parse_org_emftext_language_top_H() throws RecognitionException {
        org.emftext.language.top.H element =  null;

        int parse_org_emftext_language_top_H_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.I a0_0 =null;

        org.emftext.language.top.I a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return element; }

            // Top.g:1331:2: ( (a0_0= parse_org_emftext_language_top_I ) ( (a1= 'h' (a2_0= parse_org_emftext_language_top_I ) ) )* )
            // Top.g:1332:2: (a0_0= parse_org_emftext_language_top_I ) ( (a1= 'h' (a2_0= parse_org_emftext_language_top_I ) ) )*
            {
            // Top.g:1332:2: (a0_0= parse_org_emftext_language_top_I )
            // Top.g:1333:3: a0_0= parse_org_emftext_language_top_I
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_I_in_parse_org_emftext_language_top_H1023);
            a0_0=parse_org_emftext_language_top_I();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createH();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.H__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_8_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[117]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[118]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[119]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[120]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[121]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[122]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[123]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[124]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[125]);
            	}

            // Top.g:1366:2: ( (a1= 'h' (a2_0= parse_org_emftext_language_top_I ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==16) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Top.g:1367:3: (a1= 'h' (a2_0= parse_org_emftext_language_top_I ) )
            	    {
            	    // Top.g:1367:3: (a1= 'h' (a2_0= parse_org_emftext_language_top_I ) )
            	    // Top.g:1368:4: a1= 'h' (a2_0= parse_org_emftext_language_top_I )
            	    {
            	    a1=(Token)match(input,16,FOLLOW_16_in_parse_org_emftext_language_top_H1050); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createH();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_8_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getH(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[126]);
            	    			}

            	    // Top.g:1382:4: (a2_0= parse_org_emftext_language_top_I )
            	    // Top.g:1383:5: a2_0= parse_org_emftext_language_top_I
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_I_in_parse_org_emftext_language_top_H1076);
            	    a2_0=parse_org_emftext_language_top_I();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createH();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.H__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_8_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[127]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[128]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[129]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[130]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[131]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[132]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[133]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[134]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[135]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[136]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[137]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[138]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[139]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[140]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[141]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[142]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[143]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[144]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, parse_org_emftext_language_top_H_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_H"



    // $ANTLR start "parse_org_emftext_language_top_I"
    // Top.g:1433:1: parse_org_emftext_language_top_I returns [org.emftext.language.top.I element = null] : (a0_0= parse_org_emftext_language_top_J ) ( (a1= 'i' (a2_0= parse_org_emftext_language_top_J ) ) )* ;
    public final org.emftext.language.top.I parse_org_emftext_language_top_I() throws RecognitionException {
        org.emftext.language.top.I element =  null;

        int parse_org_emftext_language_top_I_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.J a0_0 =null;

        org.emftext.language.top.J a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return element; }

            // Top.g:1436:2: ( (a0_0= parse_org_emftext_language_top_J ) ( (a1= 'i' (a2_0= parse_org_emftext_language_top_J ) ) )* )
            // Top.g:1437:2: (a0_0= parse_org_emftext_language_top_J ) ( (a1= 'i' (a2_0= parse_org_emftext_language_top_J ) ) )*
            {
            // Top.g:1437:2: (a0_0= parse_org_emftext_language_top_J )
            // Top.g:1438:3: a0_0= parse_org_emftext_language_top_J
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_J_in_parse_org_emftext_language_top_I1136);
            a0_0=parse_org_emftext_language_top_J();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createI();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.I__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_9_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[145]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[146]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[147]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[148]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[149]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[150]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[151]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[152]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[153]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[154]);
            	}

            // Top.g:1472:2: ( (a1= 'i' (a2_0= parse_org_emftext_language_top_J ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==17) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Top.g:1473:3: (a1= 'i' (a2_0= parse_org_emftext_language_top_J ) )
            	    {
            	    // Top.g:1473:3: (a1= 'i' (a2_0= parse_org_emftext_language_top_J ) )
            	    // Top.g:1474:4: a1= 'i' (a2_0= parse_org_emftext_language_top_J )
            	    {
            	    a1=(Token)match(input,17,FOLLOW_17_in_parse_org_emftext_language_top_I1163); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createI();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_9_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getI(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[155]);
            	    			}

            	    // Top.g:1488:4: (a2_0= parse_org_emftext_language_top_J )
            	    // Top.g:1489:5: a2_0= parse_org_emftext_language_top_J
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_J_in_parse_org_emftext_language_top_I1189);
            	    a2_0=parse_org_emftext_language_top_J();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createI();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.I__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_9_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[156]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[157]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[158]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[159]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[160]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[161]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[162]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[163]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[164]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[165]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[166]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[167]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[168]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[169]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[170]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[171]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[172]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[173]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[174]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[175]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, parse_org_emftext_language_top_I_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_I"



    // $ANTLR start "parse_org_emftext_language_top_J"
    // Top.g:1541:1: parse_org_emftext_language_top_J returns [org.emftext.language.top.J element = null] : (a0_0= parse_org_emftext_language_top_K ) ( (a1= 'j' (a2_0= parse_org_emftext_language_top_K ) ) )* ;
    public final org.emftext.language.top.J parse_org_emftext_language_top_J() throws RecognitionException {
        org.emftext.language.top.J element =  null;

        int parse_org_emftext_language_top_J_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.K a0_0 =null;

        org.emftext.language.top.K a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return element; }

            // Top.g:1544:2: ( (a0_0= parse_org_emftext_language_top_K ) ( (a1= 'j' (a2_0= parse_org_emftext_language_top_K ) ) )* )
            // Top.g:1545:2: (a0_0= parse_org_emftext_language_top_K ) ( (a1= 'j' (a2_0= parse_org_emftext_language_top_K ) ) )*
            {
            // Top.g:1545:2: (a0_0= parse_org_emftext_language_top_K )
            // Top.g:1546:3: a0_0= parse_org_emftext_language_top_K
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_K_in_parse_org_emftext_language_top_J1249);
            a0_0=parse_org_emftext_language_top_K();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createJ();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.J__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_10_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[176]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[177]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[178]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[179]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[180]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[181]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[182]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[183]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[184]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[185]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[186]);
            	}

            // Top.g:1581:2: ( (a1= 'j' (a2_0= parse_org_emftext_language_top_K ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==18) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Top.g:1582:3: (a1= 'j' (a2_0= parse_org_emftext_language_top_K ) )
            	    {
            	    // Top.g:1582:3: (a1= 'j' (a2_0= parse_org_emftext_language_top_K ) )
            	    // Top.g:1583:4: a1= 'j' (a2_0= parse_org_emftext_language_top_K )
            	    {
            	    a1=(Token)match(input,18,FOLLOW_18_in_parse_org_emftext_language_top_J1276); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createJ();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_10_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[187]);
            	    			}

            	    // Top.g:1597:4: (a2_0= parse_org_emftext_language_top_K )
            	    // Top.g:1598:5: a2_0= parse_org_emftext_language_top_K
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_K_in_parse_org_emftext_language_top_J1302);
            	    a2_0=parse_org_emftext_language_top_K();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createJ();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.J__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_10_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[188]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[189]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[190]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[191]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[192]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[193]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[194]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[195]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[196]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[197]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[198]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[199]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[200]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[201]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[202]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[203]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[204]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[205]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[206]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[207]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[208]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[209]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, parse_org_emftext_language_top_J_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_J"



    // $ANTLR start "parse_org_emftext_language_top_K"
    // Top.g:1652:1: parse_org_emftext_language_top_K returns [org.emftext.language.top.K element = null] : (a0_0= parse_org_emftext_language_top_L ) ( (a1= 'k' (a2_0= parse_org_emftext_language_top_L ) ) )* ;
    public final org.emftext.language.top.K parse_org_emftext_language_top_K() throws RecognitionException {
        org.emftext.language.top.K element =  null;

        int parse_org_emftext_language_top_K_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.L a0_0 =null;

        org.emftext.language.top.L a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return element; }

            // Top.g:1655:2: ( (a0_0= parse_org_emftext_language_top_L ) ( (a1= 'k' (a2_0= parse_org_emftext_language_top_L ) ) )* )
            // Top.g:1656:2: (a0_0= parse_org_emftext_language_top_L ) ( (a1= 'k' (a2_0= parse_org_emftext_language_top_L ) ) )*
            {
            // Top.g:1656:2: (a0_0= parse_org_emftext_language_top_L )
            // Top.g:1657:3: a0_0= parse_org_emftext_language_top_L
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_L_in_parse_org_emftext_language_top_K1362);
            a0_0=parse_org_emftext_language_top_L();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createK();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.K__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_11_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[210]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[211]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[212]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[213]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[214]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[215]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[216]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[217]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[218]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[219]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[220]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[221]);
            	}

            // Top.g:1693:2: ( (a1= 'k' (a2_0= parse_org_emftext_language_top_L ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==19) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // Top.g:1694:3: (a1= 'k' (a2_0= parse_org_emftext_language_top_L ) )
            	    {
            	    // Top.g:1694:3: (a1= 'k' (a2_0= parse_org_emftext_language_top_L ) )
            	    // Top.g:1695:4: a1= 'k' (a2_0= parse_org_emftext_language_top_L )
            	    {
            	    a1=(Token)match(input,19,FOLLOW_19_in_parse_org_emftext_language_top_K1389); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createK();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_11_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getK(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[222]);
            	    			}

            	    // Top.g:1709:4: (a2_0= parse_org_emftext_language_top_L )
            	    // Top.g:1710:5: a2_0= parse_org_emftext_language_top_L
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_L_in_parse_org_emftext_language_top_K1415);
            	    a2_0=parse_org_emftext_language_top_L();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createK();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.K__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_11_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[223]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[224]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[225]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[226]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[227]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[228]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[229]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[230]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[231]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[232]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[233]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[234]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[235]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[236]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[237]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[238]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[239]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[240]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[241]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[242]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[243]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[244]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[245]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[246]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, parse_org_emftext_language_top_K_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_K"



    // $ANTLR start "parse_org_emftext_language_top_L"
    // Top.g:1766:1: parse_org_emftext_language_top_L returns [org.emftext.language.top.L element = null] : (a0_0= parse_org_emftext_language_top_M ) ( (a1= 'l' (a2_0= parse_org_emftext_language_top_M ) ) )* ;
    public final org.emftext.language.top.L parse_org_emftext_language_top_L() throws RecognitionException {
        org.emftext.language.top.L element =  null;

        int parse_org_emftext_language_top_L_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.M a0_0 =null;

        org.emftext.language.top.M a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return element; }

            // Top.g:1769:2: ( (a0_0= parse_org_emftext_language_top_M ) ( (a1= 'l' (a2_0= parse_org_emftext_language_top_M ) ) )* )
            // Top.g:1770:2: (a0_0= parse_org_emftext_language_top_M ) ( (a1= 'l' (a2_0= parse_org_emftext_language_top_M ) ) )*
            {
            // Top.g:1770:2: (a0_0= parse_org_emftext_language_top_M )
            // Top.g:1771:3: a0_0= parse_org_emftext_language_top_M
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_M_in_parse_org_emftext_language_top_L1475);
            a0_0=parse_org_emftext_language_top_M();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createL();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.L__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_12_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[247]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[248]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[249]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[250]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[251]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[252]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[253]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[254]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[255]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[256]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[257]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[258]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[259]);
            	}

            // Top.g:1808:2: ( (a1= 'l' (a2_0= parse_org_emftext_language_top_M ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==20) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // Top.g:1809:3: (a1= 'l' (a2_0= parse_org_emftext_language_top_M ) )
            	    {
            	    // Top.g:1809:3: (a1= 'l' (a2_0= parse_org_emftext_language_top_M ) )
            	    // Top.g:1810:4: a1= 'l' (a2_0= parse_org_emftext_language_top_M )
            	    {
            	    a1=(Token)match(input,20,FOLLOW_20_in_parse_org_emftext_language_top_L1502); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createL();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_12_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getL(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[260]);
            	    			}

            	    // Top.g:1824:4: (a2_0= parse_org_emftext_language_top_M )
            	    // Top.g:1825:5: a2_0= parse_org_emftext_language_top_M
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_M_in_parse_org_emftext_language_top_L1528);
            	    a2_0=parse_org_emftext_language_top_M();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createL();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.L__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_12_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[261]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[262]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[263]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[264]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[265]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[266]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[267]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[268]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[269]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[270]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[271]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[272]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[273]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[274]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[275]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[276]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[277]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[278]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[279]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[280]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[281]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[282]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[283]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[284]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[285]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[286]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, parse_org_emftext_language_top_L_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_L"



    // $ANTLR start "parse_org_emftext_language_top_M"
    // Top.g:1883:1: parse_org_emftext_language_top_M returns [org.emftext.language.top.M element = null] : (a0_0= parse_org_emftext_language_top_N ) ( (a1= 'm' (a2_0= parse_org_emftext_language_top_N ) ) )* ;
    public final org.emftext.language.top.M parse_org_emftext_language_top_M() throws RecognitionException {
        org.emftext.language.top.M element =  null;

        int parse_org_emftext_language_top_M_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.N a0_0 =null;

        org.emftext.language.top.N a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return element; }

            // Top.g:1886:2: ( (a0_0= parse_org_emftext_language_top_N ) ( (a1= 'm' (a2_0= parse_org_emftext_language_top_N ) ) )* )
            // Top.g:1887:2: (a0_0= parse_org_emftext_language_top_N ) ( (a1= 'm' (a2_0= parse_org_emftext_language_top_N ) ) )*
            {
            // Top.g:1887:2: (a0_0= parse_org_emftext_language_top_N )
            // Top.g:1888:3: a0_0= parse_org_emftext_language_top_N
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_N_in_parse_org_emftext_language_top_M1588);
            a0_0=parse_org_emftext_language_top_N();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createM();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.M__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_13_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[287]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[288]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[289]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[290]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[291]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[292]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[293]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[294]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[295]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[296]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[297]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[298]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[299]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[300]);
            	}

            // Top.g:1926:2: ( (a1= 'm' (a2_0= parse_org_emftext_language_top_N ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==21) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // Top.g:1927:3: (a1= 'm' (a2_0= parse_org_emftext_language_top_N ) )
            	    {
            	    // Top.g:1927:3: (a1= 'm' (a2_0= parse_org_emftext_language_top_N ) )
            	    // Top.g:1928:4: a1= 'm' (a2_0= parse_org_emftext_language_top_N )
            	    {
            	    a1=(Token)match(input,21,FOLLOW_21_in_parse_org_emftext_language_top_M1615); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createM();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_13_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getM(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[301]);
            	    			}

            	    // Top.g:1942:4: (a2_0= parse_org_emftext_language_top_N )
            	    // Top.g:1943:5: a2_0= parse_org_emftext_language_top_N
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_N_in_parse_org_emftext_language_top_M1641);
            	    a2_0=parse_org_emftext_language_top_N();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createM();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.M__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_13_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[302]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[303]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[304]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[305]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[306]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[307]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[308]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[309]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[310]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[311]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[312]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[313]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[314]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[315]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[316]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[317]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[318]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[319]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[320]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[321]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[322]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[323]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[324]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[325]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[326]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[327]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[328]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[329]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, parse_org_emftext_language_top_M_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_M"



    // $ANTLR start "parse_org_emftext_language_top_N"
    // Top.g:2003:1: parse_org_emftext_language_top_N returns [org.emftext.language.top.N element = null] : (a0_0= parse_org_emftext_language_top_O ) ( (a1= 'n' (a2_0= parse_org_emftext_language_top_O ) ) )* ;
    public final org.emftext.language.top.N parse_org_emftext_language_top_N() throws RecognitionException {
        org.emftext.language.top.N element =  null;

        int parse_org_emftext_language_top_N_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.O a0_0 =null;

        org.emftext.language.top.O a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return element; }

            // Top.g:2006:2: ( (a0_0= parse_org_emftext_language_top_O ) ( (a1= 'n' (a2_0= parse_org_emftext_language_top_O ) ) )* )
            // Top.g:2007:2: (a0_0= parse_org_emftext_language_top_O ) ( (a1= 'n' (a2_0= parse_org_emftext_language_top_O ) ) )*
            {
            // Top.g:2007:2: (a0_0= parse_org_emftext_language_top_O )
            // Top.g:2008:3: a0_0= parse_org_emftext_language_top_O
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_O_in_parse_org_emftext_language_top_N1701);
            a0_0=parse_org_emftext_language_top_O();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createN();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.N__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_14_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[330]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[331]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[332]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[333]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[334]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[335]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[336]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[337]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[338]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[339]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[340]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[341]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[342]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[343]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[344]);
            	}

            // Top.g:2047:2: ( (a1= 'n' (a2_0= parse_org_emftext_language_top_O ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==22) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // Top.g:2048:3: (a1= 'n' (a2_0= parse_org_emftext_language_top_O ) )
            	    {
            	    // Top.g:2048:3: (a1= 'n' (a2_0= parse_org_emftext_language_top_O ) )
            	    // Top.g:2049:4: a1= 'n' (a2_0= parse_org_emftext_language_top_O )
            	    {
            	    a1=(Token)match(input,22,FOLLOW_22_in_parse_org_emftext_language_top_N1728); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createN();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_14_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getN(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[345]);
            	    			}

            	    // Top.g:2063:4: (a2_0= parse_org_emftext_language_top_O )
            	    // Top.g:2064:5: a2_0= parse_org_emftext_language_top_O
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_O_in_parse_org_emftext_language_top_N1754);
            	    a2_0=parse_org_emftext_language_top_O();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createN();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.N__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_14_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[346]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[347]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[348]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[349]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[350]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[351]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[352]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[353]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[354]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[355]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[356]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[357]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[358]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[359]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[360]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[361]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[362]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[363]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[364]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[365]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[366]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[367]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[368]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[369]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[370]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[371]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[372]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[373]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[374]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[375]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, parse_org_emftext_language_top_N_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_N"



    // $ANTLR start "parse_org_emftext_language_top_O"
    // Top.g:2126:1: parse_org_emftext_language_top_O returns [org.emftext.language.top.O element = null] : (a0_0= parse_org_emftext_language_top_P ) ( (a1= 'o' (a2_0= parse_org_emftext_language_top_P ) ) )* ;
    public final org.emftext.language.top.O parse_org_emftext_language_top_O() throws RecognitionException {
        org.emftext.language.top.O element =  null;

        int parse_org_emftext_language_top_O_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.P a0_0 =null;

        org.emftext.language.top.P a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return element; }

            // Top.g:2129:2: ( (a0_0= parse_org_emftext_language_top_P ) ( (a1= 'o' (a2_0= parse_org_emftext_language_top_P ) ) )* )
            // Top.g:2130:2: (a0_0= parse_org_emftext_language_top_P ) ( (a1= 'o' (a2_0= parse_org_emftext_language_top_P ) ) )*
            {
            // Top.g:2130:2: (a0_0= parse_org_emftext_language_top_P )
            // Top.g:2131:3: a0_0= parse_org_emftext_language_top_P
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_P_in_parse_org_emftext_language_top_O1814);
            a0_0=parse_org_emftext_language_top_P();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createO();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.O__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_15_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[376]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[377]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[378]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[379]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[380]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[381]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[382]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[383]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[384]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[385]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[386]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[387]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[388]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[389]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[390]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[391]);
            	}

            // Top.g:2171:2: ( (a1= 'o' (a2_0= parse_org_emftext_language_top_P ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==23) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // Top.g:2172:3: (a1= 'o' (a2_0= parse_org_emftext_language_top_P ) )
            	    {
            	    // Top.g:2172:3: (a1= 'o' (a2_0= parse_org_emftext_language_top_P ) )
            	    // Top.g:2173:4: a1= 'o' (a2_0= parse_org_emftext_language_top_P )
            	    {
            	    a1=(Token)match(input,23,FOLLOW_23_in_parse_org_emftext_language_top_O1841); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createO();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_15_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getO(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[392]);
            	    			}

            	    // Top.g:2187:4: (a2_0= parse_org_emftext_language_top_P )
            	    // Top.g:2188:5: a2_0= parse_org_emftext_language_top_P
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_P_in_parse_org_emftext_language_top_O1867);
            	    a2_0=parse_org_emftext_language_top_P();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createO();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.O__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_15_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[393]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[394]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[395]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[396]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[397]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[398]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[399]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[400]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[401]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[402]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[403]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[404]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[405]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[406]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[407]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[408]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[409]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[410]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[411]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[412]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[413]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[414]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[415]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[416]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[417]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[418]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[419]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[420]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[421]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[422]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[423]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[424]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, parse_org_emftext_language_top_O_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_O"



    // $ANTLR start "parse_org_emftext_language_top_P"
    // Top.g:2252:1: parse_org_emftext_language_top_P returns [org.emftext.language.top.P element = null] : (a0_0= parse_org_emftext_language_top_Q ) ( (a1= 'p' (a2_0= parse_org_emftext_language_top_Q ) ) )* ;
    public final org.emftext.language.top.P parse_org_emftext_language_top_P() throws RecognitionException {
        org.emftext.language.top.P element =  null;

        int parse_org_emftext_language_top_P_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.Q a0_0 =null;

        org.emftext.language.top.Q a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return element; }

            // Top.g:2255:2: ( (a0_0= parse_org_emftext_language_top_Q ) ( (a1= 'p' (a2_0= parse_org_emftext_language_top_Q ) ) )* )
            // Top.g:2256:2: (a0_0= parse_org_emftext_language_top_Q ) ( (a1= 'p' (a2_0= parse_org_emftext_language_top_Q ) ) )*
            {
            // Top.g:2256:2: (a0_0= parse_org_emftext_language_top_Q )
            // Top.g:2257:3: a0_0= parse_org_emftext_language_top_Q
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_Q_in_parse_org_emftext_language_top_P1927);
            a0_0=parse_org_emftext_language_top_Q();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createP();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.P__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_16_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[425]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[426]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[427]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[428]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[429]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[430]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[431]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[432]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[433]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[434]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[435]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[436]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[437]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[438]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[439]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[440]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[441]);
            	}

            // Top.g:2298:2: ( (a1= 'p' (a2_0= parse_org_emftext_language_top_Q ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==24) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // Top.g:2299:3: (a1= 'p' (a2_0= parse_org_emftext_language_top_Q ) )
            	    {
            	    // Top.g:2299:3: (a1= 'p' (a2_0= parse_org_emftext_language_top_Q ) )
            	    // Top.g:2300:4: a1= 'p' (a2_0= parse_org_emftext_language_top_Q )
            	    {
            	    a1=(Token)match(input,24,FOLLOW_24_in_parse_org_emftext_language_top_P1954); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createP();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_16_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getP(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[442]);
            	    			}

            	    // Top.g:2314:4: (a2_0= parse_org_emftext_language_top_Q )
            	    // Top.g:2315:5: a2_0= parse_org_emftext_language_top_Q
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_Q_in_parse_org_emftext_language_top_P1980);
            	    a2_0=parse_org_emftext_language_top_Q();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createP();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.P__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_16_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[443]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[444]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[445]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[446]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[447]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[448]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[449]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[450]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[451]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[452]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[453]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[454]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[455]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[456]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[457]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[458]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[459]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[460]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[461]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[462]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[463]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[464]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[465]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[466]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[467]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[468]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[469]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[470]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[471]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[472]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[473]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[474]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[475]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[476]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, parse_org_emftext_language_top_P_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_P"



    // $ANTLR start "parse_org_emftext_language_top_Q"
    // Top.g:2381:1: parse_org_emftext_language_top_Q returns [org.emftext.language.top.Q element = null] : (a0_0= parse_org_emftext_language_top_R ) ( (a1= 'q' (a2_0= parse_org_emftext_language_top_R ) ) )* ;
    public final org.emftext.language.top.Q parse_org_emftext_language_top_Q() throws RecognitionException {
        org.emftext.language.top.Q element =  null;

        int parse_org_emftext_language_top_Q_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.R a0_0 =null;

        org.emftext.language.top.R a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return element; }

            // Top.g:2384:2: ( (a0_0= parse_org_emftext_language_top_R ) ( (a1= 'q' (a2_0= parse_org_emftext_language_top_R ) ) )* )
            // Top.g:2385:2: (a0_0= parse_org_emftext_language_top_R ) ( (a1= 'q' (a2_0= parse_org_emftext_language_top_R ) ) )*
            {
            // Top.g:2385:2: (a0_0= parse_org_emftext_language_top_R )
            // Top.g:2386:3: a0_0= parse_org_emftext_language_top_R
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_R_in_parse_org_emftext_language_top_Q2040);
            a0_0=parse_org_emftext_language_top_R();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createQ();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.Q__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_17_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[477]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[478]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[479]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[480]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[481]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[482]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[483]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[484]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[485]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[486]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[487]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[488]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[489]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[490]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[491]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[492]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[493]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[494]);
            	}

            // Top.g:2428:2: ( (a1= 'q' (a2_0= parse_org_emftext_language_top_R ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==25) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // Top.g:2429:3: (a1= 'q' (a2_0= parse_org_emftext_language_top_R ) )
            	    {
            	    // Top.g:2429:3: (a1= 'q' (a2_0= parse_org_emftext_language_top_R ) )
            	    // Top.g:2430:4: a1= 'q' (a2_0= parse_org_emftext_language_top_R )
            	    {
            	    a1=(Token)match(input,25,FOLLOW_25_in_parse_org_emftext_language_top_Q2067); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createQ();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_17_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getQ(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[495]);
            	    			}

            	    // Top.g:2444:4: (a2_0= parse_org_emftext_language_top_R )
            	    // Top.g:2445:5: a2_0= parse_org_emftext_language_top_R
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_R_in_parse_org_emftext_language_top_Q2093);
            	    a2_0=parse_org_emftext_language_top_R();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createQ();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.Q__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_17_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[496]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[497]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[498]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[499]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[500]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[501]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[502]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[503]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[504]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[505]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[506]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[507]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[508]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[509]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[510]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[511]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[512]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[513]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[514]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[515]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[516]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[517]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[518]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[519]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[520]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[521]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[522]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[523]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[524]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[525]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[526]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[527]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[528]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[529]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[530]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[531]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 19, parse_org_emftext_language_top_Q_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_Q"



    // $ANTLR start "parse_org_emftext_language_top_R"
    // Top.g:2513:1: parse_org_emftext_language_top_R returns [org.emftext.language.top.R element = null] : (a0_0= parse_org_emftext_language_top_S ) ( (a1= 'r' (a2_0= parse_org_emftext_language_top_S ) ) )* ;
    public final org.emftext.language.top.R parse_org_emftext_language_top_R() throws RecognitionException {
        org.emftext.language.top.R element =  null;

        int parse_org_emftext_language_top_R_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.S a0_0 =null;

        org.emftext.language.top.S a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return element; }

            // Top.g:2516:2: ( (a0_0= parse_org_emftext_language_top_S ) ( (a1= 'r' (a2_0= parse_org_emftext_language_top_S ) ) )* )
            // Top.g:2517:2: (a0_0= parse_org_emftext_language_top_S ) ( (a1= 'r' (a2_0= parse_org_emftext_language_top_S ) ) )*
            {
            // Top.g:2517:2: (a0_0= parse_org_emftext_language_top_S )
            // Top.g:2518:3: a0_0= parse_org_emftext_language_top_S
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_S_in_parse_org_emftext_language_top_R2153);
            a0_0=parse_org_emftext_language_top_S();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createR();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.R__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_18_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[532]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[533]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[534]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[535]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[536]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[537]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[538]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[539]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[540]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[541]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[542]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[543]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[544]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[545]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[546]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[547]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[548]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[549]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[550]);
            	}

            // Top.g:2561:2: ( (a1= 'r' (a2_0= parse_org_emftext_language_top_S ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==26) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // Top.g:2562:3: (a1= 'r' (a2_0= parse_org_emftext_language_top_S ) )
            	    {
            	    // Top.g:2562:3: (a1= 'r' (a2_0= parse_org_emftext_language_top_S ) )
            	    // Top.g:2563:4: a1= 'r' (a2_0= parse_org_emftext_language_top_S )
            	    {
            	    a1=(Token)match(input,26,FOLLOW_26_in_parse_org_emftext_language_top_R2180); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createR();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_18_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getR(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[551]);
            	    			}

            	    // Top.g:2577:4: (a2_0= parse_org_emftext_language_top_S )
            	    // Top.g:2578:5: a2_0= parse_org_emftext_language_top_S
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_S_in_parse_org_emftext_language_top_R2206);
            	    a2_0=parse_org_emftext_language_top_S();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createR();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.R__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_18_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[552]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[553]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[554]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[555]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[556]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[557]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[558]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[559]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[560]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[561]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[562]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[563]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[564]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[565]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[566]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[567]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[568]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[569]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[570]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[571]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[572]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[573]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[574]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[575]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[576]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[577]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[578]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[579]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[580]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[581]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[582]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[583]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[584]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[585]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[586]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[587]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[588]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[589]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 20, parse_org_emftext_language_top_R_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_R"



    // $ANTLR start "parse_org_emftext_language_top_S"
    // Top.g:2648:1: parse_org_emftext_language_top_S returns [org.emftext.language.top.S element = null] : (a0_0= parse_org_emftext_language_top_T ) ( (a1= 's' (a2_0= parse_org_emftext_language_top_T ) ) )* ;
    public final org.emftext.language.top.S parse_org_emftext_language_top_S() throws RecognitionException {
        org.emftext.language.top.S element =  null;

        int parse_org_emftext_language_top_S_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.T a0_0 =null;

        org.emftext.language.top.T a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return element; }

            // Top.g:2651:2: ( (a0_0= parse_org_emftext_language_top_T ) ( (a1= 's' (a2_0= parse_org_emftext_language_top_T ) ) )* )
            // Top.g:2652:2: (a0_0= parse_org_emftext_language_top_T ) ( (a1= 's' (a2_0= parse_org_emftext_language_top_T ) ) )*
            {
            // Top.g:2652:2: (a0_0= parse_org_emftext_language_top_T )
            // Top.g:2653:3: a0_0= parse_org_emftext_language_top_T
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_T_in_parse_org_emftext_language_top_S2266);
            a0_0=parse_org_emftext_language_top_T();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createS();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.S__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_19_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[590]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[591]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[592]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[593]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[594]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[595]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[596]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[597]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[598]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[599]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[600]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[601]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[602]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[603]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[604]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[605]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[606]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[607]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[608]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[609]);
            	}

            // Top.g:2697:2: ( (a1= 's' (a2_0= parse_org_emftext_language_top_T ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==27) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // Top.g:2698:3: (a1= 's' (a2_0= parse_org_emftext_language_top_T ) )
            	    {
            	    // Top.g:2698:3: (a1= 's' (a2_0= parse_org_emftext_language_top_T ) )
            	    // Top.g:2699:4: a1= 's' (a2_0= parse_org_emftext_language_top_T )
            	    {
            	    a1=(Token)match(input,27,FOLLOW_27_in_parse_org_emftext_language_top_S2293); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createS();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_19_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getS(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[610]);
            	    			}

            	    // Top.g:2713:4: (a2_0= parse_org_emftext_language_top_T )
            	    // Top.g:2714:5: a2_0= parse_org_emftext_language_top_T
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_T_in_parse_org_emftext_language_top_S2319);
            	    a2_0=parse_org_emftext_language_top_T();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createS();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.S__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_19_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[611]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[612]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[613]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[614]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[615]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[616]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[617]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[618]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[619]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[620]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[621]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[622]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[623]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[624]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[625]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[626]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[627]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[628]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[629]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[630]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[631]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[632]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[633]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[634]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[635]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[636]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[637]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[638]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[639]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[640]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[641]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[642]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[643]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[644]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[645]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[646]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[647]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[648]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[649]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[650]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 21, parse_org_emftext_language_top_S_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_S"



    // $ANTLR start "parse_org_emftext_language_top_T"
    // Top.g:2786:1: parse_org_emftext_language_top_T returns [org.emftext.language.top.T element = null] : (a0_0= parse_org_emftext_language_top_U ) ( (a1= 't' (a2_0= parse_org_emftext_language_top_U ) ) )* ;
    public final org.emftext.language.top.T parse_org_emftext_language_top_T() throws RecognitionException {
        org.emftext.language.top.T element =  null;

        int parse_org_emftext_language_top_T_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.U a0_0 =null;

        org.emftext.language.top.U a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return element; }

            // Top.g:2789:2: ( (a0_0= parse_org_emftext_language_top_U ) ( (a1= 't' (a2_0= parse_org_emftext_language_top_U ) ) )* )
            // Top.g:2790:2: (a0_0= parse_org_emftext_language_top_U ) ( (a1= 't' (a2_0= parse_org_emftext_language_top_U ) ) )*
            {
            // Top.g:2790:2: (a0_0= parse_org_emftext_language_top_U )
            // Top.g:2791:3: a0_0= parse_org_emftext_language_top_U
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_U_in_parse_org_emftext_language_top_T2379);
            a0_0=parse_org_emftext_language_top_U();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createT();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.T__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_20_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[651]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[652]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[653]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[654]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[655]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[656]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[657]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[658]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[659]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[660]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[661]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[662]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[663]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[664]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[665]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[666]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[667]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[668]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[669]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[670]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[671]);
            	}

            // Top.g:2836:2: ( (a1= 't' (a2_0= parse_org_emftext_language_top_U ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==28) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // Top.g:2837:3: (a1= 't' (a2_0= parse_org_emftext_language_top_U ) )
            	    {
            	    // Top.g:2837:3: (a1= 't' (a2_0= parse_org_emftext_language_top_U ) )
            	    // Top.g:2838:4: a1= 't' (a2_0= parse_org_emftext_language_top_U )
            	    {
            	    a1=(Token)match(input,28,FOLLOW_28_in_parse_org_emftext_language_top_T2406); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createT();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_20_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getT(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[672]);
            	    			}

            	    // Top.g:2852:4: (a2_0= parse_org_emftext_language_top_U )
            	    // Top.g:2853:5: a2_0= parse_org_emftext_language_top_U
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_U_in_parse_org_emftext_language_top_T2432);
            	    a2_0=parse_org_emftext_language_top_U();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createT();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.T__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_20_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[673]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[674]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[675]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[676]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[677]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[678]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[679]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[680]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[681]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[682]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[683]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[684]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[685]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[686]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[687]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[688]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[689]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[690]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[691]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[692]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[693]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[694]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[695]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[696]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[697]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[698]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[699]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[700]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[701]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[702]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[703]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[704]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[705]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[706]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[707]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[708]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[709]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[710]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[711]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[712]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[713]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[714]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 22, parse_org_emftext_language_top_T_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_T"



    // $ANTLR start "parse_org_emftext_language_top_U"
    // Top.g:2927:1: parse_org_emftext_language_top_U returns [org.emftext.language.top.U element = null] : (a0_0= parse_org_emftext_language_top_V ) ( (a1= 'u' (a2_0= parse_org_emftext_language_top_V ) ) )* ;
    public final org.emftext.language.top.U parse_org_emftext_language_top_U() throws RecognitionException {
        org.emftext.language.top.U element =  null;

        int parse_org_emftext_language_top_U_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.V a0_0 =null;

        org.emftext.language.top.V a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return element; }

            // Top.g:2930:2: ( (a0_0= parse_org_emftext_language_top_V ) ( (a1= 'u' (a2_0= parse_org_emftext_language_top_V ) ) )* )
            // Top.g:2931:2: (a0_0= parse_org_emftext_language_top_V ) ( (a1= 'u' (a2_0= parse_org_emftext_language_top_V ) ) )*
            {
            // Top.g:2931:2: (a0_0= parse_org_emftext_language_top_V )
            // Top.g:2932:3: a0_0= parse_org_emftext_language_top_V
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_V_in_parse_org_emftext_language_top_U2492);
            a0_0=parse_org_emftext_language_top_V();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createU();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.U__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_21_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[715]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[716]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[717]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[718]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[719]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[720]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[721]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[722]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[723]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[724]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[725]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[726]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[727]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[728]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[729]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[730]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[731]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[732]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[733]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[734]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[735]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[736]);
            	}

            // Top.g:2978:2: ( (a1= 'u' (a2_0= parse_org_emftext_language_top_V ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==29) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // Top.g:2979:3: (a1= 'u' (a2_0= parse_org_emftext_language_top_V ) )
            	    {
            	    // Top.g:2979:3: (a1= 'u' (a2_0= parse_org_emftext_language_top_V ) )
            	    // Top.g:2980:4: a1= 'u' (a2_0= parse_org_emftext_language_top_V )
            	    {
            	    a1=(Token)match(input,29,FOLLOW_29_in_parse_org_emftext_language_top_U2519); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createU();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_21_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getU(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[737]);
            	    			}

            	    // Top.g:2994:4: (a2_0= parse_org_emftext_language_top_V )
            	    // Top.g:2995:5: a2_0= parse_org_emftext_language_top_V
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_V_in_parse_org_emftext_language_top_U2545);
            	    a2_0=parse_org_emftext_language_top_V();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createU();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.U__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_21_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[738]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[739]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[740]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[741]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[742]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[743]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[744]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[745]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[746]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[747]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[748]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[749]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[750]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[751]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[752]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[753]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[754]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[755]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[756]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[757]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[758]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[759]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[760]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[761]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[762]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[763]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[764]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[765]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[766]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[767]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[768]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[769]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[770]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[771]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[772]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[773]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[774]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[775]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[776]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[777]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[778]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[779]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[780]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[781]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 23, parse_org_emftext_language_top_U_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_U"



    // $ANTLR start "parse_org_emftext_language_top_V"
    // Top.g:3071:1: parse_org_emftext_language_top_V returns [org.emftext.language.top.V element = null] : (a0_0= parse_org_emftext_language_top_W ) ( (a1= 'v' (a2_0= parse_org_emftext_language_top_W ) ) )* ;
    public final org.emftext.language.top.V parse_org_emftext_language_top_V() throws RecognitionException {
        org.emftext.language.top.V element =  null;

        int parse_org_emftext_language_top_V_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.W a0_0 =null;

        org.emftext.language.top.W a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return element; }

            // Top.g:3074:2: ( (a0_0= parse_org_emftext_language_top_W ) ( (a1= 'v' (a2_0= parse_org_emftext_language_top_W ) ) )* )
            // Top.g:3075:2: (a0_0= parse_org_emftext_language_top_W ) ( (a1= 'v' (a2_0= parse_org_emftext_language_top_W ) ) )*
            {
            // Top.g:3075:2: (a0_0= parse_org_emftext_language_top_W )
            // Top.g:3076:3: a0_0= parse_org_emftext_language_top_W
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_W_in_parse_org_emftext_language_top_V2605);
            a0_0=parse_org_emftext_language_top_W();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createV();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.V__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_22_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[782]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[783]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[784]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[785]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[786]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[787]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[788]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[789]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[790]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[791]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[792]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[793]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[794]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[795]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[796]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[797]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[798]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[799]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[800]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[801]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[802]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[803]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[804]);
            	}

            // Top.g:3123:2: ( (a1= 'v' (a2_0= parse_org_emftext_language_top_W ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==30) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // Top.g:3124:3: (a1= 'v' (a2_0= parse_org_emftext_language_top_W ) )
            	    {
            	    // Top.g:3124:3: (a1= 'v' (a2_0= parse_org_emftext_language_top_W ) )
            	    // Top.g:3125:4: a1= 'v' (a2_0= parse_org_emftext_language_top_W )
            	    {
            	    a1=(Token)match(input,30,FOLLOW_30_in_parse_org_emftext_language_top_V2632); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createV();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_22_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getV(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[805]);
            	    			}

            	    // Top.g:3139:4: (a2_0= parse_org_emftext_language_top_W )
            	    // Top.g:3140:5: a2_0= parse_org_emftext_language_top_W
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_W_in_parse_org_emftext_language_top_V2658);
            	    a2_0=parse_org_emftext_language_top_W();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createV();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.V__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_22_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[806]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[807]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[808]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[809]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[810]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[811]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[812]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[813]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[814]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[815]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[816]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[817]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[818]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[819]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[820]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[821]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[822]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[823]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[824]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[825]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[826]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[827]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[828]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[829]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[830]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[831]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[832]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[833]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[834]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[835]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[836]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[837]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[838]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[839]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[840]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[841]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[842]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[843]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[844]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[845]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[846]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[847]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[848]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[849]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[850]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[851]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 24, parse_org_emftext_language_top_V_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_V"



    // $ANTLR start "parse_org_emftext_language_top_W"
    // Top.g:3218:1: parse_org_emftext_language_top_W returns [org.emftext.language.top.W element = null] : (a0_0= parse_org_emftext_language_top_X ) ( (a1= 'w' (a2_0= parse_org_emftext_language_top_X ) ) )* ;
    public final org.emftext.language.top.W parse_org_emftext_language_top_W() throws RecognitionException {
        org.emftext.language.top.W element =  null;

        int parse_org_emftext_language_top_W_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.X a0_0 =null;

        org.emftext.language.top.X a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return element; }

            // Top.g:3221:2: ( (a0_0= parse_org_emftext_language_top_X ) ( (a1= 'w' (a2_0= parse_org_emftext_language_top_X ) ) )* )
            // Top.g:3222:2: (a0_0= parse_org_emftext_language_top_X ) ( (a1= 'w' (a2_0= parse_org_emftext_language_top_X ) ) )*
            {
            // Top.g:3222:2: (a0_0= parse_org_emftext_language_top_X )
            // Top.g:3223:3: a0_0= parse_org_emftext_language_top_X
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_X_in_parse_org_emftext_language_top_W2718);
            a0_0=parse_org_emftext_language_top_X();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createW();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.W__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_23_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[852]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[853]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[854]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[855]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[856]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[857]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[858]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[859]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[860]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[861]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[862]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[863]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[864]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[865]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[866]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[867]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[868]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[869]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[870]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[871]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[872]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[873]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[874]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[875]);
            	}

            // Top.g:3271:2: ( (a1= 'w' (a2_0= parse_org_emftext_language_top_X ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==31) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // Top.g:3272:3: (a1= 'w' (a2_0= parse_org_emftext_language_top_X ) )
            	    {
            	    // Top.g:3272:3: (a1= 'w' (a2_0= parse_org_emftext_language_top_X ) )
            	    // Top.g:3273:4: a1= 'w' (a2_0= parse_org_emftext_language_top_X )
            	    {
            	    a1=(Token)match(input,31,FOLLOW_31_in_parse_org_emftext_language_top_W2745); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createW();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_23_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getW(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[876]);
            	    			}

            	    // Top.g:3287:4: (a2_0= parse_org_emftext_language_top_X )
            	    // Top.g:3288:5: a2_0= parse_org_emftext_language_top_X
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_X_in_parse_org_emftext_language_top_W2771);
            	    a2_0=parse_org_emftext_language_top_X();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createW();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.W__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_23_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[877]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[878]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[879]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[880]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[881]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[882]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[883]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[884]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[885]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[886]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[887]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[888]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[889]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[890]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[891]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[892]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[893]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[894]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[895]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[896]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[897]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[898]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[899]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[900]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[901]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[902]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[903]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[904]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[905]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[906]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[907]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[908]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[909]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[910]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[911]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[912]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[913]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[914]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[915]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[916]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[917]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[918]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[919]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[920]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[921]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[922]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[923]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[924]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 25, parse_org_emftext_language_top_W_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_W"



    // $ANTLR start "parse_org_emftext_language_top_X"
    // Top.g:3368:1: parse_org_emftext_language_top_X returns [org.emftext.language.top.X element = null] : (a0_0= parse_org_emftext_language_top_Y ) ( (a1= 'x' (a2_0= parse_org_emftext_language_top_Y ) ) )* ;
    public final org.emftext.language.top.X parse_org_emftext_language_top_X() throws RecognitionException {
        org.emftext.language.top.X element =  null;

        int parse_org_emftext_language_top_X_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.Y a0_0 =null;

        org.emftext.language.top.Y a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return element; }

            // Top.g:3371:2: ( (a0_0= parse_org_emftext_language_top_Y ) ( (a1= 'x' (a2_0= parse_org_emftext_language_top_Y ) ) )* )
            // Top.g:3372:2: (a0_0= parse_org_emftext_language_top_Y ) ( (a1= 'x' (a2_0= parse_org_emftext_language_top_Y ) ) )*
            {
            // Top.g:3372:2: (a0_0= parse_org_emftext_language_top_Y )
            // Top.g:3373:3: a0_0= parse_org_emftext_language_top_Y
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_Y_in_parse_org_emftext_language_top_X2831);
            a0_0=parse_org_emftext_language_top_Y();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createX();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.X__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_24_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[925]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[926]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[927]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[928]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[929]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[930]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[931]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[932]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[933]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[934]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[935]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[936]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[937]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[938]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[939]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[940]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[941]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[942]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[943]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[944]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[945]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[946]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[947]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[948]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[949]);
            	}

            // Top.g:3422:2: ( (a1= 'x' (a2_0= parse_org_emftext_language_top_Y ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==32) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // Top.g:3423:3: (a1= 'x' (a2_0= parse_org_emftext_language_top_Y ) )
            	    {
            	    // Top.g:3423:3: (a1= 'x' (a2_0= parse_org_emftext_language_top_Y ) )
            	    // Top.g:3424:4: a1= 'x' (a2_0= parse_org_emftext_language_top_Y )
            	    {
            	    a1=(Token)match(input,32,FOLLOW_32_in_parse_org_emftext_language_top_X2858); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createX();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_24_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getX(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[950]);
            	    			}

            	    // Top.g:3438:4: (a2_0= parse_org_emftext_language_top_Y )
            	    // Top.g:3439:5: a2_0= parse_org_emftext_language_top_Y
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_Y_in_parse_org_emftext_language_top_X2884);
            	    a2_0=parse_org_emftext_language_top_Y();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createX();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.X__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_24_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[951]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[952]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[953]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[954]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[955]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[956]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[957]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[958]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[959]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[960]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[961]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[962]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[963]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[964]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[965]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[966]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[967]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[968]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[969]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[970]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[971]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[972]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[973]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[974]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[975]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[976]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[977]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[978]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[979]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[980]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[981]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[982]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[983]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[984]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[985]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[986]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[987]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[988]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[989]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[990]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[991]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[992]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[993]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[994]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[995]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[996]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[997]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[998]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[999]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1000]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 26, parse_org_emftext_language_top_X_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_X"



    // $ANTLR start "parse_org_emftext_language_top_Y"
    // Top.g:3521:1: parse_org_emftext_language_top_Y returns [org.emftext.language.top.Y element = null] : (a0_0= parse_org_emftext_language_top_Z ) ( (a1= 'y' (a2_0= parse_org_emftext_language_top_Z ) ) )* ;
    public final org.emftext.language.top.Y parse_org_emftext_language_top_Y() throws RecognitionException {
        org.emftext.language.top.Y element =  null;

        int parse_org_emftext_language_top_Y_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.Z a0_0 =null;

        org.emftext.language.top.Z a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return element; }

            // Top.g:3524:2: ( (a0_0= parse_org_emftext_language_top_Z ) ( (a1= 'y' (a2_0= parse_org_emftext_language_top_Z ) ) )* )
            // Top.g:3525:2: (a0_0= parse_org_emftext_language_top_Z ) ( (a1= 'y' (a2_0= parse_org_emftext_language_top_Z ) ) )*
            {
            // Top.g:3525:2: (a0_0= parse_org_emftext_language_top_Z )
            // Top.g:3526:3: a0_0= parse_org_emftext_language_top_Z
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_Z_in_parse_org_emftext_language_top_Y2944);
            a0_0=parse_org_emftext_language_top_Z();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createY();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.Y__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_25_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1001]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1002]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1003]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1004]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1005]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1006]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1007]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1008]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1009]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1010]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1011]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1012]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1013]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1014]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1015]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1016]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1017]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1018]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1019]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1020]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1021]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1022]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1023]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1024]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1025]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1026]);
            	}

            // Top.g:3576:2: ( (a1= 'y' (a2_0= parse_org_emftext_language_top_Z ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==33) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // Top.g:3577:3: (a1= 'y' (a2_0= parse_org_emftext_language_top_Z ) )
            	    {
            	    // Top.g:3577:3: (a1= 'y' (a2_0= parse_org_emftext_language_top_Z ) )
            	    // Top.g:3578:4: a1= 'y' (a2_0= parse_org_emftext_language_top_Z )
            	    {
            	    a1=(Token)match(input,33,FOLLOW_33_in_parse_org_emftext_language_top_Y2971); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createY();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_25_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getY(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1027]);
            	    			}

            	    // Top.g:3592:4: (a2_0= parse_org_emftext_language_top_Z )
            	    // Top.g:3593:5: a2_0= parse_org_emftext_language_top_Z
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_Z_in_parse_org_emftext_language_top_Y2997);
            	    a2_0=parse_org_emftext_language_top_Z();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createY();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.Y__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_25_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1028]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1029]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1030]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1031]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1032]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1033]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1034]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1035]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1036]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1037]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1038]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1039]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1040]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1041]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1042]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1043]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1044]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1045]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1046]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1047]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1048]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1049]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1050]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1051]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1052]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1053]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1054]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1055]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1056]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1057]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1058]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1059]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1060]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1061]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1062]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1063]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1064]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1065]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1066]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1067]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1068]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1069]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1070]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1071]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1072]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1073]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1074]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1075]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1076]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1077]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1078]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1079]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 27, parse_org_emftext_language_top_Y_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_Y"



    // $ANTLR start "parse_org_emftext_language_top_Z"
    // Top.g:3677:1: parse_org_emftext_language_top_Z returns [org.emftext.language.top.Z element = null] : (a0_0= parse_org_emftext_language_top_ZChild ) ( (a1= 'z' (a2_0= parse_org_emftext_language_top_ZChild ) ) )* ;
    public final org.emftext.language.top.Z parse_org_emftext_language_top_Z() throws RecognitionException {
        org.emftext.language.top.Z element =  null;

        int parse_org_emftext_language_top_Z_StartIndex = input.index();

        Token a1=null;
        org.emftext.language.top.ZChild a0_0 =null;

        org.emftext.language.top.ZChild a2_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return element; }

            // Top.g:3680:2: ( (a0_0= parse_org_emftext_language_top_ZChild ) ( (a1= 'z' (a2_0= parse_org_emftext_language_top_ZChild ) ) )* )
            // Top.g:3681:2: (a0_0= parse_org_emftext_language_top_ZChild ) ( (a1= 'z' (a2_0= parse_org_emftext_language_top_ZChild ) ) )*
            {
            // Top.g:3681:2: (a0_0= parse_org_emftext_language_top_ZChild )
            // Top.g:3682:3: a0_0= parse_org_emftext_language_top_ZChild
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_ZChild_in_parse_org_emftext_language_top_Z3057);
            a0_0=parse_org_emftext_language_top_ZChild();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createZ();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					addObjectToList(element, org.emftext.language.top.TopPackage.Z__CHILD, value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_26_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1080]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1081]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1082]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1083]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1084]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1085]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1086]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1087]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1088]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1089]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1090]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1091]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1092]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1093]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1094]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1095]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1096]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1097]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1098]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1099]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1100]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1101]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1102]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1103]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1104]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1105]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1106]);
            	}

            // Top.g:3733:2: ( (a1= 'z' (a2_0= parse_org_emftext_language_top_ZChild ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==34) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // Top.g:3734:3: (a1= 'z' (a2_0= parse_org_emftext_language_top_ZChild ) )
            	    {
            	    // Top.g:3734:3: (a1= 'z' (a2_0= parse_org_emftext_language_top_ZChild ) )
            	    // Top.g:3735:4: a1= 'z' (a2_0= parse_org_emftext_language_top_ZChild )
            	    {
            	    a1=(Token)match(input,34,FOLLOW_34_in_parse_org_emftext_language_top_Z3084); if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    				if (element == null) {
            	    					element = org.emftext.language.top.TopFactory.eINSTANCE.createZ();
            	    					startIncompleteElement(element);
            	    				}
            	    				collectHiddenTokens(element);
            	    				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_26_0_0_1_0_0_0, null, true);
            	    				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
            	    			}

            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getZ(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1107]);
            	    			}

            	    // Top.g:3749:4: (a2_0= parse_org_emftext_language_top_ZChild )
            	    // Top.g:3750:5: a2_0= parse_org_emftext_language_top_ZChild
            	    {
            	    pushFollow(FOLLOW_parse_org_emftext_language_top_ZChild_in_parse_org_emftext_language_top_Z3110);
            	    a2_0=parse_org_emftext_language_top_ZChild();

            	    state._fsp--;
            	    if (state.failed) return element;

            	    if ( state.backtracking==0 ) {
            	    					if (terminateParsing) {
            	    						throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            	    					}
            	    					if (element == null) {
            	    						element = org.emftext.language.top.TopFactory.eINSTANCE.createZ();
            	    						startIncompleteElement(element);
            	    					}
            	    					if (a2_0 != null) {
            	    						if (a2_0 != null) {
            	    							Object value = a2_0;
            	    							addObjectToList(element, org.emftext.language.top.TopPackage.Z__CHILD, value);
            	    							completedElement(value, true);
            	    						}
            	    						collectHiddenTokens(element);
            	    						retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_26_0_0_1_0_0_1, a2_0, true);
            	    						copyLocalizationInfos(a2_0, element);
            	    					}
            	    				}

            	    }


            	    if ( state.backtracking==0 ) {
            	    				// expected elements (follow set)
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1108]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1109]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1110]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1111]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1112]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1113]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1114]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1115]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1116]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1117]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1118]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1119]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1120]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1121]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1122]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1123]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1124]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1125]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1126]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1127]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1128]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1129]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1130]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1131]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1132]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1133]);
            	    				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1134]);
            	    			}

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1135]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1136]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1137]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1138]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1139]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1140]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1141]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1142]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1143]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1144]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1145]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1146]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1147]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1148]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1149]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1150]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1151]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1152]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1153]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1154]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1155]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1156]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1157]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1158]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1159]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1160]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1161]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 28, parse_org_emftext_language_top_Z_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_Z"



    // $ANTLR start "parse_org_emftext_language_top_IntegerLiteral"
    // Top.g:3836:1: parse_org_emftext_language_top_IntegerLiteral returns [org.emftext.language.top.IntegerLiteral element = null] : (a0= INTEGER_LITERAL ) ;
    public final org.emftext.language.top.IntegerLiteral parse_org_emftext_language_top_IntegerLiteral() throws RecognitionException {
        org.emftext.language.top.IntegerLiteral element =  null;

        int parse_org_emftext_language_top_IntegerLiteral_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return element; }

            // Top.g:3839:2: ( (a0= INTEGER_LITERAL ) )
            // Top.g:3840:2: (a0= INTEGER_LITERAL )
            {
            // Top.g:3840:2: (a0= INTEGER_LITERAL )
            // Top.g:3841:3: a0= INTEGER_LITERAL
            {
            a0=(Token)match(input,INTEGER_LITERAL,FOLLOW_INTEGER_LITERAL_in_parse_org_emftext_language_top_IntegerLiteral3170); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.language.top.resource.top.mopp.TopTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.language.top.TopFactory.eINSTANCE.createIntegerLiteral();
            				startIncompleteElement(element);
            			}
            			if (a0 != null) {
            				org.emftext.language.top.resource.top.ITopTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER_LITERAL");
            				tokenResolver.setOptions(getOptions());
            				org.emftext.language.top.resource.top.ITopTokenResolveResult result = getFreshTokenResolveResult();
            				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.language.top.TopPackage.INTEGER_LITERAL__VALUE), result);
            				Object resolvedObject = result.getResolvedToken();
            				if (resolvedObject == null) {
            					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            				}
            				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
            				if (resolved != null) {
            					Object value = resolved;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.language.top.TopPackage.INTEGER_LITERAL__VALUE), value);
            					completedElement(value, false);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_27_0_0_0, resolved, true);
            				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1162]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1163]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1164]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1165]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1166]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1167]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1168]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1169]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1170]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1171]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1172]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1173]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1174]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1175]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1176]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1177]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1178]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1179]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1180]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1181]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1182]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1183]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1184]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1185]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1186]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1187]);
            		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1188]);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 29, parse_org_emftext_language_top_IntegerLiteral_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_IntegerLiteral"



    // $ANTLR start "parse_org_emftext_language_top_ExprChild"
    // Top.g:3904:1: parse_org_emftext_language_top_ExprChild returns [org.emftext.language.top.ExprChild element = null] : (c0= parse_org_emftext_language_top_A |c1= parse_org_emftext_language_top_B |c2= parse_org_emftext_language_top_C |c3= parse_org_emftext_language_top_D |c4= parse_org_emftext_language_top_E |c5= parse_org_emftext_language_top_F |c6= parse_org_emftext_language_top_G |c7= parse_org_emftext_language_top_H |c8= parse_org_emftext_language_top_I |c9= parse_org_emftext_language_top_J |c10= parse_org_emftext_language_top_K |c11= parse_org_emftext_language_top_L |c12= parse_org_emftext_language_top_M |c13= parse_org_emftext_language_top_N |c14= parse_org_emftext_language_top_O |c15= parse_org_emftext_language_top_P |c16= parse_org_emftext_language_top_Q |c17= parse_org_emftext_language_top_R |c18= parse_org_emftext_language_top_S |c19= parse_org_emftext_language_top_T |c20= parse_org_emftext_language_top_U |c21= parse_org_emftext_language_top_V |c22= parse_org_emftext_language_top_W |c23= parse_org_emftext_language_top_X |c24= parse_org_emftext_language_top_Y |c25= parse_org_emftext_language_top_Z |c26= parse_org_emftext_language_top_IntegerLiteral );
    public final org.emftext.language.top.ExprChild parse_org_emftext_language_top_ExprChild() throws RecognitionException {
        org.emftext.language.top.ExprChild element =  null;

        int parse_org_emftext_language_top_ExprChild_StartIndex = input.index();

        org.emftext.language.top.A c0 =null;

        org.emftext.language.top.B c1 =null;

        org.emftext.language.top.C c2 =null;

        org.emftext.language.top.D c3 =null;

        org.emftext.language.top.E c4 =null;

        org.emftext.language.top.F c5 =null;

        org.emftext.language.top.G c6 =null;

        org.emftext.language.top.H c7 =null;

        org.emftext.language.top.I c8 =null;

        org.emftext.language.top.J c9 =null;

        org.emftext.language.top.K c10 =null;

        org.emftext.language.top.L c11 =null;

        org.emftext.language.top.M c12 =null;

        org.emftext.language.top.N c13 =null;

        org.emftext.language.top.O c14 =null;

        org.emftext.language.top.P c15 =null;

        org.emftext.language.top.Q c16 =null;

        org.emftext.language.top.R c17 =null;

        org.emftext.language.top.S c18 =null;

        org.emftext.language.top.T c19 =null;

        org.emftext.language.top.U c20 =null;

        org.emftext.language.top.V c21 =null;

        org.emftext.language.top.W c22 =null;

        org.emftext.language.top.X c23 =null;

        org.emftext.language.top.Y c24 =null;

        org.emftext.language.top.Z c25 =null;

        org.emftext.language.top.IntegerLiteral c26 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return element; }

            // Top.g:3905:2: (c0= parse_org_emftext_language_top_A |c1= parse_org_emftext_language_top_B |c2= parse_org_emftext_language_top_C |c3= parse_org_emftext_language_top_D |c4= parse_org_emftext_language_top_E |c5= parse_org_emftext_language_top_F |c6= parse_org_emftext_language_top_G |c7= parse_org_emftext_language_top_H |c8= parse_org_emftext_language_top_I |c9= parse_org_emftext_language_top_J |c10= parse_org_emftext_language_top_K |c11= parse_org_emftext_language_top_L |c12= parse_org_emftext_language_top_M |c13= parse_org_emftext_language_top_N |c14= parse_org_emftext_language_top_O |c15= parse_org_emftext_language_top_P |c16= parse_org_emftext_language_top_Q |c17= parse_org_emftext_language_top_R |c18= parse_org_emftext_language_top_S |c19= parse_org_emftext_language_top_T |c20= parse_org_emftext_language_top_U |c21= parse_org_emftext_language_top_V |c22= parse_org_emftext_language_top_W |c23= parse_org_emftext_language_top_X |c24= parse_org_emftext_language_top_Y |c25= parse_org_emftext_language_top_Z |c26= parse_org_emftext_language_top_IntegerLiteral )
            int alt28=27;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==INTEGER_LITERAL) ) {
                int LA28_1 = input.LA(2);

                if ( (synpred28_Top()) ) {
                    alt28=1;
                }
                else if ( (synpred29_Top()) ) {
                    alt28=2;
                }
                else if ( (synpred30_Top()) ) {
                    alt28=3;
                }
                else if ( (synpred31_Top()) ) {
                    alt28=4;
                }
                else if ( (synpred32_Top()) ) {
                    alt28=5;
                }
                else if ( (synpred33_Top()) ) {
                    alt28=6;
                }
                else if ( (synpred34_Top()) ) {
                    alt28=7;
                }
                else if ( (synpred35_Top()) ) {
                    alt28=8;
                }
                else if ( (synpred36_Top()) ) {
                    alt28=9;
                }
                else if ( (synpred37_Top()) ) {
                    alt28=10;
                }
                else if ( (synpred38_Top()) ) {
                    alt28=11;
                }
                else if ( (synpred39_Top()) ) {
                    alt28=12;
                }
                else if ( (synpred40_Top()) ) {
                    alt28=13;
                }
                else if ( (synpred41_Top()) ) {
                    alt28=14;
                }
                else if ( (synpred42_Top()) ) {
                    alt28=15;
                }
                else if ( (synpred43_Top()) ) {
                    alt28=16;
                }
                else if ( (synpred44_Top()) ) {
                    alt28=17;
                }
                else if ( (synpred45_Top()) ) {
                    alt28=18;
                }
                else if ( (synpred46_Top()) ) {
                    alt28=19;
                }
                else if ( (synpred47_Top()) ) {
                    alt28=20;
                }
                else if ( (synpred48_Top()) ) {
                    alt28=21;
                }
                else if ( (synpred49_Top()) ) {
                    alt28=22;
                }
                else if ( (synpred50_Top()) ) {
                    alt28=23;
                }
                else if ( (synpred51_Top()) ) {
                    alt28=24;
                }
                else if ( (synpred52_Top()) ) {
                    alt28=25;
                }
                else if ( (synpred53_Top()) ) {
                    alt28=26;
                }
                else if ( (true) ) {
                    alt28=27;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return element;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }
            switch (alt28) {
                case 1 :
                    // Top.g:3906:2: c0= parse_org_emftext_language_top_A
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_A_in_parse_org_emftext_language_top_ExprChild3202);
                    c0=parse_org_emftext_language_top_A();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Top.g:3907:4: c1= parse_org_emftext_language_top_B
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_B_in_parse_org_emftext_language_top_ExprChild3212);
                    c1=parse_org_emftext_language_top_B();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 3 :
                    // Top.g:3908:4: c2= parse_org_emftext_language_top_C
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_C_in_parse_org_emftext_language_top_ExprChild3222);
                    c2=parse_org_emftext_language_top_C();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c2; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 4 :
                    // Top.g:3909:4: c3= parse_org_emftext_language_top_D
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_D_in_parse_org_emftext_language_top_ExprChild3232);
                    c3=parse_org_emftext_language_top_D();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c3; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 5 :
                    // Top.g:3910:4: c4= parse_org_emftext_language_top_E
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_E_in_parse_org_emftext_language_top_ExprChild3242);
                    c4=parse_org_emftext_language_top_E();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c4; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 6 :
                    // Top.g:3911:4: c5= parse_org_emftext_language_top_F
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_F_in_parse_org_emftext_language_top_ExprChild3252);
                    c5=parse_org_emftext_language_top_F();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c5; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 7 :
                    // Top.g:3912:4: c6= parse_org_emftext_language_top_G
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_G_in_parse_org_emftext_language_top_ExprChild3262);
                    c6=parse_org_emftext_language_top_G();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c6; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 8 :
                    // Top.g:3913:4: c7= parse_org_emftext_language_top_H
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_H_in_parse_org_emftext_language_top_ExprChild3272);
                    c7=parse_org_emftext_language_top_H();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c7; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 9 :
                    // Top.g:3914:4: c8= parse_org_emftext_language_top_I
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_I_in_parse_org_emftext_language_top_ExprChild3282);
                    c8=parse_org_emftext_language_top_I();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c8; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 10 :
                    // Top.g:3915:4: c9= parse_org_emftext_language_top_J
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_J_in_parse_org_emftext_language_top_ExprChild3292);
                    c9=parse_org_emftext_language_top_J();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c9; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 11 :
                    // Top.g:3916:4: c10= parse_org_emftext_language_top_K
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_K_in_parse_org_emftext_language_top_ExprChild3302);
                    c10=parse_org_emftext_language_top_K();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c10; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 12 :
                    // Top.g:3917:4: c11= parse_org_emftext_language_top_L
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_L_in_parse_org_emftext_language_top_ExprChild3312);
                    c11=parse_org_emftext_language_top_L();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c11; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 13 :
                    // Top.g:3918:4: c12= parse_org_emftext_language_top_M
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_M_in_parse_org_emftext_language_top_ExprChild3322);
                    c12=parse_org_emftext_language_top_M();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c12; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 14 :
                    // Top.g:3919:4: c13= parse_org_emftext_language_top_N
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_N_in_parse_org_emftext_language_top_ExprChild3332);
                    c13=parse_org_emftext_language_top_N();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c13; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 15 :
                    // Top.g:3920:4: c14= parse_org_emftext_language_top_O
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_O_in_parse_org_emftext_language_top_ExprChild3342);
                    c14=parse_org_emftext_language_top_O();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c14; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 16 :
                    // Top.g:3921:4: c15= parse_org_emftext_language_top_P
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_P_in_parse_org_emftext_language_top_ExprChild3352);
                    c15=parse_org_emftext_language_top_P();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c15; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 17 :
                    // Top.g:3922:4: c16= parse_org_emftext_language_top_Q
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_Q_in_parse_org_emftext_language_top_ExprChild3362);
                    c16=parse_org_emftext_language_top_Q();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c16; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 18 :
                    // Top.g:3923:4: c17= parse_org_emftext_language_top_R
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_R_in_parse_org_emftext_language_top_ExprChild3372);
                    c17=parse_org_emftext_language_top_R();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c17; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 19 :
                    // Top.g:3924:4: c18= parse_org_emftext_language_top_S
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_S_in_parse_org_emftext_language_top_ExprChild3382);
                    c18=parse_org_emftext_language_top_S();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c18; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 20 :
                    // Top.g:3925:4: c19= parse_org_emftext_language_top_T
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_T_in_parse_org_emftext_language_top_ExprChild3392);
                    c19=parse_org_emftext_language_top_T();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c19; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 21 :
                    // Top.g:3926:4: c20= parse_org_emftext_language_top_U
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_U_in_parse_org_emftext_language_top_ExprChild3402);
                    c20=parse_org_emftext_language_top_U();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c20; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 22 :
                    // Top.g:3927:4: c21= parse_org_emftext_language_top_V
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_V_in_parse_org_emftext_language_top_ExprChild3412);
                    c21=parse_org_emftext_language_top_V();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c21; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 23 :
                    // Top.g:3928:4: c22= parse_org_emftext_language_top_W
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_W_in_parse_org_emftext_language_top_ExprChild3422);
                    c22=parse_org_emftext_language_top_W();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c22; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 24 :
                    // Top.g:3929:4: c23= parse_org_emftext_language_top_X
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_X_in_parse_org_emftext_language_top_ExprChild3432);
                    c23=parse_org_emftext_language_top_X();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c23; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 25 :
                    // Top.g:3930:4: c24= parse_org_emftext_language_top_Y
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_Y_in_parse_org_emftext_language_top_ExprChild3442);
                    c24=parse_org_emftext_language_top_Y();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c24; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 26 :
                    // Top.g:3931:4: c25= parse_org_emftext_language_top_Z
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_Z_in_parse_org_emftext_language_top_ExprChild3452);
                    c25=parse_org_emftext_language_top_Z();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c25; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 27 :
                    // Top.g:3932:4: c26= parse_org_emftext_language_top_IntegerLiteral
                    {
                    pushFollow(FOLLOW_parse_org_emftext_language_top_IntegerLiteral_in_parse_org_emftext_language_top_ExprChild3462);
                    c26=parse_org_emftext_language_top_IntegerLiteral();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c26; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 30, parse_org_emftext_language_top_ExprChild_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_ExprChild"



    // $ANTLR start "parse_org_emftext_language_top_ZChild"
    // Top.g:3936:1: parse_org_emftext_language_top_ZChild returns [org.emftext.language.top.ZChild element = null] : c0= parse_org_emftext_language_top_IntegerLiteral ;
    public final org.emftext.language.top.ZChild parse_org_emftext_language_top_ZChild() throws RecognitionException {
        org.emftext.language.top.ZChild element =  null;

        int parse_org_emftext_language_top_ZChild_StartIndex = input.index();

        org.emftext.language.top.IntegerLiteral c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return element; }

            // Top.g:3937:2: (c0= parse_org_emftext_language_top_IntegerLiteral )
            // Top.g:3938:2: c0= parse_org_emftext_language_top_IntegerLiteral
            {
            pushFollow(FOLLOW_parse_org_emftext_language_top_IntegerLiteral_in_parse_org_emftext_language_top_ZChild3483);
            c0=parse_org_emftext_language_top_IntegerLiteral();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 31, parse_org_emftext_language_top_ZChild_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_language_top_ZChild"

    // $ANTLR start synpred28_Top
    public final void synpred28_Top_fragment() throws RecognitionException {
        org.emftext.language.top.A c0 =null;


        // Top.g:3906:2: (c0= parse_org_emftext_language_top_A )
        // Top.g:3906:2: c0= parse_org_emftext_language_top_A
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_A_in_synpred28_Top3202);
        c0=parse_org_emftext_language_top_A();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred28_Top

    // $ANTLR start synpred29_Top
    public final void synpred29_Top_fragment() throws RecognitionException {
        org.emftext.language.top.B c1 =null;


        // Top.g:3907:4: (c1= parse_org_emftext_language_top_B )
        // Top.g:3907:4: c1= parse_org_emftext_language_top_B
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_B_in_synpred29_Top3212);
        c1=parse_org_emftext_language_top_B();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred29_Top

    // $ANTLR start synpred30_Top
    public final void synpred30_Top_fragment() throws RecognitionException {
        org.emftext.language.top.C c2 =null;


        // Top.g:3908:4: (c2= parse_org_emftext_language_top_C )
        // Top.g:3908:4: c2= parse_org_emftext_language_top_C
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_C_in_synpred30_Top3222);
        c2=parse_org_emftext_language_top_C();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred30_Top

    // $ANTLR start synpred31_Top
    public final void synpred31_Top_fragment() throws RecognitionException {
        org.emftext.language.top.D c3 =null;


        // Top.g:3909:4: (c3= parse_org_emftext_language_top_D )
        // Top.g:3909:4: c3= parse_org_emftext_language_top_D
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_D_in_synpred31_Top3232);
        c3=parse_org_emftext_language_top_D();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred31_Top

    // $ANTLR start synpred32_Top
    public final void synpred32_Top_fragment() throws RecognitionException {
        org.emftext.language.top.E c4 =null;


        // Top.g:3910:4: (c4= parse_org_emftext_language_top_E )
        // Top.g:3910:4: c4= parse_org_emftext_language_top_E
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_E_in_synpred32_Top3242);
        c4=parse_org_emftext_language_top_E();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred32_Top

    // $ANTLR start synpred33_Top
    public final void synpred33_Top_fragment() throws RecognitionException {
        org.emftext.language.top.F c5 =null;


        // Top.g:3911:4: (c5= parse_org_emftext_language_top_F )
        // Top.g:3911:4: c5= parse_org_emftext_language_top_F
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_F_in_synpred33_Top3252);
        c5=parse_org_emftext_language_top_F();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred33_Top

    // $ANTLR start synpred34_Top
    public final void synpred34_Top_fragment() throws RecognitionException {
        org.emftext.language.top.G c6 =null;


        // Top.g:3912:4: (c6= parse_org_emftext_language_top_G )
        // Top.g:3912:4: c6= parse_org_emftext_language_top_G
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_G_in_synpred34_Top3262);
        c6=parse_org_emftext_language_top_G();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred34_Top

    // $ANTLR start synpred35_Top
    public final void synpred35_Top_fragment() throws RecognitionException {
        org.emftext.language.top.H c7 =null;


        // Top.g:3913:4: (c7= parse_org_emftext_language_top_H )
        // Top.g:3913:4: c7= parse_org_emftext_language_top_H
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_H_in_synpred35_Top3272);
        c7=parse_org_emftext_language_top_H();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred35_Top

    // $ANTLR start synpred36_Top
    public final void synpred36_Top_fragment() throws RecognitionException {
        org.emftext.language.top.I c8 =null;


        // Top.g:3914:4: (c8= parse_org_emftext_language_top_I )
        // Top.g:3914:4: c8= parse_org_emftext_language_top_I
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_I_in_synpred36_Top3282);
        c8=parse_org_emftext_language_top_I();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred36_Top

    // $ANTLR start synpred37_Top
    public final void synpred37_Top_fragment() throws RecognitionException {
        org.emftext.language.top.J c9 =null;


        // Top.g:3915:4: (c9= parse_org_emftext_language_top_J )
        // Top.g:3915:4: c9= parse_org_emftext_language_top_J
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_J_in_synpred37_Top3292);
        c9=parse_org_emftext_language_top_J();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred37_Top

    // $ANTLR start synpred38_Top
    public final void synpred38_Top_fragment() throws RecognitionException {
        org.emftext.language.top.K c10 =null;


        // Top.g:3916:4: (c10= parse_org_emftext_language_top_K )
        // Top.g:3916:4: c10= parse_org_emftext_language_top_K
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_K_in_synpred38_Top3302);
        c10=parse_org_emftext_language_top_K();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred38_Top

    // $ANTLR start synpred39_Top
    public final void synpred39_Top_fragment() throws RecognitionException {
        org.emftext.language.top.L c11 =null;


        // Top.g:3917:4: (c11= parse_org_emftext_language_top_L )
        // Top.g:3917:4: c11= parse_org_emftext_language_top_L
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_L_in_synpred39_Top3312);
        c11=parse_org_emftext_language_top_L();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred39_Top

    // $ANTLR start synpred40_Top
    public final void synpred40_Top_fragment() throws RecognitionException {
        org.emftext.language.top.M c12 =null;


        // Top.g:3918:4: (c12= parse_org_emftext_language_top_M )
        // Top.g:3918:4: c12= parse_org_emftext_language_top_M
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_M_in_synpred40_Top3322);
        c12=parse_org_emftext_language_top_M();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred40_Top

    // $ANTLR start synpred41_Top
    public final void synpred41_Top_fragment() throws RecognitionException {
        org.emftext.language.top.N c13 =null;


        // Top.g:3919:4: (c13= parse_org_emftext_language_top_N )
        // Top.g:3919:4: c13= parse_org_emftext_language_top_N
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_N_in_synpred41_Top3332);
        c13=parse_org_emftext_language_top_N();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred41_Top

    // $ANTLR start synpred42_Top
    public final void synpred42_Top_fragment() throws RecognitionException {
        org.emftext.language.top.O c14 =null;


        // Top.g:3920:4: (c14= parse_org_emftext_language_top_O )
        // Top.g:3920:4: c14= parse_org_emftext_language_top_O
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_O_in_synpred42_Top3342);
        c14=parse_org_emftext_language_top_O();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred42_Top

    // $ANTLR start synpred43_Top
    public final void synpred43_Top_fragment() throws RecognitionException {
        org.emftext.language.top.P c15 =null;


        // Top.g:3921:4: (c15= parse_org_emftext_language_top_P )
        // Top.g:3921:4: c15= parse_org_emftext_language_top_P
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_P_in_synpred43_Top3352);
        c15=parse_org_emftext_language_top_P();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred43_Top

    // $ANTLR start synpred44_Top
    public final void synpred44_Top_fragment() throws RecognitionException {
        org.emftext.language.top.Q c16 =null;


        // Top.g:3922:4: (c16= parse_org_emftext_language_top_Q )
        // Top.g:3922:4: c16= parse_org_emftext_language_top_Q
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_Q_in_synpred44_Top3362);
        c16=parse_org_emftext_language_top_Q();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred44_Top

    // $ANTLR start synpred45_Top
    public final void synpred45_Top_fragment() throws RecognitionException {
        org.emftext.language.top.R c17 =null;


        // Top.g:3923:4: (c17= parse_org_emftext_language_top_R )
        // Top.g:3923:4: c17= parse_org_emftext_language_top_R
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_R_in_synpred45_Top3372);
        c17=parse_org_emftext_language_top_R();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred45_Top

    // $ANTLR start synpred46_Top
    public final void synpred46_Top_fragment() throws RecognitionException {
        org.emftext.language.top.S c18 =null;


        // Top.g:3924:4: (c18= parse_org_emftext_language_top_S )
        // Top.g:3924:4: c18= parse_org_emftext_language_top_S
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_S_in_synpred46_Top3382);
        c18=parse_org_emftext_language_top_S();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred46_Top

    // $ANTLR start synpred47_Top
    public final void synpred47_Top_fragment() throws RecognitionException {
        org.emftext.language.top.T c19 =null;


        // Top.g:3925:4: (c19= parse_org_emftext_language_top_T )
        // Top.g:3925:4: c19= parse_org_emftext_language_top_T
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_T_in_synpred47_Top3392);
        c19=parse_org_emftext_language_top_T();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred47_Top

    // $ANTLR start synpred48_Top
    public final void synpred48_Top_fragment() throws RecognitionException {
        org.emftext.language.top.U c20 =null;


        // Top.g:3926:4: (c20= parse_org_emftext_language_top_U )
        // Top.g:3926:4: c20= parse_org_emftext_language_top_U
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_U_in_synpred48_Top3402);
        c20=parse_org_emftext_language_top_U();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred48_Top

    // $ANTLR start synpred49_Top
    public final void synpred49_Top_fragment() throws RecognitionException {
        org.emftext.language.top.V c21 =null;


        // Top.g:3927:4: (c21= parse_org_emftext_language_top_V )
        // Top.g:3927:4: c21= parse_org_emftext_language_top_V
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_V_in_synpred49_Top3412);
        c21=parse_org_emftext_language_top_V();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred49_Top

    // $ANTLR start synpred50_Top
    public final void synpred50_Top_fragment() throws RecognitionException {
        org.emftext.language.top.W c22 =null;


        // Top.g:3928:4: (c22= parse_org_emftext_language_top_W )
        // Top.g:3928:4: c22= parse_org_emftext_language_top_W
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_W_in_synpred50_Top3422);
        c22=parse_org_emftext_language_top_W();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred50_Top

    // $ANTLR start synpred51_Top
    public final void synpred51_Top_fragment() throws RecognitionException {
        org.emftext.language.top.X c23 =null;


        // Top.g:3929:4: (c23= parse_org_emftext_language_top_X )
        // Top.g:3929:4: c23= parse_org_emftext_language_top_X
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_X_in_synpred51_Top3432);
        c23=parse_org_emftext_language_top_X();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred51_Top

    // $ANTLR start synpred52_Top
    public final void synpred52_Top_fragment() throws RecognitionException {
        org.emftext.language.top.Y c24 =null;


        // Top.g:3930:4: (c24= parse_org_emftext_language_top_Y )
        // Top.g:3930:4: c24= parse_org_emftext_language_top_Y
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_Y_in_synpred52_Top3442);
        c24=parse_org_emftext_language_top_Y();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred52_Top

    // $ANTLR start synpred53_Top
    public final void synpred53_Top_fragment() throws RecognitionException {
        org.emftext.language.top.Z c25 =null;


        // Top.g:3931:4: (c25= parse_org_emftext_language_top_Z )
        // Top.g:3931:4: c25= parse_org_emftext_language_top_Z
        {
        pushFollow(FOLLOW_parse_org_emftext_language_top_Z_in_synpred53_Top3452);
        c25=parse_org_emftext_language_top_Z();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred53_Top

    // Delegated rules

    public final boolean synpred33_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred50_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred51_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred51_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred49_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred49_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred28_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred53_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred48_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred48_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_Top() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_Top_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_parse_org_emftext_language_top_Expr_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_ExprChild_in_parse_org_emftext_language_top_Expr119 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_8_in_parse_org_emftext_language_top_Expr146 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_ExprChild_in_parse_org_emftext_language_top_Expr172 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_B_in_parse_org_emftext_language_top_A232 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_9_in_parse_org_emftext_language_top_A259 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_B_in_parse_org_emftext_language_top_A285 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_C_in_parse_org_emftext_language_top_B345 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_parse_org_emftext_language_top_B372 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_C_in_parse_org_emftext_language_top_B398 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_D_in_parse_org_emftext_language_top_C458 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_parse_org_emftext_language_top_C485 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_D_in_parse_org_emftext_language_top_C511 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_E_in_parse_org_emftext_language_top_D571 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_parse_org_emftext_language_top_D598 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_E_in_parse_org_emftext_language_top_D624 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_F_in_parse_org_emftext_language_top_E684 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_parse_org_emftext_language_top_E711 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_F_in_parse_org_emftext_language_top_E737 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_G_in_parse_org_emftext_language_top_F797 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_parse_org_emftext_language_top_F824 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_G_in_parse_org_emftext_language_top_F850 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_H_in_parse_org_emftext_language_top_G910 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_parse_org_emftext_language_top_G937 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_H_in_parse_org_emftext_language_top_G963 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_I_in_parse_org_emftext_language_top_H1023 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_parse_org_emftext_language_top_H1050 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_I_in_parse_org_emftext_language_top_H1076 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_J_in_parse_org_emftext_language_top_I1136 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_parse_org_emftext_language_top_I1163 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_J_in_parse_org_emftext_language_top_I1189 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_K_in_parse_org_emftext_language_top_J1249 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_parse_org_emftext_language_top_J1276 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_K_in_parse_org_emftext_language_top_J1302 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_L_in_parse_org_emftext_language_top_K1362 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_parse_org_emftext_language_top_K1389 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_L_in_parse_org_emftext_language_top_K1415 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_M_in_parse_org_emftext_language_top_L1475 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_parse_org_emftext_language_top_L1502 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_M_in_parse_org_emftext_language_top_L1528 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_N_in_parse_org_emftext_language_top_M1588 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_parse_org_emftext_language_top_M1615 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_N_in_parse_org_emftext_language_top_M1641 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_O_in_parse_org_emftext_language_top_N1701 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_parse_org_emftext_language_top_N1728 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_O_in_parse_org_emftext_language_top_N1754 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_P_in_parse_org_emftext_language_top_O1814 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_parse_org_emftext_language_top_O1841 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_P_in_parse_org_emftext_language_top_O1867 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_Q_in_parse_org_emftext_language_top_P1927 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_parse_org_emftext_language_top_P1954 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_Q_in_parse_org_emftext_language_top_P1980 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_R_in_parse_org_emftext_language_top_Q2040 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_parse_org_emftext_language_top_Q2067 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_R_in_parse_org_emftext_language_top_Q2093 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_S_in_parse_org_emftext_language_top_R2153 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_parse_org_emftext_language_top_R2180 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_S_in_parse_org_emftext_language_top_R2206 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_T_in_parse_org_emftext_language_top_S2266 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_parse_org_emftext_language_top_S2293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_T_in_parse_org_emftext_language_top_S2319 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_U_in_parse_org_emftext_language_top_T2379 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_28_in_parse_org_emftext_language_top_T2406 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_U_in_parse_org_emftext_language_top_T2432 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_V_in_parse_org_emftext_language_top_U2492 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_parse_org_emftext_language_top_U2519 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_V_in_parse_org_emftext_language_top_U2545 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_W_in_parse_org_emftext_language_top_V2605 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30_in_parse_org_emftext_language_top_V2632 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_W_in_parse_org_emftext_language_top_V2658 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_X_in_parse_org_emftext_language_top_W2718 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_31_in_parse_org_emftext_language_top_W2745 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_X_in_parse_org_emftext_language_top_W2771 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_Y_in_parse_org_emftext_language_top_X2831 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_parse_org_emftext_language_top_X2858 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_Y_in_parse_org_emftext_language_top_X2884 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_Z_in_parse_org_emftext_language_top_Y2944 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_33_in_parse_org_emftext_language_top_Y2971 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_Z_in_parse_org_emftext_language_top_Y2997 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_ZChild_in_parse_org_emftext_language_top_Z3057 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_parse_org_emftext_language_top_Z3084 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_ZChild_in_parse_org_emftext_language_top_Z3110 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_INTEGER_LITERAL_in_parse_org_emftext_language_top_IntegerLiteral3170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_A_in_parse_org_emftext_language_top_ExprChild3202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_B_in_parse_org_emftext_language_top_ExprChild3212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_C_in_parse_org_emftext_language_top_ExprChild3222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_D_in_parse_org_emftext_language_top_ExprChild3232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_E_in_parse_org_emftext_language_top_ExprChild3242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_F_in_parse_org_emftext_language_top_ExprChild3252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_G_in_parse_org_emftext_language_top_ExprChild3262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_H_in_parse_org_emftext_language_top_ExprChild3272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_I_in_parse_org_emftext_language_top_ExprChild3282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_J_in_parse_org_emftext_language_top_ExprChild3292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_K_in_parse_org_emftext_language_top_ExprChild3302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_L_in_parse_org_emftext_language_top_ExprChild3312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_M_in_parse_org_emftext_language_top_ExprChild3322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_N_in_parse_org_emftext_language_top_ExprChild3332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_O_in_parse_org_emftext_language_top_ExprChild3342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_P_in_parse_org_emftext_language_top_ExprChild3352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_Q_in_parse_org_emftext_language_top_ExprChild3362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_R_in_parse_org_emftext_language_top_ExprChild3372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_S_in_parse_org_emftext_language_top_ExprChild3382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_T_in_parse_org_emftext_language_top_ExprChild3392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_U_in_parse_org_emftext_language_top_ExprChild3402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_V_in_parse_org_emftext_language_top_ExprChild3412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_W_in_parse_org_emftext_language_top_ExprChild3422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_X_in_parse_org_emftext_language_top_ExprChild3432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_Y_in_parse_org_emftext_language_top_ExprChild3442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_Z_in_parse_org_emftext_language_top_ExprChild3452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_IntegerLiteral_in_parse_org_emftext_language_top_ExprChild3462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_IntegerLiteral_in_parse_org_emftext_language_top_ZChild3483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_A_in_synpred28_Top3202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_B_in_synpred29_Top3212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_C_in_synpred30_Top3222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_D_in_synpred31_Top3232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_E_in_synpred32_Top3242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_F_in_synpred33_Top3252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_G_in_synpred34_Top3262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_H_in_synpred35_Top3272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_I_in_synpred36_Top3282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_J_in_synpred37_Top3292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_K_in_synpred38_Top3302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_L_in_synpred39_Top3312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_M_in_synpred40_Top3322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_N_in_synpred41_Top3332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_O_in_synpred42_Top3342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_P_in_synpred43_Top3352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_Q_in_synpred44_Top3362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_R_in_synpred45_Top3372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_S_in_synpred46_Top3382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_T_in_synpred47_Top3392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_U_in_synpred48_Top3402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_V_in_synpred49_Top3412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_W_in_synpred50_Top3422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_X_in_synpred51_Top3432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_Y_in_synpred52_Top3442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_language_top_Z_in_synpred53_Top3452 = new BitSet(new long[]{0x0000000000000002L});

}