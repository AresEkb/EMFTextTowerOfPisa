/**
 */
package org.emftext.language.top;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.language.top.Expr#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.language.top.TopPackage#getExpr()
 * @model
 * @generated
 */
public interface Expr extends EObject {
	/**
   * Returns the value of the '<em><b>Child</b></em>' containment reference list.
   * The list contents are of type {@link org.emftext.language.top.ExprChild}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Child</em>' containment reference list.
   * @see org.emftext.language.top.TopPackage#getExpr_Child()
   * @model containment="true" required="true"
   * @generated
   */
	EList<ExprChild> getChild();

} // Expr
