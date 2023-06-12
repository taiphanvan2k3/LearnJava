public class Main {
	public static void main(String[] args) {
		NgaySinh a1=new NgaySinh(24,3,2003);
		NgaySinh a2=new NgaySinh(24,3, 2003);
		Lop l1=new Lop("21TCLC_DT3", "CNTT");
		Lop l2=new Lop("21T_DT","CNTT");
		SinhVien sv1=new SinhVien("102","ABC", a1, 9.2, l1);
		SinhVien sv2=new SinhVien("103", "CDE", a2, 9, l2);
		System.out.println(sv1.checkSameDob(sv1));
	}
}
