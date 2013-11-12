/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class TopExpectedCsString extends org.emftext.language.top.resource.top.mopp.TopAbstractExpectedElement {
	
	private org.emftext.language.top.resource.top.grammar.TopKeyword keyword;
	
	public TopExpectedCsString(org.emftext.language.top.resource.top.grammar.TopKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public org.emftext.language.top.resource.top.grammar.TopSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof TopExpectedCsString) {
			return getValue().equals(((TopExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
