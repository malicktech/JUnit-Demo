package demo6.mockito;

import java.util.Date;

import demo0.gettingstarted.gs1.Address;

public class User {

	private String login;
	private int age;
	private Address address;
	private Date birthday;

	public void setLogin(String login) {
		this.login = login;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String login) {
		super();
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	
	
	
	
}
