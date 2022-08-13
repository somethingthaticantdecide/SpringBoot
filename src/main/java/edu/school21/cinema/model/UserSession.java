package edu.school21.cinema.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class UserSession extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    private User user;

    private String date;
    private String time;
    private String ip;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserSession that = (UserSession) o;
        return Objects.equals(user, that.user) && Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(ip, that.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user, date, time, ip);
    }
}
