/*
 * Copyright 2013 EnergyOS.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.27 at 01:43:57 PM EDT 
//


package org.energyos.espi.common.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.energyos.espi.common.models.atom.adapters.SubscriptionAdapter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Defines the parameters of a subscription between Third Party and Data Custodian.
 * <p/>
 * <p>Java class for Subscription complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="Subscription">
 *   &lt;complexContent>
 *     &lt;extension base="{http://naesb.org/espi}IdentifiedObject">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Subscription")
@Entity
@Table(name = "subscriptions")
@XmlJavaTypeAdapter(SubscriptionAdapter.class)
@NamedQueries(value = {
        @NamedQuery(name = Subscription.QUERY_FIND_BY_ID, query = "SELECT subscription FROM Subscription subscription WHERE subscription.id = :id"),
        @NamedQuery(name = Subscription.QUERY_FIND_BY_UUID, query = "SELECT subscription FROM Subscription subscription WHERE subscription.uuid = :uuid"),
        @NamedQuery(name = Subscription.QUERY_FIND_ALL, query = "SELECT subscription FROM Subscription subscription"),
        @NamedQuery(name = Subscription.QUERY_FIND_BY_HASHED_ID, query = "SELECT subscription FROM Subscription subscription WHERE subscription.hashedId = :hashedId"),
        @NamedQuery(name = Subscription.QUERY_FIND_ALL_IDS, query = "SELECT subscription.id FROM Subscription subscription"),
        @NamedQuery(name = Subscription.QUERY_FIND_BY_AUTHORIZATION_ID, query = "SELECT subscription from Subscription subscription WHERE subscription.authorization.id = :id")
})

public class Subscription
        extends IdentifiedObject {

	public final static String QUERY_FIND_BY_UUID = "Subscription.findByUUID";
    public static final String QUERY_FIND_BY_ID = "Subscription.findById";
	public final static String QUERY_FIND_ALL = "Subscription.findAll";
    public final static String QUERY_FIND_BY_HASHED_ID = "Subscription.findByHashedID";
    public static final String QUERY_FIND_ALL_IDS = "Subscription.findAllIds";
    public static final String QUERY_FIND_BY_AUTHORIZATION_ID = "Subscription.findByAuthorizationId";

    private String hashedId;

    @ManyToOne
    @JoinColumn(name = "retail_customer_id")
    @NotNull
    @XmlTransient
    protected RetailCustomer retailCustomer;

    @XmlTransient
    @OneToOne
    private Authorization authorization;

    @OneToOne
    @NotNull
    private ApplicationInformation applicationInformation;

    @XmlTransient
    @ManyToMany (cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<UsagePoint> usagePoints;

    public Calendar lastUpdate;    
    
    public String getHashedId() {
        return hashedId;
    }

    public void setHashedId(String hashedId) {
        this.hashedId = hashedId;
    }
    
    public RetailCustomer getRetailCustomer() {
        return retailCustomer;
    }

    public void setRetailCustomer(RetailCustomer retailCustomer) {
        this.retailCustomer = retailCustomer;
    }

    public ApplicationInformation getApplicationInformation() {
        return applicationInformation;
    }

    public void setApplicationInformation(ApplicationInformation applicationInformation) {
        this.applicationInformation = applicationInformation;
    }

    public void setLastUpdate(Calendar lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Calendar getLastUpdate() {
        return lastUpdate;
    }

    public List<UsagePoint> getUsagePoints() {
        return usagePoints;
    }
    
    public void setUsagePoints(List<UsagePoint> usagePoints) {
        this.usagePoints = usagePoints;
    }

    public void removeUsagePoint(UsagePoint up) {
    	usagePoints.remove(up);
    }
    
    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }
    
    @Override
    public void merge(IdentifiedObject resource) {
    	super.merge(resource);
    	if (((Subscription)resource).applicationInformation != null) {
    		this.applicationInformation = ((Subscription)resource).applicationInformation;
    	}
    	if (((Subscription)resource).authorization != null){
    		this.authorization = ((Subscription)resource).authorization;
    	}
    	if (((Subscription)resource).lastUpdate != null) {
    		this.lastUpdate = ((Subscription)resource).lastUpdate;
    	}
        if (((Subscription)resource).retailCustomer != null) {
        	this.retailCustomer = ((Subscription)resource).retailCustomer;
        }
        if (((Subscription)resource).usagePoints != null) {
        	this.usagePoints = ((Subscription)resource).usagePoints;
        }
    }
    
    @Override
    public void unlink() {
    	super.unlink();
    	this.usagePoints.clear();
    	this.authorization = null;
    }

    public boolean equals (Subscription s) {
    	return (this.getId() == s.getId());
    }
}
