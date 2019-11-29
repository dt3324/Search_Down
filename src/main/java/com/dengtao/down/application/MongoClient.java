package com.dengtao.down.application;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author dtt
 */
public class MongoClient {
    /**
     * 获取fiction库的MongoTemplate
     * @return
     */
    public static MongoTemplate getFictionMongoTemplate(){
        return new MongoTemplate(new com.mongodb.MongoClient("192.168.99.115", 27017), "fiction");
    }

    /**
     * 获取fiction库 fictionCatalogue 表的Client
     * @return
     */
    public static MongoCollection<Document> getFictionCatalogueClient(){
        MongoTemplate mongoTemplate = new MongoTemplate(new com.mongodb.MongoClient("192.168.99.115", 27017), "fiction");
        return mongoTemplate.getCollection("fictionCatalogue");
    }

    /**
     * 获取fiction库 fictionContent 表的Client
     * @return
     */
    public static MongoCollection<Document> getFictionContentClient(){
        MongoTemplate mongoTemplate = new MongoTemplate(new com.mongodb.MongoClient("192.168.99.115", 27017), "fiction");
        return mongoTemplate.getCollection("fictionContent");
    }

    /**
     * 获取fiction库 fictionDetail 表的Client
     * @return
     */
    public static MongoCollection<Document> getFictionDetailClient(){
        MongoTemplate mongoTemplate = new MongoTemplate(new com.mongodb.MongoClient("192.168.99.115", 27017), "fiction");
        return mongoTemplate.getCollection("fictionDetail");
    }

    /**
     * 获取fiction库 fictionList 表的Client
     * @return
     */
    public static MongoCollection<Document> getFictionListClient(){
        MongoTemplate mongoTemplate = new MongoTemplate(new com.mongodb.MongoClient("192.168.99.115", 27017), "fiction");
        return mongoTemplate.getCollection("fictionList");
    }

}
