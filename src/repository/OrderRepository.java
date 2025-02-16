package repository;

import com.google.gson.GsonBuilder;
import com.mongodb.client.model.Updates;
import org.bson.conversions.Bson;
import persistence.Client;
import persistence.LocalDateTypeAdapter;
import persistence.Order;
import persistence.PersistenceService;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.google.gson.Gson;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    PersistenceService persistenceService = new PersistenceService();
    MongoCollection<Document> collection = persistenceService.getCollection("orders");
    Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
            .create();


    public List<Order> getOrders() {

        List<Order> orders = new ArrayList<>();

        for (Document doc : collection.find()) {
            orders.add(convertFromDocument(doc));
        }
        return orders;
    }

    public List<Order> getOrders(String id) {

        List<Order> orders = new ArrayList<>();
        for (Document doc :  collection.find(Filters.eq("clientId", id))) {
            orders.add(convertFromDocument(doc));
        }

        return orders;
    }

    public void addOrder(Order order) {

        Document document = convertToDocument(order);
        collection.insertOne(document);
    }

    public boolean cancelOrder(String id) {

        ObjectId objectId = convertToId(id);
        if (objectId == null) {
            return false;
        }
        Bson filter = Filters.eq("_id", new ObjectId(id));
        Bson updateOperation = Updates.set("active", false);
        collection.updateOne(filter, updateOperation);
        return true;
    }

    private ObjectId convertToId(String id) {
        try {
            ObjectId objectId = new ObjectId(id);
            return objectId;
        } catch (Exception ex) {
            return null;
        }
    }

    private Order convertFromDocument(Document document) {

        Order order = gson.fromJson(document.toJson(), Order.class);
        order.id = document.getObjectId("_id").toHexString();
        return order;
    }

    public Document convertToDocument(Order order) {

        String jsonString = gson.toJson(order);
        Document document = Document.parse(jsonString);
        return document;
    }
}
