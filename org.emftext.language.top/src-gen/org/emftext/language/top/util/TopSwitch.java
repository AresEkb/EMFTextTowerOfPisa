/**
 */
package org.emftext.language.top.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.emftext.language.top.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.emftext.language.top.TopPackage
 * @generated
 */
public class TopSwitch<T1> extends Switch<T1> {
	/**
   * The cached model package
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static TopPackage modelPackage;

	/**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TopSwitch() {
    if (modelPackage == null)
    {
      modelPackage = TopPackage.eINSTANCE;
    }
  }

	/**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

	/**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID)
    {
      case TopPackage.EXPR:
      {
        Expr expr = (Expr)theEObject;
        T1 result = caseExpr(expr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.EXPR_CHILD:
      {
        ExprChild exprChild = (ExprChild)theEObject;
        T1 result = caseExprChild(exprChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.A:
      {
        A a = (A)theEObject;
        T1 result = caseA(a);
        if (result == null) result = caseExprChild(a);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.ACHILD:
      {
        AChild aChild = (AChild)theEObject;
        T1 result = caseAChild(aChild);
        if (result == null) result = caseExprChild(aChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.B:
      {
        B b = (B)theEObject;
        T1 result = caseB(b);
        if (result == null) result = caseAChild(b);
        if (result == null) result = caseExprChild(b);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.BCHILD:
      {
        BChild bChild = (BChild)theEObject;
        T1 result = caseBChild(bChild);
        if (result == null) result = caseAChild(bChild);
        if (result == null) result = caseExprChild(bChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.C:
      {
        C c = (C)theEObject;
        T1 result = caseC(c);
        if (result == null) result = caseBChild(c);
        if (result == null) result = caseAChild(c);
        if (result == null) result = caseExprChild(c);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.CCHILD:
      {
        CChild cChild = (CChild)theEObject;
        T1 result = caseCChild(cChild);
        if (result == null) result = caseBChild(cChild);
        if (result == null) result = caseAChild(cChild);
        if (result == null) result = caseExprChild(cChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.D:
      {
        D d = (D)theEObject;
        T1 result = caseD(d);
        if (result == null) result = caseCChild(d);
        if (result == null) result = caseBChild(d);
        if (result == null) result = caseAChild(d);
        if (result == null) result = caseExprChild(d);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.DCHILD:
      {
        DChild dChild = (DChild)theEObject;
        T1 result = caseDChild(dChild);
        if (result == null) result = caseCChild(dChild);
        if (result == null) result = caseBChild(dChild);
        if (result == null) result = caseAChild(dChild);
        if (result == null) result = caseExprChild(dChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.E:
      {
        E e = (E)theEObject;
        T1 result = caseE(e);
        if (result == null) result = caseDChild(e);
        if (result == null) result = caseCChild(e);
        if (result == null) result = caseBChild(e);
        if (result == null) result = caseAChild(e);
        if (result == null) result = caseExprChild(e);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.ECHILD:
      {
        EChild eChild = (EChild)theEObject;
        T1 result = caseEChild(eChild);
        if (result == null) result = caseDChild(eChild);
        if (result == null) result = caseCChild(eChild);
        if (result == null) result = caseBChild(eChild);
        if (result == null) result = caseAChild(eChild);
        if (result == null) result = caseExprChild(eChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.F:
      {
        F f = (F)theEObject;
        T1 result = caseF(f);
        if (result == null) result = caseEChild(f);
        if (result == null) result = caseDChild(f);
        if (result == null) result = caseCChild(f);
        if (result == null) result = caseBChild(f);
        if (result == null) result = caseAChild(f);
        if (result == null) result = caseExprChild(f);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.FCHILD:
      {
        FChild fChild = (FChild)theEObject;
        T1 result = caseFChild(fChild);
        if (result == null) result = caseEChild(fChild);
        if (result == null) result = caseDChild(fChild);
        if (result == null) result = caseCChild(fChild);
        if (result == null) result = caseBChild(fChild);
        if (result == null) result = caseAChild(fChild);
        if (result == null) result = caseExprChild(fChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.G:
      {
        G g = (G)theEObject;
        T1 result = caseG(g);
        if (result == null) result = caseFChild(g);
        if (result == null) result = caseEChild(g);
        if (result == null) result = caseDChild(g);
        if (result == null) result = caseCChild(g);
        if (result == null) result = caseBChild(g);
        if (result == null) result = caseAChild(g);
        if (result == null) result = caseExprChild(g);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.GCHILD:
      {
        GChild gChild = (GChild)theEObject;
        T1 result = caseGChild(gChild);
        if (result == null) result = caseFChild(gChild);
        if (result == null) result = caseEChild(gChild);
        if (result == null) result = caseDChild(gChild);
        if (result == null) result = caseCChild(gChild);
        if (result == null) result = caseBChild(gChild);
        if (result == null) result = caseAChild(gChild);
        if (result == null) result = caseExprChild(gChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.H:
      {
        H h = (H)theEObject;
        T1 result = caseH(h);
        if (result == null) result = caseGChild(h);
        if (result == null) result = caseFChild(h);
        if (result == null) result = caseEChild(h);
        if (result == null) result = caseDChild(h);
        if (result == null) result = caseCChild(h);
        if (result == null) result = caseBChild(h);
        if (result == null) result = caseAChild(h);
        if (result == null) result = caseExprChild(h);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.HCHILD:
      {
        HChild hChild = (HChild)theEObject;
        T1 result = caseHChild(hChild);
        if (result == null) result = caseGChild(hChild);
        if (result == null) result = caseFChild(hChild);
        if (result == null) result = caseEChild(hChild);
        if (result == null) result = caseDChild(hChild);
        if (result == null) result = caseCChild(hChild);
        if (result == null) result = caseBChild(hChild);
        if (result == null) result = caseAChild(hChild);
        if (result == null) result = caseExprChild(hChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.I:
      {
        I i = (I)theEObject;
        T1 result = caseI(i);
        if (result == null) result = caseHChild(i);
        if (result == null) result = caseGChild(i);
        if (result == null) result = caseFChild(i);
        if (result == null) result = caseEChild(i);
        if (result == null) result = caseDChild(i);
        if (result == null) result = caseCChild(i);
        if (result == null) result = caseBChild(i);
        if (result == null) result = caseAChild(i);
        if (result == null) result = caseExprChild(i);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.ICHILD:
      {
        IChild iChild = (IChild)theEObject;
        T1 result = caseIChild(iChild);
        if (result == null) result = caseHChild(iChild);
        if (result == null) result = caseGChild(iChild);
        if (result == null) result = caseFChild(iChild);
        if (result == null) result = caseEChild(iChild);
        if (result == null) result = caseDChild(iChild);
        if (result == null) result = caseCChild(iChild);
        if (result == null) result = caseBChild(iChild);
        if (result == null) result = caseAChild(iChild);
        if (result == null) result = caseExprChild(iChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.J:
      {
        J j = (J)theEObject;
        T1 result = caseJ(j);
        if (result == null) result = caseIChild(j);
        if (result == null) result = caseHChild(j);
        if (result == null) result = caseGChild(j);
        if (result == null) result = caseFChild(j);
        if (result == null) result = caseEChild(j);
        if (result == null) result = caseDChild(j);
        if (result == null) result = caseCChild(j);
        if (result == null) result = caseBChild(j);
        if (result == null) result = caseAChild(j);
        if (result == null) result = caseExprChild(j);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.JCHILD:
      {
        JChild jChild = (JChild)theEObject;
        T1 result = caseJChild(jChild);
        if (result == null) result = caseIChild(jChild);
        if (result == null) result = caseHChild(jChild);
        if (result == null) result = caseGChild(jChild);
        if (result == null) result = caseFChild(jChild);
        if (result == null) result = caseEChild(jChild);
        if (result == null) result = caseDChild(jChild);
        if (result == null) result = caseCChild(jChild);
        if (result == null) result = caseBChild(jChild);
        if (result == null) result = caseAChild(jChild);
        if (result == null) result = caseExprChild(jChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.K:
      {
        K k = (K)theEObject;
        T1 result = caseK(k);
        if (result == null) result = caseJChild(k);
        if (result == null) result = caseIChild(k);
        if (result == null) result = caseHChild(k);
        if (result == null) result = caseGChild(k);
        if (result == null) result = caseFChild(k);
        if (result == null) result = caseEChild(k);
        if (result == null) result = caseDChild(k);
        if (result == null) result = caseCChild(k);
        if (result == null) result = caseBChild(k);
        if (result == null) result = caseAChild(k);
        if (result == null) result = caseExprChild(k);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.KCHILD:
      {
        KChild kChild = (KChild)theEObject;
        T1 result = caseKChild(kChild);
        if (result == null) result = caseJChild(kChild);
        if (result == null) result = caseIChild(kChild);
        if (result == null) result = caseHChild(kChild);
        if (result == null) result = caseGChild(kChild);
        if (result == null) result = caseFChild(kChild);
        if (result == null) result = caseEChild(kChild);
        if (result == null) result = caseDChild(kChild);
        if (result == null) result = caseCChild(kChild);
        if (result == null) result = caseBChild(kChild);
        if (result == null) result = caseAChild(kChild);
        if (result == null) result = caseExprChild(kChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.L:
      {
        L l = (L)theEObject;
        T1 result = caseL(l);
        if (result == null) result = caseKChild(l);
        if (result == null) result = caseJChild(l);
        if (result == null) result = caseIChild(l);
        if (result == null) result = caseHChild(l);
        if (result == null) result = caseGChild(l);
        if (result == null) result = caseFChild(l);
        if (result == null) result = caseEChild(l);
        if (result == null) result = caseDChild(l);
        if (result == null) result = caseCChild(l);
        if (result == null) result = caseBChild(l);
        if (result == null) result = caseAChild(l);
        if (result == null) result = caseExprChild(l);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.LCHILD:
      {
        LChild lChild = (LChild)theEObject;
        T1 result = caseLChild(lChild);
        if (result == null) result = caseKChild(lChild);
        if (result == null) result = caseJChild(lChild);
        if (result == null) result = caseIChild(lChild);
        if (result == null) result = caseHChild(lChild);
        if (result == null) result = caseGChild(lChild);
        if (result == null) result = caseFChild(lChild);
        if (result == null) result = caseEChild(lChild);
        if (result == null) result = caseDChild(lChild);
        if (result == null) result = caseCChild(lChild);
        if (result == null) result = caseBChild(lChild);
        if (result == null) result = caseAChild(lChild);
        if (result == null) result = caseExprChild(lChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.M:
      {
        M m = (M)theEObject;
        T1 result = caseM(m);
        if (result == null) result = caseLChild(m);
        if (result == null) result = caseKChild(m);
        if (result == null) result = caseJChild(m);
        if (result == null) result = caseIChild(m);
        if (result == null) result = caseHChild(m);
        if (result == null) result = caseGChild(m);
        if (result == null) result = caseFChild(m);
        if (result == null) result = caseEChild(m);
        if (result == null) result = caseDChild(m);
        if (result == null) result = caseCChild(m);
        if (result == null) result = caseBChild(m);
        if (result == null) result = caseAChild(m);
        if (result == null) result = caseExprChild(m);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.MCHILD:
      {
        MChild mChild = (MChild)theEObject;
        T1 result = caseMChild(mChild);
        if (result == null) result = caseLChild(mChild);
        if (result == null) result = caseKChild(mChild);
        if (result == null) result = caseJChild(mChild);
        if (result == null) result = caseIChild(mChild);
        if (result == null) result = caseHChild(mChild);
        if (result == null) result = caseGChild(mChild);
        if (result == null) result = caseFChild(mChild);
        if (result == null) result = caseEChild(mChild);
        if (result == null) result = caseDChild(mChild);
        if (result == null) result = caseCChild(mChild);
        if (result == null) result = caseBChild(mChild);
        if (result == null) result = caseAChild(mChild);
        if (result == null) result = caseExprChild(mChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.N:
      {
        N n = (N)theEObject;
        T1 result = caseN(n);
        if (result == null) result = caseMChild(n);
        if (result == null) result = caseLChild(n);
        if (result == null) result = caseKChild(n);
        if (result == null) result = caseJChild(n);
        if (result == null) result = caseIChild(n);
        if (result == null) result = caseHChild(n);
        if (result == null) result = caseGChild(n);
        if (result == null) result = caseFChild(n);
        if (result == null) result = caseEChild(n);
        if (result == null) result = caseDChild(n);
        if (result == null) result = caseCChild(n);
        if (result == null) result = caseBChild(n);
        if (result == null) result = caseAChild(n);
        if (result == null) result = caseExprChild(n);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.NCHILD:
      {
        NChild nChild = (NChild)theEObject;
        T1 result = caseNChild(nChild);
        if (result == null) result = caseMChild(nChild);
        if (result == null) result = caseLChild(nChild);
        if (result == null) result = caseKChild(nChild);
        if (result == null) result = caseJChild(nChild);
        if (result == null) result = caseIChild(nChild);
        if (result == null) result = caseHChild(nChild);
        if (result == null) result = caseGChild(nChild);
        if (result == null) result = caseFChild(nChild);
        if (result == null) result = caseEChild(nChild);
        if (result == null) result = caseDChild(nChild);
        if (result == null) result = caseCChild(nChild);
        if (result == null) result = caseBChild(nChild);
        if (result == null) result = caseAChild(nChild);
        if (result == null) result = caseExprChild(nChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.O:
      {
        O o = (O)theEObject;
        T1 result = caseO(o);
        if (result == null) result = caseNChild(o);
        if (result == null) result = caseMChild(o);
        if (result == null) result = caseLChild(o);
        if (result == null) result = caseKChild(o);
        if (result == null) result = caseJChild(o);
        if (result == null) result = caseIChild(o);
        if (result == null) result = caseHChild(o);
        if (result == null) result = caseGChild(o);
        if (result == null) result = caseFChild(o);
        if (result == null) result = caseEChild(o);
        if (result == null) result = caseDChild(o);
        if (result == null) result = caseCChild(o);
        if (result == null) result = caseBChild(o);
        if (result == null) result = caseAChild(o);
        if (result == null) result = caseExprChild(o);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.OCHILD:
      {
        OChild oChild = (OChild)theEObject;
        T1 result = caseOChild(oChild);
        if (result == null) result = caseNChild(oChild);
        if (result == null) result = caseMChild(oChild);
        if (result == null) result = caseLChild(oChild);
        if (result == null) result = caseKChild(oChild);
        if (result == null) result = caseJChild(oChild);
        if (result == null) result = caseIChild(oChild);
        if (result == null) result = caseHChild(oChild);
        if (result == null) result = caseGChild(oChild);
        if (result == null) result = caseFChild(oChild);
        if (result == null) result = caseEChild(oChild);
        if (result == null) result = caseDChild(oChild);
        if (result == null) result = caseCChild(oChild);
        if (result == null) result = caseBChild(oChild);
        if (result == null) result = caseAChild(oChild);
        if (result == null) result = caseExprChild(oChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.P:
      {
        P p = (P)theEObject;
        T1 result = caseP(p);
        if (result == null) result = caseOChild(p);
        if (result == null) result = caseNChild(p);
        if (result == null) result = caseMChild(p);
        if (result == null) result = caseLChild(p);
        if (result == null) result = caseKChild(p);
        if (result == null) result = caseJChild(p);
        if (result == null) result = caseIChild(p);
        if (result == null) result = caseHChild(p);
        if (result == null) result = caseGChild(p);
        if (result == null) result = caseFChild(p);
        if (result == null) result = caseEChild(p);
        if (result == null) result = caseDChild(p);
        if (result == null) result = caseCChild(p);
        if (result == null) result = caseBChild(p);
        if (result == null) result = caseAChild(p);
        if (result == null) result = caseExprChild(p);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.PCHILD:
      {
        PChild pChild = (PChild)theEObject;
        T1 result = casePChild(pChild);
        if (result == null) result = caseOChild(pChild);
        if (result == null) result = caseNChild(pChild);
        if (result == null) result = caseMChild(pChild);
        if (result == null) result = caseLChild(pChild);
        if (result == null) result = caseKChild(pChild);
        if (result == null) result = caseJChild(pChild);
        if (result == null) result = caseIChild(pChild);
        if (result == null) result = caseHChild(pChild);
        if (result == null) result = caseGChild(pChild);
        if (result == null) result = caseFChild(pChild);
        if (result == null) result = caseEChild(pChild);
        if (result == null) result = caseDChild(pChild);
        if (result == null) result = caseCChild(pChild);
        if (result == null) result = caseBChild(pChild);
        if (result == null) result = caseAChild(pChild);
        if (result == null) result = caseExprChild(pChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.Q:
      {
        Q q = (Q)theEObject;
        T1 result = caseQ(q);
        if (result == null) result = casePChild(q);
        if (result == null) result = caseOChild(q);
        if (result == null) result = caseNChild(q);
        if (result == null) result = caseMChild(q);
        if (result == null) result = caseLChild(q);
        if (result == null) result = caseKChild(q);
        if (result == null) result = caseJChild(q);
        if (result == null) result = caseIChild(q);
        if (result == null) result = caseHChild(q);
        if (result == null) result = caseGChild(q);
        if (result == null) result = caseFChild(q);
        if (result == null) result = caseEChild(q);
        if (result == null) result = caseDChild(q);
        if (result == null) result = caseCChild(q);
        if (result == null) result = caseBChild(q);
        if (result == null) result = caseAChild(q);
        if (result == null) result = caseExprChild(q);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.QCHILD:
      {
        QChild qChild = (QChild)theEObject;
        T1 result = caseQChild(qChild);
        if (result == null) result = casePChild(qChild);
        if (result == null) result = caseOChild(qChild);
        if (result == null) result = caseNChild(qChild);
        if (result == null) result = caseMChild(qChild);
        if (result == null) result = caseLChild(qChild);
        if (result == null) result = caseKChild(qChild);
        if (result == null) result = caseJChild(qChild);
        if (result == null) result = caseIChild(qChild);
        if (result == null) result = caseHChild(qChild);
        if (result == null) result = caseGChild(qChild);
        if (result == null) result = caseFChild(qChild);
        if (result == null) result = caseEChild(qChild);
        if (result == null) result = caseDChild(qChild);
        if (result == null) result = caseCChild(qChild);
        if (result == null) result = caseBChild(qChild);
        if (result == null) result = caseAChild(qChild);
        if (result == null) result = caseExprChild(qChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.R:
      {
        R r = (R)theEObject;
        T1 result = caseR(r);
        if (result == null) result = caseQChild(r);
        if (result == null) result = casePChild(r);
        if (result == null) result = caseOChild(r);
        if (result == null) result = caseNChild(r);
        if (result == null) result = caseMChild(r);
        if (result == null) result = caseLChild(r);
        if (result == null) result = caseKChild(r);
        if (result == null) result = caseJChild(r);
        if (result == null) result = caseIChild(r);
        if (result == null) result = caseHChild(r);
        if (result == null) result = caseGChild(r);
        if (result == null) result = caseFChild(r);
        if (result == null) result = caseEChild(r);
        if (result == null) result = caseDChild(r);
        if (result == null) result = caseCChild(r);
        if (result == null) result = caseBChild(r);
        if (result == null) result = caseAChild(r);
        if (result == null) result = caseExprChild(r);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.RCHILD:
      {
        RChild rChild = (RChild)theEObject;
        T1 result = caseRChild(rChild);
        if (result == null) result = caseQChild(rChild);
        if (result == null) result = casePChild(rChild);
        if (result == null) result = caseOChild(rChild);
        if (result == null) result = caseNChild(rChild);
        if (result == null) result = caseMChild(rChild);
        if (result == null) result = caseLChild(rChild);
        if (result == null) result = caseKChild(rChild);
        if (result == null) result = caseJChild(rChild);
        if (result == null) result = caseIChild(rChild);
        if (result == null) result = caseHChild(rChild);
        if (result == null) result = caseGChild(rChild);
        if (result == null) result = caseFChild(rChild);
        if (result == null) result = caseEChild(rChild);
        if (result == null) result = caseDChild(rChild);
        if (result == null) result = caseCChild(rChild);
        if (result == null) result = caseBChild(rChild);
        if (result == null) result = caseAChild(rChild);
        if (result == null) result = caseExprChild(rChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.S:
      {
        S s = (S)theEObject;
        T1 result = caseS(s);
        if (result == null) result = caseRChild(s);
        if (result == null) result = caseQChild(s);
        if (result == null) result = casePChild(s);
        if (result == null) result = caseOChild(s);
        if (result == null) result = caseNChild(s);
        if (result == null) result = caseMChild(s);
        if (result == null) result = caseLChild(s);
        if (result == null) result = caseKChild(s);
        if (result == null) result = caseJChild(s);
        if (result == null) result = caseIChild(s);
        if (result == null) result = caseHChild(s);
        if (result == null) result = caseGChild(s);
        if (result == null) result = caseFChild(s);
        if (result == null) result = caseEChild(s);
        if (result == null) result = caseDChild(s);
        if (result == null) result = caseCChild(s);
        if (result == null) result = caseBChild(s);
        if (result == null) result = caseAChild(s);
        if (result == null) result = caseExprChild(s);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.SCHILD:
      {
        SChild sChild = (SChild)theEObject;
        T1 result = caseSChild(sChild);
        if (result == null) result = caseRChild(sChild);
        if (result == null) result = caseQChild(sChild);
        if (result == null) result = casePChild(sChild);
        if (result == null) result = caseOChild(sChild);
        if (result == null) result = caseNChild(sChild);
        if (result == null) result = caseMChild(sChild);
        if (result == null) result = caseLChild(sChild);
        if (result == null) result = caseKChild(sChild);
        if (result == null) result = caseJChild(sChild);
        if (result == null) result = caseIChild(sChild);
        if (result == null) result = caseHChild(sChild);
        if (result == null) result = caseGChild(sChild);
        if (result == null) result = caseFChild(sChild);
        if (result == null) result = caseEChild(sChild);
        if (result == null) result = caseDChild(sChild);
        if (result == null) result = caseCChild(sChild);
        if (result == null) result = caseBChild(sChild);
        if (result == null) result = caseAChild(sChild);
        if (result == null) result = caseExprChild(sChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.T:
      {
        T t = (T)theEObject;
        T1 result = caseT(t);
        if (result == null) result = caseSChild(t);
        if (result == null) result = caseRChild(t);
        if (result == null) result = caseQChild(t);
        if (result == null) result = casePChild(t);
        if (result == null) result = caseOChild(t);
        if (result == null) result = caseNChild(t);
        if (result == null) result = caseMChild(t);
        if (result == null) result = caseLChild(t);
        if (result == null) result = caseKChild(t);
        if (result == null) result = caseJChild(t);
        if (result == null) result = caseIChild(t);
        if (result == null) result = caseHChild(t);
        if (result == null) result = caseGChild(t);
        if (result == null) result = caseFChild(t);
        if (result == null) result = caseEChild(t);
        if (result == null) result = caseDChild(t);
        if (result == null) result = caseCChild(t);
        if (result == null) result = caseBChild(t);
        if (result == null) result = caseAChild(t);
        if (result == null) result = caseExprChild(t);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.TCHILD:
      {
        TChild tChild = (TChild)theEObject;
        T1 result = caseTChild(tChild);
        if (result == null) result = caseSChild(tChild);
        if (result == null) result = caseRChild(tChild);
        if (result == null) result = caseQChild(tChild);
        if (result == null) result = casePChild(tChild);
        if (result == null) result = caseOChild(tChild);
        if (result == null) result = caseNChild(tChild);
        if (result == null) result = caseMChild(tChild);
        if (result == null) result = caseLChild(tChild);
        if (result == null) result = caseKChild(tChild);
        if (result == null) result = caseJChild(tChild);
        if (result == null) result = caseIChild(tChild);
        if (result == null) result = caseHChild(tChild);
        if (result == null) result = caseGChild(tChild);
        if (result == null) result = caseFChild(tChild);
        if (result == null) result = caseEChild(tChild);
        if (result == null) result = caseDChild(tChild);
        if (result == null) result = caseCChild(tChild);
        if (result == null) result = caseBChild(tChild);
        if (result == null) result = caseAChild(tChild);
        if (result == null) result = caseExprChild(tChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.U:
      {
        U u = (U)theEObject;
        T1 result = caseU(u);
        if (result == null) result = caseTChild(u);
        if (result == null) result = caseSChild(u);
        if (result == null) result = caseRChild(u);
        if (result == null) result = caseQChild(u);
        if (result == null) result = casePChild(u);
        if (result == null) result = caseOChild(u);
        if (result == null) result = caseNChild(u);
        if (result == null) result = caseMChild(u);
        if (result == null) result = caseLChild(u);
        if (result == null) result = caseKChild(u);
        if (result == null) result = caseJChild(u);
        if (result == null) result = caseIChild(u);
        if (result == null) result = caseHChild(u);
        if (result == null) result = caseGChild(u);
        if (result == null) result = caseFChild(u);
        if (result == null) result = caseEChild(u);
        if (result == null) result = caseDChild(u);
        if (result == null) result = caseCChild(u);
        if (result == null) result = caseBChild(u);
        if (result == null) result = caseAChild(u);
        if (result == null) result = caseExprChild(u);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.UCHILD:
      {
        UChild uChild = (UChild)theEObject;
        T1 result = caseUChild(uChild);
        if (result == null) result = caseTChild(uChild);
        if (result == null) result = caseSChild(uChild);
        if (result == null) result = caseRChild(uChild);
        if (result == null) result = caseQChild(uChild);
        if (result == null) result = casePChild(uChild);
        if (result == null) result = caseOChild(uChild);
        if (result == null) result = caseNChild(uChild);
        if (result == null) result = caseMChild(uChild);
        if (result == null) result = caseLChild(uChild);
        if (result == null) result = caseKChild(uChild);
        if (result == null) result = caseJChild(uChild);
        if (result == null) result = caseIChild(uChild);
        if (result == null) result = caseHChild(uChild);
        if (result == null) result = caseGChild(uChild);
        if (result == null) result = caseFChild(uChild);
        if (result == null) result = caseEChild(uChild);
        if (result == null) result = caseDChild(uChild);
        if (result == null) result = caseCChild(uChild);
        if (result == null) result = caseBChild(uChild);
        if (result == null) result = caseAChild(uChild);
        if (result == null) result = caseExprChild(uChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.V:
      {
        V v = (V)theEObject;
        T1 result = caseV(v);
        if (result == null) result = caseUChild(v);
        if (result == null) result = caseTChild(v);
        if (result == null) result = caseSChild(v);
        if (result == null) result = caseRChild(v);
        if (result == null) result = caseQChild(v);
        if (result == null) result = casePChild(v);
        if (result == null) result = caseOChild(v);
        if (result == null) result = caseNChild(v);
        if (result == null) result = caseMChild(v);
        if (result == null) result = caseLChild(v);
        if (result == null) result = caseKChild(v);
        if (result == null) result = caseJChild(v);
        if (result == null) result = caseIChild(v);
        if (result == null) result = caseHChild(v);
        if (result == null) result = caseGChild(v);
        if (result == null) result = caseFChild(v);
        if (result == null) result = caseEChild(v);
        if (result == null) result = caseDChild(v);
        if (result == null) result = caseCChild(v);
        if (result == null) result = caseBChild(v);
        if (result == null) result = caseAChild(v);
        if (result == null) result = caseExprChild(v);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.VCHILD:
      {
        VChild vChild = (VChild)theEObject;
        T1 result = caseVChild(vChild);
        if (result == null) result = caseUChild(vChild);
        if (result == null) result = caseTChild(vChild);
        if (result == null) result = caseSChild(vChild);
        if (result == null) result = caseRChild(vChild);
        if (result == null) result = caseQChild(vChild);
        if (result == null) result = casePChild(vChild);
        if (result == null) result = caseOChild(vChild);
        if (result == null) result = caseNChild(vChild);
        if (result == null) result = caseMChild(vChild);
        if (result == null) result = caseLChild(vChild);
        if (result == null) result = caseKChild(vChild);
        if (result == null) result = caseJChild(vChild);
        if (result == null) result = caseIChild(vChild);
        if (result == null) result = caseHChild(vChild);
        if (result == null) result = caseGChild(vChild);
        if (result == null) result = caseFChild(vChild);
        if (result == null) result = caseEChild(vChild);
        if (result == null) result = caseDChild(vChild);
        if (result == null) result = caseCChild(vChild);
        if (result == null) result = caseBChild(vChild);
        if (result == null) result = caseAChild(vChild);
        if (result == null) result = caseExprChild(vChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.W:
      {
        W w = (W)theEObject;
        T1 result = caseW(w);
        if (result == null) result = caseVChild(w);
        if (result == null) result = caseUChild(w);
        if (result == null) result = caseTChild(w);
        if (result == null) result = caseSChild(w);
        if (result == null) result = caseRChild(w);
        if (result == null) result = caseQChild(w);
        if (result == null) result = casePChild(w);
        if (result == null) result = caseOChild(w);
        if (result == null) result = caseNChild(w);
        if (result == null) result = caseMChild(w);
        if (result == null) result = caseLChild(w);
        if (result == null) result = caseKChild(w);
        if (result == null) result = caseJChild(w);
        if (result == null) result = caseIChild(w);
        if (result == null) result = caseHChild(w);
        if (result == null) result = caseGChild(w);
        if (result == null) result = caseFChild(w);
        if (result == null) result = caseEChild(w);
        if (result == null) result = caseDChild(w);
        if (result == null) result = caseCChild(w);
        if (result == null) result = caseBChild(w);
        if (result == null) result = caseAChild(w);
        if (result == null) result = caseExprChild(w);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.WCHILD:
      {
        WChild wChild = (WChild)theEObject;
        T1 result = caseWChild(wChild);
        if (result == null) result = caseVChild(wChild);
        if (result == null) result = caseUChild(wChild);
        if (result == null) result = caseTChild(wChild);
        if (result == null) result = caseSChild(wChild);
        if (result == null) result = caseRChild(wChild);
        if (result == null) result = caseQChild(wChild);
        if (result == null) result = casePChild(wChild);
        if (result == null) result = caseOChild(wChild);
        if (result == null) result = caseNChild(wChild);
        if (result == null) result = caseMChild(wChild);
        if (result == null) result = caseLChild(wChild);
        if (result == null) result = caseKChild(wChild);
        if (result == null) result = caseJChild(wChild);
        if (result == null) result = caseIChild(wChild);
        if (result == null) result = caseHChild(wChild);
        if (result == null) result = caseGChild(wChild);
        if (result == null) result = caseFChild(wChild);
        if (result == null) result = caseEChild(wChild);
        if (result == null) result = caseDChild(wChild);
        if (result == null) result = caseCChild(wChild);
        if (result == null) result = caseBChild(wChild);
        if (result == null) result = caseAChild(wChild);
        if (result == null) result = caseExprChild(wChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.X:
      {
        X x = (X)theEObject;
        T1 result = caseX(x);
        if (result == null) result = caseWChild(x);
        if (result == null) result = caseVChild(x);
        if (result == null) result = caseUChild(x);
        if (result == null) result = caseTChild(x);
        if (result == null) result = caseSChild(x);
        if (result == null) result = caseRChild(x);
        if (result == null) result = caseQChild(x);
        if (result == null) result = casePChild(x);
        if (result == null) result = caseOChild(x);
        if (result == null) result = caseNChild(x);
        if (result == null) result = caseMChild(x);
        if (result == null) result = caseLChild(x);
        if (result == null) result = caseKChild(x);
        if (result == null) result = caseJChild(x);
        if (result == null) result = caseIChild(x);
        if (result == null) result = caseHChild(x);
        if (result == null) result = caseGChild(x);
        if (result == null) result = caseFChild(x);
        if (result == null) result = caseEChild(x);
        if (result == null) result = caseDChild(x);
        if (result == null) result = caseCChild(x);
        if (result == null) result = caseBChild(x);
        if (result == null) result = caseAChild(x);
        if (result == null) result = caseExprChild(x);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.XCHILD:
      {
        XChild xChild = (XChild)theEObject;
        T1 result = caseXChild(xChild);
        if (result == null) result = caseWChild(xChild);
        if (result == null) result = caseVChild(xChild);
        if (result == null) result = caseUChild(xChild);
        if (result == null) result = caseTChild(xChild);
        if (result == null) result = caseSChild(xChild);
        if (result == null) result = caseRChild(xChild);
        if (result == null) result = caseQChild(xChild);
        if (result == null) result = casePChild(xChild);
        if (result == null) result = caseOChild(xChild);
        if (result == null) result = caseNChild(xChild);
        if (result == null) result = caseMChild(xChild);
        if (result == null) result = caseLChild(xChild);
        if (result == null) result = caseKChild(xChild);
        if (result == null) result = caseJChild(xChild);
        if (result == null) result = caseIChild(xChild);
        if (result == null) result = caseHChild(xChild);
        if (result == null) result = caseGChild(xChild);
        if (result == null) result = caseFChild(xChild);
        if (result == null) result = caseEChild(xChild);
        if (result == null) result = caseDChild(xChild);
        if (result == null) result = caseCChild(xChild);
        if (result == null) result = caseBChild(xChild);
        if (result == null) result = caseAChild(xChild);
        if (result == null) result = caseExprChild(xChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.Y:
      {
        Y y = (Y)theEObject;
        T1 result = caseY(y);
        if (result == null) result = caseXChild(y);
        if (result == null) result = caseWChild(y);
        if (result == null) result = caseVChild(y);
        if (result == null) result = caseUChild(y);
        if (result == null) result = caseTChild(y);
        if (result == null) result = caseSChild(y);
        if (result == null) result = caseRChild(y);
        if (result == null) result = caseQChild(y);
        if (result == null) result = casePChild(y);
        if (result == null) result = caseOChild(y);
        if (result == null) result = caseNChild(y);
        if (result == null) result = caseMChild(y);
        if (result == null) result = caseLChild(y);
        if (result == null) result = caseKChild(y);
        if (result == null) result = caseJChild(y);
        if (result == null) result = caseIChild(y);
        if (result == null) result = caseHChild(y);
        if (result == null) result = caseGChild(y);
        if (result == null) result = caseFChild(y);
        if (result == null) result = caseEChild(y);
        if (result == null) result = caseDChild(y);
        if (result == null) result = caseCChild(y);
        if (result == null) result = caseBChild(y);
        if (result == null) result = caseAChild(y);
        if (result == null) result = caseExprChild(y);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.YCHILD:
      {
        YChild yChild = (YChild)theEObject;
        T1 result = caseYChild(yChild);
        if (result == null) result = caseXChild(yChild);
        if (result == null) result = caseWChild(yChild);
        if (result == null) result = caseVChild(yChild);
        if (result == null) result = caseUChild(yChild);
        if (result == null) result = caseTChild(yChild);
        if (result == null) result = caseSChild(yChild);
        if (result == null) result = caseRChild(yChild);
        if (result == null) result = caseQChild(yChild);
        if (result == null) result = casePChild(yChild);
        if (result == null) result = caseOChild(yChild);
        if (result == null) result = caseNChild(yChild);
        if (result == null) result = caseMChild(yChild);
        if (result == null) result = caseLChild(yChild);
        if (result == null) result = caseKChild(yChild);
        if (result == null) result = caseJChild(yChild);
        if (result == null) result = caseIChild(yChild);
        if (result == null) result = caseHChild(yChild);
        if (result == null) result = caseGChild(yChild);
        if (result == null) result = caseFChild(yChild);
        if (result == null) result = caseEChild(yChild);
        if (result == null) result = caseDChild(yChild);
        if (result == null) result = caseCChild(yChild);
        if (result == null) result = caseBChild(yChild);
        if (result == null) result = caseAChild(yChild);
        if (result == null) result = caseExprChild(yChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.Z:
      {
        Z z = (Z)theEObject;
        T1 result = caseZ(z);
        if (result == null) result = caseYChild(z);
        if (result == null) result = caseXChild(z);
        if (result == null) result = caseWChild(z);
        if (result == null) result = caseVChild(z);
        if (result == null) result = caseUChild(z);
        if (result == null) result = caseTChild(z);
        if (result == null) result = caseSChild(z);
        if (result == null) result = caseRChild(z);
        if (result == null) result = caseQChild(z);
        if (result == null) result = casePChild(z);
        if (result == null) result = caseOChild(z);
        if (result == null) result = caseNChild(z);
        if (result == null) result = caseMChild(z);
        if (result == null) result = caseLChild(z);
        if (result == null) result = caseKChild(z);
        if (result == null) result = caseJChild(z);
        if (result == null) result = caseIChild(z);
        if (result == null) result = caseHChild(z);
        if (result == null) result = caseGChild(z);
        if (result == null) result = caseFChild(z);
        if (result == null) result = caseEChild(z);
        if (result == null) result = caseDChild(z);
        if (result == null) result = caseCChild(z);
        if (result == null) result = caseBChild(z);
        if (result == null) result = caseAChild(z);
        if (result == null) result = caseExprChild(z);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.ZCHILD:
      {
        ZChild zChild = (ZChild)theEObject;
        T1 result = caseZChild(zChild);
        if (result == null) result = caseYChild(zChild);
        if (result == null) result = caseXChild(zChild);
        if (result == null) result = caseWChild(zChild);
        if (result == null) result = caseVChild(zChild);
        if (result == null) result = caseUChild(zChild);
        if (result == null) result = caseTChild(zChild);
        if (result == null) result = caseSChild(zChild);
        if (result == null) result = caseRChild(zChild);
        if (result == null) result = caseQChild(zChild);
        if (result == null) result = casePChild(zChild);
        if (result == null) result = caseOChild(zChild);
        if (result == null) result = caseNChild(zChild);
        if (result == null) result = caseMChild(zChild);
        if (result == null) result = caseLChild(zChild);
        if (result == null) result = caseKChild(zChild);
        if (result == null) result = caseJChild(zChild);
        if (result == null) result = caseIChild(zChild);
        if (result == null) result = caseHChild(zChild);
        if (result == null) result = caseGChild(zChild);
        if (result == null) result = caseFChild(zChild);
        if (result == null) result = caseEChild(zChild);
        if (result == null) result = caseDChild(zChild);
        if (result == null) result = caseCChild(zChild);
        if (result == null) result = caseBChild(zChild);
        if (result == null) result = caseAChild(zChild);
        if (result == null) result = caseExprChild(zChild);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TopPackage.INTEGER_LITERAL:
      {
        IntegerLiteral integerLiteral = (IntegerLiteral)theEObject;
        T1 result = caseIntegerLiteral(integerLiteral);
        if (result == null) result = caseZChild(integerLiteral);
        if (result == null) result = caseYChild(integerLiteral);
        if (result == null) result = caseXChild(integerLiteral);
        if (result == null) result = caseWChild(integerLiteral);
        if (result == null) result = caseVChild(integerLiteral);
        if (result == null) result = caseUChild(integerLiteral);
        if (result == null) result = caseTChild(integerLiteral);
        if (result == null) result = caseSChild(integerLiteral);
        if (result == null) result = caseRChild(integerLiteral);
        if (result == null) result = caseQChild(integerLiteral);
        if (result == null) result = casePChild(integerLiteral);
        if (result == null) result = caseOChild(integerLiteral);
        if (result == null) result = caseNChild(integerLiteral);
        if (result == null) result = caseMChild(integerLiteral);
        if (result == null) result = caseLChild(integerLiteral);
        if (result == null) result = caseKChild(integerLiteral);
        if (result == null) result = caseJChild(integerLiteral);
        if (result == null) result = caseIChild(integerLiteral);
        if (result == null) result = caseHChild(integerLiteral);
        if (result == null) result = caseGChild(integerLiteral);
        if (result == null) result = caseFChild(integerLiteral);
        if (result == null) result = caseEChild(integerLiteral);
        if (result == null) result = caseDChild(integerLiteral);
        if (result == null) result = caseCChild(integerLiteral);
        if (result == null) result = caseBChild(integerLiteral);
        if (result == null) result = caseAChild(integerLiteral);
        if (result == null) result = caseExprChild(integerLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Expr</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseExpr(Expr object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Expr Child</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expr Child</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseExprChild(ExprChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>A</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>A</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseA(A object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>AChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>AChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseAChild(AChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>B</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>B</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseB(B object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>BChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>BChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseBChild(BChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>C</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>C</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseC(C object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>CChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>CChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseCChild(CChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>D</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>D</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseD(D object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>DChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>DChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseDChild(DChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>E</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>E</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseE(E object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>EChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseEChild(EChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>F</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>F</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseF(F object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>FChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>FChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseFChild(FChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>G</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>G</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseG(G object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>GChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>GChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseGChild(GChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>H</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>H</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseH(H object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>HChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>HChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseHChild(HChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>I</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>I</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseI(I object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>IChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>IChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseIChild(IChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>J</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>J</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseJ(J object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>JChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>JChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseJChild(JChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>K</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>K</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseK(K object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>KChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>KChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseKChild(KChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>L</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>L</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseL(L object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>LChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>LChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseLChild(LChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>M</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>M</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseM(M object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>MChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseMChild(MChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>N</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>N</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseN(N object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>NChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>NChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseNChild(NChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>O</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>O</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseO(O object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>OChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>OChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseOChild(OChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>P</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>P</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseP(P object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>PChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>PChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 casePChild(PChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Q</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Q</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseQ(Q object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>QChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>QChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseQChild(QChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>R</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>R</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseR(R object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>RChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>RChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseRChild(RChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>S</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>S</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseS(S object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>SChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseSChild(SChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>T</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>T</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseT(T object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>TChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>TChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseTChild(TChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>U</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>U</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseU(U object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>UChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>UChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseUChild(UChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>V</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>V</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseV(V object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>VChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>VChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseVChild(VChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>W</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>W</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseW(W object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>WChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>WChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseWChild(WChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>X</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>X</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseX(X object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>XChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseXChild(XChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Y</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Y</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseY(Y object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>YChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>YChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseYChild(YChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Z</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Z</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseZ(Z object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>ZChild</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ZChild</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseZChild(ZChild object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public T1 caseIntegerLiteral(IntegerLiteral object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
	@Override
	public T1 defaultCase(EObject object) {
    return null;
  }

} //TopSwitch
