/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.ui;

public class TopHoverTextProvider implements org.emftext.language.top.resource.top.ITopHoverTextProvider {
	
	private org.emftext.language.top.resource.top.ui.TopDefaultHoverTextProvider defaultProvider = new org.emftext.language.top.resource.top.ui.TopDefaultHoverTextProvider();
	
	public String getHoverText(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject referencedObject) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(referencedObject);
	}
	
	public String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
