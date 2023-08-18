package com.akr.business.url.shortner.creator.config;

import com.couchbase.client.java.query.QueryScanConsistency;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

@Configuration
@Profile("test")
//@EnableCouchbaseRepositories(basePackages = { "com.akr.business.url.shortner.creator" })
public class CouchbaseTestConfig extends AbstractCouchbaseConfiguration {

    public static final String NODE_LIST = "localhost";
    //public static final String BUCKET_NAME = "document-collection";
    public static final String BUCKET_NAME = "ShortUrlTest";
    public static final String BUCKET_USERNAME = "Administrator";
    public static final String BUCKET_PASSWORD = "123456";

    @Override
    public String getConnectionString() {
        return NODE_LIST;
    }

    @Override
    public String getUserName() {
        return BUCKET_USERNAME;
    }

    @Override
    public String getPassword() {
        return BUCKET_PASSWORD;
    }

    @Override
    public String getBucketName() {
        return BUCKET_NAME;
    }

    @Override
    public QueryScanConsistency getDefaultConsistency() {
        return QueryScanConsistency.REQUEST_PLUS;
    }

}