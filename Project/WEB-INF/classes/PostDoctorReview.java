import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@WebServlet("/PostDoctorReview")

/* 
	Home class uses the printHtml Function of Utilities class and prints the Header,LeftNavigationBar,
	Content,Footer of Game Speed Application.

*/

public class PostDoctorReview extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		
		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");
		pw.println("<div class='6u'><section><header><h2>Add Review</h2></header>");
		pw.println("<form method='POST' action='Home'>");
		pw.println("<table style='width:100%'>");
		pw.println("<tr><td><h3>Review</h3></td><td>");
		pw.println("<textarea name='review' rows='4' cols='50' class='input' required></textarea></td></tr>");


		pw.println("<tr><td><h3>Rate</h3></td><td>");
		pw.println("<select name='rate' class='input'>");
		pw.println("<option value='0' selected>0</option>");
		pw.println("<option value='1'>1</option>");
		pw.println("<option value='2'>2</option>");
		pw.println("<option value='3'>3</option>");
		pw.println("<option value='4'>4</option>");
		pw.println("<option value='5'>5</option>");
		pw.println("<option value='6'>6</option>");
		pw.println("<option value='7'>7</option>");
		pw.println("<option value='8'>8</option>");
		pw.println("<option value='9'>9</option>");
		pw.println("<option value='10'>10</option>");

		pw.println("</select></td></tr></table>");
		pw.println("<input type='submit' class='btnbuy' name='action' value='AddReview'style='float: right;height: 20px margin: 20px; margin-right: 10px;'></input>");
		pw.println("</form></section></div>");


		utility.printHtml("Footer.html");

	}

}
