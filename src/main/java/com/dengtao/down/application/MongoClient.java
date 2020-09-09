package com.dengtao.down.application;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author dtt
 */
public class MongoClient {
    /**
     * 获取faction库的MongoTemplate
     * @return
     */
    public static MongoTemplate getFactionMongoTemplate(){
        return new MongoTemplate(new com.mongodb.MongoClient("localhost", 27017), "faction");
    }

    /**
     * 获取faction库 factionCatalogue 表的Client
     * @return
     */
    public static MongoCollection<Document> getFactionCatalogueClient(){
        MongoTemplate mongoTemplate = new MongoTemplate(new com.mongodb.MongoClient("localhost", 27017), "faction");
        return mongoTemplate.getCollection("factionCatalogue");
    }

    /**
     * 获取faction库 factionContent 表的Client
     * @return
     */
    public static MongoCollection<Document> getFactionContentClient(){
        MongoTemplate mongoTemplate = new MongoTemplate(new com.mongodb.MongoClient("localhost", 27017), "faction");
        return mongoTemplate.getCollection("factionContent");
    }

    /**
     * 获取faction库 factionDetail 表的Client
     * @return
     */
    public static MongoCollection<Document> getFactionDetailClient(){
        MongoTemplate mongoTemplate = new MongoTemplate(new com.mongodb.MongoClient("localhost", 27017), "faction");
        return mongoTemplate.getCollection("factionDetail");
    }

    /**
     * 获取faction库 factionList 表的Client
     * @return
     */
    public static MongoCollection<Document> getFactionListClient(){
        MongoTemplate mongoTemplate = new MongoTemplate(new com.mongodb.MongoClient("localhost", 27017), "faction");
        return mongoTemplate.getCollection("factionList");
    }

}
