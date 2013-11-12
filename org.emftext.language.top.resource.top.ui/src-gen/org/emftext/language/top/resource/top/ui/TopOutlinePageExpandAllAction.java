/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.ui;

public class TopOutlinePageExpandAllAction extends org.emftext.language.top.resource.top.ui.AbstractTopOutlinePageAction {
	
	public TopOutlinePageExpandAllAction(org.emftext.language.top.resource.top.ui.TopOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Expand all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/expand_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().expandAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
