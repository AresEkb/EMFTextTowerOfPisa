/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'org.emftext.language.top.resource.top.default_load_options' with the
 * difference that the options defined in this class are used even if no Eclipse
 * platform is running.
 */
package org.emftext.language.top.resource.top.mopp;

public class TopOptionProvider implements org.emftext.language.top.resource.top.ITopOptionProvider {
	
	public java.util.Map<?,?> getOptions() {
		// create a map with static option providers here
		return java.util.Collections.emptyMap();
	}
	
}
