package com.gridnine.testing.filters;

import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.Segment;

import java.time.LocalDateTime;
import java.util.List;

public class DepartsAfterItArrivesFilter implements FlightFilter {

    @Override
    public boolean check(Flight flight) {
        if (flight.getSegments().size() == 1) {
            LocalDateTime dep = flight.getSegments().get(0).getDepartureDate();
            LocalDateTime arr = flight.getSegments().get(0).getArrivalDate();
            if (dep.isAfter(arr)) {
                return false;
            }
        } else {
            List<Segment> segments = flight.getSegments();

            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime dep = segments.get(i).getDepartureDate();
                LocalDateTime arr = segments.get(i).getArrivalDate();
                LocalDateTime depNext = segments.get(i + 1).getDepartureDate();

                if (dep.isAfter(arr) || arr.isAfter(depNext)) {
                    return false;
                }
            }
        }
        return true;
    }
}