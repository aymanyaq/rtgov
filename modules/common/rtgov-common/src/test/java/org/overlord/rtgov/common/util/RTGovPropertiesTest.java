/*
 * 2012-3 Red Hat Inc. and/or its affiliates and other contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.overlord.rtgov.common.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class RTGovPropertiesTest {

    private static final String RTGOV_CONFIG_FILE_NAME="rtgov.config.file.name";

    @org.junit.BeforeClass
    public static void init() {
        System.setProperty(RTGOV_CONFIG_FILE_NAME, "overlord-rtgov.properties");        
    }
    
    @org.junit.AfterClass
    public static void close() {
        System.getProperties().remove(RTGOV_CONFIG_FILE_NAME);        
    }
    
    @Test
    public void testDefaultPropertyProvider() {
        
        String value=RTGovProperties.getProperty("test.property");

        if (value == null) {
            fail("Property not found");
        }
        
        if (!value.equals("test.value")) {
            fail("Incorrect value: "+value);
        }
    }
}
