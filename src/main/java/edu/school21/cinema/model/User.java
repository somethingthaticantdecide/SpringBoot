package edu.school21.cinema.model;

import edu.school21.cinema.annotations.ValidPassword;
import edu.school21.cinema.annotations.PhoneNumber;
import edu.school21.cinema.enums.Role;
import edu.school21.cinema.enums.UserStatus;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastName;
    @PhoneNumber
    private String phoneNumber;
    @Email
    @NotEmpty
    private String email;
    @ValidPassword
    private String password;
    @Transient
    private String passwordConfirm;
    @OneToMany
    @ToString.Exclude
    private List<Image> avatars;
    @OneToMany
    @ToString.Exclude
    private List<UserSession> sessions;
    @Enumerated(EnumType.STRING)
    private Role roles;
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public User() {
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
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(roles);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return firstname;
    }

}
