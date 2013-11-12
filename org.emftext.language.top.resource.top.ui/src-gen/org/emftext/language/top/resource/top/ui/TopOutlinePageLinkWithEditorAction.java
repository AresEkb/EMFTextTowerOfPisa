/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.ui;

public class TopOutlinePageLinkWithEditorAction extends org.emftext.language.top.resource.top.ui.AbstractTopOutlinePageAction {
	
	public TopOutlinePageLinkWithEditorAction(org.emftext.language.top.resource.top.ui.TopOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
