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

@WebServlet("/TrendingCompany")

public class TrendingCompany extends HttpServlet {


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
        pw.println("<button class=\"tablink\" id=\"hospitalButton\">Hospitals</button>");
        pw.println("<button class=\"tablink\" onclick=\"openPage('Company', this, 'grey')\" id=\"defaultOpen\">Insurance Company</button>");
        pw.println("<div id=\"Company\" class=\"tabcontent\">");
        pw.println("<div class=\"9u skel-cell-important\">");
        pw.println("<section><header>");
        pw.println("<h2>Top 5 Insurance Company</h2>");
        pw.println("<span class=\"byline\"></span>");
        pw.println("<br></header></section></div>");
        pw.println("<div><table>");
        pw.println("<tr>");
        pw.println("<th>Name</th>");
        //pw.println("<th>Department</th>");
        pw.println("<th>Location</th>");
        pw.println("<th>Telephone</th>");
        pw.println("<th>Rating</th>");
        pw.println("<th>Review</th></tr>");

        //NEED TO CHANGE
        pw.println("<tr>");
        pw.println("<td>United Healthcare</td>");
        pw.println("<td>Chicago,IL.</td>");
        pw.println("<td>(872)241-1585</td>");
        pw.println("<td>5/5</td>");
        pw.println("<td><a href=\"https://google.com\" target=\"blank\">click for details</a></td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td>Mutual of Omaha Insurance Co</td>");
        pw.println("<td>Chicago,IL.</td>");
        //pw.println("<td>Open 24 hours</td>");
        pw.println("<td>(268)222-4876</td>");
        pw.println("<td>4.8/5</td>");
        pw.println("<td><a href=\"https://google.com\" target=\"blank\">click for details</a></td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td>Blue Cross Health Brokers</td>");
        pw.println("<td>San Jose, CA</td>");
        //pw.println("<td>9am-15pm Mon-Fri</td>");
        pw.println("<td>(987)222-4876</td>");
        pw.println("<td>4.7/5</td>");
        pw.println("<td><a href=\"https://google.com\" target=\"blank\">click for details</a></td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td>BMC HealthNet Plan</td>");
        pw.println("<td>Boston, MA</td>");
        //pw.println("<td>8am-16pm Mon-Fri</td>");
        pw.println("<td>(635)222-4876</td>");
        pw.println("<td>4.6/5</td>");
        pw.println("<td><a href=\"https://google.com\" target=\"blank\">click for details</a></td>");
        pw.println("</tr>");
        pw.println("<tr>");
        pw.println("<td>Humana</td>");
        pw.println("<td>Miami, FL</td>");
        //pw.println("<td>11am-18pm Mon-Fri</td>");
        pw.println("<td>(967)489-4876</td>");
        pw.println("<td>4.5/5</td>");
        pw.println("<td><a href=\"https://google.com\" target=\"blank\">click for details</a></td>");
        pw.println("</tr>");





//        //ArrayList<DoctorDetail> list=new ArrayList<DoctorDetail>();
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
//         }


        pw.println("</table></div></div></div></div>");
        utility.printHtml("TrendingFooter.html");
    }
}