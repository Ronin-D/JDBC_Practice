package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightsDAOImp implements FlightsDAO{

    @Override
    public void addFlight(Flight flight) {
        String query =  "INSERT INTO flights(AirCompany, EndPoint, Price, SeatsCount, StartPoint) VALUES(?, ?, ?, ?, ?)";
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try(

                Connection connection = DriverManager.getConnection(
                        Constants.CONNECTION_URL,
                        Constants.USERNAME,
                        Constants.PASSWORD
                );
                PreparedStatement stmnt = connection.prepareStatement(query);
                ){
            stmnt.setString(1, flight.getAirCompany());
            stmnt.setString(2,flight.getEndPoint());
            stmnt.setInt(3,flight.getPrice());
            stmnt.setInt(4,flight.getSeatsCount());
            stmnt.setString(5,flight.getStartPoint());
            stmnt.executeUpdate();
            System.out.println("Success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Flight> getFlights() {
        String query = "SELECT * FROM flights";
        List<Flight> flights = new ArrayList<>();
        try{
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (
                Connection connection = DriverManager.getConnection(
                        Constants.CONNECTION_URL,
                        Constants.USERNAME,
                        Constants.PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ){
            while (resultSet.next()){
                String startPoint = resultSet.getString("StartPoint");
                String endPoint = resultSet.getString("EndPoint");
                String airCompany = resultSet.getString("AirCompany");
                int price = resultSet.getInt("Price");
                int seatsCount = resultSet.getInt("SeatsCount");
                Flight flight = new Flight(airCompany,startPoint,endPoint,price,seatsCount);
                flights.add(flight);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flights;
    }

    @Override
    public Flight getFlight(Flight flight) {
       try {
           Class.forName(DRIVER);
       }catch (ClassNotFoundException e){
           throw new RuntimeException(e);
       }
       String query = "SELECT * FROM flights WHERE AirCompany = ? AND EndPoint = ? AND Price = ? AND SeatsCount = ? AND StartPoint = ?";
       try(
               Connection connection = DriverManager.getConnection(
                       Constants.CONNECTION_URL,
                       Constants.USERNAME,
                       Constants.PASSWORD
               );
               PreparedStatement stmnt = connection.prepareStatement(query)
       ){
           stmnt.setString(1, flight.getAirCompany());
           stmnt.setString(2,flight.getEndPoint());
           stmnt.setInt(3,flight.getPrice());
           stmnt.setInt(4,flight.getSeatsCount());
           stmnt.setString(5,flight.getStartPoint());
           ResultSet resultSet = stmnt.executeQuery();
           resultSet.next();
           String startPoint = resultSet.getString("StartPoint");
           String endPoint = resultSet.getString("EndPoint");
           String airCompany = resultSet.getString("AirCompany");
           int price = resultSet.getInt("Price");
           int seatsCount = resultSet.getInt("SeatsCount");
           Flight flight1 = new Flight(airCompany,startPoint,endPoint,price,seatsCount);
           resultSet.close();
           return flight1;


       }catch (SQLException e){
           return null;
       }
    }
}
