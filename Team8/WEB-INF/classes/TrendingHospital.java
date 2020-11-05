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

@WebServlet("/TrendingHospital")

public class TrendingHospital extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
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
        pw.println("<button class=\"tablink\" id=\"doctorButton\">Doctors</button>");
        pw.println("<button class=\"tablink\" onclick=\"openPage('Hostipals', this, 'grey')\" id=\"defaultOpen\">Hospitals</button>");
        pw.println("<button class=\"tablink\" id=\"incButton\">Insurance Company</button>");
        pw.println("<div id=\"Hostipals\" class=\"tabcontent\">");
        pw.println("<div class=\"9u skel-cell-important\">");
        pw.println("<section><header>");
        pw.println("<h2>Top 5 most liked hospitals</h2>");
        pw.println("<span class=\"byline\"></span>");
        pw.println("<br></header></section></div>");
        pw.println("<div><table>");
        pw.println("<tr>");
        pw.println("<th>Hospital</th>");
        pw.println("<th>Location</th>");
        pw.println("<th>Hours</th>");
        pw.println("<th>Telephone</th>");
        pw.println("<th>Rating</th>");
        pw.println("<th>Detailed Page</th></tr>");



        //NEED TO CHANGE
        pw.println("<tr>");
        pw.println("<td>Lubbock DT</td>");
        pw.println("<td>Lubbock,TX</td>");
        pw.println("<td>Open 24 hours</td>");
        pw.println("<td>(111)222-4876</td>");
        pw.println("<td>5/5</td>");
        pw.println("<td><a href=\"https://google.com\" target=\"blank\">click for details</a></td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td>California Medical Center</td>");
        pw.println("<td>Sabta Ana,CA</td>");
        pw.println("<td>Open 24 hours</td>");
        pw.println("<td>(268)222-4876</td>");
        pw.println("<td>4.9/5</td>");
        pw.println("<td><a href=\"https://google.com\" target=\"blank\">click for details</a></td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td>Florida Therapy Center</td>");
        pw.println("<td>Tampa,FL</td>");
        pw.println("<td>9am-15pm Mon-Fri</td>");
        pw.println("<td>(987)222-4876</td>");
        pw.println("<td>4.9/5</td>");
        pw.println("<td><a href=\"https://google.com\" target=\"blank\">click for details</a></td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td>NewYork-Presbyterian Lower Manhattan Hospital</td>");
        pw.println("<td>New York City, NY</td>");
        pw.println("<td>8am-16pm Mon-Fri</td>");
        pw.println("<td>(635)222-4876</td>");
        pw.println("<td>4.8/5</td>");
        pw.println("<td><a href=\"https://google.com\" target=\"blank\">click for details</a></td>");
        pw.println("</tr>");pw.println("<tr>");
        pw.println("<td>Chicago DT</td>");
        pw.println("<td>Chicago,IL</td>");
        pw.println("<td>11am-18pm Mon-Fri</td>");
        pw.println("<td>(967)489-4876</td>");
        pw.println("<td>4.5/5</td>");
        pw.println("<td><a href=\"https://google.com\" target=\"blank\">click for details</a></td>");
        pw.println("</tr>");


//        ArrayList<TopRatingDoc> alist=MongoDBDataStoreUtilities.topDoctors();
//       for(TopRatingDoc doc: alist) {
//
//            pw.println("<tr><td>");
//            pw.println(doc.getId());
//            pw.println("</td><td>");
//            //pw.println(TopRatingDoc.getDepartment()+ "b");
//            pw.println("</td><td>");
//            //pw.println(doctorDetail.getLocation()+ "c");
//            pw.println("</td><td>");
//            pw.println(doc.getReviewrating() + "/10");
//            pw.println("</td><td>");
//            pw.println("<a href=\"https://google.com\" target=\"blank\">click for details</a>");
//            pw.println("</td></tr>");
 //        }


        pw.println("</table></div></div></div>");
        utility.printHtml("TrendingFooter.html");
    }
}