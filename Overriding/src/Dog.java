
public class Dog extends Animal {
	public Dog() {
		super("KiKi");
	}

	@Override
	public void makeSound() {
		System.out.println("Gau gau");
	}

	@Override
	public void eat() {
		System.out.println("I like eating bones");
	}
}
