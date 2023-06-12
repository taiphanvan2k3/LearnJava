
public class test {
	public static void main(String[] args) {
		//C1:Box2<String> b2=new Box2<String>("abc");
		//C2:Box2 b=new Box2<String>("abc");
		//c3:
		Box2<String> b=new Box2<>("abc");
		System.out.println(b.getValue());
	}
}
