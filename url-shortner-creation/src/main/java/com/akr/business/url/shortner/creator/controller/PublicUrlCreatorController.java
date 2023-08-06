package com.akr.business.url.shortner.creator.controller;

import com.akr.business.url.shortner.creator.dto.CreateShortUrlDto;
import com.akr.business.url.shortner.creator.dto.UrlCreatorResponseDto;
import com.akr.business.url.shortner.creator.service.UrlCreatorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public/")
@Slf4j
public class PublicUrlCreatorController {
    @Autowired
    UrlCreatorServiceImpl urlCreatorService;

    @GetMapping("health")
    public ResponseEntity<String> health(){
        return new ResponseEntity<String>("OK", HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<UrlCreatorResponseDto> createShortUrl(@RequestBody CreateShortUrlDto createShortUrlDto){
        String shortUrl = urlCreatorService.shortUrl(createShortUrlDto.getUrl());
        UrlCreatorResponseDto urlCreatorResponseDto = new UrlCreatorResponseDto();
        urlCreatorResponseDto.setUrl(shortUrl);
        return new ResponseEntity<UrlCreatorResponseDto>(urlCreatorResponseDto, HttpStatus.OK);

    }
}
