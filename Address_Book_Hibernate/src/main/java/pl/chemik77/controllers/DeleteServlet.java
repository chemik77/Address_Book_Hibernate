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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Service service = new Service();
		List<Person> persons = service.getPersonsList();
		Person person = service.getRecord(Person.class, id);
		service.deleteRecord(Person.class, id);
		service.deleteRecord(Address.class, person.getAddress().getId());
		service.deleteRecord(Contact.class, person.getContact().getId());

		request.setAttribute("persons", persons);

		String jsp = "/read";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(jsp);
		rd.forward(request, response);

	}

}
