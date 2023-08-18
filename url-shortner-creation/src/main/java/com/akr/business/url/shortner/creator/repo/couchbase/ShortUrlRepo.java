package com.akr.business.url.shortner.creator.repo.couchbase;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

public interface ShortUrlRepo extends CrudRepository<ShortUrlCollection, String> {
    Optional<ShortUrlCollection> findById(String id);

    ShortUrlCollection save(ShortUrlCollection entity);

}