package com.tagify.service.implmentation;

import com.tagify.entity.Tag;
import com.tagify.entity.User;
import com.tagify.repo.TagRepo;
import com.tagify.service.TagService;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TagsServiceImpl implements TagService {

    private final TagRepo tagRepo;

    protected TagsServiceImpl(TagRepo tagRepo){
        this.tagRepo = tagRepo;
    }

    @Override
    public Tag createTag(Tag tag) {
        if(tagRepo.findByName(tag.getName()).isPresent()) {
            throw new RuntimeException("Tag Already Exists");
        }
        return tagRepo.save(tag);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepo.findAll();
    }

    @Override
    public Tag getTagById(String tagName) {
        return tagRepo.findByName(tagName).orElseThrow(() -> new RuntimeException("Tag Not Found"));
    }

    @Override
    public Set<User> getUsersByTagName(String tagName) {
        Tag tag =  tagRepo.findByName(tagName).orElseThrow(() -> new RuntimeException("Tag Not Found"));
        return tag.getUsers();
    }

    @Override
    public Tag findOrCreateTag(String tagName) {
        return tagRepo.findByName(tagName)
                .orElseGet(() -> {
                    Tag newTag = Tag.builder().name(tagName).build();
                    return tagRepo.save(newTag);
                });
    }
}
