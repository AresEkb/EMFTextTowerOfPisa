/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class TopProposalPostProcessor {
	
	public java.util.List<org.emftext.language.top.resource.top.ui.TopCompletionProposal> process(java.util.List<org.emftext.language.top.resource.top.ui.TopCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
