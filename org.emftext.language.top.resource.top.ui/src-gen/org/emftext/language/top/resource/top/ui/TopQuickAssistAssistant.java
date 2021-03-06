/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.ui;

public class TopQuickAssistAssistant extends org.eclipse.jface.text.quickassist.QuickAssistAssistant implements org.eclipse.jface.text.quickassist.IQuickAssistAssistant {
	
	public TopQuickAssistAssistant(org.emftext.language.top.resource.top.ITopResourceProvider resourceProvider, org.emftext.language.top.resource.top.ui.ITopAnnotationModelProvider annotationModelProvider) {
		setQuickAssistProcessor(new org.emftext.language.top.resource.top.ui.TopQuickAssistProcessor(resourceProvider, annotationModelProvider));
		setInformationControlCreator(new org.eclipse.jface.text.AbstractReusableInformationControlCreator() {
			public org.eclipse.jface.text.IInformationControl doCreateInformationControl(org.eclipse.swt.widgets.Shell parent) {
				return new org.eclipse.jface.text.DefaultInformationControl(parent, (org.eclipse.jface.text.DefaultInformationControl.IInformationPresenter) null);
			}
		});
	}
	
	public boolean canAssist(org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext invocationContext) {
		return false;
	}
	
	public boolean canFix(org.eclipse.jface.text.source.Annotation annotation) {
		return true;
	}
	
}
