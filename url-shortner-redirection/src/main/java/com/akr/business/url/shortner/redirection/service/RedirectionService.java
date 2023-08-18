package com.akr.business.url.shortner.redirection.service;

import com.akr.business.url.shortner.redirection.exception.ExceptionMessages;
import com.akr.business.url.shortner.redirection.exception.ServiceException;
import com.akr.business.url.shortner.redirection.repo.couchbase.ShortUrlCollection;
import com.akr.business.url.shortner.redirection.repo.couchbase.ShortUrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RedirectionService {

    @Autowired
    ShortUrlRepo shortUrlRepo;

    public String getRedirectUrl(String id) throws ServiceException {

        Optional<ShortUrlCollection> shortUrlCollectionOptional = shortUrlRepo.findById(id);
        if(shortUrlCollectionOptional.isEmpty()){
            throw new ServiceException(ExceptionMessages.SERVICE_EXCEPTION);
        }
        ShortUrlCollection shortUrlCollection = shortUrlCollectionOptional.get();
        return shortUrlCollection.getUrl();
    }
}
