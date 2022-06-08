package edu.school21.cinema.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filename")
    private String filename;

    @Column(name = "size")
    private Long size;

    @Column(name = "mime")
    private String mime;
}
