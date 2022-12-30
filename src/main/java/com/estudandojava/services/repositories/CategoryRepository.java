package com.estudandojava.services.repositories;

import com.estudandojava.services.entities.Category;
import com.estudandojava.services.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category,Long> {
}
