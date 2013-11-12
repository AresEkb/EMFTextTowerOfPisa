/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top;

public interface ITopProblem {
	public String getMessage();
	public org.emftext.language.top.resource.top.TopEProblemSeverity getSeverity();
	public org.emftext.language.top.resource.top.TopEProblemType getType();
	public java.util.Collection<org.emftext.language.top.resource.top.ITopQuickFix> getQuickFixes();
}
