package com.gridnine.testing;

import com.gridnine.testing.filters.DepartingInThePastFilter;
import com.gridnine.testing.filters.DepartsAfterItArrivesFilter;
import com.gridnine.testing.filters.FlightFilter;
import com.gridnine.testing.filters.MoreThanTwoHoursGroundTimeFilter;
import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.FlightBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FlightFilterTest {

    List<Flight> flights = FlightBuilder.createFlights();

    @Test
    public void afterUseDepartingInThePastFilterShouldBeOneFlightLess(){
        FlightFilter flightFilter = new DepartingInThePastFilter();
        long actual = flights.stream().filter(x-> flightFilter.check(x)).count();
        long expected = flights.size()-1;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void afterUseDepartsAfterItArrivesFilterShouldBeOneFlightLess() {
        FlightFilter flightFilter = new DepartsAfterItArrivesFilter();
        long actual = flights.stream().filter(x-> flightFilter.check(x)).count();
        long expected = flights.size() - 1;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void afterUseMoreThanTwoHoursGroundTimeFilterShouldBeTwoFlightsLess(){
        FlightFilter flightFilter = new MoreThanTwoHoursGroundTimeFilter();
        long actual = flights.stream().filter(x-> flightFilter.check(x)).count();
        long expected = flights.size() - 2;
        Assertions.assertEquals(actual, expected);
    }



}
