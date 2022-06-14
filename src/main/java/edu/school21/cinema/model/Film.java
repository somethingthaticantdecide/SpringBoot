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
public class Film extends AbstractEntity {

    private String title;
    private int year;
    private int age;
    private String description;

    @ManyToOne
    @JoinColumn(name = "poster")
    public Image poster;

}