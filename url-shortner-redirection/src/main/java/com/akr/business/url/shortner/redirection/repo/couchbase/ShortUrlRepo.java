package com.akr.business.url.shortner.redirection.repo.couchbase;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShortUrlRepo extends CrudRepository<ShortUrlCollection, String> {
    Optional<ShortUrlCollection> findById(String id);

    ShortUrlCollection save(ShortUrlCollection entity);

}