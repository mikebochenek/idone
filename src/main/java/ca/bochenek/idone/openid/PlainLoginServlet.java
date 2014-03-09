package ca.bochenek.idone.openid;

import ca.bochenek.idone.data.UserProducer;
import ca.bochenek.idone.entity.User;

import java.io.IOException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlainLoginServlet extends javax.servlet.http.HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
	
	@EJB
	private UserProducer userProducer;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if (username != null && username.length() > 0) {
			
			//User user = userProducer.create(username, password);
			User user = userProducer.login(username, password);

			if (user == null) {
				this.getServletContext().getRequestDispatcher("/#/signin").forward(req, resp);
				
			} else {
				req.getSession(true).setAttribute("user", user);
				
				this.getServletContext().getRequestDispatcher("/#/home").forward(req, resp);
			}
		} else {
			
			String id = req.getParameter("id");
			
			System.out.println ("I guess we are doing the openID thing");
		}
		
		
	}
}
