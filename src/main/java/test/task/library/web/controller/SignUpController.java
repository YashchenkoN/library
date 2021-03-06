package test.task.library.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.task.library.dto.UserDTO;
import test.task.library.entity.Role;
import test.task.library.entity.User;
import test.task.library.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author Nikolay Yashchenko
 */
@Controller
public class SignUpController {

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("userDTOValidator")
    private Validator validator;

    @PreAuthorize("hasRole('ROLE_ANONYMOUS')")
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userDTO") UserDTO userDTO,
                               HttpServletRequest request) {
        BindingResult bindingResult = new MapBindingResult(new HashMap<>(), "userDTO");
        validator.validate(userDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/registration";
        }
        if (userService.readByEmail(userDTO.getEmail()) != null) {
            return "redirect:/login";
        }
        User user = conversionService.convert(userDTO, User.class);
        user.setRole(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.create(user);

        try {
            request.login(user.getEmail(), userDTO.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
