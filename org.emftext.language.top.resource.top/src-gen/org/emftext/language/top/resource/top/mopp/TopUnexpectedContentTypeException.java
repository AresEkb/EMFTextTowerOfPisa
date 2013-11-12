/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see org.emftext.language.top.resource.top.ITopOptions.RESOURCE_CONTENT_TYPE
 */
public class TopUnexpectedContentTypeException extends org.antlr.runtime3_4_0.RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  TopUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
