/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.grammar;

public class TopWhiteSpace extends org.emftext.language.top.resource.top.grammar.TopFormattingElement {
	
	private final int amount;
	
	public TopWhiteSpace(int amount, org.emftext.language.top.resource.top.grammar.TopCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
