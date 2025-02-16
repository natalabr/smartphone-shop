package repository;

import org.bson.conversions.Bson;
import persistence.PersistenceService;
import persistence.Smartphone;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneRepository {

    PersistenceService persistenceService = new PersistenceService();
    MongoCollection<Document> collection = persistenceService.getCollection("smartphones");
    Gson gson = new Gson();

    public List<Smartphone> getSmartphones() {

        List<Smartphone> smartphones = new ArrayList<>();

        for (Document doc : collection.find()) {
            smartphones.add(convertFromDocument(doc));
        }
        return smartphones;
    }

    public Smartphone getSmartphone(String id) {

        ObjectId objectId = convertToId(id);
        if (objectId == null) {
            return null;
        }
        Document doc = collection.find(Filters.eq("_id", objectId)).first();
        if (doc == null) {
            return null;
        }
        return convertFromDocument(doc);
    }

    public boolean updateSmartphone(Smartphone smartphone) {

        Document document = convertToDocument(smartphone);
        Bson filter = Filters.eq("_id", new ObjectId(smartphone.id));
        Document updatedDocument = new Document("$set", document);
        return collection.updateOne(filter, updatedDocument).getMatchedCount() == 1;
    }

    public void addSmartphone(Smartphone smartphone) {

        Document document = convertToDocument(smartphone);
        collection.insertOne(document);
    }

    public boolean deleteSmartphone(String id) {

        ObjectId objectId = convertToId(id);
        if (objectId == null) {
            return false;
        }
        var result = collection.deleteOne(Filters.eq("_id", objectId));
        return result.getDeletedCount() == 1;
    }

    private ObjectId convertToId(String id) {
        try {
            ObjectId objectId = new ObjectId(id);
            return objectId;
        } catch (Exception ex) {
            return null;
        }
    }

    private Smartphone convertFromDocument(Document document) {

        Smartphone smartphone = gson.fromJson(document.toJson(), Smartphone.class);
        smartphone.id = document.getObjectId("_id").toHexString();
        return smartphone;
    }

    public Document convertToDocument(Smartphone smartphone) {

        String jsonString = gson.toJson(smartphone);
        Document document = Document.parse(jsonString);
        return document;
    }
}
