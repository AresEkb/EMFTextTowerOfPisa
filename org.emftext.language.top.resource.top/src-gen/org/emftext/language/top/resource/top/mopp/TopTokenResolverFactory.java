/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top.mopp;

/**
 * The TopTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class TopTokenResolverFactory implements org.emftext.language.top.resource.top.ITopTokenResolverFactory {
	
	private java.util.Map<String, org.emftext.language.top.resource.top.ITopTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, org.emftext.language.top.resource.top.ITopTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.language.top.resource.top.ITopTokenResolver defaultResolver = new org.emftext.language.top.resource.top.analysis.TopDefaultTokenResolver();
	
	public TopTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, org.emftext.language.top.resource.top.ITopTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, org.emftext.language.top.resource.top.ITopTokenResolver>();
		registerTokenResolver("INTEGER_LITERAL", new org.emftext.language.top.resource.top.analysis.TopINTEGER_LITERALTokenResolver());
	}
	
	public org.emftext.language.top.resource.top.ITopTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.language.top.resource.top.ITopTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.emftext.language.top.resource.top.ITopTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.emftext.language.top.resource.top.ITopTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.language.top.resource.top.ITopTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.language.top.resource.top.ITopTokenResolver internalCreateResolver(java.util.Map<String, org.emftext.language.top.resource.top.ITopTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, org.emftext.language.top.resource.top.ITopTokenResolver> resolverMap, String key, org.emftext.language.top.resource.top.ITopTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
