package com.course_project.airlines.models;

import lombok.Data;
@Data
public class Flight {
    private String flightFrom;
    private String flightTo;
    //@DateTimeFormat(pattern = "dd-MM-yyyy")
    //change type to Date
    private String departDate;
    private String returnDate;
    private String typeTraveler;
    private boolean orderStatus;

    public Flight() {
    }

    public Flight(String flightFrom, String flightTo, String departDate, String returnDate, String typeTraveler, boolean orderStatus) {
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.departDate = departDate;
        this.returnDate = returnDate;
        this.typeTraveler = typeTraveler;
        this.orderStatus = orderStatus;
    }

    public String getStringOrderStatus(){
        return this.orderStatus ? "vacant" : "ordered";
    }
}
