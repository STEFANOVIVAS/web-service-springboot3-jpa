package com.estudandojava.services.repositories;

import com.estudandojava.services.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
}
