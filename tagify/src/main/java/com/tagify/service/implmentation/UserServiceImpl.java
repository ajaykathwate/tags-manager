package com.tagify.service.implmentation;

import com.tagify.entity.Tag;
import com.tagify.entity.User;
import com.tagify.repo.UserRepo;
import com.tagify.service.TagService;
import com.tagify.service.UserService;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final TagService tagService;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(UUID id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    @Override
    public User addTagToUser(UUID userId, String tagName) {
        User user = getUserById(userId);
        Tag tag = tagService.findOrCreateTag(tagName);

        user.addTag(tag);
        return user;
    }

    @Override
    public User removeTagFromUser(UUID userId, String tagName) {
        User user = getUserById(userId);
        Tag tag = tagService.getTagById(tagName);

        user.removeTag(tag);
        return user;
    }

    @Override
    public Set<Tag> getTagsByUserId(UUID userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
        return user.getTags();
    }
}
