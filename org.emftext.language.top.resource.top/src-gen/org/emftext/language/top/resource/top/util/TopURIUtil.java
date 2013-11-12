/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.util;

public class TopURIUtil {
	
	public boolean isInBinFolder(org.eclipse.emf.common.util.URI uri) {
		String[] segments = uri.segments();
		for (String segment : segments) {
			if ("bin".equals(segment)) {
				return true;
			}
		}
		return false;
	}
	
}
