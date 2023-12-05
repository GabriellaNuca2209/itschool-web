package com.gabriella.itschool.services;

import com.gabriella.itschool.exceptions.UserCreateException;
import com.gabriella.itschool.models.dtos.UserDTO;
import com.gabriella.itschool.models.entities.User;
import com.gabriella.itschool.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        // validate dto
        // convert dto to entity
        // save entity to db

        // validation
        if (userDTO.getFirstName().length() < 3) {
            throw new UserCreateException("Invalid first name");
        }

        // conversion to entity
        User userEntity = new User();
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setEmail(userDTO.getEmail());

        // save entity to database
        User savedUser = userRepository.save(userEntity);
        log.info("User {} was saved.", savedUser.getFirstName());

        // conversion to DTO
        UserDTO userResponseDTO = new UserDTO();
        userResponseDTO.setId(savedUser.getId());
        userResponseDTO.setFirstName(savedUser.getFirstName());
        userResponseDTO.setLastName(savedUser.getLastName());
        userResponseDTO.setEmail(savedUser.getEmail());

        return userResponseDTO;
    }
}
