/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

public class TopTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public org.emftext.language.top.resource.top.ITopTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("a".equals(tokenName)) {
			return new org.emftext.language.top.resource.top.mopp.TopTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("b".equals(tokenName)) {
			return new org.emftext.language.top.resource.top.mopp.TopTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("c".equals(tokenName)) {
			return new org.emftext.language.top.resource.top.mopp.TopTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("d".equals(tokenName)) {
			return new org.emftext.language.top.resource.top.mopp.TopTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("e".equals(tokenName)) {
			return new org.emftext.language.top.resource.top.mopp.TopTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("f".equals(tokenName)) {
			return new org.emftext.language.top.resource.top.mopp.TopTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("g".equals(tokenName)) {
			return new org.emftext.language.top.resource.top.mopp.TopTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("h".equals(tokenName)) {
			return new org.emftext.language.top.resource.top.mopp.TopTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("i".equals(tokenName)) {
			return new org.emftext.language.top.resource.top.mopp.TopTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("j".equals(tokenName)) {
			return new org.emftext.language.top.resource.top.mopp.TopTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("k".equals(tokenName)) {
			return new org.emftext.language.top.resource.top.mopp.TopTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new org.emftext.language.top.resource.top.mopp.TopTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
