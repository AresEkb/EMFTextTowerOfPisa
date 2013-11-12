/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.ui;

public class TopOutlinePageCollapseAllAction extends org.emftext.language.top.resource.top.ui.AbstractTopOutlinePageAction {
	
	public TopOutlinePageCollapseAllAction(org.emftext.language.top.resource.top.ui.TopOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Collapse all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/collapse_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().collapseAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
