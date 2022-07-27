package com.example.demo.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private long Id;

    @Column(name = "title")
    private String Title;

    @Column(name ="director")
    private String Director;

    @Column(name = "rating")
    private int Rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Id == movie.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
