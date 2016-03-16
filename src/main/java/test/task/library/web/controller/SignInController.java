package test.task.library.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.task.library.dto.UserDTO;

/**
 * @author Nikolay Yashchenko
 */
@Controller
public class SignInController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "login";
    }
}
