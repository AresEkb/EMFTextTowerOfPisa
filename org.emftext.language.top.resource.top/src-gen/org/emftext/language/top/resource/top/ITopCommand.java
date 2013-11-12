/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.top.resource.top;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface ITopCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
