package com.gabriella.itschool.repositories;

import com.gabriella.itschool.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

}
