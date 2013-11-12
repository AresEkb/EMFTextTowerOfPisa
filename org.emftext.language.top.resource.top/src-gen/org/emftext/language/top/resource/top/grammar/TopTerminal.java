/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.grammar;

public class TopTerminal extends org.emftext.language.top.resource.top.grammar.TopSyntaxElement {
	
	private final org.eclipse.emf.ecore.EStructuralFeature feature;
	private final int mandatoryOccurencesAfter;
	
	public TopTerminal(org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.top.resource.top.grammar.TopCardinality cardinality, int mandatoryOccurencesAfter) {
		super(cardinality, null);
		this.feature = feature;
		this.mandatoryOccurencesAfter = mandatoryOccurencesAfter;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return feature;
	}
	
	public int getMandatoryOccurencesAfter() {
		return mandatoryOccurencesAfter;
	}
	
	public String toString() {
		return feature.getName() + "[]";
	}
	
}
