/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.ui;

public class TopOutlinePageAutoExpandAction extends org.emftext.language.top.resource.top.ui.AbstractTopOutlinePageAction {
	
	public TopOutlinePageAutoExpandAction(org.emftext.language.top.resource.top.ui.TopOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
