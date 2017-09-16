package com.raj.shashi.spring.vertx;

/**
 * @author rajs
 *
 */
public class User {

	private String name;
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + "]";
	}

}
