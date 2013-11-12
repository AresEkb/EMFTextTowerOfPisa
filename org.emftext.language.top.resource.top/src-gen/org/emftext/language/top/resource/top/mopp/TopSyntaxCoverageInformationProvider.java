/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

public class TopSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.top.TopPackage.eINSTANCE.getExpr(),
			org.emftext.language.top.TopPackage.eINSTANCE.getA(),
			org.emftext.language.top.TopPackage.eINSTANCE.getB(),
			org.emftext.language.top.TopPackage.eINSTANCE.getC(),
			org.emftext.language.top.TopPackage.eINSTANCE.getD(),
			org.emftext.language.top.TopPackage.eINSTANCE.getE(),
			org.emftext.language.top.TopPackage.eINSTANCE.getF(),
			org.emftext.language.top.TopPackage.eINSTANCE.getG(),
			org.emftext.language.top.TopPackage.eINSTANCE.getH(),
			org.emftext.language.top.TopPackage.eINSTANCE.getI(),
			org.emftext.language.top.TopPackage.eINSTANCE.getJ(),
			org.emftext.language.top.TopPackage.eINSTANCE.getK(),
			org.emftext.language.top.TopPackage.eINSTANCE.getIntegerLiteral(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.language.top.TopPackage.eINSTANCE.getExpr(),
		};
	}
	
}
