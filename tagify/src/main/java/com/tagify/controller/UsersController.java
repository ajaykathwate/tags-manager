package com.tagify.controller;

import com.tagify.entity.Tag;
import com.tagify.entity.User;
import com.tagify.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UsersController.USERS_ENDPOINT)
@CrossOrigin(origins = "*")
public class UsersController {

    public static final String USERS_ENDPOINT = "/api/users";

    public UsersController(UserService userService){
        this.userService = userService;
    }

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/{user_id}/tags/{tagName}")
    public ResponseEntity<User> addTagToUser(
        @PathVariable("user_id") UUID userId,
        @PathVariable("tagName") String tagName
    ){
        return ResponseEntity.ok(userService.addTagToUser(userId, tagName));
    }

    @DeleteMapping("/{user_id}/tags/{tagName}")
    public ResponseEntity<User> removeTagFromUser(
        @PathVariable("user_id") UUID userId,
        @PathVariable("tagName") String tagName
    ) {
        return ResponseEntity.ok(userService.removeTagFromUser(userId, tagName));
    }

    @GetMapping("/{userId}/tags")
    public ResponseEntity<Set<Tag>> getUserTags(@PathVariable UUID userId) {
        return ResponseEntity.ok(userService.getTagsByUserId(userId));
    }

}
