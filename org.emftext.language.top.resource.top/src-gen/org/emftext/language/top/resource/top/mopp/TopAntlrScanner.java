/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

public class TopAntlrScanner implements org.emftext.language.top.resource.top.ITopTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public TopAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.emftext.language.top.resource.top.ITopTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		org.emftext.language.top.resource.top.ITopTextToken result = new org.emftext.language.top.resource.top.mopp.TopANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
