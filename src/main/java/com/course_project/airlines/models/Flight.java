package com.course_project.airlines.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "flight_from")
    private String flightFrom;
    @Column(name = "flight_to")
    private String flightTo;
    @Column(name = "depart_date")
    private Date departDate;
    @Column(name = "return_date")
    private Date returnDate;
    @Column(name = "type_travaler")
    private String typeTraveler;
    @Column(name = "order_status")
    private boolean orderStatus;

    public String getStringOrderStatus(){
        return this.orderStatus ? "vacant" : "ordered";
    }
}
