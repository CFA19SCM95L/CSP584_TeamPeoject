import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.time.*;

@WebServlet("/TrendingDoctor")

public class TrendingDoctor extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        //list = getTenDoctor();
        //alist = MongoDBDataStoreUtilities.topTenDoctorReview();
        //System.out.println("alist.size = "+alist.size());
        Utilities utility = new Utilities(request, pw);

        /*if (!utility.isLoggedin()) {
            HttpSession session = request.getSession(true);
            System.out.println("LogIn: Not");
        } else {
            HttpSession session = request.getSession();
            User user = utility.getUser();
        }*/

        utility.printHtml("TrendingHeader.html");
        pw.println("<button class='tablink' id='myButton'>News</button>");
        //pw.println("");
        pw.println("<button class=\"tablink\" onclick=\"openPage('Doctors', this, 'grey')\" id=\"defaultOpen\">Doctors</button>");
        pw.println("<button class=\"tablink\" id=\"hospitalButton\">Hospitals</button>");
        pw.println("<button class=\"tablink\" id=\"incButton\">Insurance Company</button>");
        pw.println("<div id=\"Doctors\" class=\"tabcontent\">");
        pw.println("<div class=\"9u skel-cell-important\">");
        pw.println("<section><header>");
        pw.println("<h2>Top 10 most liked doctors</h2>");
        pw.println("<span class=\"byline\"></span>");
        pw.println("<br></header></section></div>");
        pw.println("<div><table>");
        pw.println("<tr>");
        pw.println("<th>Name</th>");
        pw.println("<th>Department</th>");
        pw.println("<th>Location</th>");
        //pw.println("<th>Outpatient Time</th>");
        pw.println("<th>Rating</th>");
        pw.println("<th>Detailed Page</th></tr>");



//        //ArrayList<DoctorDetail> list=new ArrayList<DoctorDetail>();
        ArrayList<TopRatingDoc> alist=MongoDBDataStoreUtilities.topDoctors();
       for(TopRatingDoc doc: alist) {

            pw.println("<tr><td>");
            pw.println(doc.getId());
            pw.println("</td><td>");
            //pw.println(TopRatingDoc.getDepartment()+ "b");
            pw.println("</td><td>");
            //pw.println(doctorDetail.getLocation()+ "c");
            pw.println("</td><td>");
            pw.println(doc.getReviewrating() + "/10");
            pw.println("</td><td>");
            pw.println("<a href=\"https://google.com\" target=\"blank\">click for details</a>");
            pw.println("</td></tr>");
         }


        pw.println("</table></div></div></div>");
        utility.printHtml("TrendingFooter.html");
    }
}