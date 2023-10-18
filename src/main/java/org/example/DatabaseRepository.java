package org.example;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseRepository {

    private final FlightsDAO flightsDAO = new FlightsDAOImp();

    public void addFlight(Flight flight){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                flightsDAO.addFlight(flight);
            }
        });
    }
    public void isFlightExists(Flight flight){
        ExecutorService ex = Executors.newCachedThreadPool();
         ex.execute(new Runnable() {
             @Override
             public void run() {
                Flight flight1 = flightsDAO.getFlight(flight);
                 System.out.println(flight1 != null);
             }
         });
    }

    public void getFlights(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                List<Flight> flights = flightsDAO.getFlights();
                for (Flight flight:flights){
                    System.out.println(flight.toString());
                }
            }
        });
    }

}
