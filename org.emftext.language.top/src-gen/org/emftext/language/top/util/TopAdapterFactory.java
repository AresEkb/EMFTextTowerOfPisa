/**
 */
package org.emftext.language.top.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.emftext.language.top.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.language.top.TopPackage
 * @generated
 */
public class TopAdapterFactory extends AdapterFactoryImpl {
	/**
   * The cached model package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static TopPackage modelPackage;

	/**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TopAdapterFactory() {
    if (modelPackage == null)
    {
      modelPackage = TopPackage.eINSTANCE;
    }
  }

	/**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
	@Override
	public boolean isFactoryForType(Object object) {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

	/**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected TopSwitch<Adapter> modelSwitch =
		new TopSwitch<Adapter>()
    {
      @Override
      public Adapter caseExpr(Expr object)
      {
        return createExprAdapter();
      }
      @Override
      public Adapter caseExprChild(ExprChild object)
      {
        return createExprChildAdapter();
      }
      @Override
      public Adapter caseA(A object)
      {
        return createAAdapter();
      }
      @Override
      public Adapter caseAChild(AChild object)
      {
        return createAChildAdapter();
      }
      @Override
      public Adapter caseB(B object)
      {
        return createBAdapter();
      }
      @Override
      public Adapter caseBChild(BChild object)
      {
        return createBChildAdapter();
      }
      @Override
      public Adapter caseC(C object)
      {
        return createCAdapter();
      }
      @Override
      public Adapter caseCChild(CChild object)
      {
        return createCChildAdapter();
      }
      @Override
      public Adapter caseD(D object)
      {
        return createDAdapter();
      }
      @Override
      public Adapter caseDChild(DChild object)
      {
        return createDChildAdapter();
      }
      @Override
      public Adapter caseE(E object)
      {
        return createEAdapter();
      }
      @Override
      public Adapter caseEChild(EChild object)
      {
        return createEChildAdapter();
      }
      @Override
      public Adapter caseF(F object)
      {
        return createFAdapter();
      }
      @Override
      public Adapter caseFChild(FChild object)
      {
        return createFChildAdapter();
      }
      @Override
      public Adapter caseG(G object)
      {
        return createGAdapter();
      }
      @Override
      public Adapter caseGChild(GChild object)
      {
        return createGChildAdapter();
      }
      @Override
      public Adapter caseH(H object)
      {
        return createHAdapter();
      }
      @Override
      public Adapter caseHChild(HChild object)
      {
        return createHChildAdapter();
      }
      @Override
      public Adapter caseI(I object)
      {
        return createIAdapter();
      }
      @Override
      public Adapter caseIChild(IChild object)
      {
        return createIChildAdapter();
      }
      @Override
      public Adapter caseJ(J object)
      {
        return createJAdapter();
      }
      @Override
      public Adapter caseJChild(JChild object)
      {
        return createJChildAdapter();
      }
      @Override
      public Adapter caseK(K object)
      {
        return createKAdapter();
      }
      @Override
      public Adapter caseKChild(KChild object)
      {
        return createKChildAdapter();
      }
      @Override
      public Adapter caseL(L object)
      {
        return createLAdapter();
      }
      @Override
      public Adapter caseLChild(LChild object)
      {
        return createLChildAdapter();
      }
      @Override
      public Adapter caseM(M object)
      {
        return createMAdapter();
      }
      @Override
      public Adapter caseMChild(MChild object)
      {
        return createMChildAdapter();
      }
      @Override
      public Adapter caseN(N object)
      {
        return createNAdapter();
      }
      @Override
      public Adapter caseNChild(NChild object)
      {
        return createNChildAdapter();
      }
      @Override
      public Adapter caseO(O object)
      {
        return createOAdapter();
      }
      @Override
      public Adapter caseOChild(OChild object)
      {
        return createOChildAdapter();
      }
      @Override
      public Adapter caseP(P object)
      {
        return createPAdapter();
      }
      @Override
      public Adapter casePChild(PChild object)
      {
        return createPChildAdapter();
      }
      @Override
      public Adapter caseQ(Q object)
      {
        return createQAdapter();
      }
      @Override
      public Adapter caseQChild(QChild object)
      {
        return createQChildAdapter();
      }
      @Override
      public Adapter caseR(R object)
      {
        return createRAdapter();
      }
      @Override
      public Adapter caseRChild(RChild object)
      {
        return createRChildAdapter();
      }
      @Override
      public Adapter caseS(S object)
      {
        return createSAdapter();
      }
      @Override
      public Adapter caseSChild(SChild object)
      {
        return createSChildAdapter();
      }
      @Override
      public Adapter caseT(T object)
      {
        return createTAdapter();
      }
      @Override
      public Adapter caseTChild(TChild object)
      {
        return createTChildAdapter();
      }
      @Override
      public Adapter caseU(U object)
      {
        return createUAdapter();
      }
      @Override
      public Adapter caseUChild(UChild object)
      {
        return createUChildAdapter();
      }
      @Override
      public Adapter caseV(V object)
      {
        return createVAdapter();
      }
      @Override
      public Adapter caseVChild(VChild object)
      {
        return createVChildAdapter();
      }
      @Override
      public Adapter caseW(W object)
      {
        return createWAdapter();
      }
      @Override
      public Adapter caseWChild(WChild object)
      {
        return createWChildAdapter();
      }
      @Override
      public Adapter caseX(X object)
      {
        return createXAdapter();
      }
      @Override
      public Adapter caseXChild(XChild object)
      {
        return createXChildAdapter();
      }
      @Override
      public Adapter caseY(Y object)
      {
        return createYAdapter();
      }
      @Override
      public Adapter caseYChild(YChild object)
      {
        return createYChildAdapter();
      }
      @Override
      public Adapter caseZ(Z object)
      {
        return createZAdapter();
      }
      @Override
      public Adapter caseZChild(ZChild object)
      {
        return createZChildAdapter();
      }
      @Override
      public Adapter caseIntegerLiteral(IntegerLiteral object)
      {
        return createIntegerLiteralAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

	/**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
	@Override
	public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.Expr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.Expr
   * @generated
   */
	public Adapter createExprAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.ExprChild <em>Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.ExprChild
   * @generated
   */
	public Adapter createExprChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.A <em>A</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.A
   * @generated
   */
	public Adapter createAAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.AChild <em>AChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.AChild
   * @generated
   */
	public Adapter createAChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.B <em>B</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.B
   * @generated
   */
	public Adapter createBAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.BChild <em>BChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.BChild
   * @generated
   */
	public Adapter createBChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.C <em>C</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.C
   * @generated
   */
	public Adapter createCAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.CChild <em>CChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.CChild
   * @generated
   */
	public Adapter createCChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.D <em>D</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.D
   * @generated
   */
	public Adapter createDAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.DChild <em>DChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.DChild
   * @generated
   */
	public Adapter createDChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.E <em>E</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.E
   * @generated
   */
	public Adapter createEAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.EChild <em>EChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.EChild
   * @generated
   */
	public Adapter createEChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.F <em>F</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.F
   * @generated
   */
	public Adapter createFAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.FChild <em>FChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.FChild
   * @generated
   */
	public Adapter createFChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.G <em>G</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.G
   * @generated
   */
	public Adapter createGAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.GChild <em>GChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.GChild
   * @generated
   */
	public Adapter createGChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.H <em>H</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.H
   * @generated
   */
	public Adapter createHAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.HChild <em>HChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.HChild
   * @generated
   */
	public Adapter createHChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.I <em>I</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.I
   * @generated
   */
	public Adapter createIAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.IChild <em>IChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.IChild
   * @generated
   */
	public Adapter createIChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.J <em>J</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.J
   * @generated
   */
	public Adapter createJAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.JChild <em>JChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.JChild
   * @generated
   */
	public Adapter createJChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.K <em>K</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.K
   * @generated
   */
	public Adapter createKAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.KChild <em>KChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.KChild
   * @generated
   */
	public Adapter createKChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.L <em>L</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.L
   * @generated
   */
	public Adapter createLAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.LChild <em>LChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.LChild
   * @generated
   */
	public Adapter createLChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.M <em>M</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.M
   * @generated
   */
	public Adapter createMAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.MChild <em>MChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.MChild
   * @generated
   */
	public Adapter createMChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.N <em>N</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.N
   * @generated
   */
	public Adapter createNAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.NChild <em>NChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.NChild
   * @generated
   */
	public Adapter createNChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.O <em>O</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.O
   * @generated
   */
	public Adapter createOAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.OChild <em>OChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.OChild
   * @generated
   */
	public Adapter createOChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.P <em>P</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.P
   * @generated
   */
	public Adapter createPAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.PChild <em>PChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.PChild
   * @generated
   */
	public Adapter createPChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.Q <em>Q</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.Q
   * @generated
   */
	public Adapter createQAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.QChild <em>QChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.QChild
   * @generated
   */
	public Adapter createQChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.R <em>R</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.R
   * @generated
   */
	public Adapter createRAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.RChild <em>RChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.RChild
   * @generated
   */
	public Adapter createRChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.S <em>S</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.S
   * @generated
   */
	public Adapter createSAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.SChild <em>SChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.SChild
   * @generated
   */
	public Adapter createSChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.T <em>T</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.T
   * @generated
   */
	public Adapter createTAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.TChild <em>TChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.TChild
   * @generated
   */
	public Adapter createTChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.U <em>U</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.U
   * @generated
   */
	public Adapter createUAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.UChild <em>UChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.UChild
   * @generated
   */
	public Adapter createUChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.V <em>V</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.V
   * @generated
   */
	public Adapter createVAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.VChild <em>VChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.VChild
   * @generated
   */
	public Adapter createVChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.W <em>W</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.W
   * @generated
   */
	public Adapter createWAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.WChild <em>WChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.WChild
   * @generated
   */
	public Adapter createWChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.X <em>X</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.X
   * @generated
   */
	public Adapter createXAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.XChild <em>XChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.XChild
   * @generated
   */
	public Adapter createXChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.Y <em>Y</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.Y
   * @generated
   */
	public Adapter createYAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.YChild <em>YChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.YChild
   * @generated
   */
	public Adapter createYChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.Z <em>Z</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.Z
   * @generated
   */
	public Adapter createZAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.ZChild <em>ZChild</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.ZChild
   * @generated
   */
	public Adapter createZChildAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link org.emftext.language.top.IntegerLiteral <em>Integer Literal</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.emftext.language.top.IntegerLiteral
   * @generated
   */
	public Adapter createIntegerLiteralAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
	public Adapter createEObjectAdapter() {
    return null;
  }

} //TopAdapterFactory
