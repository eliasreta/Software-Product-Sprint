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


public final class FindMeetingQuery {
  public Collection<TimeRange> query(Collection<Event> events, MeetingRequest request) {
    //throw new UnsupportedOperationException("TODO: Implement this method.");
    ArrayList<TimeRange> returnList = new ArrayList<>();
    if (request.getDuration() > 1440) { //if the duration is longer than a day(1440 minutes), then there should be no options
        //returnList = Arrays.asList(); //makes the returnList an empty list
    } else if (request.getDuration() != 0) {
        for (Event event: events) {
            TimeRange eventInfo = event.getWhen();
            int duration = eventInfo.duration(); 
            int eventStartTime = eventInfo.start();
            int eventEndTime = eventInfo.end();
            returnList.add(TimeRange.fromStartEnd(TimeRange.START_OF_DAY, eventStartTime, false));
            returnList.add(TimeRange.fromStartEnd(eventEndTime, TimeRange.END_OF_DAY, true));
        }
    }
    return returnList;
  }
}
