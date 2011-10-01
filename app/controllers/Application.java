package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.Cookie;
import java.util.*;
import models.*;

public class Application extends Controller {

	public static void view(long id) {
		List people = Person.find("order by lower(nick) asc").fetch();
		Person person = Person.findById(id);
		render(people, person); 
	}
	public static void bndex() {
		response.setCookie("design", "b", "14d");
		gridindex();
	}
	public static void cndex() {
		response.setCookie("design", "c", "14d");
		gridindex();	
	}
	public static void gridindex() {
		List people = Person.find("accepted = true order by lower(nick) asc").fetch();
		Cookie c = Http.Request.current().cookies.get("design");
		String co = (c != null ? c.value : "b");	
		render(people, co); 
	}
	public static void userPhoto(long id) {
		Person person = Person.findById(id);
		notFoundIfNull(person);
		//response.setHeader("X-This-Is-Image-Of", person.nick);
                response.setContentTypeIfNotSet(person.image.type());
		renderBinary(person.image.get());
	}
	
}
