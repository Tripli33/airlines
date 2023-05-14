package com.course_project.airlines.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name="flight")
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
    private String departDate;
    @Column(name = "return_date")
    private String returnDate;
    @Column(name = "type_travaler")
    private String typeTraveler;
    @Column(name = "order_status")
    private boolean orderStatus;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    public String getStringOrderStatus(){
        return this.orderStatus ? "ordered" : "vacant";
    }
}
