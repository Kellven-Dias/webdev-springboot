package com.webproject.webproject.repositories;

import com.webproject.webproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
