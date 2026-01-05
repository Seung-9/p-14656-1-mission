package com.back.global;

import java.time.OffsetDateTime;
import java.util.Objects;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@ToString
public class BaseDocument<ID> implements Persistable<ID> {
    @Id
    private ID id;

    @Field(
            type = FieldType.Date,
            format = DateFormat.date_time
    )
    @CreatedDate
    private OffsetDateTime createdAt;

    @Field(
            type = FieldType.Date,
            format = DateFormat.date_time
    )
    @LastModifiedDate
    private OffsetDateTime lastModifiedAt;

    @Override
    public boolean isNew() { // id가 null이거나 날짜 필드가 모두 null이면 새 엔티티로 판단
        return id == null || (createdAt == null && lastModifiedAt == null);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BaseDocument<?> that = (BaseDocument<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}