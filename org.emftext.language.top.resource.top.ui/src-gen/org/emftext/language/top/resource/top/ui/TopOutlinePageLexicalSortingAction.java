/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.ui;

public class TopOutlinePageLexicalSortingAction extends org.emftext.language.top.resource.top.ui.AbstractTopOutlinePageAction {
	
	public TopOutlinePageLexicalSortingAction(org.emftext.language.top.resource.top.ui.TopOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
