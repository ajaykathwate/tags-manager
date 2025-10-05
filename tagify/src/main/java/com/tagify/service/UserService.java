package com.tagify.service;

import com.tagify.entity.Tag;
import com.tagify.entity.User;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(UUID id);

    User addTagToUser(UUID userId, String tagName);

    User removeTagFromUser(UUID userId, String tagName);

    Set<Tag> getTagsByUserId(UUID userId);
}
