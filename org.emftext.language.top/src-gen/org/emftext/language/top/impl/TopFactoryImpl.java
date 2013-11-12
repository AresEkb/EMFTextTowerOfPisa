/**
 */
package org.emftext.language.top.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.language.top.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TopFactoryImpl extends EFactoryImpl implements TopFactory {
	/**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static TopFactory init() {
    try
    {
      TopFactory theTopFactory = (TopFactory)EPackage.Registry.INSTANCE.getEFactory(TopPackage.eNS_URI);
      if (theTopFactory != null)
      {
        return theTopFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TopFactoryImpl();
  }

	/**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TopFactoryImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public EObject create(EClass eClass) {
    switch (eClass.getClassifierID())
    {
      case TopPackage.EXPR: return createExpr();
      case TopPackage.A: return createA();
      case TopPackage.B: return createB();
      case TopPackage.C: return createC();
      case TopPackage.D: return createD();
      case TopPackage.E: return createE();
      case TopPackage.F: return createF();
      case TopPackage.G: return createG();
      case TopPackage.H: return createH();
      case TopPackage.I: return createI();
      case TopPackage.J: return createJ();
      case TopPackage.K: return createK();
      case TopPackage.L: return createL();
      case TopPackage.M: return createM();
      case TopPackage.N: return createN();
      case TopPackage.O: return createO();
      case TopPackage.P: return createP();
      case TopPackage.Q: return createQ();
      case TopPackage.R: return createR();
      case TopPackage.S: return createS();
      case TopPackage.T: return createT();
      case TopPackage.U: return createU();
      case TopPackage.V: return createV();
      case TopPackage.W: return createW();
      case TopPackage.X: return createX();
      case TopPackage.Y: return createY();
      case TopPackage.Z: return createZ();
      case TopPackage.INTEGER_LITERAL: return createIntegerLiteral();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Expr createExpr() {
    ExprImpl expr = new ExprImpl();
    return expr;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public A createA() {
    AImpl a = new AImpl();
    return a;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public B createB() {
    BImpl b = new BImpl();
    return b;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public C createC() {
    CImpl c = new CImpl();
    return c;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public D createD() {
    DImpl d = new DImpl();
    return d;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public E createE() {
    EImpl e = new EImpl();
    return e;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public F createF() {
    FImpl f = new FImpl();
    return f;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public G createG() {
    GImpl g = new GImpl();
    return g;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public H createH() {
    HImpl h = new HImpl();
    return h;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public I createI() {
    IImpl i = new IImpl();
    return i;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public J createJ() {
    JImpl j = new JImpl();
    return j;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public K createK() {
    KImpl k = new KImpl();
    return k;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public L createL() {
    LImpl l = new LImpl();
    return l;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public M createM() {
    MImpl m = new MImpl();
    return m;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public N createN() {
    NImpl n = new NImpl();
    return n;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public O createO() {
    OImpl o = new OImpl();
    return o;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public P createP() {
    PImpl p = new PImpl();
    return p;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Q createQ() {
    QImpl q = new QImpl();
    return q;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public R createR() {
    RImpl r = new RImpl();
    return r;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public S createS() {
    SImpl s = new SImpl();
    return s;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public T createT() {
    TImpl t = new TImpl();
    return t;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public U createU() {
    UImpl u = new UImpl();
    return u;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public V createV() {
    VImpl v = new VImpl();
    return v;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public W createW() {
    WImpl w = new WImpl();
    return w;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public X createX() {
    XImpl x = new XImpl();
    return x;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Y createY() {
    YImpl y = new YImpl();
    return y;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Z createZ() {
    ZImpl z = new ZImpl();
    return z;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public IntegerLiteral createIntegerLiteral() {
    IntegerLiteralImpl integerLiteral = new IntegerLiteralImpl();
    return integerLiteral;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TopPackage getTopPackage() {
    return (TopPackage)getEPackage();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
	@Deprecated
	public static TopPackage getPackage() {
    return TopPackage.eINSTANCE;
  }

} //TopFactoryImpl
