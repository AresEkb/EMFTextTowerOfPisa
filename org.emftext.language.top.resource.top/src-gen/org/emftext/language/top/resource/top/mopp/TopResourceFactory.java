/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

public class TopResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public TopResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.language.top.resource.top.mopp.TopResource(uri);
	}
	
}
