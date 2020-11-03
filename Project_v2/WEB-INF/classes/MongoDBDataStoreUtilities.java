import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.AggregationOutput;

import java.util.*;

public class MongoDBDataStoreUtilities {
    static DBCollection doctorReviews;
    static DBCollection hospitalReviews;
    static DBCollection companyReviews;

    public static void getConnection() {
        MongoClient mongo;
        mongo = new MongoClient("localhost", 27017);

        DB db = mongo.getDB("CustomerReviews");
        doctorReviews = db.getCollection("doctorReviews");
        hospitalReviews = db.getCollection("hospitalReviews");
        companyReviews = db.getCollection("companyReviews");
    }

    public static String insertDoctorReview(String doctorId, String reviewrating, String reviewdate,
            String reviewtext) {

        try {
            getConnection();

            BasicDBObject doc = new BasicDBObject("title", "doctorReviews").append("doctorId", doctorId)
                    .append("reviewrating", Integer.parseInt(reviewrating)).append("reviewdate", reviewdate)
                    .append("reviewtext", reviewtext);
            doctorReviews.insert(doc);
            return "Successfull";
        } catch (Exception e) {
            return "UnSuccessfull";
        }

    }

    public static HashMap<String, ArrayList<Review>> selectDoctorReview() {
        HashMap<String, ArrayList<Review>> reviews = null;

        try {

            getConnection();
            DBCursor cursor = doctorReviews.find();
            reviews = new HashMap<String, ArrayList<Review>>();
            while (cursor.hasNext()) {
                BasicDBObject obj = (BasicDBObject) cursor.next();

                if (!reviews.containsKey(obj.getString("doctorId"))) {
                    ArrayList<Review> arr = new ArrayList<Review>();
                    reviews.put(obj.getString("doctorId"), arr);
                }
                ArrayList<Review> listReview = reviews.get(obj.getString("doctorId"));
                Review review = new Review(obj.getString("doctorId"), obj.getString("reviewrating"), obj.getString("reviewdate"), obj.getString("reviewtext"));
                // add to review hashmap
                listReview.add(review);

            }
            return reviews;
        } catch (Exception e) {
            reviews = null;
            return reviews;
        }

    }

    // public static ArrayList<Bestrating> topProducts() {
    // ArrayList<Bestrating> Bestrate = new ArrayList<Bestrating>();
    // try {

    // getConnection();
    // int retlimit = 5;
    // DBObject sort = new BasicDBObject();
    // sort.put("reviewrating", -1);
    // DBCursor cursor = myReviews.find().limit(retlimit).sort(sort);
    // while (cursor.hasNext()) {
    // BasicDBObject obj = (BasicDBObject) cursor.next();

    // String prodcutnm = obj.get("productname").toString();
    // String rating = obj.get("reviewrating").toString();
    // Bestrating best = new Bestrating(prodcutnm, rating);
    // Bestrate.add(best);
    // }

    // } catch (Exception e) {
    // System.out.println(e.getMessage());
    // }
    // return Bestrate;
    // }
}