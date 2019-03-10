package com.hyen.boot2simplelogin.web.repository;

import com.hyen.boot2simplelogin.web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(String id);
}
