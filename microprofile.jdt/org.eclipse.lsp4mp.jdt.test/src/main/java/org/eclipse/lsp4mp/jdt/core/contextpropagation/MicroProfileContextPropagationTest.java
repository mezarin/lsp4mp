/*******************************************************************************
* Copyright (c) 2020 Red Hat Inc. and others.
* All rights reserved. This program and the accompanying materials
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v20.html
*
* Contributors:
*     Red Hat Inc. - initial API and implementation
*******************************************************************************/
package org.eclipse.lsp4mp.jdt.core.contextpropagation;

import static org.eclipse.lsp4mp.jdt.internal.core.MicroProfileAssert.assertProperties;
import static org.eclipse.lsp4mp.jdt.internal.core.MicroProfileAssert.assertPropertiesDuplicate;
import static org.eclipse.lsp4mp.jdt.internal.core.MicroProfileAssert.p;

import org.eclipse.lsp4mp.commons.MicroProfileProjectInfo;
import org.eclipse.lsp4mp.commons.MicroProfilePropertiesScope;
import org.eclipse.lsp4mp.jdt.core.BasePropertiesManagerTest;
import org.junit.Test;

/**
 * Test the availability of the MicroProfile Context Propagation properties
 * 
 * @author Ryan Zegray
 *
 */
public class MicroProfileContextPropagationTest extends BasePropertiesManagerTest {

	@Test
	public void microprofileContextPropagationPropertiesTest() throws Exception {

		MicroProfileProjectInfo infoFromClasspath = getMicroProfileProjectInfoFromMavenProject(
				MavenProjectName.microprofile_context_propagation, MicroProfilePropertiesScope.SOURCES_AND_DEPENDENCIES);

		assertProperties(infoFromClasspath,

				p("microprofile-context-propagation-api", "mp.context.ThreadContext.propagated", "java.lang.String",
						"Defines the set of thread context types to capture from the thread that contextualizes an action or task. This context is later re-established on the thread(s) where the action or task executes.\n\n The MicroProfile Config property, `mp.context.ThreadContext.propagated`, establishes a default that is used if no value is otherwise specified. The value of the MicroProfile Config property can be the empty string or a comma separated list of context type constant values.",
						true, null, null, null, 0, null),
				p("microprofile-context-propagation-api", "mp.context.ThreadContext.cleared", "java.lang.String",
						"Defines the set of thread context types to clear from the thread where the action or task executes. The previous context is resumed on the thread after the action or task ends. This context is later re-established on the thread(s) where the action or task executes.\n\n The MicroProfile Config property, `mp.context.ThreadContext.cleared`, establishes a default that is used if no value is otherwise specified. The value of the MicroProfile Config property can be the empty string or a comma separated list of context type constant values.",
						true, null, null, null, 0, null),
				p("microprofile-context-propagation-api", "mp.context.ThreadContext.unchanged", "java.lang.String",
						"Defines a set of thread context types that are essentially ignored, in that they are neither captured nor are they propagated or cleared from thread(s) that execute the action or task. \n\n The MicroProfile Config property, `mp.context.ThreadContext.unchanged`, establishes a default that is used if no value is otherwise specified. The value of the MicroProfile Config property can be the empty string or a comma separated list of context type constant values. If a default value is not specified by MicroProfile Config, then the default value is an empty set.",
						true, null, null, null, 0, null),
				p("microprofile-context-propagation-api", "mp.context.ManagedExecutor.cleared", "java.lang.String",
						"Defines the set of thread context types to clear from the thread where the action or task executes. The previous context is resumed on the thread after the action or task ends.\n\n The MicroProfile Config property, `mp.context.ManagedExecutor.cleared`, establishes a default that is used if no value is otherwise specified. The value of the MicroProfile Config property can be the empty string or a comma separated list of context type constant values.",
						true, null, null, null, 0, null),
				p("microprofile-context-propagation-api", "mp.context.ManagedExecutor.propagated", "java.lang.String",
						"Defines the set of thread context types to capture from the thread that creates a dependent stage (or that submits a task) and which to propagate to the thread where the action or task executes.\n\n The MicroProfile Config property, `mp.context.ManagedExecutor.propagated`, establishes a default that is used if no value is otherwise specified. The value of the MicroProfile Config property can be the empty string or a comma separated list of context type constant values.",
						true, null, null, null, 0, null),
				p("microprofile-context-propagation-api", "mp.context.ManagedExecutor.maxAsync", "int",
						"Establishes an upper bound on the number of async completion stage actions and async executor tasks that can be running at any given point in time. There is no guarantee that async actions or tasks will start running immediately, even when the `maxAsync` constraint has not get been reached. Async actions and tasks remain queued until the `ManagedExecutor` starts executing them.\n\n The default value of `-1` indicates no upper bound, although practically, resource constraints of the system will apply. You can switch the default by specifying the MicroProfile Config property, `mp.context.ManagedExecutor.maxAsync`.",
						true, null, null, null, 0, null),
				p("microprofile-context-propagation-api", "mp.context.ManagedExecutor.maxQueued", "int",
						"Establishes an upper bound on the number of async actions and async tasks that can be queued up for execution. Async actions and tasks are rejected if no space in the queue is available to accept them.\n\n The default value of `-1` indicates no upper bound, although practically, resource constraints of the system will apply. You can switch the default by specifying the MicroProfile Config property, `mp.context.ManagedExecutor.maxQueued`.",
						true, null, null, null, 0, null)
		);

		assertPropertiesDuplicate(infoFromClasspath);
	}

}