package com.airline.model;

public class Flight {
    private int flightId;
    private String flightName;
    private String source;
    private String destination;
    private String date;
    private String time;
    private int price;
    private int seats;

    public Flight(int flightId, String flightName, String source,
                  String destination, String date, String time,
                  int price, int seats) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.price = price;
        this.seats = seats;
    }

    public int getFlightId() { return flightId; }
    public String getFlightName() { return flightName; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public int getPrice() { return price; }
    public int getSeats() { return seats; }
}
