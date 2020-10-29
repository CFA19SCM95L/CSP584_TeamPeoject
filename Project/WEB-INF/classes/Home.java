import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet("/Home")

/*
 * Home class uses the printHtml Function of Utilities class and prints the
 * Header,LeftNavigationBar, Content,Footer of Game Speed Application.
 * 
 */

public class Home extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		Utilities utility = new Utilities(request, pw);
		utility.printHtml("Header.html");
		// utility.printHtml("Content.html");
		ArrayList<News> newsList = ApiUtilities.getHealthNews();
		// Head news
		String headNews = newsList.get(0).getTitle();
		pw.print("<div class='6u'><section><header>");
		pw.print("<h2>" + newsList.get(0).getTitle() + "</h2>");
		pw.print("<span class='byline'>" + newsList.get(0).getPublishedAt() + ". By " + newsList.get(0).getAuthor()
				+ "</span></header>");
		pw.print("<p>" + newsList.get(0).getDescription() + "</p>");
		pw.print("<p><a href='DetailedNews?Title=" + newsList.get(0).getTitle() + "'><img src="
				+ newsList.get(0).getUrlToImage() + " 	alt='' width='550' height='300'></a></p>");
		pw.print("<a href='DetailedNews?Title=" + newsList.get(0).getTitle()
				+ "' class='button'>More Details</a></section></div>");
		// Other news
		pw.print("<div class='3u'><section class='sidebar'><header><h2>Other NEWS</h2></header>");
		pw.print("<ul class='style2'>");
		int i = 0;
		for (News news : newsList) {
			if (!news.getTitle().equals(headNews) && i < 3) {
				pw.print("<li><a href='DetailedNews?Title=" + news.getTitle() + "'><img src=" + news.getUrlToImage()
						+ " alt='' width='80' height='80'><p>" + news.getTitle() + "</p></a></li>");
				i++;
			}

		}

		pw.print("</ul></section></div>");

		utility.printHtml("Footer.html");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("action").equals("Login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("Login : " + username + ":" + password);
		} else if (request.getParameter("action").equals("AddReview") ) {
			String review = request.getParameter("review");
			String rate = request.getParameter("rate");
			System.out.println("AddReview : " + review + ":" + rate);

		}
		doGet(request, response);
	}

}
