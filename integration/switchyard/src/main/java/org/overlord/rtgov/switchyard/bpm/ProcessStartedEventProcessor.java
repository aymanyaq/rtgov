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
package org.overlord.rtgov.switchyard.bpm;

import java.util.EventObject;

import org.drools.core.event.ProcessStartedEventImpl;
import org.kie.api.event.process.ProcessStartedEvent;
import org.overlord.rtgov.switchyard.AbstractEventProcessor;

/**
 * This class provides the BPM component implementation of the
 * event processor.
 *
 */
public class ProcessStartedEventProcessor extends AbstractEventProcessor {

    /**
     * This is the default constructor.
     */
    public ProcessStartedEventProcessor() {
        super(ProcessStartedEventImpl.class);
    }

    /**
     * {@inheritDoc}
     */
    public void handleEvent(EventObject event) {
        ProcessStartedEvent bpmEvent=(ProcessStartedEvent)event;
        
        org.overlord.rtgov.activity.model.bpm.ProcessStarted ps=
                new org.overlord.rtgov.activity.model.bpm.ProcessStarted();
        
        ps.setProcessType(bpmEvent.getProcessInstance().getProcessName());
        ps.setInstanceId(Long.toString(bpmEvent.getProcessInstance().getId()));
        
        recordActivity(event, ps);
    }

}
