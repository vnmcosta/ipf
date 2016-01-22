/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openehealth.ipf.commons.ihe.fhir.iti81;

import ca.uhn.fhir.rest.client.IGenericClient;
import ca.uhn.fhir.rest.gclient.IClientExecutable;
import ca.uhn.fhir.rest.gclient.ICriterion;
import ca.uhn.fhir.rest.gclient.IQuery;
import org.hl7.fhir.instance.model.AuditEvent;
import org.hl7.fhir.instance.model.Bundle;
import org.hl7.fhir.instance.model.Patient;
import org.openehealth.ipf.commons.ihe.fhir.ClientRequestFactory;

import java.util.Map;

/**
 * Request Factory for ITI-81 requests returning a bundle of audit events based on query criteria of type
 * {@link ICriterion} or String in the request data
 *
 * @since 3.1
 */
public class Iti81ClientRequestFactory implements ClientRequestFactory<IQuery<Bundle>> {

    @Override
    public IClientExecutable<IQuery<Bundle>, Bundle> getClientExecutable(IGenericClient client, Object requestData, Map<String, Object> parameters) {
        IClientExecutable<IQuery<Bundle>, Bundle> executable;
        if (requestData instanceof ICriterion) {
            executable = client.search()
                    .forResource(AuditEvent.class)
                    .where((ICriterion<?>) requestData)
                    .returnBundle(Bundle.class);
        } else {
            executable = client.search()
                    .byUrl(requestData.toString())
                    .returnBundle(Bundle.class);
        }
        return executable;
    }
}
