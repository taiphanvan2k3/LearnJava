
public class Main {
	public static void main(String[] args) {
		Date d=new Date(1,2,1999);
		producer p=new producer("Huynh Lap","Viet Nam");
		film a=new film("Hoang Hau Ho Huynh",2022,p,70000,new Date(1,1,2000));
		System.out.println(a.getNgayChieu());
	}
}
