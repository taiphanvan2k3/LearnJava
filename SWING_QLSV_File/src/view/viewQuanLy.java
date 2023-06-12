package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.HeThong;
import model.ThiSinh;
import model.TinhThanh;
import model.XDate;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QuanLyController;

import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;

public class viewQuanLy extends WindowAdapter {

	public JFrame frame;
	// panel chính chứa toàn bộ view của chương trình
	private JPanel contentPane;
	public HeThong model;
	private JTextField filer_textField_mssv;
	public JTable tableSV;
	public JTextField textField_mssv;
	public JTextField textField_hoten;
	public JTextField textField_dob;
	public JTextField textField_mon1;
	public JTextField textField_mon2;
	public JTextField textField_mon3;
	public JComboBox info_listQueQuan;
	public ButtonGroup buttonGroup;
	private JRadioButton RadioButtonNu;
	private JRadioButton radioButtonNam;
	private JComboBox Filter_listQueQuan;

	public viewQuanLy() {
		this.frame = new JFrame();
		// Add sự kiện tắt chương trình cho frame
		frame.addWindowListener(this);
		ActionListener ac = new QuanLyController(this);
		frame.setTitle("Quản lý thí sinh");
		frame.setVisible(true);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\BtJava\\SWING_LearnIcon\\screen.jpg"));
		this.model = new HeThong();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setBounds(100, 100, 932, 768);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu jMenuFile = new JMenu("File");
		jMenuFile.setMnemonic(KeyEvent.VK_F);
		jMenuFile.setHorizontalAlignment(SwingConstants.CENTER);
		jMenuFile.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(jMenuFile);

		JMenuItem mntmNewMenuItem = new JMenuItem("Open", KeyEvent.VK_O);
		mntmNewMenuItem.addActionListener(ac);
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.CENTER);
		jMenuFile.add(mntmNewMenuItem);

