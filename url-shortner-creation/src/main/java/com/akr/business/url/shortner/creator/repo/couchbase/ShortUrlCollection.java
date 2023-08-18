package com.akr.business.url.shortner.creator.repo.couchbase;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;

import java.util.Date;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.USE_ATTRIBUTES;

@Document
@Data
public class ShortUrlCollection {
    @Id
    @Field
    @IdAttribute
    @GeneratedValue(strategy = USE_ATTRIBUTES)
    private String id;
    @Field
    private String shortKey;
    @Field
    private String url;
    @Field
    private String shortUrl;
    @Field
    private Date createdAt;
}
