
public class Animal {
	protected String name;

	public Animal(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void makeSound() {
		System.out.println("Some sound");
	}

	public void eat() {
		System.out.println("I'm eating");
	}
}
