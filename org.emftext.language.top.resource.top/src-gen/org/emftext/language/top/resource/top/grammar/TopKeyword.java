/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class TopKeyword extends org.emftext.language.top.resource.top.grammar.TopSyntaxElement {
	
	private final String value;
	
	public TopKeyword(String value, org.emftext.language.top.resource.top.grammar.TopCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
