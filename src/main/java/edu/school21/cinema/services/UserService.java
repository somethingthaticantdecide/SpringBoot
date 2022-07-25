package edu.school21.cinema.services;

import edu.school21.cinema.enums.Role;
import edu.school21.cinema.enums.UserStatus;
import edu.school21.cinema.model.ConfirmationToken;
import edu.school21.cinema.model.User;
import edu.school21.cinema.repositories.ConfirmationTokenRepository;
import edu.school21.cinema.repositories.UserRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService implements UserDetailsService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final VerificationService verificationService;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, EmailSenderService emailSenderService, ConfirmationTokenRepository confirmationTokenRepository, VerificationService verificationService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.verificationService = verificationService;
    }

    public void save(User user)  {
        userRepository.save(user);
    }

    public User find(String username)  {
        return userRepository.findByFirstname(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByFirstname(username);
    }

    public boolean saveUser(User user) {
        if (userRepository.findByFirstname(user.getFirstname()) != null) {
            return false;
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (Objects.equals(user.getFirstname(), "admin")) {
            user.setRoles(Role.ROLE_ADMIN);
            user.setStatus(UserStatus.CONFIRMED);
        } else {
            user.setRoles(Role.ROLE_USER);
            user.setStatus(UserStatus.NOT_CONFIRMED);
        }
        userRepository.save(user);
        if (user.getStatus() == UserStatus.NOT_CONFIRMED) {
            ConfirmationToken confirmationToken = new ConfirmationToken(user);
            confirmationTokenRepository.save(confirmationToken);
            verificationService.sendVerificationEmail(user, confirmationToken);
        }
        return true;
    }
}
