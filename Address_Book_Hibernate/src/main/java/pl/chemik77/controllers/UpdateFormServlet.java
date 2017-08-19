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

@WebServlet("/update")
public class UpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Service service = new Service();
		List<Person> persons = service.getPersonsList();
		Person person = service.getRecord(Person.class, id);
		Contact contact = service.getRecord(Contact.class, person.getContact().getId());
		Address address = service.getRecord(Address.class, person.getAddress().getId());

		request.setAttribute("persons", persons);
		request.setAttribute("person", person);
		request.setAttribute("contact", contact);
		request.setAttribute("address", address);

		String jsp = "/updateForm.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(jsp);
		rd.forward(request, response);

	}

}
