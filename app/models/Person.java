package models;
 
import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;
 
@Entity
public class Person extends Model {
	@Required
	public String nick;
	@Required	
	public String name;

	public Blob image;

	public String aliases;

 	public Person(String nick, String name) {
 		this.nick = nick;
		this.name = name;
	}

	public String toString() {
		return nick + " ( " + name + ", " +  (image.exists()? "has image" : "dosen't have image") + " )";
	}
}