/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

public class TopProblem implements org.emftext.language.top.resource.top.ITopProblem {
	
	private String message;
	private org.emftext.language.top.resource.top.TopEProblemType type;
	private org.emftext.language.top.resource.top.TopEProblemSeverity severity;
	private java.util.Collection<org.emftext.language.top.resource.top.ITopQuickFix> quickFixes;
	
	public TopProblem(String message, org.emftext.language.top.resource.top.TopEProblemType type, org.emftext.language.top.resource.top.TopEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.emftext.language.top.resource.top.ITopQuickFix>emptySet());
	}
	
	public TopProblem(String message, org.emftext.language.top.resource.top.TopEProblemType type, org.emftext.language.top.resource.top.TopEProblemSeverity severity, org.emftext.language.top.resource.top.ITopQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public TopProblem(String message, org.emftext.language.top.resource.top.TopEProblemType type, org.emftext.language.top.resource.top.TopEProblemSeverity severity, java.util.Collection<org.emftext.language.top.resource.top.ITopQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.emftext.language.top.resource.top.ITopQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.emftext.language.top.resource.top.TopEProblemType getType() {
		return type;
	}
	
	public org.emftext.language.top.resource.top.TopEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.emftext.language.top.resource.top.ITopQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
