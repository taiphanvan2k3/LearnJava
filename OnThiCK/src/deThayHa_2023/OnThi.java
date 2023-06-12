package deThayHa_2023;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class OnThi extends JFrame implements ActionListener {
	private JButton btnXoa;
	private JButton btnSplit;

	JTextField txtInput;
	private JTextArea txtOutput;
	private JComboBox<String> cbb;

	/*
	 * private void init() { this.setResizable(false); this.setSize(600, 300);
	 * this.setLocationRelativeTo(null); this.setDefaultCloseOperation(3);
	 * 
	 * JLabel lbl1 = new JLabel("Nhập số tự nhiên n"); JLabel lbl2 = new
	 * JLabel("Tách theo chiều");
	 * 
	 * String[] items = new String[] { "Từ trái sang phải", "Từ phải sang trái" };
	 * cbb = new JComboBox<String>(items);
	 * 
	 * JPanel pnlTop = new JPanel(); pnlTop.setBorder(new EmptyBorder(20, 20, 20,
	 * 20)); pnlTop.setLayout(new BorderLayout(20, 20));
	 * 
	 * JPanel pnl1 = new JPanel(); pnl1.setLayout(new GridLayout(2, 2, 20, 20));
	 * 
	 * txtInput = new JTextField(16);
	 * txtInput.setHorizontalAlignment(JTextField.RIGHT); pnl1.add(lbl1);
	 * pnl1.add(txtInput); pnl1.add(lbl2); pnl1.add(cbb);
	 * 
	 * JPanel pnlButton = new JPanel(); pnlButton.setLayout(new GridLayout(2, 1, 30,
	 * 30));
	 * 
	 * btnXoa = new JButton("Xoá"); btnSplit = new JButton("Tách số");
	 * pnlButton.add(btnXoa); pnlButton.add(btnSplit); pnlTop.add(pnl1,
	 * BorderLayout.WEST); pnlTop.add(pnlButton, BorderLayout.EAST);
	 * 
	 * JPanel pnlBottom = new JPanel(); pnlBottom.setBorder(new EmptyBorder(20, 20,
	 * 20, 20)); pnlBottom.setLayout(null);
	 * 
	 * JLabel lbl3 = new JLabel("Kết quả tách được:"); lbl3.setBounds(20, 0, 140,
	 * 10); txtOutput = new JTextArea(); txtOutput.setBounds(200, 0, 360, 100);
	 * pnlBottom.add(lbl3); pnlBottom.add(txtOutput);
	 * 
	 * this.setLayout(new GridLayout(2, 1)); this.add(pnlTop); this.add(pnlBottom);
	 * 
	 * btnXoa.addActionListener(this); btnSplit.addActionListener(this); }
	 */
	private void init2() {
		this.setSize(600, 350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);

		JPanel pnlLeft = new JPanel();
		pnlLeft.setLayout(new GridLayout(3, 1, 20, 20));
		pnlLeft.setBorder(new EmptyBorder(5, 20, 0, 0));
		pnlLeft.add(new JLabel("Nhập số tự nhiên n:"));
		pnlLeft.add(new JLabel("Tách theo chiều:"));
		pnlLeft.add(new JLabel("Kết quả tách được:"));

		JPanel pnlCenter1 = new JPanel();
		pnlCenter1.setLayout(new GridLayout(1, 2, 60, 50));
		pnlCenter1.setBorder(new EmptyBorder(10, 0, 10, 0));
		pnlCenter1.add(new JTextArea());

		JPanel pnlButtonXoa = new JPanel();
		pnlButtonXoa.setLayout(new BorderLayout());
		pnlButtonXoa.add(new JButton("Xoá"));
		pnlButtonXoa.setBorder(new EmptyBorder(0, 80, 0, 0));
		pnlCenter1.add(pnlButtonXoa, BorderLayout.CENTER);

		JPanel pnlCenter2 = new JPanel();
		pnlCenter2.setBorder(new EmptyBorder(10, 0, 10, 0));
		pnlCenter2.setLayout(new GridLayout(1, 2, 60, 50));
		pnlCenter2.add(new JComboBox<String>(new String[] { "Abc", "cde" }));

		JPanel pnlButtonSplit = new JPanel();
		pnlButtonSplit.setLayout(new GridLayout());
		pnlButtonSplit.add(new JButton("Tách số"), BorderLayout.CENTER);
		pnlButtonSplit.setBorder(new EmptyBorder(0, 80, 0, 0));
		pnlCenter2.add(pnlButtonSplit);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setBorder(new EmptyBorder(20, 20, 20, 20));
		pnlCenter.setLayout(new GridLayout(3, 1, 60, 50));
		pnlCenter.add(pnlCenter1);
		pnlCenter.add(pnlCenter2);
		pnlCenter.add(new JTextArea());

		this.setLayout(new BorderLayout());
		this.add(pnlLeft, BorderLayout.WEST);
		this.add(pnlCenter, BorderLayout.CENTER);
	}

	public OnThi() {
		init2();
		this.setVisible(true);
	}

	private void SplitNumber(String num) {
		StringBuffer sb = new StringBuffer(num);
		if (cbb.getSelectedIndex() == 1)
			sb.reverse();
		String str = "";
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '-')
				continue;
			if (!str.isBlank())
				str += " ";
			str += sb.charAt(i);
		}
		txtOutput.setText(str);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Xoá")) {
			txtInput.setText("");
			txtOutput.setText("");
		} else {
			String num = txtInput.getText();
			try {
				int n = Integer.valueOf(num);
				SplitNumber(num);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Giá trị nhập vào không hợp lệ");
			}
		}
	}

	public static void main(String[] args) {
//		new OnThi();
		new Cau2();
	}
}

