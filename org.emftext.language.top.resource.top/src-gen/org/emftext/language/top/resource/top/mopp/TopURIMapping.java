/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

/**
 * A basic implementation of the
 * org.emftext.language.top.resource.top.ITopURIMapping interface that can map
 * identifiers to URIs.
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * org.emftext.language.top.resource.top.ITopURIMapping.
 */
public class TopURIMapping<ReferenceType> implements org.emftext.language.top.resource.top.ITopURIMapping<ReferenceType> {
	
	private org.eclipse.emf.common.util.URI uri;
	private String identifier;
	private String warning;
	
	public TopURIMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier, String warning) {
		super();
		this.uri = newIdentifier;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public org.eclipse.emf.common.util.URI getTargetIdentifier() {
		return uri;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
