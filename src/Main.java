import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;


import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ListDatabases();
    }


    public static void ListDatabases() {
        String connectionString = "mongodb://localhost:27017";
        MongoClient mongoClient = MongoClients.create(connectionString);
        List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());

        databases.forEach(db -> System.out.println(db.toJson()));
    }
}
