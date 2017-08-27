package pl.chemik77.controllers.services;

import java.util.*;

import pl.chemik77.model.Person;

public class ComparatorC implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getLastName().compareTo(o2.getLastName());
	}

}
