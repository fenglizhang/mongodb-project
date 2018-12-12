import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;


public class TestMongoDB {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//獲取客戶端對象
		MongoClient client = new MongoClient("localhost",27017);
		//获取数据库
		MongoDatabase database = client.getDatabase("runoob");
		//获取数据库下所有的集合名字
		 MongoIterable<String> listCollectionNames = database.listCollectionNames();
		 MongoCursor<String> iterator = listCollectionNames.iterator();
		 System.out.println("-------------------test数据库下的集合-Collection名字分别为：-------------");
		 while(iterator.hasNext()){
			 System.out.println(iterator.next());
		 }

		
		
	}
}
