/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

public class TopNewFileContentProvider {
	
	public org.emftext.language.top.resource.top.ITopMetaInformation getMetaInformation() {
		return new org.emftext.language.top.resource.top.mopp.TopMetaInformation();
	}
	
	public String getNewFileContent(String newFileName) {
		return getExampleContent(new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.top.TopPackage.eINSTANCE.getExpr(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass[] startClasses, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, String newFileName) {
		String content = "";
		for (org.eclipse.emf.ecore.EClass next : startClasses) {
			content = getExampleContent(next, allClassesWithSyntax, newFileName);
			if (content.trim().length() > 0) {
				break;
			}
		}
		return content;
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass eClass, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, String newFileName) {
		// create a minimal model
		org.eclipse.emf.ecore.EObject root = new org.emftext.language.top.resource.top.util.TopMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		if (root == null) {
			// could not create a minimal model. returning an empty document is the best we
			// can do.
			return "";
		}
		// use printer to get text for model
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		org.emftext.language.top.resource.top.ITopTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (java.io.IOException e) {
			new org.emftext.language.top.resource.top.util.TopRuntimeUtil().logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public org.emftext.language.top.resource.top.ITopTextPrinter getPrinter(java.io.OutputStream outputStream) {
		return getMetaInformation().createPrinter(outputStream, new org.emftext.language.top.resource.top.mopp.TopResource());
	}
	
}
