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
public class Session extends AbstractEntity {

    private String time;
    private int cost;

    @ManyToOne
    @JoinColumn(name = "film")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "hall")
    private Hall hall;
}