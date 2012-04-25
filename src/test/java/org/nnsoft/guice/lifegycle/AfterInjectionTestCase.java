package org.nnsoft.guice.lifegycle;

/*
 *  Copyright 2012 The 99 Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

import static com.google.inject.Guice.createInjector;
import static junit.framework.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.nnsoft.guice.lifegycle.AfterInjection;
import org.nnsoft.guice.lifegycle.AfterInjectionModule;

public final class AfterInjectionTestCase
{

    private boolean afterInjectionInvoked = false;

    @Before
    public void setUp()
    {
        createInjector( new AfterInjectionModule() )
        .getMembersInjector( AfterInjectionTestCase.class )
        .injectMembers( this );
    }

    @AfterInjection
    public void init()
    {
        afterInjectionInvoked = true;
    }

    @Test
    public void verifyAfterInjectionAnnotatedMethodInvocation()
    {
        assertTrue( afterInjectionInvoked );
    }

}
