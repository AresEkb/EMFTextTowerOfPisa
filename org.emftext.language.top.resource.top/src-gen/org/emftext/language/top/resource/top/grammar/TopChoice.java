/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.grammar;

public class TopChoice extends org.emftext.language.top.resource.top.grammar.TopSyntaxElement {
	
	public TopChoice(org.emftext.language.top.resource.top.grammar.TopCardinality cardinality, org.emftext.language.top.resource.top.grammar.TopSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.emftext.language.top.resource.top.util.TopStringUtil.explode(getChildren(), "|");
	}
	
}
