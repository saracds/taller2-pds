package com.example.demo.persistence.entity;

import com.example.demo.model.Movie;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "showtime_movie")
public class Showtime_Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_showtime_movie", unique = true, nullable = false)
    private long Id_Showtime_Movie;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "id_showtime")
    private Showtime showtime;

    @Column(name = "id_movie")
    private long Id_Movie;

    @Transient
    private Movie movie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showtime_Movie that = (Showtime_Movie) o;
        return Id_Showtime_Movie == that.Id_Showtime_Movie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id_Showtime_Movie);
    }
}
