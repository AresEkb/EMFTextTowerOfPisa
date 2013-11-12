/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top;

/**
 * A mapping from an identifier to an EObject.
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface ITopElementMapping<ReferenceType> extends org.emftext.language.top.resource.top.ITopReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the target object the identifier is mapped to.
	 */
	public ReferenceType getTargetElement();
}
