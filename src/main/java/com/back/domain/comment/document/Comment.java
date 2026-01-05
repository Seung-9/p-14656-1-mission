package com.back.domain.comment.document;

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

@Document(indexName = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString(callSuper = true) @EqualsAndHashCode(callSuper = true)
@Builder(access = AccessLevel.PRIVATE)
public class Comment extends BaseDocument<String> {

    @Field(type = FieldType.Keyword)
    private String postId;

    @Field(type = FieldType.Text)
    private String content;

    @Field(type = FieldType.Keyword)
    private String author;

    public static Comment create(String postId, String content, String author) {
        return Comment.builder()
                .postId(postId)
                .content(content)
                .author(author)
                .build();
    }
}