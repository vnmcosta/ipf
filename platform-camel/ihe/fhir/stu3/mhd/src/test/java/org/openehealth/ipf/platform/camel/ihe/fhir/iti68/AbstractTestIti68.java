/*
 * Copyright 2018 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.openehealth.ipf.platform.camel.ihe.fhir.iti68;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.openehealth.ipf.platform.camel.ihe.ws.StandardTestContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
abstract class AbstractTestIti68 extends StandardTestContainer {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractTestIti68.class);

    public static void startServer(String contextDescriptor) {
        CamelHttpTransportServlet servlet = new CamelHttpTransportServlet();
        startServer(servlet, contextDescriptor, false, DEMO_APP_PORT, "CamelServlet");
    }

}