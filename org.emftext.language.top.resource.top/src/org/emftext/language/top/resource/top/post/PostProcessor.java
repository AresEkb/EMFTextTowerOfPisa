package org.emftext.language.top.resource.top.post;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.top.Expr;
import org.emftext.language.top.resource.top.ITopOptionProvider;
import org.emftext.language.top.resource.top.ITopOptions;
import org.emftext.language.top.resource.top.ITopResourcePostProcessor;
import org.emftext.language.top.resource.top.ITopResourcePostProcessorProvider;
import org.emftext.language.top.resource.top.mopp.TopResource;

public class PostProcessor implements ITopOptionProvider,
		ITopResourcePostProcessorProvider, ITopResourcePostProcessor {

	@Override
	public void process(TopResource resource) {
		//EObject root = resource.getContents().get(0);
		System.out.println(">>> PostProcessor called");
		System.err.println(">>> PostProcessor called");
		int x = 1;
		int y = 0;
		System.err.println(x / y);
		simplifyExpressions(resource);
	}

	@Override
	public void terminate() {
	}

	@Override
	public ITopResourcePostProcessor getResourcePostProcessor() {
		System.out.println(">>> PostProcessor called");
		System.err.println(">>> PostProcessor called");
		return this;
	}

	@Override
	public Map<?, ?> getOptions() {
		System.out.println(">>> PostProcessor called");
		System.err.println(">>> PostProcessor called");
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
		if (!(parent instanceof Expr)) {
			return null;
		}

		EObject singleContained = null;
		for (EObject contained : parent.eContents()) {
			if (singleContained != null) {
				return null;
			}
			singleContained = contained;
		}
		if (!(singleContained instanceof Expr)) {
			return null;
		}

		return singleContained;
	}
}
