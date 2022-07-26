package com.example.demo.persistence.entity;

import com.example.demo.model.Movie;
import com.example.demo.model.Showtime;
import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_booking", unique = true, nullable = false)
    private long Id;

    @Column(name = "id_user")
    private long userId;

    @Transient
    private User user;

    @Column(name = "id_showtime")
    private long showtimeId;

    @Transient
    private Showtime showtime;

    @Valid
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_booking")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Booking_Movie> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Id == booking.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
