package persistence;

import com.mongodb.client.*;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;


public class PersistenceService {

    private String uri = "mongodb://localhost:27017";
    private MongoClient mongoClient = MongoClients.create(uri);

    public MongoCollection<Document> getCollection(String collectionName) {

        MongoDatabase database = mongoClient.getDatabase("shopdb");

        MongoCollection<Document> collection = database.getCollection(collectionName);

        return collection;
    }

}

