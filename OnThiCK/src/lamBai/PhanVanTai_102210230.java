package lamBai;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyPair;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PhanVanTai_102210230 extends JFrame implements ActionListener {
	private JTextField txtCanhC;
	private JTextField txtCanhB;
	private JTextField txtCanhA;
	private JButton btnArea;
	private JButton btnChuVi;
	private JTextField txtKetQua;

	private void initComponents() {
		this.setSize(600, 350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);

		JPanel pnlNhapCanh = new JPanel();
		pnlNhapCanh.setLayout(new GridLayout(3, 2, 0, 10));
		pnlNhapCanh.setBorder(new EmptyBorder(10, 40, 0, 40));

		JLabel lblCanhA = new JLabel("Độ dài cạnh a:");
		txtCanhA = new JTextField(20);
		JLabel lblCanhB = new JLabel("Độ dài cạnh b:");
		txtCanhB = new JTextField(20);
		JLabel lblCanhC = new JLabel("Độ dài cạnh c:");
		txtCanhC = new JTextField(20);
		pnlNhapCanh.add(lblCanhA);
		pnlNhapCanh.add(txtCanhA);
		pnlNhapCanh.add(lblCanhB);
		pnlNhapCanh.add(txtCanhB);
		pnlNhapCanh.add(lblCanhC);
		pnlNhapCanh.add(txtCanhC);

		JPanel pnlButton = new JPanel();
		pnlButton.setLayout(new GridLayout(2, 1, 30, 20));
		pnlButton.setBorder(new EmptyBorder(20, 290, 10, 40));

		btnArea = new JButton("Tính diện tích");
		btnChuVi = new JButton("Tính chu vi");
		pnlButton.add(btnArea);
		pnlButton.add(btnChuVi);

		JPanel pnlKetQua = new JPanel();
		pnlKetQua.setLayout(new GridLayout(1, 2));
		pnlKetQua.setBorder(new EmptyBorder(20, 40, 50, 40));
		JLabel lblKetQua = new JLabel("Kết quả:");
		txtKetQua = new JTextField(20);
		pnlKetQua.add(lblKetQua);
		pnlKetQua.add(txtKetQua);

		this.setLayout(new GridLayout(3, 1, 10, 10));
		this.add(pnlNhapCanh);
		this.add(pnlButton);
		this.add(pnlKetQua);

		btnArea.addActionListener(this);
		btnChuVi.addActionListener(this);
	}

	public PhanVanTai_102210230() {
		initComponents();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		String log = "";
		double a = -1;
		try {
			a = Double.valueOf(txtCanhA.getText());
			if (a <= 0)
				throw new Exception("Độ dài cạnh a không hợp lệ.");
			txtCanhA.setBackground(Color.white);
		} catch (Exception e2) {
			log += "\n" + e2.getMessage();
			txtCanhA.setBackground(Color.red);
		}

		double b = -1;
		try {
			b = Double.valueOf(txtCanhB.getText());
			if (b <= 0)
				throw new Exception("Độ dài cạnh b không hợp lệ.");
			txtCanhB.setBackground(Color.white);
		} catch (Exception e2) {
			log += "\n" + e2.getMessage();
			txtCanhB.setBackground(Color.red);
		}

		double c = -1;
		try {
			c = Double.valueOf(txtCanhC.getText());
			if (c <= 0)
				throw new Exception("Độ dài cạnh c không hợp lệ.");
			txtCanhC.setBackground(Color.white);
		} catch (Exception e2) {
			log += "\n" + e2.getMessage();
			txtCanhC.setBackground(Color.red);
		}

		if (!log.isEmpty()) {
			JOptionPane.showMessageDialog(this, log);
			txtKetQua.setText("");
			return;
		}

		if (!(a + b > c && a + c > b && b + c > a)) {
			JOptionPane.showMessageDialog(this, "Không thể tạo thành tam giác");
			txtKetQua.setText("");
			return;
		}
		if (src.equals("Tính diện tích")) {
			double p = (a + b + c) / 2;
			double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
			txtKetQua.setText(s + "");
		} else {
			txtKetQua.setText((a + b + c) + "");
		}
	}

	public static void main(String[] args) {
//		new PhanVanTai_102210230();
		new Cau2();
	}
}

class Cau2 {
	private HashMap<Integer, String> map = new HashMap<>();

	public Cau2() {
		ReadFile();
		WriteErrorLog();
	}

