package edu.max.fyl.elearn.controller;

import edu.max.fyl.elearn.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@ControllerAdvice
public class AdviceController {

    @ModelAttribute
    public void addAttributePrincipalName(Model model, Principal principal){
        if (principal != null) {
            UserEntity user = (UserEntity) ((Authentication) principal).getPrincipal();
            model.addAttribute("username", principal.getName());
            model.addAttribute("email", user.getEmail());
        }
    }
}
