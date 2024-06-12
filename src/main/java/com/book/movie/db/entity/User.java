package com.book.movie.db.entity;

import com.book.movie.db.entity.enumType.Tier;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class User {

    @Id
    private String userId;
    private String password;
    private Date birthDate;
    private Tier membershipTier;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Profile profile;
}
