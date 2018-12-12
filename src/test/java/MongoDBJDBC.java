

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDBJDBC {
	public static void main(String[] args) {
		MongoClient client=new MongoClient("localhost",27017);
		MongoDatabase zhanglf = client.getDatabase("zhanglf");
		System.out.println("Connect to database successfully");
		//zhanglf.createCollection("zlf");
		//System.out.println("集合创建成功！");
		MongoCollection<Document> collection = zhanglf.getCollection("zlf");
		System.out.println("获得zlf集合成功！"+collection);
		
		 //插入文档  
        /** 
        * 1. 创建文档 org.bson.Document 参数为key-value的格式 
        * 2. 创建文档集合List<Document> 
        * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document) 
        * */
//		Document document = new Document("zlf","MongoDB");
//		document.append("description", "database");
//		document.append("likes",100);
//		document.append("by", "fly");
//		
//		List<Document> documents =new ArrayList<>();
//		documents.add(document);
//		collection.insertMany(documents);
//		System.out.println("文档插入成功！");
		
		//检索文档
		 /** 
         * 1. 获取迭代器FindIterable<Document> 
         * 2. 获取游标MongoCursor<Document> 
         * 3. 通过游标遍历检索出的文档集合 
         * */  
//		FindIterable<Document> findIterable = collection.find();
//		MongoCursor<Document> mongoCursor = findIterable.iterator();
//		while(mongoCursor.hasNext()){
//			System.out.println(mongoCursor.next());
//		}
		
		//更新文档   将文档中likes=100的文档修改为likes=200  
		
//		collection.updateMany(Filters.eq("likes", 100), new Document("$set",new Document("likes",200)));
		
		//查看
//		FindIterable<Document> findIterable = collection.find();
//		MongoCursor<Document> iterator = findIterable.iterator();
//		while(iterator.hasNext()){
//			System.out.println(iterator.next());
//		}
		
		
		//删除
		
		collection.deleteOne(Filters.eq("likes",200));
		//查看结果
		FindIterable<Document> findIterable = collection.find();
		MongoCursor<Document> iterator = findIterable.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		
		
		
		
		
	}
}
