/**
 */
package org.emftext.language.top;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>K</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.top.K#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.top.TopPackage#getK()
 * @model
 * @generated
 */
public interface K extends JChild {
	/**
   * Returns the value of the '<em><b>Child</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.top.KChild}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Child</em>' containment reference list.
   * @see org.emftext.language.top.TopPackage#getK_Child()
   * @model containment="true" lower="2"
   * @generated
   */
	EList<KChild> getChild();

} // K
