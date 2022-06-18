package edu.school21.cinema.model;

import edu.school21.cinema.enums.Role;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

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

    @Enumerated(EnumType.STRING)
    private Role roles;

    public User(String firstName, String lastName, String phoneNumber, String password) {
        this.firstname = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(role);
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        list.add(new SimpleGrantedAuthority(roles.name()));
        return list;
    }

    @Override
    public String getUsername() {
        return firstname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }
        User that = (User) obj;
        return this.id.equals(that.getId());
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

}
