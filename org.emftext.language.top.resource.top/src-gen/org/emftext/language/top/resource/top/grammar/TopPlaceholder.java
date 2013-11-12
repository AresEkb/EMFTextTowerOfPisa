/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class TopPlaceholder extends org.emftext.language.top.resource.top.grammar.TopTerminal {
	
	private final String tokenName;
	
	public TopPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.emftext.language.top.resource.top.grammar.TopCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
