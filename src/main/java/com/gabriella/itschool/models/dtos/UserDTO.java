package com.gabriella.itschool.models.dtos;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
