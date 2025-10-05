package com.tagify.controller;

import com.tagify.entity.Tag;
import com.tagify.service.TagService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(TagsController.TAGS_ENDPOINT)
@CrossOrigin(origins = "*")
public class TagsController {

    public static final String TAGS_ENDPOINT = "/api/tags";

    private final TagService tagService;

    protected TagsController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        return ResponseEntity.ok(tagService.createTag(tag));
    }

    @GetMapping
    public ResponseEntity<List<Tag>> getAllTags() {
        return ResponseEntity.ok(tagService.getAllTags());
    }

    @GetMapping("/{tagName}")
    public ResponseEntity<Tag> getTag(@PathVariable String tagName) {
        return ResponseEntity.ok(tagService.getTagById(tagName));
    }

}
