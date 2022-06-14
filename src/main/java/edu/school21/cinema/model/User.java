package edu.school21.cinema.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "users")
public class User extends AbstractEntity {

    private String firstname;
    private String lastName;
    private String phoneNumber;
    private String password;

    @OneToMany
    @ToString.Exclude
    private List<Image> avatars;

    @OneToMany
    @ToString.Exclude
    private List<UserSession> sessions;

    public User(String firstName, String lastName, String phoneNumber, String password) {
        this.firstname = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
