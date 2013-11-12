/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.grammar;

public class TopLineBreak extends org.emftext.language.top.resource.top.grammar.TopFormattingElement {
	
	private final int tabs;
	
	public TopLineBreak(org.emftext.language.top.resource.top.grammar.TopCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
