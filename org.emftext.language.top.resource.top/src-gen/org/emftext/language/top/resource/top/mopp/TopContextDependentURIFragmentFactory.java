/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class TopContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements org.emftext.language.top.resource.top.ITopContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final org.emftext.language.top.resource.top.ITopReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public TopContextDependentURIFragmentFactory(org.emftext.language.top.resource.top.ITopReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public org.emftext.language.top.resource.top.ITopContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new org.emftext.language.top.resource.top.mopp.TopContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.emftext.language.top.resource.top.ITopReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
