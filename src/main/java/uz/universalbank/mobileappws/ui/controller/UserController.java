package uz.universalbank.mobileappws.ui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.universalbank.mobileappws.ui.model.User;

@RestController
@RequestMapping("users") // http:localhost:8080/users/

public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "25") int limit,
                           @RequestParam(value = "sort", defaultValue = "desc") String sort) {
        return "Get users was called with pages = " + page + " and limit = " + limit + " sorting = " + sort;
    }

    @GetMapping(path = "/{userId}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity getUser(@PathVariable String userId) {
        User user = new User();
        user.setFirstName("Max");
        user.setLastName("Alpha");
        user.setEmail("maxalpha@enginer.com");
        user.setUserId(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PostMapping
    public String createUser() {
        return "Create user was called ";
    }

    @PutMapping
    public String updateUser() {
        return "update was called ";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Delete user was called";
    }
}

