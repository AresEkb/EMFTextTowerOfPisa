/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.ui;

public class TopOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(org.emftext.language.top.resource.top.ui.TopOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new org.emftext.language.top.resource.top.ui.TopOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.emftext.language.top.resource.top.ui.TopOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.emftext.language.top.resource.top.ui.TopOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.emftext.language.top.resource.top.ui.TopOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.emftext.language.top.resource.top.ui.TopOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.emftext.language.top.resource.top.ui.TopOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
