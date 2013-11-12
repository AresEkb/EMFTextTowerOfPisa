/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

public class TopBracketInformationProvider {
	
	public class BracketPair implements org.emftext.language.top.resource.top.ITopBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<org.emftext.language.top.resource.top.ITopBracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.language.top.resource.top.ITopBracketPair> result = new java.util.ArrayList<org.emftext.language.top.resource.top.ITopBracketPair>();
		return result;
	}
	
}
