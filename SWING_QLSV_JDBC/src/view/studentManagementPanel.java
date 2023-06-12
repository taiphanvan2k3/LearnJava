package view;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.ButtonGroup;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import dao.sinhVienDao;
import helper.DataValidator;
import helper.ImageHelper;
import helper.MessageDialogHelper;
import model.sinhvien;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class studentManagementPanel extends JPanel {
	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JTextField txtMSSV;
	private JTextField txtHoTen;
	private JTable table;
	private JButton btnMoHinh;
	private JButton btnUpdate;
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnNew;
	private JTextArea txtDiaChi;
	private JLabel lblPicture;
	private JRadioButton checkNam;
	private DefaultTableModel model = null;
	private JRadioButton checkNu;
	private byte[] personalImage;

	/**
	 * Create the panel.
	 */
	private void initTable() {
		if (model == null)
			model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(
				new Object[] { "Mã sinh viên", "Họ tên", "Email", "Số điện thoại", "Giới tính", "Địa chỉ" });
		table.setModel(model);
	}

	private void loadDataToTable() {
		try {
			model.setRowCount(0);
			ArrayList<sinhvien> listStudent = sinhVienDao.findAllStudent();
			if (listStudent.size() == 0)
				return;
			for (sinhvien sv : listStudent) {
				model.addRow(new Object[] { sv.getMaSinhVien(), sv.getHoVaTen(), sv.getEmail(), sv.getSdt(),
						(sv.getGioiTinh() == 1) ? "Nam" : "Nữ", sv.getDiaChi() });
			}
			model.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialogHelper.showErrorDialog(contentPane, e.getMessage(), "Lỗi");
		}
	}

	public studentManagementPanel() {
		contentPane = this;
		setBackground(new Color(250, 250, 210));

		JLabel lblTitle = new JLabel("Quản Lý Sinh Viên");
		lblTitle.setForeground(Color.GREEN);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTitle.setBounds(10, 10, 172, 22);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 38, 780, 13);

		JLabel lblNewLabel_1 = new JLabel("Mã Sinh Viên");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 72, 102, 15);

		JLabel lblNewLabel_2 = new JLabel("Họ Tên:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 117, 73, 15);

		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 165, 57, 15);

		JLabel lblNewLabel_4 = new JLabel("Số điện thoại:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 215, 85, 15);

		JLabel lblNewLabel_5 = new JLabel("Giới tính:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 267, 73, 15);

		txtEmail = new JTextField();
		txtEmail.setBounds(122, 162, 230, 20);
		txtEmail.setColumns(10);

		txtSDT = new JTextField();
		txtSDT.setBounds(122, 212, 230, 20);
		txtSDT.setColumns(10);

		txtMSSV = new JTextField();
		txtMSSV.setBounds(122, 70, 230, 20);
		txtMSSV.setColumns(10);

		txtHoTen = new JTextField();
		txtHoTen.setBounds(122, 115, 230, 20);
		txtHoTen.setColumns(10);

		ButtonGroup group = new ButtonGroup();
		checkNam = new JRadioButton("Nam");
		checkNam.setSelected(true);
		checkNam.setFont(new Font("Times New Roman", Font.BOLD, 14));
		checkNam.setBounds(122, 263, 85, 21);
		group.add(checkNam);

		checkNu = new JRadioButton("Nữ");
		checkNu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		checkNu.setBounds(209, 264, 103, 21);
		group.add(checkNu);

		JLabel lblNewLabel_6 = new JLabel("Địa chỉ:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 305, 45, 15);

		lblPicture = new JLabel("", JLabel.CENTER);
		lblPicture.setBounds(610, 58, 180, 195);
		setLayout(null);
		add(separator);
		add(lblTitle);
		add(lblNewLabel_2);
		add(lblNewLabel_3);
		add(lblNewLabel_4);
		add(lblNewLabel_6);
		add(lblNewLabel_5);
		add(lblNewLabel_1);
		add(txtMSSV);
		add(txtSDT);
		add(checkNam);
		add(checkNu);
		add(txtEmail);
		add(txtHoTen);
		add(lblPicture);

		btnNew = new JButton("Tạo mới");
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNew.setBounds(10, 392, 116, 21);
		add(btnNew);

		btnDelete = new JButton("Xoá");

		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDelete.setBounds(621, 393, 116, 21);
		add(btnDelete);

		btnSave = new JButton("Lưu");

		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSave.setBounds(212, 393, 116, 21);
		add(btnSave);

		btnUpdate = new JButton("Cập nhật");

		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnUpdate.setBounds(422, 393, 116, 21);
		add(btnUpdate);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 429, 804, 13);
		add(separator_1);

		table = new JTable();

		this.initTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 440, 804, 165);
		add(scrollPane);

		txtDiaChi = new JTextArea();
		txtDiaChi.setRows(3);
		txtDiaChi.setTabSize(10);
		txtDiaChi.setColumns(30);
		txtDiaChi.setLineWrap(true);
		txtDiaChi.setBounds(119, 290, 315, 92);
		add(txtDiaChi);

		btnMoHinh = new JButton("Mở Hình");

		btnMoHinh.setToolTipText("Nhấn vào để chọn hình");
		btnMoHinh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnMoHinh.setBounds(643, 263, 119, 22);
		add(btnMoHinh);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		verticalBox.setBounds(610, 61, 180, 195);
		add(verticalBox);
		this.setIconForComponents();
		this.addActionListener();
		this.loadDataToTable();
	}

	private void setIconForComponents() {
		btnMoHinh.setIcon(new ImageIcon(this.getClass().getResource("/open.png")));
		btnNew.setIcon(new ImageIcon(this.getClass().getResource("/new.png")));
		btnSave.setIcon(new ImageIcon(this.getClass().getResource("/save.png")));
		btnDelete.setIcon(new ImageIcon(this.getClass().getResource("/delete.png")));
		btnUpdate.setIcon(new ImageIcon(this.getClass().getResource("/update.png")));
		lblPicture.setIcon(new ImageIcon(this.getClass().getResource("/student_128px.png")));
	}

	private void setDataForSinhVien(sinhvien sv) {
		sv.setMaSinhVien(txtMSSV.getText());
		sv.setHoVaTen(txtHoTen.getText());
		sv.setEmail(txtEmail.getText());
		sv.setDiaChi(txtDiaChi.getText());
		sv.setSdt(txtSDT.getText());
		sv.setGioiTinh(checkNam.isSelected() ? 1 : 0);
		sv.setHinh(personalImage);
	}

	private void clearTextField() {
		txtMSSV.setText("");
		txtHoTen.setText("");
		txtSDT.setText("");
		txtEmail.setText("");
		txtDiaChi.setText("");
		lblPicture.setText("");
		personalImage = null;
		lblPicture.setIcon(new ImageIcon(this.getClass().getResource("/student_128px.png")));
	}

	private void addActionListener() {
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextField();
			}
		});

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				DataValidator.validateEmpty(txtMSSV, sb, "Mã sinh viên không được để trống.");
				DataValidator.validateEmpty(txtHoTen, sb, "Tên sinh viên không được để trống.");
				if (sb.length() > 0) {
					return;
				}
				try {
					sinhvien sv = new sinhvien();
					setDataForSinhVien(sv);
					if (sinhVienDao.insert(sv)) {
						MessageDialogHelper.showMessageDialog(contentPane, "Sinh viên đã được lưu", "Thông báo");
						loadDataToTable();
					} else {
						MessageDialogHelper.showErrorDialog(contentPane, "Sinh viên không được lưu do lỗi", "Lỗi");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					MessageDialogHelper.showErrorDialog(contentPane, e2.getMessage(), "Lỗi");
				}
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				DataValidator.validateEmpty(txtMSSV, sb, "Mã sinh viên không được để trống.");
				DataValidator.validateEmpty(txtHoTen, sb, "Tên sinh viên không được để trống.");
				if (sb.length() > 0) {
					MessageDialogHelper.showErrorDialog(contentPane, sb.toString(), "Lỗi");
					return;
				}
				if (MessageDialogHelper.showConfirmDialog(contentPane,
						"Bạn có muốn cập nhật thông tin sinh viên không?", "Hỏi") == JOptionPane.NO_OPTION)
					return;
				try {
					sinhvien sv = new sinhvien();
					setDataForSinhVien(sv);
					if (sinhVienDao.update(sv)) {
						MessageDialogHelper.showMessageDialog(contentPane, "Sinh viên đã được cập nhật", "Thông báo");
						loadDataToTable();
					} else {
						MessageDialogHelper.showErrorDialog(contentPane, "Sinh viên không được cập nhật do lỗi", "Lỗi");
					}
				} catch (Exception e2) {
					e2.printStackTrace();
					MessageDialogHelper.showErrorDialog(contentPane, e2.getMessage(), "Lỗi");
				}
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				DataValidator.validateEmpty(txtMSSV, sb, "Mã sinh viên không được để trống.");
				if (sb.length() > 0) {
					MessageDialogHelper.showErrorDialog(contentPane, sb.toString(), "Lỗi");
					return;
				}
				if (MessageDialogHelper.showConfirmDialog(contentPane,
						"Bạn có muốn xoá sinh viên này ra khỏi danh sách hay không?", "Hỏi") == JOptionPane.NO_OPTION)
					return;
				try {
					if (sinhVienDao.delete(txtMSSV.getText())) {
						MessageDialogHelper.showMessageDialog(contentPane, "Sinh viên đã được xoá ra khỏi danh sách",
								"Thông báo");
						clearTextField();
						loadDataToTable();
					} else {
						MessageDialogHelper.showErrorDialog(contentPane, "Sinh viên không được xoá do lỗi", "Lỗi");
					}

				} catch (Exception e2) {
					e2.printStackTrace();
					MessageDialogHelper.showErrorDialog(contentPane, e2.getMessage(), "Lỗi");
				}
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			// "Mã sinh viên", "Họ tên", "Email", "Số điện thoại", "Giới tính", "Địa chỉ"
			
			//Mỗi khi click vào từng dòng (edit 2/3/2023)
			public void mouseClicked(MouseEvent e) {
				int idx = table.getSelectedRow();
				if (idx < 0)
					return;
				sinhvien sv;
				try {
					sv = sinhVienDao.findById(model.getValueAt(idx, 0) + "");
					txtMSSV.setText(sv.getMaSinhVien());
					txtHoTen.setText(sv.getHoVaTen());
					txtEmail.setText(sv.getEmail());
					txtSDT.setText(sv.getSdt());
					int gender = sv.getGioiTinh();
					if (gender == 1)
						checkNam.setSelected(true);
					else
						checkNu.setSelected(true);
					txtDiaChi.setText(model.getValueAt(idx, 5) + "");
					if (sv.getHinh() != null) {
						try {
							Image img = ImageHelper.createImageFromByteArray(sv.getHinh());
							lblPicture.setIcon(new ImageIcon(img));
							personalImage = ImageHelper.toByteArray(img, "jpg");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else {
						lblPicture.setIcon(new ImageIcon(this.getClass().getResource("/student_128px.png")));
					}
				} catch (SQLException e1) {
					MessageDialogHelper.showErrorDialog(contentPane, e1.getMessage(), "Error");
					e1.printStackTrace();
				}

			}
		});

		btnMoHinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser("E:\\");
				fc.setFileFilter(new FileFilter() {

					@Override
					public String getDescription() {
						// Image File (*.jpg) là hình thức thôi, để biết
						// đag chọn file nào thôi
						return "Image File (*.jpg)";
					}

					@Override
					public boolean accept(File f) {
						// Dựa vào accept này sẽ xác định những gì sẽ hiện
						// ra cho người dùng, và hiển nhiên phải hiển thị thư mục
						// nên nếu là thư mục thì vẫn hiện ra
						if (f.isDirectory())
							return true;
						return f.getName().endsWith(".jpg");
					}
				});
				if (fc.showOpenDialog(contentPane) == JFileChooser.CANCEL_OPTION)
					return;
				File f = fc.getSelectedFile();
				try {
					//Image: là lớp trừu tượng, ImageIcon là lớp bình thường
					ImageIcon img = new ImageIcon(f.getPath());
					Image resizedImage = ImageHelper.resizeImage(img.getImage(), 180, 195);
					lblPicture.setIcon(new ImageIcon(resizedImage));
					personalImage = ImageHelper.toByteArray(resizedImage, "jpg");
				} catch (Exception e2) {
					MessageDialogHelper.showErrorDialog(contentPane, e2.getMessage(), "Error");
					e2.printStackTrace();
				}
			}
		});
	}
}
