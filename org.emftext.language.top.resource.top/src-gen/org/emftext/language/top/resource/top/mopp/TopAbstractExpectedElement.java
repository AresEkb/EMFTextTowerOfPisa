/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class TopAbstractExpectedElement implements org.emftext.language.top.resource.top.ITopExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<org.emftext.language.top.resource.top.util.TopPair<org.emftext.language.top.resource.top.ITopExpectedElement, org.emftext.language.top.resource.top.mopp.TopContainedFeature[]>> followers = new java.util.LinkedHashSet<org.emftext.language.top.resource.top.util.TopPair<org.emftext.language.top.resource.top.ITopExpectedElement, org.emftext.language.top.resource.top.mopp.TopContainedFeature[]>>();
	
	public TopAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.emftext.language.top.resource.top.ITopExpectedElement follower, org.emftext.language.top.resource.top.mopp.TopContainedFeature[] path) {
		followers.add(new org.emftext.language.top.resource.top.util.TopPair<org.emftext.language.top.resource.top.ITopExpectedElement, org.emftext.language.top.resource.top.mopp.TopContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.emftext.language.top.resource.top.util.TopPair<org.emftext.language.top.resource.top.ITopExpectedElement, org.emftext.language.top.resource.top.mopp.TopContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
