/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.util;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractTopInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<org.emftext.language.top.resource.top.ITopInterpreterListener> listeners = new java.util.ArrayList<org.emftext.language.top.resource.top.ITopInterpreterListener>();
	private org.eclipse.emf.ecore.EObject nextObjectToInterprete;
	private Object currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		org.eclipse.emf.ecore.EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (java.util.EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof org.emftext.language.top.Expr) {
			result = interprete_org_emftext_language_top_Expr((org.emftext.language.top.Expr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.A) {
			result = interprete_org_emftext_language_top_A((org.emftext.language.top.A) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.B) {
			result = interprete_org_emftext_language_top_B((org.emftext.language.top.B) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.C) {
			result = interprete_org_emftext_language_top_C((org.emftext.language.top.C) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.D) {
			result = interprete_org_emftext_language_top_D((org.emftext.language.top.D) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.E) {
			result = interprete_org_emftext_language_top_E((org.emftext.language.top.E) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.F) {
			result = interprete_org_emftext_language_top_F((org.emftext.language.top.F) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.G) {
			result = interprete_org_emftext_language_top_G((org.emftext.language.top.G) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.H) {
			result = interprete_org_emftext_language_top_H((org.emftext.language.top.H) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.I) {
			result = interprete_org_emftext_language_top_I((org.emftext.language.top.I) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.J) {
			result = interprete_org_emftext_language_top_J((org.emftext.language.top.J) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.K) {
			result = interprete_org_emftext_language_top_K((org.emftext.language.top.K) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.L) {
			result = interprete_org_emftext_language_top_L((org.emftext.language.top.L) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.M) {
			result = interprete_org_emftext_language_top_M((org.emftext.language.top.M) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.N) {
			result = interprete_org_emftext_language_top_N((org.emftext.language.top.N) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.O) {
			result = interprete_org_emftext_language_top_O((org.emftext.language.top.O) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.P) {
			result = interprete_org_emftext_language_top_P((org.emftext.language.top.P) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.Q) {
			result = interprete_org_emftext_language_top_Q((org.emftext.language.top.Q) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.R) {
			result = interprete_org_emftext_language_top_R((org.emftext.language.top.R) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.S) {
			result = interprete_org_emftext_language_top_S((org.emftext.language.top.S) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.T) {
			result = interprete_org_emftext_language_top_T((org.emftext.language.top.T) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.U) {
			result = interprete_org_emftext_language_top_U((org.emftext.language.top.U) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.V) {
			result = interprete_org_emftext_language_top_V((org.emftext.language.top.V) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.W) {
			result = interprete_org_emftext_language_top_W((org.emftext.language.top.W) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.X) {
			result = interprete_org_emftext_language_top_X((org.emftext.language.top.X) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.Y) {
			result = interprete_org_emftext_language_top_Y((org.emftext.language.top.Y) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.Z) {
			result = interprete_org_emftext_language_top_Z((org.emftext.language.top.Z) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.IntegerLiteral) {
			result = interprete_org_emftext_language_top_IntegerLiteral((org.emftext.language.top.IntegerLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.ZChild) {
			result = interprete_org_emftext_language_top_ZChild((org.emftext.language.top.ZChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.YChild) {
			result = interprete_org_emftext_language_top_YChild((org.emftext.language.top.YChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.XChild) {
			result = interprete_org_emftext_language_top_XChild((org.emftext.language.top.XChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.WChild) {
			result = interprete_org_emftext_language_top_WChild((org.emftext.language.top.WChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.VChild) {
			result = interprete_org_emftext_language_top_VChild((org.emftext.language.top.VChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.UChild) {
			result = interprete_org_emftext_language_top_UChild((org.emftext.language.top.UChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.TChild) {
			result = interprete_org_emftext_language_top_TChild((org.emftext.language.top.TChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.SChild) {
			result = interprete_org_emftext_language_top_SChild((org.emftext.language.top.SChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.RChild) {
			result = interprete_org_emftext_language_top_RChild((org.emftext.language.top.RChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.QChild) {
			result = interprete_org_emftext_language_top_QChild((org.emftext.language.top.QChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.PChild) {
			result = interprete_org_emftext_language_top_PChild((org.emftext.language.top.PChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.OChild) {
			result = interprete_org_emftext_language_top_OChild((org.emftext.language.top.OChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.NChild) {
			result = interprete_org_emftext_language_top_NChild((org.emftext.language.top.NChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.MChild) {
			result = interprete_org_emftext_language_top_MChild((org.emftext.language.top.MChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.LChild) {
			result = interprete_org_emftext_language_top_LChild((org.emftext.language.top.LChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.KChild) {
			result = interprete_org_emftext_language_top_KChild((org.emftext.language.top.KChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.JChild) {
			result = interprete_org_emftext_language_top_JChild((org.emftext.language.top.JChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.IChild) {
			result = interprete_org_emftext_language_top_IChild((org.emftext.language.top.IChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.HChild) {
			result = interprete_org_emftext_language_top_HChild((org.emftext.language.top.HChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.GChild) {
			result = interprete_org_emftext_language_top_GChild((org.emftext.language.top.GChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.FChild) {
			result = interprete_org_emftext_language_top_FChild((org.emftext.language.top.FChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.EChild) {
			result = interprete_org_emftext_language_top_EChild((org.emftext.language.top.EChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.DChild) {
			result = interprete_org_emftext_language_top_DChild((org.emftext.language.top.DChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.CChild) {
			result = interprete_org_emftext_language_top_CChild((org.emftext.language.top.CChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.BChild) {
			result = interprete_org_emftext_language_top_BChild((org.emftext.language.top.BChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.AChild) {
			result = interprete_org_emftext_language_top_AChild((org.emftext.language.top.AChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.language.top.ExprChild) {
			result = interprete_org_emftext_language_top_ExprChild((org.emftext.language.top.ExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_emftext_language_top_Expr(org.emftext.language.top.Expr expr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_ExprChild(org.emftext.language.top.ExprChild exprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_A(org.emftext.language.top.A a, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_AChild(org.emftext.language.top.AChild aChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_B(org.emftext.language.top.B b, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_BChild(org.emftext.language.top.BChild bChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_C(org.emftext.language.top.C c, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_CChild(org.emftext.language.top.CChild cChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_D(org.emftext.language.top.D d, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_DChild(org.emftext.language.top.DChild dChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_E(org.emftext.language.top.E e, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_EChild(org.emftext.language.top.EChild eChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_F(org.emftext.language.top.F f, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_FChild(org.emftext.language.top.FChild fChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_G(org.emftext.language.top.G g, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_GChild(org.emftext.language.top.GChild gChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_H(org.emftext.language.top.H h, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_HChild(org.emftext.language.top.HChild hChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_I(org.emftext.language.top.I i, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_IChild(org.emftext.language.top.IChild iChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_J(org.emftext.language.top.J j, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_JChild(org.emftext.language.top.JChild jChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_K(org.emftext.language.top.K k, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_KChild(org.emftext.language.top.KChild kChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_L(org.emftext.language.top.L l, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_LChild(org.emftext.language.top.LChild lChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_M(org.emftext.language.top.M m, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_MChild(org.emftext.language.top.MChild mChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_N(org.emftext.language.top.N n, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_NChild(org.emftext.language.top.NChild nChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_O(org.emftext.language.top.O o, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_OChild(org.emftext.language.top.OChild oChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_P(org.emftext.language.top.P p, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_PChild(org.emftext.language.top.PChild pChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_Q(org.emftext.language.top.Q q, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_QChild(org.emftext.language.top.QChild qChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_R(org.emftext.language.top.R r, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_RChild(org.emftext.language.top.RChild rChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_S(org.emftext.language.top.S s, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_SChild(org.emftext.language.top.SChild sChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_T(org.emftext.language.top.T t, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_TChild(org.emftext.language.top.TChild tChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_U(org.emftext.language.top.U u, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_UChild(org.emftext.language.top.UChild uChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_V(org.emftext.language.top.V v, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_VChild(org.emftext.language.top.VChild vChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_W(org.emftext.language.top.W w, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_WChild(org.emftext.language.top.WChild wChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_X(org.emftext.language.top.X x, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_XChild(org.emftext.language.top.XChild xChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_Y(org.emftext.language.top.Y y, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_YChild(org.emftext.language.top.YChild yChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_Z(org.emftext.language.top.Z z, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_ZChild(org.emftext.language.top.ZChild zChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_language_top_IntegerLiteral(org.emftext.language.top.IntegerLiteral integerLiteral, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (org.emftext.language.top.resource.top.ITopInterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		for (org.eclipse.emf.ecore.EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		java.util.List<org.eclipse.emf.ecore.EObject> reverse = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(objects.size());
		reverse.addAll(objects);
		java.util.Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> objects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		objects.add(root);
		java.util.Iterator<org.eclipse.emf.ecore.EObject> it = root.eAllContents();
		while (it.hasNext()) {
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(org.emftext.language.top.resource.top.ITopInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(org.emftext.language.top.resource.top.ITopInterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public org.eclipse.emf.ecore.EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public java.util.Stack<org.eclipse.emf.ecore.EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public Object getCurrentContext() {
		return currentContext;
	}
	
}
