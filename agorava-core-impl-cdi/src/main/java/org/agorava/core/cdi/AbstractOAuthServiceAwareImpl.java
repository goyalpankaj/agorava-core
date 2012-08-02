/*
 * Copyright 2012 Agorava
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 *
 */
package org.agorava.core.cdi;

import org.agorava.core.api.oauth.OAuthService;
import org.agorava.core.api.oauth.OAuthServiceAware;
import org.agorava.core.api.oauth.OAuthSession;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.lang.annotation.Annotation;

/**
 * {@inheritDoc}
 *
 * @author Antoine Sabot-Durand
 */

//TODO:delete this class and inject OAuthService with proper qualifier in each *BaseService and *ServicesHub
public abstract class AbstractOAuthServiceAwareImpl implements OAuthServiceAware {

    @Inject
    @Any
    protected Instance<OAuthService> serviceInstances;

    @Override
    public OAuthService getService() {
        return serviceInstances.select(getQualifier()).get();
    }

    @Override
    public OAuthSession getSession() {
        return getService().getSession();
    }

    /**
     * Returns the annotation related to the Social Media
     *
     * @return Annotation being a Qualifier
     */
    abstract public Annotation getQualifier();


}