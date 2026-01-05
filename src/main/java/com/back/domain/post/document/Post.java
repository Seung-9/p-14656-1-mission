package com.back.domain.post.document;

import com.back.global.BaseDocument;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString(callSuper = true) @EqualsAndHashCode(callSuper = true)
@Builder(access = AccessLevel.PRIVATE)
public class Post extends BaseDocument<String> {
    @Field(type= FieldType.Text)
    private String title;
    @Field(type= FieldType.Text)
    private String content;
    @Field(type= FieldType.Keyword)
    private String author;

    public static Post create(String title, String content, String author) {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

    public void update(String title, String content) {
        if (title != null) {
            this.title = title;
        }
        if (content != null) {
            this.content = content;
        }
    }
}