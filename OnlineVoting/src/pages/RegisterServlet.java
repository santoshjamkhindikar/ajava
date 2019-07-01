package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VoterClass;
import pojos.Voters;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
				
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()){
			VoterClass bookObj = new VoterClass();
			Voters cust = new Voters();
			cust.setName(userName);
			cust.setEmailId(email);
			cust.setPassword(password);
			cust.setStatus("not Voted");
			bookObj.insertCustomerData(cust);
			bookObj.cleanUp();
			pw.print("<a href=indix.html>Login</a>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
