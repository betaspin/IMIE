package fr.imie.cours;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter()
		.format("Protocol: %s<br/>Adresse locale: %s<br/>", request.getProtocol(), request.getLocalAddr())
		.append(request.getRemoteAddr()+"<br/>")
		.append(request.getLocalName()+"<br/>")
		.append(request.getRemoteHost()+"<br/>")
		.append(request.getServerName()+"<br/>")
		.append(request.getLocalPort()+"<br/>")
		.append(request.getScheme()+"<br/>")
		.append("prenom : " + request.getParameter("prenom") + "<br/>")
		.append("nom : " + request.getParameter("nom") + "<br/>");
		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()){
			String param = params.nextElement();
			String value = request.getParameter(param);
			response.getWriter().append(param);
			
			request.getParameter(param + " : " + value + "<br/>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
