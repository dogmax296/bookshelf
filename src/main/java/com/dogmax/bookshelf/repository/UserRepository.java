package com.dogmax.bookshelf.repository;

import com.dogmax.bookshelf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
