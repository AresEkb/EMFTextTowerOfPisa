grammar Top;

options {
	superClass = TopANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.emftext.language.top.resource.top.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
	}
}
@header{
	package org.emftext.language.top.resource.top.mopp;
}

@members{
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getExpr(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_emftext_language_top_Expr{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_emftext_language_top_Expr returns [org.emftext.language.top.Expr element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_ExprChild		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1]);
	}
	
	(
		(
			a1 = ',' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createExpr();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_0_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getExpr(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[2]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_ExprChild				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[3]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[4]);
	}
	
;

parse_org_emftext_language_top_A returns [org.emftext.language.top.A element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_B		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[5]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[6]);
	}
	
	(
		(
			a1 = 'a' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createA();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_1_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getA(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[7]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_B				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[8]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[9]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[10]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[11]);
	}
	
;

parse_org_emftext_language_top_B returns [org.emftext.language.top.B element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_C		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[12]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[13]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[14]);
	}
	
	(
		(
			a1 = 'b' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createB();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_2_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getB(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[15]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_C				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[16]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[17]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[18]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[19]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[20]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[21]);
	}
	
;

parse_org_emftext_language_top_C returns [org.emftext.language.top.C element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_D		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[22]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[23]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[24]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[25]);
	}
	
	(
		(
			a1 = 'c' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createC();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_3_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getC(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[26]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_D				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[27]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[28]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[29]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[30]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[31]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[32]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[33]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[34]);
	}
	
;

parse_org_emftext_language_top_D returns [org.emftext.language.top.D element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_E		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[35]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[36]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[37]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[38]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[39]);
	}
	
	(
		(
			a1 = 'd' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createD();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_4_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getD(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[40]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_E				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[41]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[42]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[43]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[44]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[45]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[46]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[47]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[48]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[49]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[50]);
	}
	
;

parse_org_emftext_language_top_E returns [org.emftext.language.top.E element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_F		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[51]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[52]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[53]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[54]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[55]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[56]);
	}
	
	(
		(
			a1 = 'e' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createE();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_5_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getE(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[57]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_F				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[58]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[59]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[60]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[61]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[62]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[63]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[64]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[65]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[66]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[67]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[68]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[69]);
	}
	
;

parse_org_emftext_language_top_F returns [org.emftext.language.top.F element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_G		{
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
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[70]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[71]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[72]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[73]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[74]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[75]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[76]);
	}
	
	(
		(
			a1 = 'f' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createF();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_6_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getF(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[77]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_G				{
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
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[78]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[79]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[80]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[81]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[82]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[83]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[84]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[85]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[86]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[87]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[88]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[89]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[90]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[91]);
	}
	
;

parse_org_emftext_language_top_G returns [org.emftext.language.top.G element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_H		{
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
	)
	{
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
	
	(
		(
			a1 = 'g' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createG();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_7_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getG(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[100]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_H				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_H returns [org.emftext.language.top.H element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_I		{
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
	)
	{
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
	
	(
		(
			a1 = 'h' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createH();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_8_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getH(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[126]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_I				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_I returns [org.emftext.language.top.I element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_J		{
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
	)
	{
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
	
	(
		(
			a1 = 'i' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createI();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_9_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getI(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[155]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_J				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_J returns [org.emftext.language.top.J element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_K		{
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
	)
	{
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
	
	(
		(
			a1 = 'j' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createJ();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_10_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[187]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_K				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_K returns [org.emftext.language.top.K element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_L		{
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
	)
	{
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
	
	(
		(
			a1 = 'k' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createK();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_11_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getK(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[222]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_L				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_L returns [org.emftext.language.top.L element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_M		{
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
	)
	{
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
	
	(
		(
			a1 = 'l' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createL();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_12_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getL(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[260]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_M				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_M returns [org.emftext.language.top.M element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_N		{
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
	)
	{
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
	
	(
		(
			a1 = 'm' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createM();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_13_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getM(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[301]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_N				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_N returns [org.emftext.language.top.N element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_O		{
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
	)
	{
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
	
	(
		(
			a1 = 'n' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createN();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_14_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getN(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[345]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_O				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_O returns [org.emftext.language.top.O element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_P		{
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
	)
	{
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
	
	(
		(
			a1 = 'o' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createO();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_15_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getO(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[392]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_P				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_P returns [org.emftext.language.top.P element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_Q		{
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
	)
	{
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
	
	(
		(
			a1 = 'p' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createP();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_16_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getP(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[442]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_Q				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_Q returns [org.emftext.language.top.Q element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_R		{
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
	)
	{
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
	
	(
		(
			a1 = 'q' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createQ();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_17_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getQ(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[495]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_R				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_R returns [org.emftext.language.top.R element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_S		{
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
	)
	{
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
	
	(
		(
			a1 = 'r' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createR();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_18_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getR(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[551]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_S				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_S returns [org.emftext.language.top.S element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_T		{
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
	)
	{
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
	
	(
		(
			a1 = 's' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createS();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_19_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getS(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[610]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_T				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_T returns [org.emftext.language.top.T element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_U		{
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
	)
	{
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
	
	(
		(
			a1 = 't' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createT();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_20_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getT(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[672]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_U				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_U returns [org.emftext.language.top.U element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_V		{
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
	)
	{
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
	
	(
		(
			a1 = 'u' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createU();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_21_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getU(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[737]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_V				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_V returns [org.emftext.language.top.V element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_W		{
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
	)
	{
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
	
	(
		(
			a1 = 'v' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createV();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_22_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getV(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[805]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_W				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_W returns [org.emftext.language.top.W element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_X		{
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
	)
	{
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
	
	(
		(
			a1 = 'w' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createW();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_23_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getW(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[876]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_X				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_X returns [org.emftext.language.top.X element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_Y		{
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
	)
	{
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
	
	(
		(
			a1 = 'x' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createX();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_24_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getX(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[950]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_Y				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_Y returns [org.emftext.language.top.Y element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_Z		{
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
	)
	{
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
	
	(
		(
			a1 = 'y' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createY();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_25_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getY(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1027]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_Z				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_Z returns [org.emftext.language.top.Z element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_ZChild		{
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
	)
	{
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
	
	(
		(
			a1 = 'z' {
				if (element == null) {
					element = org.emftext.language.top.TopFactory.eINSTANCE.createZ();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_26_0_0_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getZ(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[1107]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_ZChild				{
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
			)
			{
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
			
		)
		
	)*	{
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
	
;

parse_org_emftext_language_top_IntegerLiteral returns [org.emftext.language.top.IntegerLiteral element = null]
@init{
}
:
	(
		a0 = INTEGER_LITERAL		
		{
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
	)
	{
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
	
;

parse_org_emftext_language_top_ExprChild returns [org.emftext.language.top.ExprChild element = null]
:
	c0 = parse_org_emftext_language_top_A{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_top_B{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_top_C{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_top_D{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_top_E{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_top_F{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_top_G{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_top_H{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_org_emftext_language_top_I{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_org_emftext_language_top_J{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_org_emftext_language_top_K{ element = c10; /* this is a subclass or primitive expression choice */ }
	|	c11 = parse_org_emftext_language_top_L{ element = c11; /* this is a subclass or primitive expression choice */ }
	|	c12 = parse_org_emftext_language_top_M{ element = c12; /* this is a subclass or primitive expression choice */ }
	|	c13 = parse_org_emftext_language_top_N{ element = c13; /* this is a subclass or primitive expression choice */ }
	|	c14 = parse_org_emftext_language_top_O{ element = c14; /* this is a subclass or primitive expression choice */ }
	|	c15 = parse_org_emftext_language_top_P{ element = c15; /* this is a subclass or primitive expression choice */ }
	|	c16 = parse_org_emftext_language_top_Q{ element = c16; /* this is a subclass or primitive expression choice */ }
	|	c17 = parse_org_emftext_language_top_R{ element = c17; /* this is a subclass or primitive expression choice */ }
	|	c18 = parse_org_emftext_language_top_S{ element = c18; /* this is a subclass or primitive expression choice */ }
	|	c19 = parse_org_emftext_language_top_T{ element = c19; /* this is a subclass or primitive expression choice */ }
	|	c20 = parse_org_emftext_language_top_U{ element = c20; /* this is a subclass or primitive expression choice */ }
	|	c21 = parse_org_emftext_language_top_V{ element = c21; /* this is a subclass or primitive expression choice */ }
	|	c22 = parse_org_emftext_language_top_W{ element = c22; /* this is a subclass or primitive expression choice */ }
	|	c23 = parse_org_emftext_language_top_X{ element = c23; /* this is a subclass or primitive expression choice */ }
	|	c24 = parse_org_emftext_language_top_Y{ element = c24; /* this is a subclass or primitive expression choice */ }
	|	c25 = parse_org_emftext_language_top_Z{ element = c25; /* this is a subclass or primitive expression choice */ }
	|	c26 = parse_org_emftext_language_top_IntegerLiteral{ element = c26; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_top_ZChild returns [org.emftext.language.top.ZChild element = null]
:
	c0 = parse_org_emftext_language_top_IntegerLiteral{ element = c0; /* this is a subclass or primitive expression choice */ }
	
;

INTEGER_LITERAL:
	('0'|(('+'|'-')?('1'..'9')('0'..'9')*))
;
TEXT:
	(('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+)
	{ _channel = 99; }
;
WHITESPACE:
	((' ' | '\t' | '\f'))
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;

