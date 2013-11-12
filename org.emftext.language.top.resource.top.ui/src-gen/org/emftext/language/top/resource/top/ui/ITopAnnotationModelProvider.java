/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.ui;

/**
 * A provider for annotation models.
 */
public interface ITopAnnotationModelProvider {
	
	/**
	 * Returns the annotation model.
	 */
	public org.eclipse.jface.text.source.IAnnotationModel getAnnotationModel();
	
}
