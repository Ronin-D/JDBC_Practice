package org.example;

import java.util.List;

public interface FlightsDAO {
     final String DRIVER = "com.mysql.cj.jdbc.Driver";
     void addFlight(Flight flight);
     List<Flight> getFlights();
     Flight getFlight(Flight flight);
}
