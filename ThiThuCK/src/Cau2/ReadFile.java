package Cau2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {
	private static Map<Integer, String> m = new HashMap<>();
	private static ArrayList<String> errorCheck = new ArrayList<>();

	private static int GetMaxDayInMonth(int month, int year) {
		int[] days = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((year % 4 == 0 && year / 100 != 0) && year % 400 == 0)
			days[2] = 29;
		return days[month];
	}

	private static boolean checkValidNgsinh(String ngsinh) {
		String[] ds = ngsinh.split("[\\s/-]+");
		if (ds.length != 3)
			return false;
		int[] part = new int[3];
		for (int i = 0; i < ds.length; i++) {
			part[i] = Integer.valueOf(ds[i]);
		}
		if (part[1] > 12 || part[0] > GetMaxDayInMonth(part[1], part[2]))
			return false;
		return true;
	}

	private static HocVien CreateHocVien(int idx, String str) {
		String error = "";
		HocVien hv = new HocVien();
		String MaSV = str.substring(0, 10).trim();

		if (MaSV.length() < 10)
			error = "Sai dinh dang MaHocVien";
		else
			hv.setMaSV(MaSV);

		String HoTen = str.substring(10, 59).trim();
		hv.setHoTen(HoTen);

		String dateString = str.substring(59, 69);
		if (checkValidNgsinh(dateString)) {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			try {
				java.util.Date date = df.parse(dateString);
				java.sql.Date d = new Date(date.getTime());
				hv.setNgaySinh(d);
			} catch (ParseException e1) {
				if (error.length() != 0)
					error += ",";
				e1.printStackTrace();
			}
		} else {
			if (error.length() != 0)
				error += ",";
			error += "Sai dinh dang Ngaysinh";
		}

		String GioiTinh = str.substring(69, 72).trim();
		if (!GioiTinh.equals("Nam") && !GioiTinh.equals("Nu")) {
			if (error.length() != 0)
				error += ",";
			error += "Sai dinh dang GioiTinh";
		} else
			hv.setGioiTinh(GioiTinh);

		try {
			double diemThi = Double.valueOf(str.substring(72));
			if (diemThi < 0 || diemThi > 10)
				throw new Exception("Gia tri diem thi khong hop le");
			hv.setDiem(diemThi);
		} catch (Exception e) {
			if (error.length() != 0)
				error += ",";
			if (e.getMessage().equals("Gia tri diem thi khong hop le"))
				error += e.getMessage();
			else
				error += "Sai dinh dang diem thi";
		}
		if (error.length() == 0) {
			return hv;
		} else {
			m.put(idx, error);
			return null;
		}
	}

	private static void InsertHocVien(HocVien hv) {
		Connection cnn = JDBCUtils.getConnection();
		if (cnn != null) {
			try {
				String sql = "insert into HocVien values (?,?,?,?,?)";
				PreparedStatement pst = cnn.prepareStatement(sql);
				pst.setString(1, hv.getMaSV());
				pst.setString(2, hv.getHoTen());
				pst.setDate(3, hv.getNgaySinh());
				pst.setString(4, hv.getGioiTinh());
				pst.setDouble(5, hv.getDiem());
				pst.executeUpdate();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	private static void ReadFileMethod() {
		File f = new File("data/testError.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			int idx = 1;
			while (true) {
				String str = br.readLine();
				if ("".equals(str) || str == null)
					break;
				HocVien hv = CreateHocVien(idx, str);
				if (hv != null) {
					InsertHocVien(hv);
					System.out.println(hv.getMaSV());
				} else {
					String error = m.get(idx);
					errorCheck.add("Dong " + idx + ":" + error);
					System.out.println("Dong " + idx + ":" + error);
				}
				idx++;
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void WriteErrorIntoFile() {
		File f = new File("data/error.txt");
		try {
			FileWriter fr = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fr);
			for (String str : errorCheck) {
				bw.write(str);
				bw.newLine();
			}
			bw.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void test() {
		String str = "20/11/1990";
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.util.Date myDate = df.parse(str);
			Date d = new Date(myDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// ReadFileMethod();
		// WriteErrorIntoFile();
		String str = "FFDFDDFFDDD";
		Pattern p = Pattern.compile("((F)|(FD)|(FDD))+");
		Matcher m = p.matcher(str);
		if (m.matches())
			System.out.println("Yes");
		else
			System.out.println("NO");
	}
}
