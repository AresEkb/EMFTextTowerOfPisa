/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

public class TopDynamicTokenStyler {
	
	/**
	 * This method is called to dynamically style tokens.
	 * 
	 * @param resource the TextResource that contains the token
	 * @param token the token to obtain a style for
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public org.emftext.language.top.resource.top.ITopTokenStyle getDynamicTokenStyle(org.emftext.language.top.resource.top.ITopTextResource resource, org.emftext.language.top.resource.top.ITopTextToken token, org.emftext.language.top.resource.top.ITopTokenStyle staticStyle) {
		// The default implementation returns the static style without any changes. To
		// implement dynamic token styling, set the overrideDynamicTokenStyler option to
		// <code>false</code> and customize this method.
		return staticStyle;
	}
	
}
