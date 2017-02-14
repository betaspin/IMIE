package imie.business;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imie.model.Person;
import imie.persistence.PersonDAO;

@WebServlet("/person/*")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW = "/person.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if (path == null) {
			
		} else if (path.matches("/save.*")) {
			Person person = new Person();
			person.setFirstname(request.getParameter("firstname"));
			person.setLastname(request.getParameter("lastname"));
			if (request.getParameter("id") != null && request.getParameter("id").isEmpty() == false) {
				person.setId(Integer.parseInt(request.getParameter("id")));
				new PersonDAO().update(person);
			} else {
				new PersonDAO().insert(person);
			}
		} else if (path.matches("/delete.*")) {
			Person person = new Person();
			person.setId(Integer.parseInt(request.getParameter("id")));
			new PersonDAO().delete(person);
		} else if (path.matches("/select.*")) {
			Person person = new Person();
			person.setId(Integer.parseInt(request.getParameter("id")));
			Person data = new PersonDAO().findOne(person);
			request.setAttribute("data", data);
		}
		request.setAttribute("list", new PersonDAO().findAll());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
