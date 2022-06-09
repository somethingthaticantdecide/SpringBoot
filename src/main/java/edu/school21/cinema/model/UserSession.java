package edu.school21.cinema.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User user;

    private String date;
    private String time;
    private String ip;

    public UserSession(User user, String date, String time, String ip) {
        this.user = user;
        this.date = date;
        this.time = time;
        this.ip = ip;
    }
}
