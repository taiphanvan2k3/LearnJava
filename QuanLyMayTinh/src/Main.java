
public class Main {
	public static void main(String[] args) {
		NgaySanXuat d=new NgaySanXuat(23, 7, 2022);
		Country c=new Country("3400","Viet Nam");
		HangSx h=new HangSx("Dell", c);
		MayTinh computer=new MayTinh(h, d,17000, 36);
		System.out.println(computer.tenQuocGiaSx());
	}
}
