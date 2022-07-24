package com.example.demo.persistence.entity;

import com.example.demo.model.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "showtime")
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_showtime", unique = true, nullable = false)
    private long Id;

    @Column(name = "date")
    private LocalDateTime Date;

    @Transient
    private List<Movie> Movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showtime showtime = (Showtime) o;
        return Id == showtime.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}