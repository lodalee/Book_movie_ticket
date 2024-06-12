package com.book.movie.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Time;
import java.util.Date;

@Entity
public class Showtime {

    @Id
    private String showTimeId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private ScreeningRoom screeningRoom;

    private Date showDate;

    private Time showTime;


}
