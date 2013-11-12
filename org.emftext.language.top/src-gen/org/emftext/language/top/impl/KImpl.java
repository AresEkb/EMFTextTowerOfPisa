/**
 */
package org.emftext.language.top.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.emftext.language.top.K;
import org.emftext.language.top.KChild;
import org.emftext.language.top.TopPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>K</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.language.top.impl.KImpl#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KImpl extends JChildImpl implements K {
	/**
   * The cached value of the '{@link #getChild() <em>Child</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getChild()
   * @generated
   * @ordered
   */
	protected EList<KChild> child;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected KImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return TopPackage.Literals.K;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EList<KChild> getChild() {
    if (child == null)
    {
      child = new EObjectContainmentEList<KChild>(KChild.class, this, TopPackage.K__CHILD);
    }
    return child;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID)
    {
      case TopPackage.K__CHILD:
        return ((InternalEList<?>)getChild()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case TopPackage.K__CHILD:
        return getChild();
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case TopPackage.K__CHILD:
        getChild().clear();
        getChild().addAll((Collection<? extends KChild>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public void eUnset(int featureID) {
    switch (featureID)
    {
      case TopPackage.K__CHILD:
        getChild().clear();
        return;
    }
    super.eUnset(featureID);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public boolean eIsSet(int featureID) {
    switch (featureID)
    {
      case TopPackage.K__CHILD:
        return child != null && !child.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //KImpl
