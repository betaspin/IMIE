package imie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class forwardInclude
 */
@WebServlet("/forwardInclude")
public class forwardInclude extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();		 
		out.println("<html><head></head><body>");
		out.println("<form name=\"\" action=\"forwardInclude\" method=\"post\">");
		out.println("<label>Forward</label><input type=\"radio\" name=\"dispatch\" value=\"forward\"/>");
		out.println("<label>Include</label><input type=\"radio\" name=\"dispatch\" value=\"include\"/>");
		out.println("<button type=\"submit\">Envoyer</button>");
		
		String dispatch = request.getParameter("dispatch");
		
		if(dispatch != null && dispatch.equals("forward")){
			request.getRequestDispatcher("/servletb2").forward(request, response);
		}else if(dispatch != null && dispatch.equals("include")){
			request.getRequestDispatcher("/servletb2").include(request, response);
		}
		
		out.println("</form>");
		out.println("<html><head></head><body>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
