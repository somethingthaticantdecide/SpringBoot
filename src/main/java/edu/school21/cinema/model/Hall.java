package edu.school21.cinema.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "halls")
public class Hall extends AbstractEntity {

    @Column(columnDefinition = "text")
    private String name;
    private int seats;

}