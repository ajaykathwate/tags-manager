package com.tagify.repo;

import com.tagify.entity.Tag;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepo extends JpaRepository<Tag, UUID> {
    Optional<Tag> findByName(String name);
}
