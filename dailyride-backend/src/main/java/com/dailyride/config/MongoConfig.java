package com.dailyride.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.IndexDefinition;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import com.mongodb.client.model.IndexOptions;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoConfig {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongoMappingContext mongoMappingContext;

    @PostConstruct
    public void initIndexes() {
        // Drop existing indexes except _id
        mongoTemplate.getCollection("users").dropIndexes();

        // Create new index using Spring Data MongoDB
        IndexOperations indexOps = mongoTemplate.indexOps("users");
        Index index = new Index().on("email", Sort.Direction.ASC).unique();
        indexOps.ensureIndex(index);
    }
} 