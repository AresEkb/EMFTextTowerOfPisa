/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.ui;

public class TopUIMetaInformation extends org.emftext.language.top.resource.top.mopp.TopMetaInformation {
	
	public org.emftext.language.top.resource.top.ITopHoverTextProvider getHoverTextProvider() {
		return new org.emftext.language.top.resource.top.ui.TopHoverTextProvider();
	}
	
	public org.emftext.language.top.resource.top.ui.TopImageProvider getImageProvider() {
		return org.emftext.language.top.resource.top.ui.TopImageProvider.INSTANCE;
	}
	
	public org.emftext.language.top.resource.top.ui.TopColorManager createColorManager() {
		return new org.emftext.language.top.resource.top.ui.TopColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.emftext.language.top.resource.top.ITopTextResource,
	 * org.emftext.language.top.resource.top.ui.TopColorManager) instead.
	 */
	public org.emftext.language.top.resource.top.ui.TopTokenScanner createTokenScanner(org.emftext.language.top.resource.top.ui.TopColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public org.emftext.language.top.resource.top.ui.TopTokenScanner createTokenScanner(org.emftext.language.top.resource.top.ITopTextResource resource, org.emftext.language.top.resource.top.ui.TopColorManager colorManager) {
		return new org.emftext.language.top.resource.top.ui.TopTokenScanner(resource, colorManager);
	}
	
	public org.emftext.language.top.resource.top.ui.TopCodeCompletionHelper createCodeCompletionHelper() {
		return new org.emftext.language.top.resource.top.ui.TopCodeCompletionHelper();
	}
	
}
