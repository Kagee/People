package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import models.*;

public class Application extends Controller {

	public static void view(long id) {
		List people = Person.find("order by lower(nick) asc").fetch();
		Person person = Person.findById(id);
		render(people, person); 
	}
	public static void bndex() {
		gridindex(true);
	}
	public static void cndex() {
		gridindex(false);	
	}
	public static void gridindex(boolean css) {
		List people = Person.find("order by lower(nick) asc").fetch();
		render(people, css); 
	}
	public static void userPhoto(long id) {
		final Person person = Person.findById(id);
		notFoundIfNull(person);
		response.setContentTypeIfNotSet(person.image.type());
		renderBinary(person.image.get());
	}
}
