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
public class OutputMessage extends AbstractEntity {

    @Column(length = 1000)
    private String author;
    @Column(columnDefinition = "text")
    private String text;
    private String time;
    private String film;

    public OutputMessage(String author, String text, String time, String film) {
        this.author = author;
        this.text = text;
        this.time = time;
        this.film = film;
    }

}
