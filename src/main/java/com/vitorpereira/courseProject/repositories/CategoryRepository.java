package com.vitorpereira.courseProject.repositories;

import com.vitorpereira.courseProject.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
