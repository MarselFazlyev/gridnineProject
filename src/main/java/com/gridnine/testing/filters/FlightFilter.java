package com.gridnine.testing.filters;

import com.gridnine.testing.models.Flight;

public interface FlightFilter {
    boolean check(Flight flight);

}
