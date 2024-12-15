package com.example.communityservice.domian;


import com.example.communityservice.dto.PostRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "post_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Content content;

    @Embedded
    private Title title;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



    public void updatePost(PostRequestDto postUpdateRequestDto) {

        this.title = new Title(postUpdateRequestDto.getTitle());

        this.content = new Content(postUpdateRequestDto.getContent());

        this.updatedAt = LocalDateTime.now();

        this.status = postUpdateRequestDto.getStatus();

        this.category = postUpdateRequestDto.getCategory();
    }
}

