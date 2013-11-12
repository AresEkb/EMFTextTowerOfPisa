/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

public class TopMetaInformation implements org.emftext.language.top.resource.top.ITopMetaInformation {
	
	public String getSyntaxName() {
		return "top";
	}
	
	public String getURI() {
		return "http://www.emftext.org/language/top";
	}
	
	public org.emftext.language.top.resource.top.ITopTextScanner createLexer() {
		return new org.emftext.language.top.resource.top.mopp.TopAntlrScanner(new org.emftext.language.top.resource.top.mopp.TopLexer());
	}
	
	public org.emftext.language.top.resource.top.ITopTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.emftext.language.top.resource.top.mopp.TopParser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.language.top.resource.top.ITopTextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.language.top.resource.top.ITopTextResource resource) {
		return new org.emftext.language.top.resource.top.mopp.TopPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.language.top.resource.top.mopp.TopSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.language.top.resource.top.mopp.TopSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.language.top.resource.top.ITopReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.language.top.resource.top.mopp.TopReferenceResolverSwitch();
	}
	
	public org.emftext.language.top.resource.top.ITopTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.language.top.resource.top.mopp.TopTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.emftext.language.top/metamodel/top.cs";
	}
	
	public String[] getTokenNames() {
		return org.emftext.language.top.resource.top.mopp.TopParser.tokenNames;
	}
	
	public org.emftext.language.top.resource.top.ITopTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.emftext.language.top.resource.top.mopp.TopTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.language.top.resource.top.ITopBracketPair> getBracketPairs() {
		return new org.emftext.language.top.resource.top.mopp.TopBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.language.top.resource.top.mopp.TopFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.language.top.resource.top.mopp.TopResourceFactory();
	}
	
	public org.emftext.language.top.resource.top.mopp.TopNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.language.top.resource.top.mopp.TopNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.emftext.language.top.resource.top.mopp.TopResourceFactory());
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "org.emftext.language.top.resource.top.ui.launchConfigurationType";
	}
	
	public org.emftext.language.top.resource.top.ITopNameProvider createNameProvider() {
		return new org.emftext.language.top.resource.top.analysis.TopDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.emftext.language.top.resource.top.mopp.TopAntlrTokenHelper tokenHelper = new org.emftext.language.top.resource.top.mopp.TopAntlrTokenHelper();
		java.util.List<String> highlightableTokens = new java.util.ArrayList<String>();
		String[] parserTokenNames = getTokenNames();
		for (int i = 0; i < parserTokenNames.length; i++) {
			// If ANTLR is used we need to normalize the token names
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			String tokenName = tokenHelper.getTokenName(parserTokenNames, i);
			if (tokenName == null) {
				continue;
			}
			highlightableTokens.add(tokenName);
		}
		highlightableTokens.add(org.emftext.language.top.resource.top.mopp.TopTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
