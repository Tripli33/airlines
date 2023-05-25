package com.course_project.airlines.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Model class representing a flight entity
 */
@Entity
@Table(name = "flight")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank(message = "Flight from required")
    @Column(name = "flight_from")
    private String flightFrom;
    @NotBlank(message = "Flight to required")
    @Column(name = "flight_to")
    private String flightTo;
    @NotBlank(message = "Depart date required")
    @Column(name = "depart_date")
    private String departDate;
    @NotBlank(message = "Return date required")
    @Column(name = "return_date")
    private String returnDate;
    @Column(name = "type_travaler")
    private String typeTraveler;
    @Column(name = "order_status")
    private boolean orderStatus;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    /**
     * Method for retrieving the string representation of the order status
     *
     * @return "Ordered" if the order status is true, "Vacant" otherwise
     */
    public String getStringOrderStatus() {
        return this.orderStatus ? "Ordered" : "Vacant";
    }
}
