package com.akr.business.url.shortner.creator.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class UrlCreatorServiceImpl {

    private String domain= "http://localhost:8080/r/";
    private Random random = new Random();

    private Long bound = 1000000L;
    public String shortUrl(String url){
        log.info("url received {}",url);
       long num = random.nextLong(bound);
       return domain+""+num;
    }
}
