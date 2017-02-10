package imie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import imie.model.UserDTO;
import imie.persistence.UserDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Boolean connect = false; 
		
		//Tests
		if(login.isEmpty()){
			request.setAttribute("error", "Le mail est obligatoire");
		}else if(!login.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")){
			request.setAttribute("error", "Le mail n'est pas au bon format");
		}else{
			UserDAO userDAO = new UserDAO();
			UserDTO user = userDAO.getUser(login, password);
			if(user != null){
				HttpSession session = request.getSession();
				session.setAttribute("user", user);				
				connect = true;				
			}else{
				request.setAttribute("error", "Login ou mot de passe erronné");
			}
		}
		
		if(connect){
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
