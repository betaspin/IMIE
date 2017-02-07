package imie;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class session
 */
@WebServlet("/session")
public class session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		DateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		session.setAttribute("ID", request.getParameter("ID"));
		
		response.getWriter().format("id: %s \nDate de création: %s \nDate dernier accès: %s \nID utilisateur: %s \n", session.getId(), simpleFormat.format(session.getCreationTime()), simpleFormat.format(session.getLastAccessedTime()), session.getAttribute("ID"));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
