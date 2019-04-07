import Bill.Bill;
import Items.Drink.DraftInterference;
import Items.Food.Fruit;
import Items.Item;
import Items.Piece;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;



public class MongoDB {

    private static MongoDB mon = new MongoDB();

    private MongoDB() {
    }

    public static MongoDB getInstance() {
        return mon;
    }



    public void insertData(Bill bill) {
        MongoClient mongoClient = new MongoClient("localhost",27017);
        MongoDatabase database = mongoClient.getDatabase("Kaufland");
        MongoCollection<org.bson.Document> collection = database.getCollection("Bill");

        Document document = new Document();

        for(Item item: bill.getList()){
            Document documentItem = new Document("name",item.getName());

            documentItem.append("price",item.getPrice());
            if (item instanceof DraftInterference){
                documentItem.append("count",((DraftInterference) item).getVolume());
                documentItem.append("unit","l");
            }else if(item instanceof Fruit){
                documentItem.append("count",((Fruit) item).getWeight());
                documentItem.append("unit","kg");
            }else if(item instanceof Piece){
                documentItem.append("count",((Piece) item).getAmount());
                documentItem.append("unit","pieces");
            }
            document.append("Item",documentItem);
        }

        document.append("Date", bill.getDate());
        document.append("Price", bill.getFinalPrice());
    }
}
