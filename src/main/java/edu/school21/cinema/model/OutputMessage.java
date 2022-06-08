package edu.school21.cinema.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "messages")
public class OutputMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "author")
    private String author;

    @Column(name = "text")
    private String text;

    @Column(name = "time")
    private String time;

    @Column(name = "film")
    private String film;

    public OutputMessage(String author, String text, String time, String film) {
        this.author = author;
        this.text = text;
        this.time = time;
        this.film = film;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutputMessage that = (OutputMessage) o;
        return id == that.id && Objects.equals(author, that.author) && Objects.equals(text, that.text) && Objects.equals(time, that.time) && Objects.equals(film, that.film);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, text, time, film);
    }
}
