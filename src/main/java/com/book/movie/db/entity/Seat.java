//package com.book.movie.db.entity;
//
//import com.book.movie.db.entity.enumType.SeatStatus;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class Seat {
//
//    @Id
//    private String seatId;
//
//    @ManyToOne
//    @JoinColumn(name = "room_id")
//    private ScreeningRoom screeningRoom;
//
//    private String row;
//    private Integer number;
//
//    private SeatStatus status;
//}
