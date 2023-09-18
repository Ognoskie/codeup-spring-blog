package edu.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import org.hibernate.mapping.PrimaryKey;

@Entity
@Table(name = "dogs")
public class Dog {
	public Dog() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int(11) UNSIGNED NOT NULL AUTO_INCREMENT")
	private long id;

	@Column(columnDefinition = "tinyint(3) UNSIGNED NOT NULL")
	private long age;

	@Column(columnDefinition = "VARCHAR(200) NOT NULL")
	private String name;

	@Column(columnDefinition = "CHAR(2) DEFAULT 'XX' ")
	private String reside_state;


	public Dog(long id, long age, String name, String reside_state) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.reside_state = reside_state;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReside_state() {
		return reside_state;
	}

	public void setReside_state(String reside_state) {
		this.reside_state = reside_state;
	}

}
