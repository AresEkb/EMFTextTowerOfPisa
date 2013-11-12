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
		int followSetID = 50;
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
		a0_0 = parse_org_emftext_language_top_AChild		{
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
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getA(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[6]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_AChild				{
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
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[7]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[8]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[9]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[10]);
	}
	
;

parse_org_emftext_language_top_B returns [org.emftext.language.top.B element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_BChild		{
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
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[11]);
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
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getB(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[12]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_BChild				{
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
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[13]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[14]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[15]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[16]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[17]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[18]);
	}
	
;

parse_org_emftext_language_top_C returns [org.emftext.language.top.C element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_CChild		{
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
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[19]);
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
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getC(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[20]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_CChild				{
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
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[21]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[22]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[23]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[24]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[25]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[26]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[28]);
	}
	
;

parse_org_emftext_language_top_D returns [org.emftext.language.top.D element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_DChild		{
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
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[29]);
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
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getD(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[30]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_DChild				{
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
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[31]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[32]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[33]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[34]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[35]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[36]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[37]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[38]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[39]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[40]);
	}
	
;

parse_org_emftext_language_top_E returns [org.emftext.language.top.E element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_EChild		{
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
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[41]);
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
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getE(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[42]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_EChild				{
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
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[43]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[44]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[45]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[46]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[47]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[48]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[49]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[50]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[51]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[52]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[53]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[54]);
	}
	
;

parse_org_emftext_language_top_F returns [org.emftext.language.top.F element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_FChild		{
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
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[55]);
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
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getF(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[56]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_FChild				{
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
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[57]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[58]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[59]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[60]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[61]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[62]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[63]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[64]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[65]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[66]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[67]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[68]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[69]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[70]);
	}
	
;

parse_org_emftext_language_top_G returns [org.emftext.language.top.G element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_GChild		{
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
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[71]);
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
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getG(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[72]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_GChild				{
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
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[73]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[74]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[75]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[76]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[77]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[78]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[79]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[80]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[81]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[82]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[83]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[84]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[85]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[86]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[87]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[88]);
	}
	
;

parse_org_emftext_language_top_H returns [org.emftext.language.top.H element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_HChild		{
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
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[89]);
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
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getH(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[90]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_HChild				{
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
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[91]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[92]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[93]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[94]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[95]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[96]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[97]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[98]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[99]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[100]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[101]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[102]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[103]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[104]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[105]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[106]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[107]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[108]);
	}
	
;

parse_org_emftext_language_top_I returns [org.emftext.language.top.I element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_IChild		{
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
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[109]);
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
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getI(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[110]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_IChild				{
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
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[111]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[112]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[113]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[114]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[115]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[116]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[117]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[118]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[119]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[120]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[121]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[122]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[123]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[124]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[125]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[126]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[127]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[128]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[129]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[130]);
	}
	
;

parse_org_emftext_language_top_J returns [org.emftext.language.top.J element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_JChild		{
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
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[131]);
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
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getJ(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[132]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_JChild				{
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
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[133]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[134]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[135]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[136]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[137]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[138]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[139]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[140]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[141]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[142]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[143]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[144]);
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
	
;

parse_org_emftext_language_top_K returns [org.emftext.language.top.K element = null]
@init{
}
:
	(
		a0_0 = parse_org_emftext_language_top_KChild		{
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
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[155]);
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
				addExpectedElement(org.emftext.language.top.TopPackage.eINSTANCE.getK(), org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[156]);
			}
			
			(
				a2_0 = parse_org_emftext_language_top_KChild				{
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
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[157]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[158]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[159]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[160]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[161]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[162]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[163]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[164]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[165]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[166]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[167]);
				addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[168]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[169]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[170]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[171]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[172]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[173]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[174]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[175]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[176]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[177]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[178]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[179]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[180]);
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
				retrieveLayoutInformation(element, org.emftext.language.top.resource.top.grammar.TopGrammarInformationProvider.TOP_12_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[181]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[182]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[183]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[184]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[185]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[186]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[187]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[188]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[189]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[190]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[191]);
		addExpectedElement(null, org.emftext.language.top.resource.top.mopp.TopExpectationConstants.EXPECTATIONS[192]);
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
	|	c11 = parse_org_emftext_language_top_IntegerLiteral{ element = c11; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_top_AChild returns [org.emftext.language.top.AChild element = null]
:
	c0 = parse_org_emftext_language_top_B{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_top_C{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_top_D{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_top_E{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_top_F{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_top_G{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_top_H{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_top_I{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_org_emftext_language_top_J{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_org_emftext_language_top_K{ element = c9; /* this is a subclass or primitive expression choice */ }
	|	c10 = parse_org_emftext_language_top_IntegerLiteral{ element = c10; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_top_BChild returns [org.emftext.language.top.BChild element = null]
:
	c0 = parse_org_emftext_language_top_C{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_top_D{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_top_E{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_top_F{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_top_G{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_top_H{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_top_I{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_top_J{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_org_emftext_language_top_K{ element = c8; /* this is a subclass or primitive expression choice */ }
	|	c9 = parse_org_emftext_language_top_IntegerLiteral{ element = c9; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_top_CChild returns [org.emftext.language.top.CChild element = null]
:
	c0 = parse_org_emftext_language_top_D{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_top_E{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_top_F{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_top_G{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_top_H{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_top_I{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_top_J{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_top_K{ element = c7; /* this is a subclass or primitive expression choice */ }
	|	c8 = parse_org_emftext_language_top_IntegerLiteral{ element = c8; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_top_DChild returns [org.emftext.language.top.DChild element = null]
:
	c0 = parse_org_emftext_language_top_E{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_top_F{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_top_G{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_top_H{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_top_I{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_top_J{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_top_K{ element = c6; /* this is a subclass or primitive expression choice */ }
	|	c7 = parse_org_emftext_language_top_IntegerLiteral{ element = c7; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_top_EChild returns [org.emftext.language.top.EChild element = null]
:
	c0 = parse_org_emftext_language_top_F{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_top_G{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_top_H{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_top_I{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_top_J{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_top_K{ element = c5; /* this is a subclass or primitive expression choice */ }
	|	c6 = parse_org_emftext_language_top_IntegerLiteral{ element = c6; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_top_FChild returns [org.emftext.language.top.FChild element = null]
:
	c0 = parse_org_emftext_language_top_G{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_top_H{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_top_I{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_top_J{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_top_K{ element = c4; /* this is a subclass or primitive expression choice */ }
	|	c5 = parse_org_emftext_language_top_IntegerLiteral{ element = c5; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_top_GChild returns [org.emftext.language.top.GChild element = null]
:
	c0 = parse_org_emftext_language_top_H{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_top_I{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_top_J{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_top_K{ element = c3; /* this is a subclass or primitive expression choice */ }
	|	c4 = parse_org_emftext_language_top_IntegerLiteral{ element = c4; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_top_HChild returns [org.emftext.language.top.HChild element = null]
:
	c0 = parse_org_emftext_language_top_I{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_top_J{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_top_K{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_emftext_language_top_IntegerLiteral{ element = c3; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_top_IChild returns [org.emftext.language.top.IChild element = null]
:
	c0 = parse_org_emftext_language_top_J{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_top_K{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_emftext_language_top_IntegerLiteral{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_top_JChild returns [org.emftext.language.top.JChild element = null]
:
	c0 = parse_org_emftext_language_top_K{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_emftext_language_top_IntegerLiteral{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_emftext_language_top_KChild returns [org.emftext.language.top.KChild element = null]
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

