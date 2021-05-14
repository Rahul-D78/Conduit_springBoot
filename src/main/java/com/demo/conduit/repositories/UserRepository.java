package com.demo.conduit.repositories;

import com.demo.conduit.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserEntityByUsername(
            @Param("username") String username
    );
}
