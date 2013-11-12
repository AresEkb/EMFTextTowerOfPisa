/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.launch;

/**
 * A class that handles launch configurations.
 */
public class TopLaunchConfigurationDelegate extends org.eclipse.debug.core.model.LaunchConfigurationDelegate {
	
	/**
	 * The URI of the resource that shall be launched.
	 */
	public final static String ATTR_RESOURCE_URI = "uri";
	
	public void launch(org.eclipse.debug.core.ILaunchConfiguration configuration, String mode, org.eclipse.debug.core.ILaunch launch, org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		// Set the overrideLaunchConfigurationDelegate option to <code>false</code> to
		// implement this method or disable launching support by setting
		// disableLaunchSupport to <code>true</code>.
		
		new org.emftext.language.top.resource.top.launch.TopLaunchConfigurationHelper().launch(configuration, mode, launch, monitor);
	}
	
}
