package com.book.movie.db.entity;

import com.book.movie.db.entity.enumType.Tier;
import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    private String userId;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    private String name;
    private Integer accumulatedAmount;
    private Tier membershipTier;
    private Tier nextMonthTier;
}
