/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top;

/**
 * An interface used to access the result of parsing a document.
 */
public interface ITopParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<org.emftext.language.top.resource.top.ITopCommand<org.emftext.language.top.resource.top.ITopTextResource>> getPostParseCommands();
	
}
