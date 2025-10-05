package com.tagify.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.*;

@Entity
@Table(
    name = "tags",
    indexes = {
        @Index(name = "idx_tags_name", columnList = "name")
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "users")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false, length = 20)
    private String name;
    
    @ManyToMany(mappedBy = "tags")
    @Builder.Default
    @JsonBackReference
    private Set<User> users = new HashSet<>();
}