		JMenuItem jMenuItem_Save = new JMenuItem("SaveFile", KeyEvent.VK_S);
		jMenuItem_Save.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jMenuItem_Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		jMenuItem_Save.setHorizontalAlignment(SwingConstants.CENTER);
		jMenuItem_Save.addActionListener(ac);
		jMenuFile.add(jMenuItem_Save);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Close");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jMenuFile.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(ac);
		JSeparator separator_1 = new JSeparator();
		jMenuFile.add(separator_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit", KeyEvent.VK_X);
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		jMenuFile.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(ac);

		JMenu jMenuAbout = new JMenu("About");
		jMenuAbout.setHorizontalAlignment(SwingConstants.CENTER);
		jMenuAbout.setFont(new Font("Times New Roman", Font.BOLD, 18));
		menuBar.add(jMenuAbout);

		JMenuItem jMenuItemAbout = new JMenuItem("About me");
		jMenuAbout.add(jMenuItemAbout);
		jMenuItemAbout.addActionListener(ac);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// Vì toàn cho contentPane.add nên ta phải setContentPane cho frame
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Student Filter");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(32, 24, 138, 25);
		contentPane.add(lblNewLabel);

		filer_textField_mssv = new JTextField();
		filer_textField_mssv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		filer_textField_mssv.setBounds(478, 72, 137, 30);
		contentPane.add(filer_textField_mssv);
		filer_textField_mssv.setColumns(10);

		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(651, 72, 132, 33);
		btnNewButton.addActionListener(ac);
		contentPane.add(btnNewButton);

		ArrayList<String> dsTinhThanh = TinhThanh.getTinhThanh();
		Filter_listQueQuan = new JComboBox();
		Filter_listQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Filter_listQueQuan.addItem("");
		for (String str : dsTinhThanh)
			Filter_listQueQuan.addItem(str);
		Filter_listQueQuan.setBounds(138, 71, 108, 21);
		contentPane.add(Filter_listQueQuan);

		JLabel Filter_labelQueQuan = new JLabel("Quê quán");
		Filter_labelQueQuan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Filter_labelQueQuan.setBounds(32, 64, 96, 35);
		contentPane.add(Filter_labelQueQuan);

		JLabel Filter_labelMSSV = new JLabel("Mã số SV");
		Filter_labelMSSV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Filter_labelMSSV.setHorizontalAlignment(SwingConstants.CENTER);
		Filter_labelMSSV.setBounds(372, 67, 96, 35);
		contentPane.add(Filter_labelMSSV);

		JLabel lblNewLabel_2 = new JLabel("Danh sách sinh viên");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(32, 130, 214, 30);
		contentPane.add(lblNewLabel_2);

		tableSV = new JTable();
		tableSV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tableSV.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 th\u00ED sinh", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh",
						"Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3" }));
		tableSV.setRowHeight(25);
		tableSV.setBounds(32, 170, 846, 312);
		JScrollPane scrollPaneTable = new JScrollPane(tableSV);
		scrollPaneTable.setBounds(30, 185, 857, 224);
		contentPane.add(scrollPaneTable);

		JLabel lblNewLabel_3 = new JLabel("Thông tin thí sinh");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(32, 419, 198, 30);
		contentPane.add(lblNewLabel_3);

		JLabel Info_labelMSSV = new JLabel("MSSV");
		Info_labelMSSV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Info_labelMSSV.setBounds(32, 459, 76, 19);
		contentPane.add(Info_labelMSSV);

		JLabel Info_labelHoTen = new JLabel("Họ tên");
		Info_labelHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Info_labelHoTen.setBounds(32, 488, 45, 23);
		contentPane.add(Info_labelHoTen);

		JLabel Info_labelQueQuan = new JLabel("Quê quán");
		Info_labelQueQuan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Info_labelQueQuan.setBounds(32, 521, 76, 24);
		contentPane.add(Info_labelQueQuan);

		JLabel Info_labelDob = new JLabel("Ngày sinh");
		Info_labelDob.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Info_labelDob.setBounds(32, 555, 78, 27);
		contentPane.add(Info_labelDob);

		JLabel Info_labelGioiTinh = new JLabel("Giới tính");
		Info_labelGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Info_labelGioiTinh.setBounds(532, 454, 76, 30);
		contentPane.add(Info_labelGioiTinh);

		radioButtonNam = new JRadioButton("Nam");
		radioButtonNam.setSelected(true);
		radioButtonNam.setFont(new Font("Tahoma", Font.BOLD, 14));
		radioButtonNam.setBounds(614, 458, 60, 21);
		contentPane.add(radioButtonNam);

		RadioButtonNu = new JRadioButton("Nữ");
		RadioButtonNu.setFont(new Font("Tahoma", Font.BOLD, 14));
		RadioButtonNu.setBounds(693, 458, 60, 21);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButtonNam);
		buttonGroup.add(RadioButtonNu);

		contentPane.add(RadioButtonNu);

		textField_mssv = new JTextField();
		textField_mssv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_mssv.setBounds(101, 459, 184, 21);
		contentPane.add(textField_mssv);
		textField_mssv.setColumns(10);

		textField_hoten = new JTextField();
		textField_hoten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_hoten.setColumns(10);
		textField_hoten.setBounds(101, 488, 184, 27);
		contentPane.add(textField_hoten);

		textField_dob = new JTextField();
		textField_dob.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_dob.setColumns(10);
		textField_dob.setBounds(101, 555, 184, 27);
		contentPane.add(textField_dob);

		JLabel labelDiem1 = new JLabel("Điểm môn 1");
		labelDiem1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		labelDiem1.setBounds(532, 490, 96, 19);
		contentPane.add(labelDiem1);

		JLabel labelDiem2 = new JLabel("Điểm môn 2");
		labelDiem2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		labelDiem2.setBounds(532, 524, 96, 19);
		contentPane.add(labelDiem2);

		JLabel labelDiem3 = new JLabel("Điểm môn 3");
		labelDiem3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		labelDiem3.setBounds(532, 559, 96, 19);
		contentPane.add(labelDiem3);

		textField_mon1 = new JTextField();
		textField_mon1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_mon1.setColumns(10);
		textField_mon1.setBounds(651, 490, 85, 21);
		contentPane.add(textField_mon1);

		textField_mon2 = new JTextField();
		textField_mon2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_mon2.setColumns(10);
		textField_mon2.setBounds(651, 524, 85, 21);
		contentPane.add(textField_mon2);

		textField_mon3 = new JTextField();
		textField_mon3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_mon3.setColumns(10);
		textField_mon3.setBounds(651, 559, 85, 21);
		contentPane.add(textField_mon3);

		info_listQueQuan = new JComboBox();
		// .......
		info_listQueQuan.addItem("");
		for (String str : dsTinhThanh)
			info_listQueQuan.addItem(str);
		info_listQueQuan.setBounds(101, 524, 138, 21);
		contentPane.add(info_listQueQuan);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.addActionListener(ac);
		btnDelete.setBounds(243, 651, 117, 21);
		contentPane.add(btnDelete);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.addActionListener(ac);
		btnUpdate.setBounds(420, 651, 98, 21);
		contentPane.add(btnUpdate);

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSave.addActionListener(ac);
		btnSave.setBounds(569, 652, 117, 21);
		contentPane.add(btnSave);

		JButton btnUndo = new JButton("Undo");
		btnUndo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUndo.addActionListener(ac);
		btnUndo.setBounds(743, 652, 117, 21);
		contentPane.add(btnUndo);

		JButton btNInsert = new JButton("Insert");
		btNInsert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btNInsert.setBounds(85, 651, 85, 21);
		contentPane.add(btNInsert);
		btNInsert.addActionListener(ac);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		horizontalBox.setBounds(32, 623, 857, 71);
		contentPane.add(horizontalBox);

		JButton btnHuy = new JButton("Huỷ");
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.addActionListener(ac);
		btnHuy.setBounds(802, 72, 85, 33);
		contentPane.add(btnHuy);

	}

	@Override
	public void windowClosing(WindowEvent e) {
		int returnVal = JOptionPane.showConfirmDialog(frame, "Bạn có chắc chắn muốn thoát chương trình?", "Warning",
				JOptionPane.YES_NO_OPTION);
		if (returnVal == JOptionPane.YES_OPTION)
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void clearTextField() {
		this.textField_mssv.setText("");
		this.textField_hoten.setText("");
		this.textField_dob.setText("");
		this.textField_mon1.setText("");
		this.textField_mon2.setText("");
		this.textField_mon3.setText("");
		// Đưa lựa chọn về rỗng ở index 0: ứng với xâu rỗng trong lits
		// Hoặc setSelectedIndex(-1)
		this.info_listQueQuan.setSelectedIndex(0);
		this.buttonGroup.clearSelection();
	}

	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		boolean checkExist = this.model.checkExist(ts.getMssv());
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		DefaultTableModel model_table = (DefaultTableModel) tableSV.getModel();
		if (!checkExist) {
			this.model.setLuaChon("Insert");
			// Lưu thí sinh vừa thêm vào bảng vào temp
			this.model.setThiSinhTemp(ts);
			// Thêm thí sinh vào ArrayList
			this.model.insertThiSinh(ts);
			// Thêm thí sinh vào bảng
			String gioiTinh = "";
			if (ts.getGioiTinh())
				gioiTinh = "Nam";
			else
				gioiTinh = "Nữ";
			model_table.addRow(new Object[] { ts.getMssv() + "", ts.getTen(), ts.getQueQuan(), df.format(ts.getDob()),
					gioiTinh, ts.getMon1() + "", ts.getMon2() + "", ts.getMon3() + "" });
		} else {
			this.model.setLuaChon("Update");
			this.model.update(ts);
			int cnt = model_table.getRowCount();
			int i;
			for (i = 0; i < cnt; i++) {
				if (Integer.valueOf(model_table.getValueAt(i, 0) + "") == ts.getMssv())
					break;
			}
			// Lấy ra thí sinh trước khi thay đổi để lưu vào temp
			this.model.setThiSinhTemp(this.getInfoThiSinhDaChon(i));
			model_table.setValueAt(ts.getTen(), i, 1);
			model_table.setValueAt(ts.getQueQuan(), i, 2);
			model_table.setValueAt(df.format(ts.getDob()), i, 3);
			model_table.setValueAt((ts.getGioiTinh() ? "Nam" : "Nữ"), i, 4);
			model_table.setValueAt(ts.getMon1(), i, 5);
			model_table.setValueAt(ts.getMon2(), i, 6);
			model_table.setValueAt(ts.getMon3(), i, 7);

		}
	}

	// Vì lúc ta xoá thí sinh khỏi table ở tìm kiếm nhưng ko xoá ở trong ArrayList
	// do đó bây giờ ta chỉ cần thêm vào lại table
	public void onlyInsertThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) tableSV.getModel();
		String gioiTinh = ts.getGioiTinh() ? "Nam" : "Nữ";
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		model_table.addRow(new Object[] { ts.getMssv() + "", ts.getTen(), ts.getQueQuan(), df.format(ts.getDob()),
				gioiTinh, ts.getMon1() + "", ts.getMon2() + "", ts.getMon3() + "" });
	}

	public void hienThiThongTinDaChon() {
		// getValueAt(row,col) (row>=0,col>=0) giống mảng 2 chiều
		int i_row = tableSV.getSelectedRow();
		this.textField_mssv.setText(tableSV.getValueAt(i_row, 0) + "");
		this.textField_hoten.setText(tableSV.getValueAt(i_row, 1) + "");
		String queQuan = tableSV.getValueAt(i_row, 2) + "";
		this.info_listQueQuan.setSelectedItem(queQuan);
		this.textField_dob.setText(tableSV.getValueAt(i_row, 3) + "");
		this.buttonGroup.clearSelection();
		String gioiTinh = tableSV.getValueAt(i_row, 4) + "";

		// Set trực tiếp cho từng JRadioButton, ko dùng ButtonGroup.setSelected vì rắc
		// rối
		if (gioiTinh.equals("Nam"))
			this.radioButtonNam.setSelected(true);
		else
			this.RadioButtonNu.setSelected(true);
		this.textField_mon1.setText(tableSV.getValueAt(i_row, 5) + "");
		this.textField_mon2.setText(tableSV.getValueAt(i_row, 6) + "");
		this.textField_mon3.setText(tableSV.getValueAt(i_row, 7) + "");
	}

	public ThiSinh getInfoThiSinhDaChon(int i_row) {
		ThiSinh ts = new ThiSinh();
		ts.setMssv(Integer.valueOf(tableSV.getValueAt(i_row, 0) + ""));
		ts.setTen(tableSV.getValueAt(i_row, 1) + "");
		String queQuan = tableSV.getValueAt(i_row, 2) + "";
		ts.setQueQuan(queQuan);
		try {
			Date d = XDate.StringToDate(tableSV.getValueAt(i_row, 3) + "", "dd/MM/yyyy");
			ts.setDob(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String gioiTinh = tableSV.getValueAt(i_row, 4) + "";
		ts.setGioiTinh((gioiTinh.equals("Nam") ? true : false));
		ts.setMon1(Float.valueOf(tableSV.getValueAt(i_row, 5) + ""));
		ts.setMon2(Float.valueOf(tableSV.getValueAt(i_row, 6) + ""));
		ts.setMon3(Float.valueOf(tableSV.getValueAt(i_row, 7) + ""));
		return ts;
	}

	// Xoá thí sinh ở hàng được chọn
	public void xoaThiSinh() {
		this.model.setLuaChon("Delete");
		int i_row = this.tableSV.getSelectedRow();
		DefaultTableModel model_table = (DefaultTableModel) tableSV.getModel();
		int a = JOptionPane.showConfirmDialog(frame, "Bạn có chắc chặn xoá thí sinh đã chọn không?");
		if (a == JOptionPane.YES_OPTION) {
			ThiSinh ts = this.getInfoThiSinhDaChon(i_row);
			this.model.setThiSinhTemp(ts);
			// Xây dựng phương thức equals là 2 thí sinh giống nhau khi cùng mã số sinh viên
			// rồi
			// nên chỉ cần tạo ra thí sinh ts rồi set mssv cho nó là đc
			ts.setMssv(Integer.valueOf(model_table.getValueAt(i_row, 0) + ""));
			this.model.deleteThiSinh(ts);
			model_table.removeRow(i_row);
		}
	}

	// Xoá thí sinh ra khỏi bằng theo tham số là thí sinh truyền vào
	public void xoaThiSinh(ThiSinh ts) {
		this.model.deleteThiSinh(ts);
		DefaultTableModel model_table = (DefaultTableModel) tableSV.getModel();
		int cnt = model_table.getRowCount();
		for (int i = 0; i < cnt; i++) {
			if (Integer.valueOf(model_table.getValueAt(i, 0) + "").equals(ts.getMssv())) {
				this.model.deleteThiSinh(ts);
				model_table.removeRow(i);
				break;
			}
		}
	}

	// Phương thức trả về đối tượng ThiSinh có dữ liệu nhập từ các textField
	public ThiSinh loadDataFromTextField() {
		int mssv = Integer.valueOf(this.textField_mssv.getText());
		String hoten = this.textField_hoten.getText();
		String queQuan = this.info_listQueQuan.getSelectedItem().toString();
		String dob = this.textField_dob.getText();
		Date d = new Date();
		try {
			d = XDate.StringToDate(dob, "dd/MM/yyyy");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		float diem1, diem2, diem3;
		diem1 = Float.valueOf(this.textField_mon1.getText());
		diem2 = Float.valueOf(this.textField_mon2.getText());
		diem3 = Float.valueOf(this.textField_mon3.getText());
		String gioiTinh = "";
		Enumeration<AbstractButton> ds = this.buttonGroup.getElements();
		while (ds.hasMoreElements()) {
			AbstractButton b = ds.nextElement();
			if (b.isSelected()) {
				gioiTinh = b.getText();
				break;
			}
		}

		// Hoặc đơn giản hơn để biết đươcn giới tính
		boolean sex = (gioiTinh.equals("Nam")) ? (true) : (false);
		ThiSinh ts = new ThiSinh(mssv, hoten, queQuan, sex, diem1, diem2, diem3, d);
		return ts;
	}

	public void clearTable() {
		DefaultTableModel model_table = (DefaultTableModel) this.tableSV.getModel();
		int n_row = model_table.getRowCount();
		for (int i = n_row - 1; i >= 0; i--)
			model_table.removeRow(i);
	}

	public void TimKiem() {
		// Tìm theo mã sinh viên
		int mssv = -1;
		String Mssv = this.filer_textField_mssv.getText();
		if (Mssv.length() > 0)
			mssv = Integer.valueOf(Mssv);
		// Tìm theo quê quán
		String queQuan = this.Filter_listQueQuan.getSelectedItem().toString();
		ArrayList<ThiSinh> ds = this.model.getDsThiSinh();
		HashSet<Integer> idThiSinhCanXoa = new HashSet<>();
		if (queQuan.length() > 0) {
			for (int i = 0; i < ds.size(); i++) {
				if (!ds.get(i).getQueQuan().equals(queQuan))
					idThiSinhCanXoa.add(ds.get(i).getMssv());
			}
		}
		if (mssv != -1) {
			for (int i = 0; i < ds.size(); i++) {
				if (ds.get(i).getMssv() != mssv)
					idThiSinhCanXoa.add(ds.get(i).getMssv());
			}
		}

		this.clearTable();
		for (int i = 0; i < ds.size(); i++) {
			if (!idThiSinhCanXoa.contains(ds.get(i).getMssv())) {
				this.onlyInsertThiSinh(ds.get(i));
			}
		}
	}

	public void HuyTim() {
		this.filer_textField_mssv.setText("");
		this.Filter_listQueQuan.setSelectedItem("");
		this.clearTable();
		for (ThiSinh ts : this.model.getDsThiSinh())
			this.onlyInsertThiSinh(ts);
	}

	public void thoatChuongTrinh() {
		int check = JOptionPane.showConfirmDialog(frame, "Bạn có muốn lưu lại tiến trình của mình không?", "Exit",
				JOptionPane.YES_NO_OPTION);
		if (check == JOptionPane.YES_OPTION) {
			System.out.println("Đã lưu lại tiến trình.");
			System.exit(0);
		}
	}

	public void thucHienSave() {
		String tenFile = "";
		if (this.model.getTenFile().equals("")) {
			JFileChooser fc = new JFileChooser("E:\\");
			int returnVal = fc.showSaveDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				tenFile = f.getAbsolutePath();
				System.out.println(tenFile);
				this.model.setTenFile(tenFile);
			}
		}
		ArrayList<ThiSinh> ds = this.model.getDsThiSinh();
		File out = new File(tenFile);
		try {
			OutputStream os = new FileOutputStream(out);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeInt(ds.size());
			for (ThiSinh ts : ds)
				oos.writeObject(ts);
			oos.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void thucHienOpen() {
		// Thay đổi đường dẫn mặc định của JFileChooser
		JFileChooser fc = new JFileChooser("E:\\");
		int returnVal = fc.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			InputStream is;
			ObjectInputStream ois;
			ArrayList<ThiSinh> ds = new ArrayList<>();
			try {
				is = new FileInputStream(f);
				ois = new ObjectInputStream(is);
				int n = ois.readInt();
				for (int i = 0; i < n; i++) {
					ThiSinh ts = (ThiSinh) ois.readObject();
					ds.add(ts);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.model.setDsThiSinh(ds);
			this.HuyTim();
		}

	}
}
