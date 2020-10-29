import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


@WebServlet("/BookingCustomer")

/* 
	Home class uses the printHtml Function of Utilities class and prints the Header,LeftNavigationBar,
	Content,Footer of Game Speed Application.

*/

public class BookingCustomer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		List<Book> bookList = getBookListFromDataBase("1");		
		Utilities utility = new Utilities(request,pw);
		utility.printHtml("Header.html");


		pw.println("<div class='6u'><section><header><h2>Review Booking</h2><span class='byline'></span> <br><hr><header></section>");
		pw.println("<div><table><tr><th>BookId</th><th>Provider Name</th><th>Time</th><th>Note</th><th>Cancel</th></tr>");
		for (Book book : bookList) {
			pw.println("<form method='POST' action='BookingCustomer'><tr>");
			pw.println("<td>"+ book.getId() + "</td>");
			pw.println("<td>"+ book.getName() + "</td>");
			pw.println("<td>"+ book.getTime() + "</td>");
			pw.println("<td>"+ book.getNote() + "</td>");
			pw.println("<td><input type='submit' class='btnbuy' name='cancel' value='"+book.getId()+"'style='float: right;height: 20px margin: 20px; margin-right: 10px;'></input></td></tr></form>");

		}
		pw.println("</table></div></div>");

		utility.printHtml("Footer.html");

	}

	private List<Book> getBookListFromDataBase(String userId) {
		ArrayList<Book> bookList = new ArrayList();
		bookList.add(new Book("1", "Doctor1", "13:00 10/20/2020", "check my teeth"));
		bookList.add(new Book("2", "company1", "16:00 10/20/2020", "talk about health insurance"));
		return bookList;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cancelId = request.getParameter("cancel");
		System.out.println("Cancel: " + cancelId);
		doGet(request, response);
	}





}
