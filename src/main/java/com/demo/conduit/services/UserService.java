package com.demo.conduit.services;

import com.demo.conduit.entities.UserEntity;
import com.demo.conduit.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepo;

    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException() {
            super("no user found");
        }
    }

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public UserEntity findUserByUsername(String username) {
        UserEntity user = userRepo.findUserEntityByUsername(username);
        if(user == null) throw new UserNotFoundException();
        return user;
    }
}
