// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps;

import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.lang.String;


public final class FindMeetingQuery {
  public Collection<TimeRange> query(Collection<Event> events, MeetingRequest request) {
    //throw new UnsupportedOperationException("TODO: Implement this method.");
    ArrayList<TimeRange> returnList = new ArrayList<>();
    if (request.getDuration() > 1440) { //if the duration is longer than a day(1440 minutes), then there should be no options
        returnList = Arrays.asList(); //makes the returnList an empty list
    } else if (request.getDuration() != 0) {
    
        for (Event event: events) {
            Collection<String> attendeesCollection = request.getAttendees(); //here, getAttendees returns a collection, so I made it an arraylist on the next line
            ArrayList<String> attendeesList = new ArrayList<>();
            for (String attendee: attendeesCollection) {
                attendeesList.add(attendee);
            }
            
            // HashSet<String> attendeesSet = event.getAttendees(); //getAttendees() returns a Set(interface) of attendees, so I made 
            // //it a hashset to call methods on it
            // int numAttendees = attendeesSet.size();
            // request.getAttendees();
            // ArrayList<String> attendeesList = new ArrayList<>();
            // //i think what i need is the number of attendees requested, not the number in existing events...?
            int previousEventEndTime = 0;
            for (int i = 0; i <= numAttendees; i++) {
                TimeRange eventInfo = event.getWhen();
                int duration = eventInfo.duration(); 
                int eventStartTime = eventInfo.start();
                int eventEndTime = eventInfo.end();
                if (i == 0) { //first iteration
                    if (i == numAttendees - 1) { //only 1 event
                        returnList.add(TimeRange.fromStartEnd(TimeRange.START_OF_DAY, eventStartTime, false));
                        returnList.add(TimeRange.fromStartEnd(eventEndTime, TimeRange.END_OF_DAY, true));
                    } else { // more than 1 event, but it's the first iteration
                        returnList.add(TimeRange.fromStartEnd(TimeRange.START_OF_DAY, eventStartTime, false));
                    } 
                } else if (i != numAttendees - 1) { //we havne't reached the last event yet, and we're not on first iteration
                    returnList.add(TimeRange.fromStartEnd(previousEventEndTime, eventStartTime, false));
                    //adds the TimeRange between the previous event's end time and current event's start time
                } else if (i == numAttendees - 1) { //if it's the last event, we can make the end available time END_OF_DAY
                    returnList.add(TimeRange.fromStartEnd(eventEndTime, TimeRange.END_OF_DAY, true));
                }
                int previousEventEndTime = eventEndTime;
            }
            
        }
            
    }
            // Collection<String> attendeesCollection = request.getAttendees(); //here, getAttendees returns a collection, so I made it an arraylist on the next line
            // ArrayList<String> attendeesList = new ArrayList<>();
            // for (String attendee: attendeesCollection) {
            //     attendeesList.add(attendee);
            // }
            // //i think what i need is the number of attendees requested, not the number in existing events...?
            // //ArrayList<String> attendeesList = request.getAttendees(); 
            // for (Event event: events) { 
            //     int previousEventEndTime = 0;
            //     int numAttendees = attendeesList.size(); //number of requested attendees
            //     for (int i = 0; i <= numAttendees; i++) {
            //         TimeRange eventInfo = event.getWhen();
            //         int duration = eventInfo.duration(); 
            //         int eventStartTime = eventInfo.start();
            //         int eventEndTime = eventInfo.end();
            //         if (i == 0) { //first iteration
            //             if (i == numAttendees - 1) { //only 1 event
            //                 returnList.add(TimeRange.fromStartEnd(TimeRange.START_OF_DAY, eventStartTime, false));
            //                 returnList.add(TimeRange.fromStartEnd(eventEndTime, TimeRange.END_OF_DAY, true));
            //             } else { // more than 1 event, but it's the first iteration
            //                 returnList.add(TimeRange.fromStartEnd(TimeRange.START_OF_DAY, eventStartTime, false));
            //             } 
            //         } else if (i != numAttendees - 1) { //we havne't reached the last event yet, and we're not on first iteration
            //             returnList.add(TimeRange.fromStartEnd(previousEventEndTime, eventStartTime, false));
            //             //adds the TimeRange between the previous event's end time and current event's start time
            //         } else if (i == numAttendees - 1) { //if it's the last event, we can make the end available time END_OF_DAY
            //             returnList.add(TimeRange.fromStartEnd(eventEndTime, TimeRange.END_OF_DAY, true));
            //         }
            //         int previousEventEndTime = eventEndTime;
            //     }
            // }

        // for (int i = 0; i <= numAttendees; i++) {
        //         TimeRange eventInfo = event.getWhen();
        //         int duration = eventInfo.duration(); 
        //         int eventStartTime = eventInfo.start();
        //         int eventEndTime = eventInfo.end();
        //         returnList.add(TimeRange.fromStartEnd(TimeRange.START_OF_DAY, eventStartTime, false));
        //         returnList.add(TimeRange.fromStartEnd(eventEndTime, TimeRange.END_OF_DAY, true));
        // }
    return returnList;
    }
    
}