class DongVat {
	String tenDongVat;
	String loai;

	public DongVat(String tenDongVat, String loai) {
		super();
		this.tenDongVat = tenDongVat;
		this.loai = loai;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != this.getClass())
			return false;
		DongVat tmp = (DongVat) obj;
		return this.tenDongVat.equals(tmp.tenDongVat);
	}
}

class ThucAn {
	String tenThucAn;
	String loai;

	public ThucAn(String tenThucAn, String loai) {
		this.tenThucAn = tenThucAn;
		this.loai = loai;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() != this.getClass())
			return false;
		ThucAn tmp = (ThucAn) obj;
		return this.tenThucAn.equals(tmp.tenThucAn);
	}
}

class Cau2 {
	private ArrayList<DongVat> dongVat = new ArrayList<>();
	private ArrayList<ThucAn> thucAn = new ArrayList<>();

	public Cau2() {
		ReadFile("data1.txt");
		ReadFile("data2.txt");
		InsertIntoAn2();
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

	private void InsertIntoDongVat(String tenDongVat, String Loai) {
		try {
			DongVat tmp = new DongVat(tenDongVat, Loai);
			if (dongVat.contains(tmp))
				return;
			dongVat.add(tmp);
			Connection c = getConnection();
			String query = "insert into dongvat " + "values (?,?)";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, tenDongVat);
			pst.setString(2, Loai);
			if (pst.executeUpdate() > 0)
				System.out.println("Insert Dong vat success");
			c.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void InsertIntoThucAn(String tenThucAn, String Loai) {
		try {
			ThucAn tmp = new ThucAn(tenThucAn, Loai);
			if (thucAn.contains(tmp))
				return;
			thucAn.add(tmp);
			Connection c = getConnection();
			String query = "insert into thucAn " + "values (?,?)";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, tenThucAn);
			pst.setString(2, Loai);
			if (pst.executeUpdate() > 0)
				System.out.println("Insert ThucAn success");
			c.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void InsertIntoAn() {
		try {
			Connection c = getConnection();
			String query = "insert into An " + "values (?,?,?)";
			PreparedStatement pst = c.prepareStatement(query);
			for (int i = 0; i < dongVat.size(); i++) {
				DongVat dongvat = dongVat.get(i);
				for (int j = 0; j < thucAn.size(); j++) {
					ThucAn thuc_an = thucAn.get(j);
					String CoTheAn = "KhongDuoc";
					if (dongvat.loai.equals("Bo") && thuc_an.loai.equals("Co"))
						CoTheAn = "Duoc";
					else if (dongvat.loai.equals("Meo") && thuc_an.loai.equals("Thit"))
						CoTheAn = "Duoc";
					else if (dongvat.loai.equals("Tho") && thuc_an.loai.equals("Carot"))
						CoTheAn = "Duoc";
					pst.setString(1, dongvat.tenDongVat);
					pst.setString(2, thuc_an.tenThucAn);
					pst.setString(3, CoTheAn);
					if (pst.executeUpdate() > 0)
						System.out.println("Insert An success");
				}
			}
			c.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void InsertIntoAn2() {
		try {
			Connection c = getConnection();
			
			String query = "select *from dongVat,thucAn";
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(query);

			String query2 = "insert into An values(?,?,?)";
			PreparedStatement pst = c.prepareStatement(query2);
			while (rs.next()) {
				String tenDV = rs.getString(1);
				String loaiDV = rs.getString(2);
				String tenTA = rs.getString(3);
				String loaiTA = rs.getString(4);
				String anDuoc = "KhongDuoc";
				if (loaiDV.equals("Bo") && loaiTA.equals("Co"))
					anDuoc = "Duoc";
				else if (loaiDV.equals("Meo") && loaiTA.equals("Thit"))
					anDuoc = "Duoc";
				else if (loaiDV.equals("Tho") && loaiTA.equals("Carot"))
					anDuoc = "Duoc";
				pst.setString(1, tenDV);
				pst.setString(2, tenTA);
				pst.setString(3, anDuoc);
				if (pst.executeUpdate() > 0)
					System.out.println("An Success");
			}
			c.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
				String[] ds = str.split(";");
				if (fileName.contains("data1"))
					InsertIntoDongVat(ds[0], ds[1]);
				else
					InsertIntoThucAn(ds[0], ds[1]);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
		}
	}
}