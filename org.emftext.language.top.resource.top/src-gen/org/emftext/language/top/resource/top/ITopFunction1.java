/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top;

/**
 * A simple interface for generic functions with one argument.
 */
public interface ITopFunction1<ReturnType, ArgumentType1> {
	
	public ReturnType execute(ArgumentType1 argument1);
}
