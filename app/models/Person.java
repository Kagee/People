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
	public String bio;
	public Blob image;
	public boolean op;	
	public boolean accepted;
	public String aliases;

 	public Person(String nick, String name) {
 		this.nick = nick;
		this.name = name;
	}
	public String formattedNick() {
		return (op ? "@" : "") + nick;
	}
	public String toString() {
		return nick + " ( " + name + " )";
	}
}
