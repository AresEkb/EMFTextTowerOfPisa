/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

/**
 * A basic implementation of the
 * org.emftext.language.top.resource.top.ITopElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class TopElementMapping<ReferenceType> implements org.emftext.language.top.resource.top.ITopElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public TopElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
