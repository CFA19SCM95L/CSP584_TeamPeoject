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

    public static void insertDefaultDoctorReview() {
        insertDoctorReview("2", "7", "2020-11-01 16:59:17.007", "review1");
        insertDoctorReview("17", "4", "2020-11-01 16:59:17.007", "review7");
        insertDoctorReview("2", "2", "2020-11-01 16:59:17.007", "review8");
        insertDoctorReview("5", "4", "2020-11-01 16:59:17.007", "review2");
        insertDoctorReview("9", "6", "2020-11-01 16:59:17.007", "review3");
        insertDoctorReview("7", "8", "2020-11-02 23:34:10.917", "review4");
        insertDoctorReview("11", "3", "2020-11-02 23:34:10.917", "review5");
        insertDoctorReview("12", "9", "2020-11-02 23:34:10.917", "review6");
        insertDoctorReview("12", "4", "2020-11-03 11:11:10.927", "review7");
        insertDoctorReview("16", "8", "2020-11-03 11:14:10.917", "review8");
        insertDoctorReview("19", "7", "2020-11-04 12:34:10.917", "review9");
        insertDoctorReview("15", "4", "2020-11-05 22:14:10.917", "review10");
        insertDoctorReview("24", "6", "2020-11-06 20:30:10.917", "review11");
        insertDoctorReview("12", "9", "2020-11-07 13:30:10.917", "review12");
        insertDoctorReview("24", "10", "2020-11-08 15:34:10.917", "review13");
        insertDoctorReview("23", "6", "2020-11-08 18:34:10.917", "review14");
        insertDoctorReview("18", "3", "2020-11-09 09:34:10.917", "review15");
        insertDoctorReview("16", "8", "2020-11-09 10:34:10.917", "review16");
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

    public static  ArrayList <TopRatingDoc> topDoctors(){
        ArrayList <TopRatingDoc> list = new ArrayList <TopRatingDoc> ();
        try{
            getConnection();

            DBObject groupDoctors = new BasicDBObject("_id","$doctorId");
            //groupDoctors.put("average",new BasicDBObject("$avg","$reviewrating"));
            BasicDBObject avgRate = new BasicDBObject("$avg","$reviewrating");
            groupDoctors.put("averageRate",avgRate);
            DBObject group = new BasicDBObject("$group",groupDoctors);
            DBObject limit=new BasicDBObject();
            limit=new BasicDBObject("$limit",10);

            DBObject sortFields = new BasicDBObject("averageRate",-1);
            DBObject sort = new BasicDBObject("$sort",sortFields);
            AggregationOutput output = doctorReviews.aggregate(group,sort,limit);

            for (DBObject res : output.results()) {

                String doctorId =(res.get("_id")).toString();
                String rateAvg = (res.get("averageRate")).toString();
                TopRatingDoc doc = new TopRatingDoc(doctorId,rateAvg);
                list.add(doc);
            }


//            DBCursor cursor = doctorReviews.find().sort(new BasicDBObject("reviewrating",-1)).limit(10);
//            while(cursor.hasNext()) {
//                BasicDBObject obj = (BasicDBObject) cursor.next();
//
//                String prodcutnm = obj.get("doctorId").toString();
//                String rating = obj.get("reviewrating").toString();
//                Review review = new Review(prodcutnm,rating,obj.getString("reviewdate"), obj.getString("reviewtext"));
//                list.add(review);
//            }

        }catch (Exception e){ System.out.println(e.getMessage());}
        return list;
    }

//    public static  ArrayList <Review> topDoctors(){
//        ArrayList <Review> list = new ArrayList <Review> ();
//        try{
//            getConnection();
//
////            DBObject groupDoctors = new BasicDBObject("_id","$doctorId");
////            groupDoctors.put("average",new BasicDBObject("$avg","$reviewrating"));
////            DBObject group = new BasicDBObject("$group",groupDoctors);
////            DBObject limit=new BasicDBObject();
////            limit=new BasicDBObject("$limit",10);
////
////            DBObject sortFields = new BasicDBObject("average",-1);
////            DBObject sort = new BasicDBObject("$sort",sortFields);
////            AggregationOutput output = doctorReviews.aggregate(group,sort,limit);
////
////            for (DBObject res : output.results()) {
////
////                String doctorId =(res.get("_id")).toString();
////                String rateAvg = (res.get("average")).toString();
////                TopRatingDoc doc = new TopRatingDoc(doctorId,rateAvg);
////                list.add(doc);
////            }
//
//
//            DBCursor cursor = doctorReviews.find().sort(new BasicDBObject("reviewrating",-1)).limit(10);
//            while(cursor.hasNext()) {
//                BasicDBObject obj = (BasicDBObject) cursor.next();
//
//                String prodcutnm = obj.get("doctorId").toString();
//                String rating = obj.get("reviewrating").toString();
//                Review review = new Review(prodcutnm,rating,obj.getString("reviewdate"), obj.getString("reviewtext"));
//                list.add(review);
//            }
//
//        }catch (Exception e){ System.out.println(e.getMessage());}
//        return list;
//    }

}