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

import javax.persistence.*;
import javax.xml.bind.annotation.*;


/**
 * Represents a permission granted by an owner for access to a resource.
 * <p/>
 * <p>Java class for Authorization complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="Authorization">
 *   &lt;complexContent>
 *     &lt;extension base="{http://naesb.org/espi}IdentifiedObject">
 *       &lt;sequence>
 *         &lt;element name="accessToken" type="{http://naesb.org/espi}String32" minOccurs="0"/>
 *         &lt;element name="authorizationServer" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="authorizedPeriod" type="{http://naesb.org/espi}DateTimeInterval" minOccurs="0"/>
 *         &lt;element name="publishedPeriod" type="{http://naesb.org/espi}DateTimeInterval" minOccurs="0"/>
 *         &lt;element name="resource" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *         &lt;element name="status" type="{http://naesb.org/espi}AuthorizationStatus" minOccurs="0"/>
 *         &lt;element name="thirdParty" type="{http://naesb.org/espi}String32" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "authorizations")
@NamedQueries(value = {
        @NamedQuery(name = Authorization.QUERY_FIND_BY_RETAIL_CUSTOMER_ID,
                query = "SELECT authorization FROM Authorization authorization WHERE authorization.retailCustomer.id = :retailCustomerId AND authorization.subscriptionURI IS NOT NULL"),
        @NamedQuery(name = Authorization.QUERY_FIND_BY_STATE,
                query = "SELECT authorization FROM Authorization authorization WHERE authorization.state = :state")
})
public class Authorization
        extends IdentifiedObject {

    public static final String QUERY_FIND_BY_RETAIL_CUSTOMER_ID = "Authorization.findAllByRetailCustomerId";
    public static final String QUERY_FIND_BY_STATE = "Authorization.findByState";

    @Transient
    protected DateTimeInterval authorizedPeriod;

    @Transient
    protected DateTimeInterval publishedPeriod;
    @Column(name = "access_token")
    protected String accessToken;
    @Column(name = "authorization_server")
    @XmlSchemaType(name = "anyURI")
    protected String authorizationServer;

    @XmlSchemaType(name = "anyURI")
    protected String resource;
    @Column(name = "status")
    protected String status;
    @Column(name = "third_party")
    protected String thirdParty;
    @ManyToOne @JoinColumn(name = "retail_customer_id")
    @XmlTransient
    protected RetailCustomer retailCustomer;

    @XmlElement(name = "expires_in")
    protected Long expiresIn;
    @XmlElement(name = "grant_type")
    protected GrantType grantType;
    @XmlElement(name = "refresh_token")
    protected String refreshToken;
    protected String scope;
    @Column(name = "state")
    @XmlTransient
    private String state;
    @XmlElement(name = "response_type")
    protected ResponseType responseType;
    @XmlElement(name = "token_type")
    protected TokenType tokenType;
    protected String code;
    protected OAuthError error;
    @XmlElement(name = "error_description")
    protected String errorDescription;
    @XmlElement(name = "error_uri")
    @XmlSchemaType(name = "anyURI")
    protected String errorUri;
    @ManyToOne @JoinColumn(name = "application_information_id")
    @XmlTransient
    private ApplicationInformation applicationInformation;
    private String subscriptionURI;

    /**
     * Gets the value of the authorizedPeriod property.
     *
     * @return
     *     possible object is
     *     {@link DateTimeInterval }
     *
     */
    public DateTimeInterval getAuthorizedPeriod() {
        return authorizedPeriod;
    }

    /**
     * Sets the value of the authorizedPeriod property.
     *
     * @param value
     *     allowed object is
     *     {@link DateTimeInterval }
     *
     */
    public void setAuthorizedPeriod(DateTimeInterval value) {
        this.authorizedPeriod = value;
    }

    /**
     * Gets the value of the publishedPeriod property.
     *
     * @return
     *     possible object is
     *     {@link DateTimeInterval }
     *
     */
    public DateTimeInterval getPublishedPeriod() {
        return publishedPeriod;
    }

    /**
     * Sets the value of the publishedPeriod property.
     *
     * @param value
     *     allowed object is
     *     {@link DateTimeInterval }
     *
     */
    public void setPublishedPeriod(DateTimeInterval value) {
        this.publishedPeriod = value;
    }

    /**
     * Gets the value of the accessToken property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Sets the value of the accessToken property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAccessToken(String value) {
        this.accessToken = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the expiresIn property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getExpiresIn() {
        return expiresIn;
    }

    /**
     * Sets the value of the expiresIn property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setExpiresIn(Long value) {
        this.expiresIn = value;
    }

    /**
     * Gets the value of the grantType property.
     *
     * @return
     *     possible object is
     *     {@link GrantType }
     *
     */
    public GrantType getGrantType() {
        return grantType;
    }

    /**
     * Sets the value of the grantType property.
     *
     * @param value
     *     allowed object is
     *     {@link GrantType }
     *
     */
    public void setGrantType(GrantType value) {
        this.grantType = value;
    }

    /**
     * Gets the value of the resource property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getResource() {
        return resource;
    }

    /**
     * Sets the value of the resource property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setResource(String value) {
        this.resource = value;
    }

    /**
     * Gets the value of the refreshToken property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Sets the value of the refreshToken property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRefreshToken(String value) {
        this.refreshToken = value;
    }

    /**
     * Gets the value of the scope property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getScope() {
        return scope;
    }

    /**
     * Sets the value of the scope property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setScope(String value) {
        this.scope = value;
    }

    /**
     * Gets the value of the state property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the responseType property.
     *
     * @return
     *     possible object is
     *     {@link ResponseType }
     *
     */
    public ResponseType getResponseType() {
        return responseType;
    }

    /**
     * Sets the value of the responseType property.
     *
     * @param value
     *     allowed object is
     *     {@link ResponseType }
     *
     */
    public void setResponseType(ResponseType value) {
        this.responseType = value;
    }

    /**
     * Gets the value of the tokenType property.
     *
     * @return
     *     possible object is
     *     {@link TokenType }
     *
     */
    public TokenType getTokenType() {
        return tokenType;
    }

    /**
     * Sets the value of the tokenType property.
     *
     * @param value
     *     allowed object is
     *     {@link TokenType }
     *
     */
    public void setTokenType(TokenType value) {
        this.tokenType = value;
    }

    /**
     * Gets the value of the code property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the error property.
     *
     * @return
     *     possible object is
     *     {@link OAuthError }
     *
     */
    public OAuthError getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     *
     * @param value
     *     allowed object is
     *     {@link OAuthError }
     *
     */
    public void setError(OAuthError value) {
        this.error = value;
    }

    /**
     * Gets the value of the errorDescription property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getErrorDescription() {
        return errorDescription;
    }

    /**
     * Sets the value of the errorDescription property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setErrorDescription(String value) {
        this.errorDescription = value;
    }

    /**
     * Gets the value of the errorUri property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getErrorUri() {
        return errorUri;
    }

    /**
     * Sets the value of the errorUri property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setErrorUri(String value) {
        this.errorUri = value;
    }

    public String getAuthorizationServer() {
        return authorizationServer;
    }

    public void setAuthorizationServer(String authorizationServer) {
        this.authorizationServer = authorizationServer;
    }

    public String getThirdParty() {
        return thirdParty;
    }

    public void setThirdParty(String thirdParty) {
        this.thirdParty = thirdParty;
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

    public void setSubscriptionURI(String subscriptionURI) {
        this.subscriptionURI = subscriptionURI;
    }

    public String getSubscriptionURI() {
        return subscriptionURI;
    }

    public String getSubscriptionId() {
        String[] pieces = subscriptionURI.split("/");
        return pieces[pieces.length-1];
    }
}
