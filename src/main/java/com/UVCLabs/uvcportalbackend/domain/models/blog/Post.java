package com.UVCLabs.uvcportalbackend.domain.models.blog;

import com.UVCLabs.uvcportalbackend.domain.ValidationGroups;
import com.UVCLabs.uvcportalbackend.domain.models.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = ValidationGroups.PostId.class)
    private Long postId;

    @NotNull
    @Size(min = 5, max = 75)
    private String title;
    @NotNull
    @Size(min = 5, max = 100)
    private String summary;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String postContent;

    @NotNull
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime publishedAt;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "tag_post",
            joinColumns = {@JoinColumn(name = "tag_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "post_id",
                            nullable = false, updatable = false)})
    private List<Tag> tags;

}
