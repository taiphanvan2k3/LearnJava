
public class Cat extends Animal{
	public Cat() {
		super("kitty");
	}

	@Override
	public void makeSound() {
		System.out.println("Meow meow");
	}

	@Override
	public void eat() {
		System.out.println("I like eating fish");
	}
}
