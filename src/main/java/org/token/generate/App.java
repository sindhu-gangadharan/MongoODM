package org.token.generate;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.query.Query;
import dev.morphia.query.experimental.filters.Filters;
import dev.morphia.query.experimental.updates.UpdateOperators;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class App {
    static Logger logger = LoggerFactory.getLogger("App");
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://addyourmongourl";

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            try {
                // Send a ping to confirm a successful connection
                //   MongoDatabase database = mongoClient.getDatabase("admin");
                //  database.runCommand(new Document("ping", 1));
                //  System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
                //bookshowroom is the document created in Mongo
                Datastore datastore = Morphia.createDatastore(MongoClients.create(connectionString), "bookshowroom");
                datastore.getMapper().mapPackage("org.token.generate");
                datastore.ensureIndexes();

                //datastore
                  //      .find(Book.class)
                Query<Book> query = datastore.find(Book.class);
                query.filter(Filters.eq("number", "number as per docuemnt"));
                Book book1=null;
                Book book2=null;
               if( query.iterator().hasNext())
               {
                    book1 = query.iterator().next();
                   book1.setJavaPerformanceCompanion("value as per the document");
               }

                System.out.println(query.toString());
                //datastore
                  //      .find(Book.class)
                Query<Book> query1 = datastore.find(Book.class);
                query1.filter(Filters.eq("number", "number as per docuemnt"));
                if( query1.iterator().hasNext())
                {
                    book2 = query1.iterator().next();
                    book2.setJavaPerformanceCompanion("value as per the document");
                }
                datastore.save(book1);
                datastore.save(book2);
                //Here book1 will be saved and book2 save will not be saved with Concurrent Modification  error
            } catch (Exception e) {
                e.printStackTrace();
                logger.info("error");
                System.out.println("exception"+e);
            }
        }
    }
}
