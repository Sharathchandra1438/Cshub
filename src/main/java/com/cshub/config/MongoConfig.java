package com.cshub.config;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(
                "mongodb+srv://sharathchandra7060:Sharath123@clustertest.v1shdwx.mongodb.net/cshubdb?retryWrites=true&w=majority"
        );
        return MongoClients.create(connectionString);
    }
}
