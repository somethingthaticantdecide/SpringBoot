package edu.school21.cinema.services;

import edu.school21.cinema.enums.Role;
import edu.school21.cinema.model.User;
import edu.school21.cinema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user)  {
        userRepository.save(user);
    }

    public User find(String username)  {
        return userRepository.findByFirstname(username);
    }

    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByFirstname(username);
    }

    public boolean saveUser(User user) {
        User userFromDB = userRepository.findByFirstname(user.getFirstname());
        if (userFromDB != null) {
            return false;
        }
        user.setRoles(Role.ROLE_ADMIN);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}
