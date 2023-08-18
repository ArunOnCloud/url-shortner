package com.akr.business.url.shortner.creator.service;

import com.akr.business.url.shortner.creator.repo.couchbase.ShortUrlRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.event.annotation.AfterTestExecution;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.testcontainers.couchbase.BucketDefinition;
import org.testcontainers.couchbase.CouchbaseContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@ActiveProfiles({"test"})
@Slf4j
public class UrlCreatorServiceTest {

    @Autowired
    UrlCreatorServiceImpl urlCreatorService;

    @Autowired
    ShortUrlRepo shortUrlRepo;
    static DockerImageName COUCHBASE_IMAGE_ENTERPRISE = DockerImageName.parse("couchbase:enterprise")
            .asCompatibleSubstituteFor("couchbase/server")
            .withTag("6.0.1");


    @Container
    static CouchbaseContainer couchbaseContainer = new CouchbaseContainer(COUCHBASE_IMAGE_ENTERPRISE).withBucket(new BucketDefinition("ShortUrl"));

    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
        /*
        spring.couchbase.bootstrap-hosts=localhost
spring.couchbase.bucket.name=test
spring.couchbase.bucket.password=couchbase
spring.data.couchbase.auto-index=true
         */
        dynamicPropertyRegistry.add("spring.couchbase.bootstrap-hosts", couchbaseContainer::getHost);
        dynamicPropertyRegistry.add("spring.couchbase.bucket.name", ()->"short-url");
        dynamicPropertyRegistry.add("spring.couchbase.bucket.password", couchbaseContainer::getPassword);
        dynamicPropertyRegistry.add("spring.couchbase.bucket.username", couchbaseContainer::getUsername);
    }

    @BeforeAll
    public static void setup(){

       // wireMockServer = new WireMockServer(0);
       // wireMockServer.start();
    }
    @AfterEach
    public  void shutdown(){
        log.info("Deleting data");
        shortUrlRepo.deleteAll();
        log.info( "deleted data");
    }


    @Test
    public void testShortUrl(){

        String url="http://google.com";
        String sortUrl=urlCreatorService.shortUrl(url);
        System.out.println("sort url:"+sortUrl);
    }

}
