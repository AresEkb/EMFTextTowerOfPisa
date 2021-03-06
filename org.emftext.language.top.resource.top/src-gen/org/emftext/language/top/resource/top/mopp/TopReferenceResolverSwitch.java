/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

public class TopReferenceResolverSwitch implements org.emftext.language.top.resource.top.ITopReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.language.top.resource.top.ITopReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
	}
	
	public org.emftext.language.top.resource.top.ITopReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> org.emftext.language.top.resource.top.ITopReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, org.emftext.language.top.resource.top.ITopReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.emftext.language.top.resource.top.ITopOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new org.emftext.language.top.resource.top.util.TopRuntimeUtil().logWarning("Found value with invalid type for option " + org.emftext.language.top.resource.top.ITopOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.emftext.language.top.resource.top.ITopReferenceResolver) {
			org.emftext.language.top.resource.top.ITopReferenceResolver replacingResolver = (org.emftext.language.top.resource.top.ITopReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.emftext.language.top.resource.top.ITopDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.emftext.language.top.resource.top.ITopDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			org.emftext.language.top.resource.top.ITopReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.emftext.language.top.resource.top.ITopReferenceCache) {
					org.emftext.language.top.resource.top.ITopReferenceResolver nextResolver = (org.emftext.language.top.resource.top.ITopReferenceResolver) next;
					if (nextResolver instanceof org.emftext.language.top.resource.top.ITopDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.emftext.language.top.resource.top.ITopDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.emftext.language.top.resource.top.util.TopRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.language.top.resource.top.ITopOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.language.top.resource.top.ITopDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.emftext.language.top.resource.top.util.TopRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.language.top.resource.top.ITopOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.language.top.resource.top.ITopDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
