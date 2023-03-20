package com.vitorpereira.courseProject.repositories;

import com.vitorpereira.courseProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
