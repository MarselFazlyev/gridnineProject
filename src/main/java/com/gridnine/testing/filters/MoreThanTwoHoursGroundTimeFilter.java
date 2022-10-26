package com.gridnine.testing.filters;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class MoreThanTwoHoursGroundTimeFilter implements FlightFilter {

    @Override
    public boolean check(Flight flight) {
        if (flight.getSegments().size() > 1) {
            int groundTime = 0;
            List<Segment> segments = flight.getSegments();

            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime arr = segments.get(i).getArrivalDate();
                LocalDateTime depNext = segments.get(i + 1).getDepartureDate();
                groundTime += arr.until(depNext, ChronoUnit.MINUTES);
            }

            return groundTime / 60 <= 2;
        }
        return true;
    }
}