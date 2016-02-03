/*
 * Copyright 2009 the original author or authors.
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
package org.openehealth.ipf.commons.ihe.xds.core.requests.query;

import lombok.Getter;
import lombok.Setter;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.jaxbadapters.XdsEnumAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.List;

/**
 * Represents a stored query for GetDocumentsAndAssociations.
 * @author Jens Riemschneider
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDocumentsAndAssociationsQuery", propOrder = {"associationStatuses", "metadataLevel"})
@XmlRootElement(name = "getDocumentsAndAssociationsQuery")
public class GetDocumentsAndAssociationsQuery extends GetByIdQuery implements Serializable {
    private static final long serialVersionUID = 7120944927521427681L;

    @XmlJavaTypeAdapter(XdsEnumAdapter.AvailabilityStatusForQueryAdapter.class)
    @XmlElement(name = "associationStatus")
    @Getter @Setter private List<AvailabilityStatus> associationStatuses;

    @Getter @Setter private Integer metadataLevel;

    /**
     * Constructs the query.
     */
    public GetDocumentsAndAssociationsQuery() {
        super(QueryType.GET_DOCUMENTS_AND_ASSOCIATIONS);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
