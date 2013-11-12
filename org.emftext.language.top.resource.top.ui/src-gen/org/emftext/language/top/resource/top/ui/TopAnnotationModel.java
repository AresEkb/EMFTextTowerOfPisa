/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.ui;

public class TopAnnotationModel extends org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel {
	
	public TopAnnotationModel(org.eclipse.core.resources.IResource resource) {
		super(resource);
	}
	
	protected org.eclipse.ui.texteditor.MarkerAnnotation createMarkerAnnotation(org.eclipse.core.resources.IMarker marker) {
		return new org.emftext.language.top.resource.top.ui.TopMarkerAnnotation(marker);
	}
	
}
