package com.akr.business.url.shortner.creator.service;


import com.akr.business.url.shortner.creator.repo.couchbase.ShortUrlCollection;
import com.akr.business.url.shortner.creator.repo.couchbase.ShortUrlRepo;
import com.akr.business.url.shortner.creator.util.Constants;
import com.akr.business.url.shortner.creator.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
@Slf4j
public class UrlCreatorServiceImpl {

    private String domain= Constants.DEFAULT_DOMAIN;

    @Autowired
    ShortUrlRepo shortUrlRepo;

    public String shortUrl(String url){
        log.info("url received {}",url);
        String id = Utils.getShortKey();
        ShortUrlCollection shortUrlCollection = new ShortUrlCollection();
        shortUrlCollection.setId(id);
        shortUrlCollection.setCreatedAt(new Date());
        shortUrlCollection.setUrl(url);
        shortUrlCollection.setShortKey(id);
        shortUrlCollection.setShortUrl(Constants.DEFAULT_DOMAIN + id);
        shortUrlRepo.save(shortUrlCollection);
       return shortUrlCollection.getShortUrl();
    }
}
