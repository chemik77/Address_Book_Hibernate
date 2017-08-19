package pl.chemik77.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.chemik77.controllers.services.Service;
import pl.chemik77.model.Person;

@WebServlet("/updatePerson")
public class UpdatePersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Service service = new Service();
		List<Person> persons = service.getPersonsList();
		service.updatePerson(request);

		request.setAttribute("persons", persons);

		String jsp = "/read";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(jsp);
		rd.forward(request, response);
		
	}

}
