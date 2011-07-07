/*
 * Copyright (c) 2009-2011 Lockheed Martin Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eurekastreams.commons.client;

import java.io.Serializable;

/**
 * Encapsulates a request to perform some action.
 *
 * Note: This is deprecated for use outside of ActionProcessorImpl.
 *
 * @param <T>
 *            specifies the return type
 */
@Deprecated
public class ActionRequestImpl<T extends Serializable> implements Serializable, ActionRequest<T>
{
    /**
     * Session id.
     */
    private String sessionId;

    /**
     * Uniquely represents one ServerAction.
     */
    private String actionKey;

    /**
     * The ID of the ActionRequest.
     */
    private int id;

    /**
     * Returns the ID.
     *
     * @return the ID
     */
    public int getId()
    {
        return id;
    }

    /**
     * Sets the ID.
     *
     * @param inId
     *            the ID
     */
    public void setId(final int inId)
    {
        this.id = inId;
    }

    /**
     * Parameter to be passed to the ServiceAction.
     */
    private Serializable param = null;

    /**
     * The response generated by the ServerAction.
     */
    private T response = null;

    /**
     * Standard constructor.
     */
    public ActionRequestImpl()
    {
    }

    /**
     * Constructor.
     *
     * @param inActionKey
     *            - identify the action to load.
     * @param inParam
     *            - paramaters to pass to the action during execution.
     */
    public ActionRequestImpl(final String inActionKey, final Serializable inParam)
    {
        actionKey = inActionKey;
        param = inParam;
    }

    /**
     * Getter.
     *
     * @return the action key
     */
    public String getActionKey()
    {
        return actionKey;
    }

    /**
     * Setter.
     *
     * @param inActionKey
     *            the action key
     */
    public void setActionKey(final String inActionKey)
    {
        this.actionKey = inActionKey;
    }

    /**
     * This getter retrieves the Serializable param for the ActionRequest. This field is only used in the new Action
     * Framework Design.
     *
     * @return current instance of the Serializable param object for this Request.
     */
    public Serializable getParam()
    {
        return param;
    }

    /**
     * This setter sets the Serializable param for this ActionRequest. This field is only used in the new Action
     * Framework Design.
     *
     * @param inParam
     *            - value to assign to the param of this ActionRequest.
     */
    public void setParam(final Serializable inParam)
    {
        param = inParam;
    }

    /**
     * Getter.
     *
     * @return the ServerAction response
     */
    public T getResponse()
    {
        return response;
    }

    /**
     * Setter.
     *
     * @param inResponse
     *            the ServerAction's response
     */
    public void setResponse(final T inResponse)
    {
        this.response = inResponse;
    }

    /**
     * Computes equality by the action key and parameters.
     *
     * see http://java.sun.com/javase/6/docs/api/java/lang/Object.html#equals(java.lang.Object)
     *
     * type checking warnings are suppressed because the type is not used to determine equality. (And type information
     * is erased at runtime)
     *
     * @param other
     *            The object to compare with.
     * @return true if object equals this one, false otherwise.
     */
    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(final Object other)
    {

        if (!(other instanceof ActionRequestImpl))
        {
            return false;
        }

        ActionRequestImpl request = (ActionRequestImpl) other;

        if (!actionKey.equals(request.actionKey))
        {
            return false;
        }

        return (param != null && request.param != null) ? param.equals(request.param) : param == request.param;

    }

    /**
     * Recommended to override when overriding equals(). uses actionkey's hashcode.
     *
     * see http://java.sun.com/javase/6/docs/api/java/lang/Object.html#equals(java.lang.Object)
     *
     * @return The hashcode.
     */
    @Override
    public int hashCode()
    {
        return actionKey.hashCode();
    }

    /**
     * Gets the session id.
     *
     * @return the session id.
     */
    public String getSessionId()
    {
        return sessionId;
    }

    /**
     * Setter.
     *
     * @param inSessionId
     *            the session id.
     */
    public void setSessionId(final String inSessionId)
    {
        sessionId = inSessionId;
    }
}
