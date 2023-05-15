package edu.max.fyl.elearn.controller;

import edu.max.fyl.elearn.dto.User;
import edu.max.fyl.elearn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
public class GeneralController {

    private final UserService userService;

    public GeneralController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showMainPage(Principal principal) {
        if (principal != null) {
            return "redirect:/lessons";
        }

        return "pages/eLearn";
    }

    @GetMapping(value = "/dictionary")
    public String showDictionaryPage() {

        return "pages/dictionary";
    }

    @GetMapping(value = "/{username}")
    public String showUserProfile(@PathVariable String username, Principal principal,
                                  Model model) {
        if (!userService.existsById(username)) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
        User user = userService.findById(username);

        if(principal != null){
            if(user.getUsername().equals(principal.getName())){
                model.addAttribute("currentUser", true);
            }
        }
        model.addAttribute("email", user.getEmail());

        return "pages/user";

    }

}
