package com.book.movie.db.entity;

import com.book.movie.db.entity.enumType.ReservationStatus;
import jakarta.persistence.*;

@Entity
public class Reservation {
    @Id
    private String reservationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "show_time_id")
    private Showtime showtime;

    private ReservationStatus status;
    private Integer adult;
    private Integer youth;
    private Integer child;


}
