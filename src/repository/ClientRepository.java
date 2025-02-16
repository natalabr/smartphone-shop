package repository;

import com.google.gson.GsonBuilder;
import org.bson.conversions.Bson;
import persistence.LocalDateTypeAdapter;
import persistence.PersistenceService;
import persistence.Client;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.google.gson.Gson;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    PersistenceService persistenceService = new PersistenceService();
    MongoCollection<Document> collection = persistenceService.getCollection("clients");
    Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
            .create();

    public List<Client> getClients() {

        List<Client> clients = new ArrayList<>();

        for (Document doc : collection.find()) {
            clients.add(convertFromDocument(doc));
        }
        return clients;
    }

    public Client getClient(String id) {

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

    public boolean updateClient(Client client) {

        Document document = convertToDocument(client);
        Bson filter = Filters.eq("_id", new ObjectId(client.id));
        Document updatedDocument = new Document("$set", document);
        return collection.updateOne(filter, updatedDocument).getMatchedCount() == 1;
    }

    public void addClient(Client client) {

        Document document = convertToDocument(client);
        collection.insertOne(document);
    }

    public boolean deleteClient(String id) {

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

    private Client convertFromDocument(Document document) {

        Client client = gson.fromJson(document.toJson(), Client.class);
        client.id = document.getObjectId("_id").toHexString();
        return client;
    }

    public Document convertToDocument(Client client) {

        String jsonString = gson.toJson(client);
        Document document = Document.parse(jsonString);
        return document;
    }
}
