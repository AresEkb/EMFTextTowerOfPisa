/**
 */
package org.emftext.language.top;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>D</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.top.D#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.top.TopPackage#getD()
 * @model
 * @generated
 */
public interface D extends CChild {
	/**
   * Returns the value of the '<em><b>Child</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.top.DChild}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Child</em>' containment reference list.
   * @see org.emftext.language.top.TopPackage#getD_Child()
   * @model containment="true" lower="2"
   * @generated
   */
	EList<DChild> getChild();

} // D