	private Connection getConnection() {
		Connection cnn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;encrypt=true;" + "database=DUT;trustServerCertificate=true;";
			String username = "sa";
			String pass = "taiphan2403";
			cnn = DriverManager.getConnection(url, username, pass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cnn;
	}

	private void InsertHocVien(HocVien hv) {
		Connection c = getConnection();
		if (c != null) {
			try {
				String query = "insert into Hocvien(maHocVien,tenHocVien,ngaySinh,gioiTinh,diemThi) "
						+ "values (?,?,?,?,?)";
				PreparedStatement ps = c.prepareStatement(query);
				ps.setString(1, hv.maHocVien);
				ps.setString(2, hv.tenHocVien);
				ps.setDate(3, hv.ngaySinh);
				ps.setString(4, hv.gioiTinh);
				ps.setDouble(5, hv.diemThi);
				int n = ps.executeUpdate();
				if (n > 0)
					System.out.println("Insert Successfully");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				map.put(hv.rowIndex, "Khong them them vao CSDL do vi pham khoa chinh,...");
			}
		}
	}

	private int getMaxDayInMonth(int m, int y) {
		int[] days = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
			days[2] = 29;
		return days[m];
	}

	private boolean checkDateIsValid(String date) {
		String[] ds = date.split("/");
		if (ds.length != 3)
			return false;
		try {
			int d = Integer.valueOf(ds[0]);
			int m = Integer.valueOf(ds[1]);
			int y = Integer.valueOf(ds[2]);
			if (d < 0 || d > 31 || m < 0 || m > 12 || y < 0)
				return false;
			if (d > getMaxDayInMonth(m, y))
				return false;
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Date getDateFormString(String date_str) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.util.Date tmp = simpleDateFormat.parse(date_str);
			Date d = new Date(tmp.getTime());
			return d;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	private HocVien getHocVienFromString(String str, int rowIndex) {
		HocVien hv = new HocVien();
		String log = "";

		String maHocVien = str.substring(0, 10);
		hv.maHocVien = maHocVien;

		String tenHocVien = str.substring(10, 60).trim();
		hv.tenHocVien = tenHocVien;

		String ngaySinh = str.substring(60, 70);
		if (checkDateIsValid(ngaySinh)) {
			hv.ngaySinh = getDateFormString(ngaySinh);
		} else {
			if (!log.isEmpty())
				log += ", ";
			log += "Sai dinh dang ngay sinh";
		}

		String gioiTinh = str.substring(70, 73).trim();

		if (!(gioiTinh.equals("Nam") || gioiTinh.equals("Nu"))) {
			if (!log.isEmpty())
				log += ", ";
			log += "Sai dinh dang gioi tinh";
		} else
			hv.gioiTinh = gioiTinh;

		String diemThi_str = str.substring(73);
		double diemThi = -1;
		try {
			diemThi = Double.valueOf(diemThi_str);
			if (diemThi < 0 || diemThi > 10)
				throw new Exception("gia tri diem thi khong hop le");
			hv.diemThi = diemThi;
		} catch (Exception e) {
			if (!e.getMessage().equals("gia tri diem thi khong hop le")) {
				if (!log.isEmpty())
					log += ", ai";
				else
					log += "Sai";
				log += " dinh dang diem thi";
			} else {
				if (!log.isEmpty())
					log += ", ";
				log += e.getMessage();
			}
		}
		if (!log.isEmpty()) {
			System.out.println(log);
			map.put(rowIndex, log);
			return null;
		}

		return hv;
	}

	private void ReadFile() {
		try {
			// Đường dẫn tính từ thư mục gốc là OnThiCK
//			FileReader fr = new FileReader("./src/lambai/input.txt");
			FileReader fr = new FileReader("input.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			ArrayList<HocVien> li = new ArrayList<>();
			int rowIndex = 0;
			while (true) {
				str = br.readLine();
				if (str == null || str == "")
					break;
				rowIndex++;
				HocVien hv = getHocVienFromString(str, rowIndex);
				if (hv != null) {
					hv.rowIndex = rowIndex;
					li.add(hv);
				}
			}

			if (li.size() != 0) {
				for (HocVien hv : li)
					InsertHocVien(hv);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void WriteErrorLog() {
		try {
			FileWriter fw = new FileWriter("error.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			int idx = 0;
			for (Map.Entry<Integer, String> entry : map.entrySet()) {
				Integer rowIndex = entry.getKey();
				String errorLog = entry.getValue();
				bw.write("Dong " + rowIndex + ": " + errorLog);
				if (idx < map.size() - 1)
					bw.newLine();
				idx++;
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class HocVien {
	int rowIndex;
	String maHocVien;
	String tenHocVien;
	Date ngaySinh;
	String gioiTinh;
	double diemThi;
}
