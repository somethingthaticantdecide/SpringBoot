package edu.school21.cinema.controller;

import edu.school21.cinema.model.ConfirmationToken;
import edu.school21.cinema.model.User;
import edu.school21.cinema.repositories.ConfirmationTokenRepository;
import edu.school21.cinema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/confirm")
public class ConfirmationController {

    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final UserRepository userRepository;

    @Autowired
    public ConfirmationController(ConfirmationTokenRepository confirmationTokenRepository, UserRepository userRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.userRepository = userRepository;
    }

    @GetMapping()
    public String doGet(ModelMap model, @PathVariable("film-id") String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if(token != null) {
            User user = userRepository.findByFirstname(token.getUser().getFirstname());
            user.setActivated(true);
            userRepository.save(user);
            model.addAttribute("title", "Congratulations!");
            model.addAttribute("message", "Congratulations! Your account has been activated and email is verified!");
        } else {
            model.addAttribute("title", "Error!");
            model.addAttribute("message", "The link is invalid or broken!");
        }
        return "confirm";
    }

}