package com.example.demo.persistence.entity;

import com.example.demo.model.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "booking_movie")
public class Booking_Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_booking_movie", unique = true, nullable = false)
    private long Id_Booking_Movie;

    @Column(name = "id_movie")
    private long Id_Movie;

    @Transient
    private Movie movie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking_Movie that = (Booking_Movie) o;
        return Id_Booking_Movie == that.Id_Booking_Movie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id_Booking_Movie);
    }
}
