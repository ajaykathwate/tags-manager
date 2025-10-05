package com.tagify.service;

import com.tagify.entity.Tag;
import com.tagify.entity.User;
import java.util.List;
import java.util.Set;

public interface TagService {
    Tag createTag(Tag tag);

    List<Tag> getAllTags();

    Tag getTagById(String tagName);

    Set<User> getUsersByTagName(String tagName);

    Tag findOrCreateTag(String tagName);
}
