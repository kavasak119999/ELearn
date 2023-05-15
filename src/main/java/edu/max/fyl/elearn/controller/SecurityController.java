package edu.max.fyl.elearn.controller;

import edu.max.fyl.elearn.dto.User;
import edu.max.fyl.elearn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Properties;

@Controller
public class SecurityController {
    private final UserService userService;

    public SecurityController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/login")
    public String login(@RequestParam(required = false) String error,
                        Model model, Principal principal) {
        if (principal != null) {
            return "redirect:/lessons";
        }

        if (error != null) {
            model.addAttribute("error", "Логін або пароль не вірні");
        }

        return "pages/login";
    }


    @GetMapping(value = "/registration")
    public String registration(Model model, Principal principal) {
        if (principal != null) {
            return "redirect:/lessons";
        }
        model.addAttribute("user", new User());
        return "pages/registration";
    }

    @PostMapping(value = "/registration-user")
    public String registration(
            @ModelAttribute @Valid User user,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "pages/registration";
        }


        Properties properties = userService.register(user);
        final String field;

        if (!properties.isEmpty()) {
            if (properties.containsKey("username")) {
                field = "username";
            } else {
                field = "email";
            }
            bindingResult.addError(new FieldError
                    ("user", field, properties.getProperty(field)));

            return "pages/registration";
        }

        return "redirect:login";
    }
}
