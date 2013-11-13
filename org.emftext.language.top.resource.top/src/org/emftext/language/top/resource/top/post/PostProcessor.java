package org.emftext.language.top.resource.top.post;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.top.Expr;
import org.emftext.language.top.ExprChild;
import org.emftext.language.top.resource.top.ITopOptionProvider;
import org.emftext.language.top.resource.top.ITopOptions;
import org.emftext.language.top.resource.top.ITopResourcePostProcessor;
import org.emftext.language.top.resource.top.ITopResourcePostProcessorProvider;
import org.emftext.language.top.resource.top.mopp.TopResource;

public class PostProcessor implements ITopOptionProvider,
		ITopResourcePostProcessorProvider, ITopResourcePostProcessor {

	@Override
	public void process(TopResource resource) {
		simplifyExpressions(resource);
	}

	@Override
	public void terminate() {
	}

	@Override
	public ITopResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	@Override
	public Map<?, ?> getOptions() {
		return Collections.singletonMap(
				ITopOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}

	public static void simplifyExpressions(Resource resource) {
		simplifyDown(resource.getContents());
	}

	private static void simplifyDown(EList<EObject> parentList) {
		for (EObject child : new BasicEList<EObject>(parentList)) {
			EObject singleContained = getSingleContained(child);
			EObject next = singleContained;
			while (next != null) {
				next = getSingleContained(singleContained);
				if (next != null) {
					singleContained = next;
				}
			}
			if (singleContained != null) {
				EcoreUtil.replace(child, singleContained);
				child = singleContained;
			}
			simplifyDown(child.eContents());
		}
	}

	private static EObject getSingleContained(EObject parent) {
		if (!(parent instanceof ExprChild)) {
			return null;
		}

		if (parent instanceof Expr) {
			return null;
		}

		EObject singleContained = null;
		for (EObject contained : parent.eContents()) {
			if (singleContained != null) {
				return null;
			}
			singleContained = contained;
		}
		if (!(singleContained instanceof ExprChild)) {
			return null;
		}

		return singleContained;
	}
}
