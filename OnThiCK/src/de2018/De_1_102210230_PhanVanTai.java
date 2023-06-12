package de2018;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorConvertOp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class De_1_102210230_PhanVanTai extends JFrame implements ActionListener {
	private JButton btnTongTien;
	private JButton btnGoiY;
	private JButton btnImport;
	private JButton btnSoluong;
	private JTextField txtImport;
	private JTextArea txtOutput;
	private JTextField txtKeyWord;

	private void init() {
		this.setTitle("Quan ly don hang");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);

		JPanel pnlLeft = new JPanel();
		pnlLeft.setBorder(new EmptyBorder(20, 20, 20, 20));
		pnlLeft.setLayout(new GridLayout(3, 1, 20, 20));
		pnlLeft.add(new JLabel("Import data"));
		pnlLeft.add(new JLabel("Keyword"));
		btnSoluong = new JButton("So luong");
		pnlLeft.add(btnSoluong);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setBorder(new EmptyBorder(20, 20, 20, 20));
		pnlCenter.setLayout(new GridLayout(3, 1, 20, 20));

		JPanel pnlCenter1 = new JPanel();
		pnlCenter1.setLayout(new GridLayout(1, 2, 20, 20));
		txtImport = new JTextField();
		btnImport = new JButton("Import file");
		pnlCenter1.add(txtImport);
		pnlCenter1.add(btnImport);

		txtKeyWord = new JTextField();

		JPanel pnlCenter2 = new JPanel();
		pnlCenter2.setLayout(new GridLayout(1, 2, 20, 20));
		btnTongTien = new JButton("Tong tien");
		btnGoiY = new JButton("Goi y");
		pnlCenter2.add(btnTongTien);
		pnlCenter2.add(btnGoiY);

		pnlCenter.add(pnlCenter1);
		pnlCenter.add(txtKeyWord);
		pnlCenter.add(pnlCenter2);

		JPanel pnlTop = new JPanel();
		pnlTop.setLayout(new BorderLayout());
		pnlTop.add(pnlLeft, BorderLayout.WEST);
		pnlTop.add(pnlCenter, BorderLayout.CENTER);

		this.setLayout(new BorderLayout(20, 20));

		JPanel pnlBottom = new JPanel();
		pnlBottom.setBorder(new EmptyBorder(20, 20, 20, 20));
		pnlBottom.setLayout(new BorderLayout());
		txtOutput = new JTextArea();
		pnlBottom.add(txtOutput);

		this.add(pnlTop, BorderLayout.NORTH);
		this.add(pnlBottom, BorderLayout.CENTER);

		btnSoluong.addActionListener(this);
		btnImport.addActionListener(this);
		btnTongTien.addActionListener(this);
		btnGoiY.addActionListener(this);
	}

	public De_1_102210230_PhanVanTai() {
		init();
		this.setVisible(true);
	}

	private Connection getConnection() {
		Connection cnn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;encrypt=true;" + "database=DUT;trustServerCertificate=true;";
			String username = "sa";
			String pass = "taiphan2403";
			cnn = DriverManager.getConnection(url, username, pass);
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cnn;
	}

	private void ReadFile(String fileName) {
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str = null;
			while (true) {
				str = br.readLine();
				if (str == null)
					break;
				String[] ds = str.split(",");
				DonHang dh = new DonHang();
				dh.tenMatHang = ds[0];
				dh.soTien = Integer.valueOf(ds[1]);
				dh.tenNguoiMua = ds[2];
				InsertDonHang(dh);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void InsertDonHang(DonHang p) {
		try {
			Connection c = getConnection();
			String query = "insert into donhang " + "values (?,?,?)";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, p.tenMatHang);
			pst.setInt(2, p.soTien);
			pst.setString(3, p.tenNguoiMua);
			if (pst.executeUpdate() > 0)
				System.out.println("Success");
			c.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void CalculateSoLuong(String tenMatHang) {
		try {
			Connection c = getConnection();
			String query = "select count(*) from donhang where tenMatHang like ?";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, tenMatHang);
			ResultSet rs = pst.executeQuery();
			String src = "";
			if (rs.next()) {
				// Di chuyển con trỏ về phía trước 1 hàng kể từ hàng hiện tại
				src += rs.getInt(1);
			} else {
				src = "Khong tim thay mat hang nay";
			}
			/*
			 * while (rs.next()) { if (rs.getInt(1) != 0) src += rs.getInt(1); else src =
			 * "Khong tim thay mat hang nay"; }
			 */
			txtOutput.setText(src);
			c.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void calculatePrice(String tenNguoiMua) {
		try {
			Connection c = getConnection();
			String query = "select sum(SoTien) from donhang " + " where TenNguoiMua like ? ";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, tenNguoiMua);
			ResultSet rs = pst.executeQuery();
			String src = null;
			if (rs.next())
				src = "" + rs.getInt(1);
			else {
				src = "Khong tim thay nguoi nay";
			}
			/*
			 * while (rs.next()) { if (rs.getInt(1) != 0) src = "" + rs.getInt(1); else src
			 * = "Khong tim thay nguoi nay"; }
			 */
			txtOutput.setText(src);
			c.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void GoiY() {
		String tenMatHang = txtKeyWord.getText();
		try {
			String query = "select TenMatHang,sum(SoTien) from DonHang " + "where TenNguoiMua in("
					+ "	select tenNguoiMua from DonHang " + " where TenMatHang = ? " + ") and TenMatHang <> ?"
					+ " group by TenMatHang" + " order by sum(SoTien) desc";
			Connection c = getConnection();
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, tenMatHang);
			pst.setString(2, tenMatHang);
			ResultSet rs = pst.executeQuery();
			String src = "";
			while (rs.next()) {
				if (!src.isEmpty())
					src += "\n";
				src += rs.getString(1) + ", " + rs.getInt(2);
			}
			txtOutput.setText(src);
			c.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		new De_1_102210230_PhanVanTai();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Import file")) {
			String fileName = txtImport.getText();
			ReadFile(fileName);
		} else if (src.equals("So luong")) {
			String tenMatHang = txtKeyWord.getText().trim();
			CalculateSoLuong(tenMatHang);
		} else if (src.equals("Tong tien")) {
			String tenNguoiMua = txtKeyWord.getText().trim();
			calculatePrice(tenNguoiMua);
		} else {
			GoiY();
		}
	}
}

class DonHang {
	String tenMatHang;
	int soTien;
	String tenNguoiMua;
}