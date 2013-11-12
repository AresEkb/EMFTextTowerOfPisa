/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface ITopResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.emftext.language.top.resource.top.ITopResourcePostProcessor getResourcePostProcessor();
	
}
