// import com.mongodb.MongoClient;
// import com.mongodb.DB;
// import com.mongodb.DBCollection;
// import com.mongodb.BasicDBObject;
// import com.mongodb.DBObject;
// import com.mongodb.DBCursor;
// import com.mongodb.AggregationOutput;

// import java.util.*;

// public class MongoDBDataStoreUtilities {
//     static DBCollection myReviews;

//     public static DBCollection getConnection() {
//         MongoClient mongo;
//         mongo = new MongoClient("localhost", 27017);

//         DB db = mongo.getDB("CustomerReviews");
//         myReviews = db.getCollection("myReviews");
//         return myReviews;
//     }


//     public static String insertReview(String productname, String producttype, String price, String storeID, String storeZip, String storeCity, String storeState, String productOnSale,
//                                       String productmaker, String manufacturerRebate, String username, String userAge, String userGender, String userOccupation, String reviewrating, String reviewdate, String reviewtext) {

//         try {
//             getConnection();


//             BasicDBObject doc = new BasicDBObject("title", "myReviews").append("productname", productname)
//                     .append("producttype", producttype).append("price",    (int) Double.parseDouble(price))
//                     .append("storeID", storeID).append("storeZip", storeZip)
//                     .append("storeCity", storeCity).append("storeState", storeState)
//                     .append("productOnSale", productOnSale).append("productmaker", productmaker)
//                     .append("manufacturerRebate", manufacturerRebate).append("username", username)
//                     .append("userAge", userAge).append("userGender", userGender)
//                     .append("userOccupation", userOccupation).append("reviewrating", Integer.parseInt(reviewrating)  )
//                     .append("reviewdate", reviewdate).append("reviewtext", reviewtext);
//             myReviews.insert(doc);
//             return "Successfull";
//         } catch (Exception e) {
//             return "UnSuccessfull";
//         }

//     }

//     public static HashMap<String, ArrayList<Review>> selectReview() {
//         HashMap<String, ArrayList<Review>> reviews = null;

//         try {

//             getConnection();
//             DBCursor cursor = myReviews.find();
//             reviews = new HashMap<String, ArrayList<Review>>();
//             while (cursor.hasNext()) {
//                 BasicDBObject obj = (BasicDBObject) cursor.next();

//                 if (!reviews.containsKey(obj.getString("productname"))) {
//                     ArrayList<Review> arr = new ArrayList<Review>();
//                     reviews.put(obj.getString("productname"), arr);
//                 }
//                 ArrayList<Review> listReview = reviews.get(obj.getString("productname"));
//                 Review review = new Review(obj.getString("productname"), obj.getString("producttype"),
//                         obj.getString("price"), obj.getString("storeID"), obj.getString("storeZip"),
//                         obj.getString("storeCity"), obj.getString("storeState"), obj.getString("productOnSale"),
//                         obj.getString("productmaker"), obj.getString("manufacturerRebate"), obj.getString("username"),
//                         obj.getString("userAge"), obj.getString("userGender"), obj.getString("userOccupation"),
//                         obj.getString("reviewrating"), obj.getString("reviewdate") , obj.getString("reviewtext"));
//                 // add to review hashmap
//                 listReview.add(review);

//             }
//             return reviews;
//         } catch (Exception e) {
//             reviews = null;
//             return reviews;
//         }

//     }

//     public static ArrayList<Bestrating> topProducts() {
//         ArrayList<Bestrating> Bestrate = new ArrayList<Bestrating>();
//         try {

//             getConnection();
//             int retlimit = 5;
//             DBObject sort = new BasicDBObject();
//             sort.put("reviewrating", -1);
//             DBCursor cursor = myReviews.find().limit(retlimit).sort(sort);
//             while (cursor.hasNext()) {
//                 BasicDBObject obj = (BasicDBObject) cursor.next();

//                 String prodcutnm = obj.get("productname").toString();
//                 String rating = obj.get("reviewrating").toString();
//                 Bestrating best = new Bestrating(prodcutnm, rating);
//                 Bestrate.add(best);
//             }

//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//         }
//         return Bestrate;
//     }
// }