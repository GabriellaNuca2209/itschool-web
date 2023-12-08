package com.gabriella.itschool.unit_tests;

import com.gabriella.itschool.models.dtos.UserDTO;
import com.gabriella.itschool.models.entities.User;
import com.gabriella.itschool.repositories.UserRepository;
import com.gabriella.itschool.services.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testCreateUser() {
        // GIVEN
        User user = new User();
        user.setFirstName("Maria");
        user.setLastName("Popescu");
        user.setEmail("maria@gmail.com");

        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setFirstName("Maria");
        savedUser.setLastName("Popescu");
        savedUser.setEmail("maria@gmail.com");

        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setFirstName("Maria");
        userDTO.setLastName("Popescu");
        userDTO.setEmail("maria@gmail.com");

        when(userRepository.save(user)).thenReturn(savedUser);

        // WHEN

        UserDTO savedUserDTO = userService.createUser(userDTO);

        // THEN
        verify(userRepository, times(1)).save(user);

        assertEquals(userDTO, savedUserDTO);
    }
}






