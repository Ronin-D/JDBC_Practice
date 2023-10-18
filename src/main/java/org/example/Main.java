package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       DatabaseRepository repository = new DatabaseRepository();
        System.out.print("1.add new flight\n2.find flight\n3.get all flights\n4.quit\n");

        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (n!=4) {
            n = scanner.nextInt();
            if (n==1){
                System.out.println("start point");
                String startPoint = scanner.next();

                System.out.println("end point");
                String endPoint = scanner.next();

                System.out.println("air company");
                String airCompany = scanner.next();

                System.out.println("price");
                int price = scanner.nextInt();

                System.out.println("seats count");
                int seatsCount = scanner.nextInt();

                Flight flight = new Flight(airCompany,startPoint,endPoint,price,seatsCount);
                repository.addFlight(flight);
                n=0;

            } else if (n==2) {

                System.out.println("start point");
                String startPoint = scanner.next();

                System.out.println("end point");
                String endPoint = scanner.next();

                System.out.println("air company");
                String airCompany = scanner.next();

                System.out.println("price");
                int price = scanner.nextInt();

                System.out.println("seats count");
                int seatsCount = scanner.nextInt();

                Flight flight = new Flight(airCompany,startPoint,endPoint,price,seatsCount);
                repository.isFlightExists(flight);
                n=0;
            } else if (n==3) {
               repository.getFlights();
               n=0;
            }
        }
    }
}