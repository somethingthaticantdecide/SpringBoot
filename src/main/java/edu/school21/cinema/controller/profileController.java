package edu.school21.cinema.controller;

import edu.school21.cinema.model.User;
import edu.school21.cinema.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/profile")
public class profileController {

    private final UsersService usersService;

    @Autowired
    public profileController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String doGet(ModelMap model, HttpServletRequest request) {
        User user = usersService.find((String) request.getSession().getAttribute("username"));
        model.addAttribute("user", user);
        model.addAttribute("avatar", user.getAvatars());
        return "profile";
    }

    @PostMapping
    public String doPost(HttpServletRequest req, HttpServletRequest request) {
//        String firstName = req.getParameter("firstName");
//        if (usersService.find(firstName) != null)
//            return "signUp";
//        usersService.signUp(firstName, req.getParameter("lastName"), req.getParameter("phoneNumber"), req.getParameter("password"));
//        req.getSession().setAttribute("username", firstName);
//        return "redirect:/sessions";

//        HttpSession session = request.getSession(false);
//        String username = (String) request.getSession().getAttribute("username");
//        session.setAttribute("sessions", userService.getUserSessions(userService.find(username).getId()));
//
//        List<Image> images = userService.getUserImages(username);
//        String filename;
//        if (images.isEmpty()) {
//            filename = Objects.requireNonNull(getClass().getClassLoader().getResource("/images/blankProfile.png")).getFile();
//        } else {
//            filename = userService.getFilesUploadPath() + File.separator + username + File.separator + images.get(images.size() - 1).getFilename();
//        }
//        session.setAttribute("avatar", Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(new File(filename))));
//        session.setAttribute("images", images);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile.jsp");
//        dispatcher.forward(request, response);

        return "profile";
    }

}