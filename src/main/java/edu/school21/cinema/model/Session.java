package edu.school21.cinema.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "time")
    private String time;

    @Column(name = "cost")
    private int cost;

    @ManyToOne
    @JoinColumn(name = "film")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "hall")
    private Hall hall;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return id == session.id && cost == session.cost && Objects.equals(time, session.time) && Objects.equals(film, session.film) && Objects.equals(hall, session.hall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, cost, film, hall);
    }
}