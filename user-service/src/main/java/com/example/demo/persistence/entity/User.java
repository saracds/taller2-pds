package com.example.demo.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_backlog", unique = true)
    private long Id;

    @Column(name = "name")
    @NotBlank
    private String Name;

    @Column(name = "lastname")
    @NotBlank
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Id == user.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
