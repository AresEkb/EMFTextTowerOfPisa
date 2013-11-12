/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.grammar;

public class TopSequence extends org.emftext.language.top.resource.top.grammar.TopSyntaxElement {
	
	public TopSequence(org.emftext.language.top.resource.top.grammar.TopCardinality cardinality, org.emftext.language.top.resource.top.grammar.TopSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.emftext.language.top.resource.top.util.TopStringUtil.explode(getChildren(), " ");
	}
	
}
