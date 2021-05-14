package com.demo.conduit.contrllers;

import com.demo.conduit.entities.ErrorEntity;
import com.demo.conduit.entities.UserEntity;
import com.demo.conduit.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    private final UserService users;

    public ProfileController(UserService users) {
        this.users = users;
    }

    @GetMapping("/profile/{username}")
    UserEntity getUserByUsername(@PathVariable("username") String username){
        return users.findUserByUsername(username);
    }

    @ExceptionHandler({RuntimeException.class})
    ResponseEntity<ErrorEntity> handleException(RuntimeException exception) {
        String message = exception.getMessage();
        HttpStatus errorStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        if(exception instanceof UserService.UserNotFoundException) {
            errorStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<ErrorEntity>(
                ErrorEntity.from(message),
                errorStatus
        );
    }
}
