/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.util;

/**
 * Utility class that provides a method to cast objects to type parameterized
 * classes without a warning.
 */
public class TopCastUtil {
	
	@SuppressWarnings("unchecked")	
	public static <T> T cast(Object temp) {
		return (T) temp;
	}
}
