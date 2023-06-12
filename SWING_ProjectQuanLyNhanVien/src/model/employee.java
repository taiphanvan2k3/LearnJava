package model;

import java.io.Serializable;
import java.util.Objects;

import helper.formatCurrency;

public class employee implements Serializable {

	private String id, name, email;
	private double salary;
	private int age;
	public employee() {

	}

	public employee(String id, String name,int age, String email, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		employee other = (employee) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "employee [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + ", age=" + age
				+ "]";
	}
	
	public Object[] covertIntoRow() {
		Object[] row= new Object[] {
			id,name,age,email,formatCurrency.format(salary)	
		};
		return row;
	}
}
