/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

public class TopResourcePostProcessor implements org.emftext.language.top.resource.top.ITopResourcePostProcessor {
	
	public void process(org.emftext.language.top.resource.top.mopp.TopResource resource) {
		// Set the overrideResourcePostProcessor option to false to customize resource
		// post processing.
	}
	
	public void terminate() {
		// To signal termination to the process() method, setting a boolean field is
		// recommended. Depending on the value of this field process() can stop its
		// computation. However, this is only required for computation intensive
		// post-processors.
	}
	
}
