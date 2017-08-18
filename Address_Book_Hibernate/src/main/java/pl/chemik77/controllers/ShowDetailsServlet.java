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
import pl.chemik77.model.Address;
import pl.chemik77.model.Contact;
import pl.chemik77.model.Person;

@WebServlet("/showDetails")
public class ShowDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Service service = new Service();
		List<Person> persons = service.getPersonsList();
		Address address = service.getRecord(Address.class, id);
		Contact contact = service.getRecord(Contact.class, id);

		request.setAttribute("persons", persons);
		request.setAttribute("address", address);
		request.setAttribute("contact", contact);

		String jsp = "/index.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(jsp);
		rd.forward(request, response);
	}

}
