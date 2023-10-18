package org.example;

public class Flight  {
    public String getAirCompany() {
        return airCompany;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public int getPrice() {
        return price;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public Flight(String airCompany, String startPoint, String endPoint, int price, int seatsCount) {
        this.airCompany = airCompany;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.price = price;
        this.seatsCount = seatsCount;
    }

    private final String airCompany;
    private final String startPoint;
    private final String endPoint;
    private final int price;
    private  int seatsCount;

    @Override
    public String toString() {
        return String.format(
                "|Start point %s| |End point %s| |Air company %s| |Price:%d| |Seats count: %d|",
                startPoint,
                endPoint,
                airCompany,
                price,
                seatsCount
        );

    }
}
