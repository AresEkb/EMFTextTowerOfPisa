/**
 */
package org.emftext.language.top;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.top.B#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.top.TopPackage#getB()
 * @model
 * @generated
 */
public interface B extends AChild {
	/**
   * Returns the value of the '<em><b>Child</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.top.BChild}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Child</em>' containment reference list.
   * @see org.emftext.language.top.TopPackage#getB_Child()
   * @model containment="true" required="true"
   * @generated
   */
	EList<BChild> getChild();

} // B
