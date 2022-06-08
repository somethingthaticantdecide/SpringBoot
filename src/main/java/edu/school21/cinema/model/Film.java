package edu.school21.cinema.model;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private int year;

    @Column(name = "age")
    private int age;

    @Column(name = "description")
    private String description;

    @Column(name = "poster")
    public String poster;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return id == film.id && year == film.year && age == film.age && Objects.equals(title, film.title) && Objects.equals(description, film.description) && Objects.equals(poster, film.poster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, age, description, poster);
    }
}