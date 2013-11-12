/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.util;

/**
 * Class TopTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.emftext.language.top.resource.top.util.TopResourceUtil.
 */
public class TopTextResourceUtil {
	
	/**
	 * Use org.emftext.language.top.resource.top.util.TopResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.top.resource.top.mopp.TopResource getResource(org.eclipse.core.resources.IFile file) {
		return new org.emftext.language.top.resource.top.util.TopEclipseProxy().getResource(file);
	}
	
	/**
	 * Use org.emftext.language.top.resource.top.util.TopResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.top.resource.top.mopp.TopResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return org.emftext.language.top.resource.top.util.TopResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use org.emftext.language.top.resource.top.util.TopResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.top.resource.top.mopp.TopResource getResource(org.eclipse.emf.common.util.URI uri) {
		return org.emftext.language.top.resource.top.util.TopResourceUtil.getResource(uri);
	}
	
	/**
	 * Use org.emftext.language.top.resource.top.util.TopResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static org.emftext.language.top.resource.top.mopp.TopResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return org.emftext.language.top.resource.top.util.TopResourceUtil.getResource(uri, options);
	}
	
}
