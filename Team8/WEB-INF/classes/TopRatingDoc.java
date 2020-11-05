import java.io.IOException;
import java.io.*;




public class TopRatingDoc implements Serializable {
    private static String id;
    private static String reviewrating;

    public TopRatingDoc(String id, String reviewrating) {
        this.id = id;
        this.reviewrating = reviewrating;
    }

    public static String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public static String getReviewrating() {
        return reviewrating;
    }

    public void setReviewrating(String reviewrating) {
        this.reviewrating = reviewrating;
    }
}