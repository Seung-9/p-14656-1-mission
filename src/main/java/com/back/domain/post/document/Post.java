package com.back.domain.post.document;

import java.time.OffsetDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class Post {
    @Id
    private String id;
    @Field(type= FieldType.Text)
    private String title;
    @Field(type= FieldType.Text)
    private String content;
    @Field(type= FieldType.Keyword)
    private String author;

    @Field(
            type = FieldType.Date,
            format = DateFormat.date_time
    )
    private OffsetDateTime createdAt;

    @Field(
            type = FieldType.Date,
            format = DateFormat.date_time
    )
    private OffsetDateTime lastModifiedAt;

    public static Post create(String title, String content, String author) {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}