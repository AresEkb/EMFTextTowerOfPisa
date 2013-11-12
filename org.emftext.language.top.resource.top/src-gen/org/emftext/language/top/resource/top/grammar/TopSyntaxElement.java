/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class TopSyntaxElement {
	
	private TopSyntaxElement[] children;
	private TopSyntaxElement parent;
	private org.emftext.language.top.resource.top.grammar.TopCardinality cardinality;
	
	public TopSyntaxElement(org.emftext.language.top.resource.top.grammar.TopCardinality cardinality, TopSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (TopSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(TopSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public TopSyntaxElement getParent() {
		return parent;
	}
	
	public TopSyntaxElement[] getChildren() {
		if (children == null) {
			return new TopSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.emftext.language.top.resource.top.grammar.TopCardinality getCardinality() {
		return cardinality;
	}
	
}
