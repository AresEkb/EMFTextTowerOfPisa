/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

/**
 * A basic implementation of the
 * org.emftext.language.top.resource.top.ITopReferenceResolveResult interface that
 * collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class TopReferenceResolveResult<ReferenceType> implements org.emftext.language.top.resource.top.ITopReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<org.emftext.language.top.resource.top.ITopReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<org.emftext.language.top.resource.top.ITopQuickFix> quickFixes;
	
	public TopReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<org.emftext.language.top.resource.top.ITopQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.emftext.language.top.resource.top.ITopQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(org.emftext.language.top.resource.top.ITopQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.emftext.language.top.resource.top.ITopQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<org.emftext.language.top.resource.top.ITopReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.emftext.language.top.resource.top.ITopReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.emftext.language.top.resource.top.mopp.TopElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.emftext.language.top.resource.top.ITopReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.emftext.language.top.resource.top.mopp.TopURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
