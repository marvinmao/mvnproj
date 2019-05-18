package com.enjoylearning.mongo.config;

import com.mongodb.*;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

//@Configuration
public class AppConfig {

    /*
     * Use the standard Mongo driver API to create a com.mongodb.MongoClient instance.
     */
    @Bean
    public MongoClient mongoClient() {

        MongoCredential createCredential =
                MongoCredential.createCredential("lison", "lison", "lison".toCharArray());

        WriteConcern acknowledged = WriteConcern.JOURNALED;
        MongoClientOptions mco = MongoClientOptions.builder()
                .writeConcern(acknowledged)
                .connectionsPerHost(100)
                .readPreference(ReadPreference.secondary())
                .threadsAllowedToBlockForConnectionMultiplier(5)
                .maxWaitTime(120000).connectTimeout(10000).build();
//		List<ServerAddress> asList = Arrays.asList(
//                new ServerAddress("192.168.1.142", 27018), 
//                new ServerAddress("192.168.1.142", 27017), 
//                new ServerAddress("192.168.1.142", 27019));
        List<ServerAddress> asList = Arrays.asList(
                new ServerAddress("116.62.222.124", 27022));

        MongoClient client = new MongoClient(asList, mco);
        return client;
    }
}
