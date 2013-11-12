/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class TopRule extends org.emftext.language.top.resource.top.grammar.TopSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public TopRule(org.eclipse.emf.ecore.EClass metaclass, org.emftext.language.top.resource.top.grammar.TopChoice choice, org.emftext.language.top.resource.top.grammar.TopCardinality cardinality) {
		super(cardinality, new org.emftext.language.top.resource.top.grammar.TopSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public org.emftext.language.top.resource.top.grammar.TopChoice getDefinition() {
		return (org.emftext.language.top.resource.top.grammar.TopChoice) getChildren()[0];
	}
	
}

