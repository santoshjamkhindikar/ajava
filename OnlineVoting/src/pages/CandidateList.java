package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VoterClass;
import pojos.Candidates;
import pojos.Voters;
/**
 * Servlet implementation class CandidateList
 */
@WebServlet("/list")
public class CandidateList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	VoterClass voterObj = null;
	
	public void init(ServletConfig config) throws ServletException 
	{
		try 
		{
			voterObj = new VoterClass();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void destroy() 
	{
		try 
		{
			voterObj.cleanUp();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		Voters voter = null;
		try(PrintWriter pw = response.getWriter())
		{
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			
			
			try{
				voter = voterObj.validateCustomer(email, pass);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(voter == null)
			{
				pw.print("<h2>Invalid User"
						+ "<a href=login.html>Login Again</a>"
						+ "</h2>");
			}
			else
			{
				pw.print("<form action='index.html' method='post'>");
				ArrayList<Candidates> candidateList = null;
				try {
					candidateList = voterObj.getAllCandidates();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(Candidates canObj:candidateList)
				{
				//	pw.print("<input type=\"radio\" name=\"cadidateName\" id=\"cadidateId\" value=\"");
					pw.print(canObj.getName());
					pw.print("</br>");
				//	pw.print("\"> </br>");
					//pw.print(canObj.getName());
				}
				pw.print("<input type=submit name=Submit value=Login>");
				pw.print("</form>");
				
			}

		}
	}

}
