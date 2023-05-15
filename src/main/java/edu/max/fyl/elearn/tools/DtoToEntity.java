package edu.max.fyl.elearn.tools;

import edu.max.fyl.elearn.dto.User;
import edu.max.fyl.elearn.entity.UserEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class DtoToEntity {

    public static UserEntity userDtoToEntity(User user) {
        String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        return UserEntity.builder()
                .id(user.getUsername())
                .password(hash)
                .email(user.getEmail())
                .build();
    }
}
