package com.gridnine.testing.filters;

import com.gridnine.testing.models.Flight;

import java.util.List;

public class FlightFilters {

    private FlightFilters() {
    }

    public static boolean check(Flight flight, List<FlightFilter> filters) {
        for (FlightFilter flightFilter : filters) {//Проверка, что полет проходит все фильтры
            if (!flightFilter.check(flight))
                return false;
        }
        return true;
    }
}