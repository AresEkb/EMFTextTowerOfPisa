/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

public class TopSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private org.emftext.language.top.resource.top.grammar.TopSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private TopSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private java.util.List<Integer> indicesToPrint = new java.util.ArrayList<Integer>();
	
	public TopSyntaxElementDecorator(org.emftext.language.top.resource.top.grammar.TopSyntaxElement decoratedElement, TopSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public org.emftext.language.top.resource.top.grammar.TopSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public TopSyntaxElementDecorator[] getChildDecorators() {
		return childDecorators;
	}
	
	public Integer getNextIndexToPrint() {
		if (indicesToPrint.size() == 0) {
			return null;
		}
		return indicesToPrint.remove(0);
	}
	
	public String toString() {
		return "" + getDecoratedElement();
	}
	
}
