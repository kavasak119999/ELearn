package edu.max.fyl.elearn.service;

import edu.max.fyl.elearn.dto.User;
import edu.max.fyl.elearn.entity.UserEntity;
import edu.max.fyl.elearn.repository.UserRepository;
import edu.max.fyl.elearn.tools.DtoToEntity;
import edu.max.fyl.elearn.tools.EntityToDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Properties;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Properties register(User user) {
        Properties properties = new Properties();
        if (userRepository.findById(user.getUsername()).isPresent()) {
            properties.setProperty("username", "Вказаний логін вже існує");
            return properties;
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            properties.setProperty("email", "Вказана пошта вже існує");
            return properties;
        }

        userRepository.save(DtoToEntity.userDtoToEntity(user));
        return properties;
    }

    @Override
    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }

    @Override
    public User findById(String id) {
        UserEntity user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Користувача із номером - '" + id + "' не знайдено."));
        return EntityToDto.userEntityToDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUserEntity = userRepository
                .findById(username);
        if (optionalUserEntity.isEmpty()) {
                throw new UsernameNotFoundException(
                        "User with username: " + username + " not found");
        } else {
            return optionalUserEntity.get();
        }
    }
}
