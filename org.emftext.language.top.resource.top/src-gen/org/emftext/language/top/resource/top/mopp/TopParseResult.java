/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

public class TopParseResult implements org.emftext.language.top.resource.top.ITopParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.emftext.language.top.resource.top.ITopCommand<org.emftext.language.top.resource.top.ITopTextResource>> commands = new java.util.ArrayList<org.emftext.language.top.resource.top.ITopCommand<org.emftext.language.top.resource.top.ITopTextResource>>();
	
	public TopParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.emftext.language.top.resource.top.ITopCommand<org.emftext.language.top.resource.top.ITopTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
