/**
 */
package org.emftext.language.top;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.language.top.TopFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore#/'"
 * @generated
 */
public interface TopPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "top";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://www.emftext.org/language/top";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "top";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	TopPackage eINSTANCE = org.emftext.language.top.impl.TopPackageImpl.init();

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.ExprImpl <em>Expr</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.ExprImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getExpr()
   * @generated
   */
	int EXPR = 0;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EXPR__CHILD = 0;

	/**
   * The number of structural features of the '<em>Expr</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EXPR_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.ExprChildImpl <em>Expr Child</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.ExprChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getExprChild()
   * @generated
   */
	int EXPR_CHILD = 1;

	/**
   * The number of structural features of the '<em>Expr Child</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int EXPR_CHILD_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.AImpl <em>A</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.AImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getA()
   * @generated
   */
	int A = 2;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int A__CHILD = EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>A</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int A_FEATURE_COUNT = EXPR_CHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.AChildImpl <em>AChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.AChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getAChild()
   * @generated
   */
	int ACHILD = 3;

	/**
   * The number of structural features of the '<em>AChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ACHILD_FEATURE_COUNT = EXPR_CHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.BImpl <em>B</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.BImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getB()
   * @generated
   */
	int B = 4;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int B__CHILD = ACHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>B</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int B_FEATURE_COUNT = ACHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.BChildImpl <em>BChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.BChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getBChild()
   * @generated
   */
	int BCHILD = 5;

	/**
   * The number of structural features of the '<em>BChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int BCHILD_FEATURE_COUNT = ACHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.CImpl <em>C</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.CImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getC()
   * @generated
   */
	int C = 6;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int C__CHILD = BCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>C</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int C_FEATURE_COUNT = BCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.CChildImpl <em>CChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.CChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getCChild()
   * @generated
   */
	int CCHILD = 7;

	/**
   * The number of structural features of the '<em>CChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int CCHILD_FEATURE_COUNT = BCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.DImpl <em>D</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.DImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getD()
   * @generated
   */
	int D = 8;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int D__CHILD = CCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>D</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int D_FEATURE_COUNT = CCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.DChildImpl <em>DChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.DChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getDChild()
   * @generated
   */
	int DCHILD = 9;

	/**
   * The number of structural features of the '<em>DChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int DCHILD_FEATURE_COUNT = CCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.EImpl <em>E</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.EImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getE()
   * @generated
   */
	int E = 10;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int E__CHILD = DCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>E</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int E_FEATURE_COUNT = DCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.EChildImpl <em>EChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.EChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getEChild()
   * @generated
   */
	int ECHILD = 11;

	/**
   * The number of structural features of the '<em>EChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ECHILD_FEATURE_COUNT = DCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.FImpl <em>F</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.FImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getF()
   * @generated
   */
	int F = 12;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int F__CHILD = ECHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>F</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int F_FEATURE_COUNT = ECHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.FChildImpl <em>FChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.FChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getFChild()
   * @generated
   */
	int FCHILD = 13;

	/**
   * The number of structural features of the '<em>FChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FCHILD_FEATURE_COUNT = ECHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.GImpl <em>G</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.GImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getG()
   * @generated
   */
	int G = 14;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int G__CHILD = FCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>G</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int G_FEATURE_COUNT = FCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.GChildImpl <em>GChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.GChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getGChild()
   * @generated
   */
	int GCHILD = 15;

	/**
   * The number of structural features of the '<em>GChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int GCHILD_FEATURE_COUNT = FCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.HImpl <em>H</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.HImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getH()
   * @generated
   */
	int H = 16;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int H__CHILD = GCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>H</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int H_FEATURE_COUNT = GCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.HChildImpl <em>HChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.HChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getHChild()
   * @generated
   */
	int HCHILD = 17;

	/**
   * The number of structural features of the '<em>HChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int HCHILD_FEATURE_COUNT = GCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.IImpl <em>I</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.IImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getI()
   * @generated
   */
	int I = 18;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int I__CHILD = HCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>I</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int I_FEATURE_COUNT = HCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.IChildImpl <em>IChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.IChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getIChild()
   * @generated
   */
	int ICHILD = 19;

	/**
   * The number of structural features of the '<em>IChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ICHILD_FEATURE_COUNT = HCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.JImpl <em>J</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.JImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getJ()
   * @generated
   */
	int J = 20;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int J__CHILD = ICHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>J</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int J_FEATURE_COUNT = ICHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.JChildImpl <em>JChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.JChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getJChild()
   * @generated
   */
	int JCHILD = 21;

	/**
   * The number of structural features of the '<em>JChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int JCHILD_FEATURE_COUNT = ICHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.KImpl <em>K</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.KImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getK()
   * @generated
   */
	int K = 22;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int K__CHILD = JCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>K</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int K_FEATURE_COUNT = JCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.KChildImpl <em>KChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.KChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getKChild()
   * @generated
   */
	int KCHILD = 23;

	/**
   * The number of structural features of the '<em>KChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int KCHILD_FEATURE_COUNT = JCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.LImpl <em>L</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.LImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getL()
   * @generated
   */
	int L = 24;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int L__CHILD = KCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>L</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int L_FEATURE_COUNT = KCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.LChildImpl <em>LChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.LChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getLChild()
   * @generated
   */
	int LCHILD = 25;

	/**
   * The number of structural features of the '<em>LChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LCHILD_FEATURE_COUNT = KCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.MImpl <em>M</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.MImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getM()
   * @generated
   */
	int M = 26;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int M__CHILD = LCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>M</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int M_FEATURE_COUNT = LCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.MChildImpl <em>MChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.MChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getMChild()
   * @generated
   */
	int MCHILD = 27;

	/**
   * The number of structural features of the '<em>MChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MCHILD_FEATURE_COUNT = LCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.NImpl <em>N</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.NImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getN()
   * @generated
   */
	int N = 28;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int N__CHILD = MCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>N</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int N_FEATURE_COUNT = MCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.NChildImpl <em>NChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.NChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getNChild()
   * @generated
   */
	int NCHILD = 29;

	/**
   * The number of structural features of the '<em>NChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int NCHILD_FEATURE_COUNT = MCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.OImpl <em>O</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.OImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getO()
   * @generated
   */
	int O = 30;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int O__CHILD = NCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>O</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int O_FEATURE_COUNT = NCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.OChildImpl <em>OChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.OChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getOChild()
   * @generated
   */
	int OCHILD = 31;

	/**
   * The number of structural features of the '<em>OChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int OCHILD_FEATURE_COUNT = NCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.PImpl <em>P</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.PImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getP()
   * @generated
   */
	int P = 32;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int P__CHILD = OCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>P</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int P_FEATURE_COUNT = OCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.PChildImpl <em>PChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.PChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getPChild()
   * @generated
   */
	int PCHILD = 33;

	/**
   * The number of structural features of the '<em>PChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int PCHILD_FEATURE_COUNT = OCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.QImpl <em>Q</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.QImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getQ()
   * @generated
   */
	int Q = 34;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int Q__CHILD = PCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Q</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int Q_FEATURE_COUNT = PCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.QChildImpl <em>QChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.QChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getQChild()
   * @generated
   */
	int QCHILD = 35;

	/**
   * The number of structural features of the '<em>QChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int QCHILD_FEATURE_COUNT = PCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.RImpl <em>R</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.RImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getR()
   * @generated
   */
	int R = 36;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int R__CHILD = QCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>R</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int R_FEATURE_COUNT = QCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.RChildImpl <em>RChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.RChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getRChild()
   * @generated
   */
	int RCHILD = 37;

	/**
   * The number of structural features of the '<em>RChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int RCHILD_FEATURE_COUNT = QCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.SImpl <em>S</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.SImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getS()
   * @generated
   */
	int S = 38;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int S__CHILD = RCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>S</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int S_FEATURE_COUNT = RCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.SChildImpl <em>SChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.SChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getSChild()
   * @generated
   */
	int SCHILD = 39;

	/**
   * The number of structural features of the '<em>SChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int SCHILD_FEATURE_COUNT = RCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.TImpl <em>T</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.TImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getT()
   * @generated
   */
	int T = 40;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int T__CHILD = SCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>T</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int T_FEATURE_COUNT = SCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.TChildImpl <em>TChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.TChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getTChild()
   * @generated
   */
	int TCHILD = 41;

	/**
   * The number of structural features of the '<em>TChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TCHILD_FEATURE_COUNT = SCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.UImpl <em>U</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.UImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getU()
   * @generated
   */
	int U = 42;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int U__CHILD = TCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>U</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int U_FEATURE_COUNT = TCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.UChildImpl <em>UChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.UChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getUChild()
   * @generated
   */
	int UCHILD = 43;

	/**
   * The number of structural features of the '<em>UChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int UCHILD_FEATURE_COUNT = TCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.VImpl <em>V</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.VImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getV()
   * @generated
   */
	int V = 44;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int V__CHILD = UCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>V</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int V_FEATURE_COUNT = UCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.VChildImpl <em>VChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.VChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getVChild()
   * @generated
   */
	int VCHILD = 45;

	/**
   * The number of structural features of the '<em>VChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int VCHILD_FEATURE_COUNT = UCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.WImpl <em>W</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.WImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getW()
   * @generated
   */
	int W = 46;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int W__CHILD = VCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>W</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int W_FEATURE_COUNT = VCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.WChildImpl <em>WChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.WChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getWChild()
   * @generated
   */
	int WCHILD = 47;

	/**
   * The number of structural features of the '<em>WChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WCHILD_FEATURE_COUNT = VCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.XImpl <em>X</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.XImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getX()
   * @generated
   */
	int X = 48;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int X__CHILD = WCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>X</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int X_FEATURE_COUNT = WCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.XChildImpl <em>XChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.XChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getXChild()
   * @generated
   */
	int XCHILD = 49;

	/**
   * The number of structural features of the '<em>XChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int XCHILD_FEATURE_COUNT = WCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.YImpl <em>Y</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.YImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getY()
   * @generated
   */
	int Y = 50;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int Y__CHILD = XCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Y</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int Y_FEATURE_COUNT = XCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.YChildImpl <em>YChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.YChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getYChild()
   * @generated
   */
	int YCHILD = 51;

	/**
   * The number of structural features of the '<em>YChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int YCHILD_FEATURE_COUNT = XCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.ZImpl <em>Z</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.ZImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getZ()
   * @generated
   */
	int Z = 52;

	/**
   * The feature id for the '<em><b>Child</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int Z__CHILD = YCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Z</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int Z_FEATURE_COUNT = YCHILD_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.ZChildImpl <em>ZChild</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.ZChildImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getZChild()
   * @generated
   */
	int ZCHILD = 53;

	/**
   * The number of structural features of the '<em>ZChild</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ZCHILD_FEATURE_COUNT = YCHILD_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link org.emftext.language.top.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see org.emftext.language.top.impl.IntegerLiteralImpl
   * @see org.emftext.language.top.impl.TopPackageImpl#getIntegerLiteral()
   * @generated
   */
	int INTEGER_LITERAL = 54;

	/**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INTEGER_LITERAL__VALUE = ZCHILD_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Integer Literal</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int INTEGER_LITERAL_FEATURE_COUNT = ZCHILD_FEATURE_COUNT + 1;


	/**
   * Returns the meta object for class '{@link org.emftext.language.top.Expr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr</em>'.
   * @see org.emftext.language.top.Expr
   * @generated
   */
	EClass getExpr();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.Expr#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.Expr#getChild()
   * @see #getExpr()
   * @generated
   */
	EReference getExpr_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.ExprChild <em>Expr Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Child</em>'.
   * @see org.emftext.language.top.ExprChild
   * @generated
   */
	EClass getExprChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.A <em>A</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>A</em>'.
   * @see org.emftext.language.top.A
   * @generated
   */
	EClass getA();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.A#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.A#getChild()
   * @see #getA()
   * @generated
   */
	EReference getA_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.AChild <em>AChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>AChild</em>'.
   * @see org.emftext.language.top.AChild
   * @generated
   */
	EClass getAChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.B <em>B</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>B</em>'.
   * @see org.emftext.language.top.B
   * @generated
   */
	EClass getB();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.B#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.B#getChild()
   * @see #getB()
   * @generated
   */
	EReference getB_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.BChild <em>BChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>BChild</em>'.
   * @see org.emftext.language.top.BChild
   * @generated
   */
	EClass getBChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.C <em>C</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>C</em>'.
   * @see org.emftext.language.top.C
   * @generated
   */
	EClass getC();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.C#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.C#getChild()
   * @see #getC()
   * @generated
   */
	EReference getC_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.CChild <em>CChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>CChild</em>'.
   * @see org.emftext.language.top.CChild
   * @generated
   */
	EClass getCChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.D <em>D</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>D</em>'.
   * @see org.emftext.language.top.D
   * @generated
   */
	EClass getD();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.D#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.D#getChild()
   * @see #getD()
   * @generated
   */
	EReference getD_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.DChild <em>DChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>DChild</em>'.
   * @see org.emftext.language.top.DChild
   * @generated
   */
	EClass getDChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.E <em>E</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>E</em>'.
   * @see org.emftext.language.top.E
   * @generated
   */
	EClass getE();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.E#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.E#getChild()
   * @see #getE()
   * @generated
   */
	EReference getE_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.EChild <em>EChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>EChild</em>'.
   * @see org.emftext.language.top.EChild
   * @generated
   */
	EClass getEChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.F <em>F</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>F</em>'.
   * @see org.emftext.language.top.F
   * @generated
   */
	EClass getF();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.F#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.F#getChild()
   * @see #getF()
   * @generated
   */
	EReference getF_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.FChild <em>FChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>FChild</em>'.
   * @see org.emftext.language.top.FChild
   * @generated
   */
	EClass getFChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.G <em>G</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>G</em>'.
   * @see org.emftext.language.top.G
   * @generated
   */
	EClass getG();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.G#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.G#getChild()
   * @see #getG()
   * @generated
   */
	EReference getG_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.GChild <em>GChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>GChild</em>'.
   * @see org.emftext.language.top.GChild
   * @generated
   */
	EClass getGChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.H <em>H</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>H</em>'.
   * @see org.emftext.language.top.H
   * @generated
   */
	EClass getH();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.H#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.H#getChild()
   * @see #getH()
   * @generated
   */
	EReference getH_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.HChild <em>HChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>HChild</em>'.
   * @see org.emftext.language.top.HChild
   * @generated
   */
	EClass getHChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.I <em>I</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>I</em>'.
   * @see org.emftext.language.top.I
   * @generated
   */
	EClass getI();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.I#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.I#getChild()
   * @see #getI()
   * @generated
   */
	EReference getI_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.IChild <em>IChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>IChild</em>'.
   * @see org.emftext.language.top.IChild
   * @generated
   */
	EClass getIChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.J <em>J</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>J</em>'.
   * @see org.emftext.language.top.J
   * @generated
   */
	EClass getJ();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.J#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.J#getChild()
   * @see #getJ()
   * @generated
   */
	EReference getJ_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.JChild <em>JChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>JChild</em>'.
   * @see org.emftext.language.top.JChild
   * @generated
   */
	EClass getJChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.K <em>K</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>K</em>'.
   * @see org.emftext.language.top.K
   * @generated
   */
	EClass getK();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.K#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.K#getChild()
   * @see #getK()
   * @generated
   */
	EReference getK_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.KChild <em>KChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>KChild</em>'.
   * @see org.emftext.language.top.KChild
   * @generated
   */
	EClass getKChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.L <em>L</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>L</em>'.
   * @see org.emftext.language.top.L
   * @generated
   */
	EClass getL();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.L#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.L#getChild()
   * @see #getL()
   * @generated
   */
	EReference getL_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.LChild <em>LChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>LChild</em>'.
   * @see org.emftext.language.top.LChild
   * @generated
   */
	EClass getLChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.M <em>M</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>M</em>'.
   * @see org.emftext.language.top.M
   * @generated
   */
	EClass getM();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.M#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.M#getChild()
   * @see #getM()
   * @generated
   */
	EReference getM_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.MChild <em>MChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>MChild</em>'.
   * @see org.emftext.language.top.MChild
   * @generated
   */
	EClass getMChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.N <em>N</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>N</em>'.
   * @see org.emftext.language.top.N
   * @generated
   */
	EClass getN();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.N#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.N#getChild()
   * @see #getN()
   * @generated
   */
	EReference getN_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.NChild <em>NChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>NChild</em>'.
   * @see org.emftext.language.top.NChild
   * @generated
   */
	EClass getNChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.O <em>O</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>O</em>'.
   * @see org.emftext.language.top.O
   * @generated
   */
	EClass getO();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.O#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.O#getChild()
   * @see #getO()
   * @generated
   */
	EReference getO_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.OChild <em>OChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>OChild</em>'.
   * @see org.emftext.language.top.OChild
   * @generated
   */
	EClass getOChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.P <em>P</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>P</em>'.
   * @see org.emftext.language.top.P
   * @generated
   */
	EClass getP();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.P#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.P#getChild()
   * @see #getP()
   * @generated
   */
	EReference getP_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.PChild <em>PChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>PChild</em>'.
   * @see org.emftext.language.top.PChild
   * @generated
   */
	EClass getPChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.Q <em>Q</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Q</em>'.
   * @see org.emftext.language.top.Q
   * @generated
   */
	EClass getQ();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.Q#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.Q#getChild()
   * @see #getQ()
   * @generated
   */
	EReference getQ_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.QChild <em>QChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>QChild</em>'.
   * @see org.emftext.language.top.QChild
   * @generated
   */
	EClass getQChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.R <em>R</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>R</em>'.
   * @see org.emftext.language.top.R
   * @generated
   */
	EClass getR();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.R#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.R#getChild()
   * @see #getR()
   * @generated
   */
	EReference getR_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.RChild <em>RChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>RChild</em>'.
   * @see org.emftext.language.top.RChild
   * @generated
   */
	EClass getRChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.S <em>S</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>S</em>'.
   * @see org.emftext.language.top.S
   * @generated
   */
	EClass getS();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.S#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.S#getChild()
   * @see #getS()
   * @generated
   */
	EReference getS_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.SChild <em>SChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>SChild</em>'.
   * @see org.emftext.language.top.SChild
   * @generated
   */
	EClass getSChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.T <em>T</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>T</em>'.
   * @see org.emftext.language.top.T
   * @generated
   */
	EClass getT();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.T#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.T#getChild()
   * @see #getT()
   * @generated
   */
	EReference getT_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.TChild <em>TChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>TChild</em>'.
   * @see org.emftext.language.top.TChild
   * @generated
   */
	EClass getTChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.U <em>U</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>U</em>'.
   * @see org.emftext.language.top.U
   * @generated
   */
	EClass getU();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.U#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.U#getChild()
   * @see #getU()
   * @generated
   */
	EReference getU_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.UChild <em>UChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>UChild</em>'.
   * @see org.emftext.language.top.UChild
   * @generated
   */
	EClass getUChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.V <em>V</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>V</em>'.
   * @see org.emftext.language.top.V
   * @generated
   */
	EClass getV();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.V#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.V#getChild()
   * @see #getV()
   * @generated
   */
	EReference getV_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.VChild <em>VChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>VChild</em>'.
   * @see org.emftext.language.top.VChild
   * @generated
   */
	EClass getVChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.W <em>W</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>W</em>'.
   * @see org.emftext.language.top.W
   * @generated
   */
	EClass getW();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.W#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.W#getChild()
   * @see #getW()
   * @generated
   */
	EReference getW_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.WChild <em>WChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>WChild</em>'.
   * @see org.emftext.language.top.WChild
   * @generated
   */
	EClass getWChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.X <em>X</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>X</em>'.
   * @see org.emftext.language.top.X
   * @generated
   */
	EClass getX();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.X#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.X#getChild()
   * @see #getX()
   * @generated
   */
	EReference getX_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.XChild <em>XChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>XChild</em>'.
   * @see org.emftext.language.top.XChild
   * @generated
   */
	EClass getXChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.Y <em>Y</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Y</em>'.
   * @see org.emftext.language.top.Y
   * @generated
   */
	EClass getY();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.Y#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.Y#getChild()
   * @see #getY()
   * @generated
   */
	EReference getY_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.YChild <em>YChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>YChild</em>'.
   * @see org.emftext.language.top.YChild
   * @generated
   */
	EClass getYChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.Z <em>Z</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Z</em>'.
   * @see org.emftext.language.top.Z
   * @generated
   */
	EClass getZ();

	/**
   * Returns the meta object for the containment reference list '{@link org.emftext.language.top.Z#getChild <em>Child</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Child</em>'.
   * @see org.emftext.language.top.Z#getChild()
   * @see #getZ()
   * @generated
   */
	EReference getZ_Child();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.ZChild <em>ZChild</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>ZChild</em>'.
   * @see org.emftext.language.top.ZChild
   * @generated
   */
	EClass getZChild();

	/**
   * Returns the meta object for class '{@link org.emftext.language.top.IntegerLiteral <em>Integer Literal</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Literal</em>'.
   * @see org.emftext.language.top.IntegerLiteral
   * @generated
   */
	EClass getIntegerLiteral();

	/**
   * Returns the meta object for the attribute '{@link org.emftext.language.top.IntegerLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.emftext.language.top.IntegerLiteral#getValue()
   * @see #getIntegerLiteral()
   * @generated
   */
	EAttribute getIntegerLiteral_Value();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	TopFactory getTopFactory();

	/**
   * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
   * @generated
   */
	interface Literals {
		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.ExprImpl <em>Expr</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.ExprImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getExpr()
     * @generated
     */
		EClass EXPR = eINSTANCE.getExpr();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference EXPR__CHILD = eINSTANCE.getExpr_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.ExprChildImpl <em>Expr Child</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.ExprChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getExprChild()
     * @generated
     */
		EClass EXPR_CHILD = eINSTANCE.getExprChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.AImpl <em>A</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.AImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getA()
     * @generated
     */
		EClass A = eINSTANCE.getA();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference A__CHILD = eINSTANCE.getA_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.AChildImpl <em>AChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.AChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getAChild()
     * @generated
     */
		EClass ACHILD = eINSTANCE.getAChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.BImpl <em>B</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.BImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getB()
     * @generated
     */
		EClass B = eINSTANCE.getB();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference B__CHILD = eINSTANCE.getB_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.BChildImpl <em>BChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.BChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getBChild()
     * @generated
     */
		EClass BCHILD = eINSTANCE.getBChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.CImpl <em>C</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.CImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getC()
     * @generated
     */
		EClass C = eINSTANCE.getC();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference C__CHILD = eINSTANCE.getC_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.CChildImpl <em>CChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.CChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getCChild()
     * @generated
     */
		EClass CCHILD = eINSTANCE.getCChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.DImpl <em>D</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.DImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getD()
     * @generated
     */
		EClass D = eINSTANCE.getD();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference D__CHILD = eINSTANCE.getD_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.DChildImpl <em>DChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.DChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getDChild()
     * @generated
     */
		EClass DCHILD = eINSTANCE.getDChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.EImpl <em>E</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.EImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getE()
     * @generated
     */
		EClass E = eINSTANCE.getE();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference E__CHILD = eINSTANCE.getE_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.EChildImpl <em>EChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.EChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getEChild()
     * @generated
     */
		EClass ECHILD = eINSTANCE.getEChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.FImpl <em>F</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.FImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getF()
     * @generated
     */
		EClass F = eINSTANCE.getF();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference F__CHILD = eINSTANCE.getF_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.FChildImpl <em>FChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.FChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getFChild()
     * @generated
     */
		EClass FCHILD = eINSTANCE.getFChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.GImpl <em>G</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.GImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getG()
     * @generated
     */
		EClass G = eINSTANCE.getG();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference G__CHILD = eINSTANCE.getG_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.GChildImpl <em>GChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.GChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getGChild()
     * @generated
     */
		EClass GCHILD = eINSTANCE.getGChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.HImpl <em>H</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.HImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getH()
     * @generated
     */
		EClass H = eINSTANCE.getH();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference H__CHILD = eINSTANCE.getH_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.HChildImpl <em>HChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.HChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getHChild()
     * @generated
     */
		EClass HCHILD = eINSTANCE.getHChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.IImpl <em>I</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.IImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getI()
     * @generated
     */
		EClass I = eINSTANCE.getI();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference I__CHILD = eINSTANCE.getI_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.IChildImpl <em>IChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.IChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getIChild()
     * @generated
     */
		EClass ICHILD = eINSTANCE.getIChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.JImpl <em>J</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.JImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getJ()
     * @generated
     */
		EClass J = eINSTANCE.getJ();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference J__CHILD = eINSTANCE.getJ_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.JChildImpl <em>JChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.JChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getJChild()
     * @generated
     */
		EClass JCHILD = eINSTANCE.getJChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.KImpl <em>K</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.KImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getK()
     * @generated
     */
		EClass K = eINSTANCE.getK();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference K__CHILD = eINSTANCE.getK_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.KChildImpl <em>KChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.KChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getKChild()
     * @generated
     */
		EClass KCHILD = eINSTANCE.getKChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.LImpl <em>L</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.LImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getL()
     * @generated
     */
		EClass L = eINSTANCE.getL();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference L__CHILD = eINSTANCE.getL_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.LChildImpl <em>LChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.LChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getLChild()
     * @generated
     */
		EClass LCHILD = eINSTANCE.getLChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.MImpl <em>M</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.MImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getM()
     * @generated
     */
		EClass M = eINSTANCE.getM();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference M__CHILD = eINSTANCE.getM_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.MChildImpl <em>MChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.MChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getMChild()
     * @generated
     */
		EClass MCHILD = eINSTANCE.getMChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.NImpl <em>N</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.NImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getN()
     * @generated
     */
		EClass N = eINSTANCE.getN();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference N__CHILD = eINSTANCE.getN_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.NChildImpl <em>NChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.NChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getNChild()
     * @generated
     */
		EClass NCHILD = eINSTANCE.getNChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.OImpl <em>O</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.OImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getO()
     * @generated
     */
		EClass O = eINSTANCE.getO();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference O__CHILD = eINSTANCE.getO_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.OChildImpl <em>OChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.OChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getOChild()
     * @generated
     */
		EClass OCHILD = eINSTANCE.getOChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.PImpl <em>P</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.PImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getP()
     * @generated
     */
		EClass P = eINSTANCE.getP();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference P__CHILD = eINSTANCE.getP_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.PChildImpl <em>PChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.PChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getPChild()
     * @generated
     */
		EClass PCHILD = eINSTANCE.getPChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.QImpl <em>Q</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.QImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getQ()
     * @generated
     */
		EClass Q = eINSTANCE.getQ();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference Q__CHILD = eINSTANCE.getQ_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.QChildImpl <em>QChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.QChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getQChild()
     * @generated
     */
		EClass QCHILD = eINSTANCE.getQChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.RImpl <em>R</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.RImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getR()
     * @generated
     */
		EClass R = eINSTANCE.getR();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference R__CHILD = eINSTANCE.getR_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.RChildImpl <em>RChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.RChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getRChild()
     * @generated
     */
		EClass RCHILD = eINSTANCE.getRChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.SImpl <em>S</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.SImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getS()
     * @generated
     */
		EClass S = eINSTANCE.getS();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference S__CHILD = eINSTANCE.getS_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.SChildImpl <em>SChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.SChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getSChild()
     * @generated
     */
		EClass SCHILD = eINSTANCE.getSChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.TImpl <em>T</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.TImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getT()
     * @generated
     */
		EClass T = eINSTANCE.getT();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference T__CHILD = eINSTANCE.getT_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.TChildImpl <em>TChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.TChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getTChild()
     * @generated
     */
		EClass TCHILD = eINSTANCE.getTChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.UImpl <em>U</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.UImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getU()
     * @generated
     */
		EClass U = eINSTANCE.getU();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference U__CHILD = eINSTANCE.getU_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.UChildImpl <em>UChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.UChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getUChild()
     * @generated
     */
		EClass UCHILD = eINSTANCE.getUChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.VImpl <em>V</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.VImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getV()
     * @generated
     */
		EClass V = eINSTANCE.getV();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference V__CHILD = eINSTANCE.getV_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.VChildImpl <em>VChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.VChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getVChild()
     * @generated
     */
		EClass VCHILD = eINSTANCE.getVChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.WImpl <em>W</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.WImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getW()
     * @generated
     */
		EClass W = eINSTANCE.getW();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference W__CHILD = eINSTANCE.getW_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.WChildImpl <em>WChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.WChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getWChild()
     * @generated
     */
		EClass WCHILD = eINSTANCE.getWChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.XImpl <em>X</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.XImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getX()
     * @generated
     */
		EClass X = eINSTANCE.getX();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference X__CHILD = eINSTANCE.getX_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.XChildImpl <em>XChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.XChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getXChild()
     * @generated
     */
		EClass XCHILD = eINSTANCE.getXChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.YImpl <em>Y</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.YImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getY()
     * @generated
     */
		EClass Y = eINSTANCE.getY();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference Y__CHILD = eINSTANCE.getY_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.YChildImpl <em>YChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.YChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getYChild()
     * @generated
     */
		EClass YCHILD = eINSTANCE.getYChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.ZImpl <em>Z</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.ZImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getZ()
     * @generated
     */
		EClass Z = eINSTANCE.getZ();

		/**
     * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference Z__CHILD = eINSTANCE.getZ_Child();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.ZChildImpl <em>ZChild</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.ZChildImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getZChild()
     * @generated
     */
		EClass ZCHILD = eINSTANCE.getZChild();

		/**
     * The meta object literal for the '{@link org.emftext.language.top.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see org.emftext.language.top.impl.IntegerLiteralImpl
     * @see org.emftext.language.top.impl.TopPackageImpl#getIntegerLiteral()
     * @generated
     */
		EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();

		/**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute INTEGER_LITERAL__VALUE = eINSTANCE.getIntegerLiteral_Value();

	}

} //TopPackage
