package com.gridnine.testing;

import com.gridnine.testing.filters.*;
import com.gridnine.testing.models.Flight;
import com.gridnine.testing.models.FlightBuilder;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();//Создаем полеты
        List<FlightFilter> filters = Arrays.asList(new DepartingInThePastFilter(), new DepartsAfterItArrivesFilter(), new MoreThanTwoHoursGroundTimeFilter());
        flights.stream().filter(flight -> FlightFilters.check(flight, filters))//фильтруем полеты, чтобы FlightFilters вернул true
                .forEach(flight -> System.out.println(flight.toString()));//выводим на экран
    }
}