/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openehealth.ipf.platform.camel.ihe.mllp.core.intercept.producer;

import org.apache.camel.Processor;
import org.openehealth.ipf.platform.camel.ihe.hl7v2.Hl7v2ConfigurationHolder;
import org.openehealth.ipf.platform.camel.ihe.hl7v2.intercept.producer.AbstractProducerInterceptor;
import org.openehealth.ipf.platform.camel.ihe.mllp.core.MllpEndpoint;
import org.openehealth.ipf.platform.camel.ihe.mllp.core.intercept.MllpInterceptor;

/**
 * @author Dmytro Rud
 */
abstract public class AbstractMllpProducerInterceptor
        extends AbstractProducerInterceptor
        implements MllpInterceptor
{
    protected AbstractMllpProducerInterceptor(
            Hl7v2ConfigurationHolder configurationHolder,
            Processor wrappedProducer)
    {
        super(configurationHolder, wrappedProducer);
    }


    public MllpEndpoint getMllpEndpoint() {
        return (MllpEndpoint) getConfigurationHolder();
    }
}