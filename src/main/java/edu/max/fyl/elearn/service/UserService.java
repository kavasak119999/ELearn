package edu.max.fyl.elearn.service;

import edu.max.fyl.elearn.dto.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Properties;

public interface UserService extends UserDetailsService {
    Properties register(User user);
    boolean existsById(String id);
    User findById(String id);
}