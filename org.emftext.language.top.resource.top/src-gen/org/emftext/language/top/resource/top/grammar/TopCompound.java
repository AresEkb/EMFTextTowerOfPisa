/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.grammar;

public class TopCompound extends org.emftext.language.top.resource.top.grammar.TopSyntaxElement {
	
	public TopCompound(org.emftext.language.top.resource.top.grammar.TopChoice choice, org.emftext.language.top.resource.top.grammar.TopCardinality cardinality) {
		super(cardinality, new org.emftext.language.top.resource.top.grammar.TopSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
