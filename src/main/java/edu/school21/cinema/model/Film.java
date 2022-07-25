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

    @Column(length = 1000)
    private String title;
    private int year;
    private int age;
    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    @JoinColumn(name = "poster")
    public Image poster;

}