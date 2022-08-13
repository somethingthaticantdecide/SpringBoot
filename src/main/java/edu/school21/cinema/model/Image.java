package edu.school21.cinema.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "images")
public class Image extends AbstractEntity {

    @Column(columnDefinition = "text")
    private String filename;
    private Long size;
    private String mime;

}
