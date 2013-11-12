/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.grammar;

public class TopContainment extends org.emftext.language.top.resource.top.grammar.TopTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public TopContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.language.top.resource.top.grammar.TopCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.emftext.language.top.resource.top.util.TopStringUtil.explode(allowedTypes, ", ", new org.emftext.language.top.resource.top.ITopFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
