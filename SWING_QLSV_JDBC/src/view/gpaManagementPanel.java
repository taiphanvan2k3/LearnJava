package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.bangDiemDao;
import dao.sinhVienDao;
import helper.DataValidator;
import helper.MessageDialogHelper;
import model.bangDiem;
import model.sinhvien;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class gpaManagementPanel extends JPanel {
	private JPanel contentPane;
	private JTextField txtSearchID;
	private JTextField txtStudentID;
	private JTextField txtName;
	private JTextField txtToan;
	private JTextField txtVan;
	private JTextField txtAnh;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnNew;
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnSearch;
	private JLabel diemTrungBinh;

	/**
	 * Create the panel.
	 */

	void initTable() {
		if (model == null)
			model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new Object[] { "Mã sinh viên", "Toán", "Văn", "Anh", "Điểm trung bình" });
		table.setModel(model);
	}

	private void loadDataToTable() {
		try {
			model.setRowCount(0);
			ArrayList<bangDiem> list = bangDiemDao.findTop(3);
			for (bangDiem bd : list) {
				Float avg = (Float.valueOf(bd.getToan()) + Float.valueOf(bd.getVan()) + Float.valueOf(bd.getAnh())) / 3;
				String st = String.format("%.2f", avg);
				model.addRow(new Object[] { bd.getMaSinhVien(), bd.getToan(), bd.getVan(), bd.getAnh(), st });
			}
			model.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialogHelper.showErrorDialog(contentPane, e.getMessage(), "Lỗi");
		}
	}

	public gpaManagementPanel() {
		contentPane = this;
		setBackground(new Color(250, 250, 210));
		setLayout(null);

		JLabel lblTitle = new JLabel("Quản Lý Điểm");
		lblTitle.setForeground(Color.RED);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTitle.setBounds(10, 14, 128, 24);
		add(lblTitle);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 48, 633, 13);
		add(separator);

		JLabel lblNewLabel_1 = new JLabel("Mã Sinh Viên");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 72, 100, 15);
		add(lblNewLabel_1);

		txtSearchID = new JTextField();

		txtSearchID.setBounds(109, 71, 304, 20);
		add(txtSearchID);
		txtSearchID.setColumns(10);

		btnSearch = new JButton("Tìm Kiếm");
		btnSearch.setBackground(new Color(135, 206, 250));
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSearch.setBounds(480, 71, 100, 21);
		add(btnSearch);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 250, 210));
		panel.setBounds(10, 112, 403, 219);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Mã Sinh Viên:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 31, 83, 15);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Họ Tên:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 69, 83, 15);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Toán");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(10, 108, 83, 15);
		panel.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Văn");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(10, 146, 83, 15);
		panel.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("Anh");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(10, 183, 83, 15);
		panel.add(lblNewLabel_2_4);

		txtStudentID = new JTextField();

		txtStudentID.setBounds(103, 30, 156, 19);
		panel.add(txtStudentID);
		txtStudentID.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(101, 68, 157, 20);
		panel.add(txtName);
		txtName.setColumns(10);

		txtToan = new JTextField();
		txtToan.setBounds(102, 105, 156, 19);
		panel.add(txtToan);
		txtToan.setColumns(10);

		txtVan = new JTextField();
		txtVan.setBounds(102, 144, 156, 19);
		panel.add(txtVan);
		txtVan.setColumns(10);

		txtAnh = new JTextField();
		txtAnh.setBounds(102, 181, 156, 19);
		panel.add(txtAnh);
		txtAnh.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 250, 210));
		panel_1.setBounds(423, 112, 213, 219);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblDiemTB = new JLabel("Điểm trung bình");
		lblDiemTB.setForeground(Color.BLUE);
		lblDiemTB.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDiemTB.setBounds(53, 35, 121, 28);
		panel_1.add(lblDiemTB);

		diemTrungBinh = new JLabel("");

		diemTrungBinh.setHorizontalAlignment(SwingConstants.CENTER);
		diemTrungBinh.setBounds(56, 89, 97, 53);
		panel_1.add(diemTrungBinh);

		btnNew = new JButton("Nhập mới");
		btnNew.setBackground(new Color(255, 255, 0));

		btnNew.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNew.setBackground(new Color(135, 206, 250));
		btnNew.setBounds(20, 364, 109, 21);
		add(btnNew);

		btnSave = new JButton("Lưu");
		btnSave.setBackground(new Color(135, 206, 250));
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSave.setBounds(162, 364, 109, 21);
		add(btnSave);

		btnDelete = new JButton("Xoá");
		btnDelete.setBackground(new Color(135, 206, 250));

		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBounds(446, 364, 109, 21);
		add(btnDelete);

		btnUpdate = new JButton("Cập Nhật");
		btnUpdate.setBackground(new Color(135, 206, 250));
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.setBounds(301, 364, 109, 21);
		add(btnUpdate);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 341, 633, 13);
		add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 395, 633, 13);
		add(separator_2);

		table = new JTable();
		table.setBounds(20, 479, 604, 173);
		initTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 407, 605, 173);
		add(scrollPane);
		this.addActionListener();
		this.loadDataToTable();
	}

	private bangDiem setDataForBangDiem() {
		bangDiem bd = new bangDiem();
		bd.setMaSinhVien(txtStudentID.getText());
		bd.setToan(Float.valueOf(txtToan.getText() + ""));
		bd.setAnh(Float.valueOf(txtAnh.getText() + ""));
		bd.setVan(Float.valueOf(txtVan.getText() + ""));
		return bd;
	}

	private void clearTextField() {
		txtStudentID.setText("");
		txtName.setText("");
		txtToan.setText("");
		txtVan.setText("");
		txtAnh.setText("");
	}

	private void tinhDiemTB() {
		float avg = (Float.valueOf(txtToan.getText()) + Float.valueOf(txtVan.getText())
				+ Float.valueOf(txtAnh.getText())) / 3;
		diemTrungBinh.setText(String.format("%.2f", avg));
	}

	private void btnSearchActionPerformed(ActionEvent e) {
		try {
			clearTextField();
			ArrayList<Object> res = bangDiemDao.findStudentAndPoint(txtSearchID.getText());
			if (res.size() > 0) {
				txtStudentID.setText((String) res.get(0));
				txtName.setText((String) res.get(1));
				txtToan.setText((Float) res.get(2) + "");
				txtVan.setText((Float) res.get(3) + "");
				txtAnh.setText((Float) res.get(4) + "");
				tinhDiemTB();
			} else
				MessageDialogHelper.showMessageDialog(contentPane, "Không tồn tại sinh viên này trong danh sách",
						"Thông báo");
		} catch (Exception e1) {
			e1.printStackTrace();
			MessageDialogHelper.showErrorDialog(contentPane, e1.getMessage(), "Lỗi");
		}
	}

	private void btnSaveActionPerformed(ActionEvent e) {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateEmpty(txtStudentID, sb, "Mã sinh viên cần phải nhập");
		if (sb.length() > 0) {
			MessageDialogHelper.showErrorDialog(contentPane, sb.toString(), "Lỗi");
			return;
		}
		bangDiem bd = setDataForBangDiem();
		try {
			// Nếu không kiểm tra xem bảng điểm của sinh viên này đã
			// có hay chưa mà cứ tiếp tục insert thì sẽ không cho thêm mà đi cập nhật
			if (bangDiemDao.findByStudentId(txtStudentID.getText()) != null) {
				int val = MessageDialogHelper.showConfirmDialog(contentPane, "Bạn có muốn cập nhật bảng điểm này không",
						"Hỏi");
				if (val == JOptionPane.OK_OPTION) {
					if (bangDiemDao.update(bd)) {
						MessageDialogHelper.showMessageDialog(contentPane, "Bảng điểm đã được cập nhật", "Thông báo");
						loadDataToTable();
					} else
						MessageDialogHelper.showErrorDialog(contentPane, "Bảng điểm không được cập nhật do lỗi", "Lỗi");
				}
			} else {
				if (bangDiemDao.insert(bd)) {
					MessageDialogHelper.showMessageDialog(contentPane, "Bảng điểm đã được lưu", "Thông báo");
					loadDataToTable();
				} else
					MessageDialogHelper.showErrorDialog(contentPane, "Bảng điểm không được lưu do lỗi", "Lỗi");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			MessageDialogHelper.showErrorDialog(contentPane, e1.getMessage(), "Lỗi");
		}
	}

	private void addActionListener() {
		txtStudentID.addFocusListener(new FocusAdapter() {
			@Override
			// Khi nhập xong txtStdudentID thì sẽ đi thiết lập txtName
			public void focusLost(FocusEvent e) {
				try {
					sinhvien sv = sinhVienDao.findById(txtStudentID.getText());
					if (sv != null)
						txtName.setText(sv.getHoVaTen());
				} catch (Exception e2) {
				}
			}
		});

		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextField();
			}
		});

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSaveActionPerformed(e);
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSaveActionPerformed(e);
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				DataValidator.validateEmpty(txtStudentID, sb, "Mã sinh viên cần phải nhập");
				if (sb.length() > 0) {
					MessageDialogHelper.showErrorDialog(contentPane, sb.toString(), "Lỗi");
					return;
				}
				try {
					bangDiem bd = bangDiemDao.findByStudentId(txtStudentID.getText());
					if (bd == null) {
						MessageDialogHelper.showMessageDialog(contentPane,
								"Không tìm thấy bảng điểm của sinh viên này!", "Thông báo");
						return;
					}
					if (MessageDialogHelper.showConfirmDialog(contentPane, "Bạn có muốn xoá điểm của sinh viên không?",
							"Hỏi") == JOptionPane.OK_OPTION) {
						if (bangDiemDao.deletByStudentID(txtStudentID.getText())) {
							MessageDialogHelper.showMessageDialog(contentPane, "Bảng điểm của sinh viên đã được xoá",
									"Thông báo");
							loadDataToTable();
						} else
							MessageDialogHelper.showMessageDialog(contentPane, "Bảng điểm của sinh viên không thể xoá",
									"Thông báo");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});

		txtSearchID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int idx = table.getSelectedRow();
				
				txtStudentID.setText(model.getValueAt(idx, 0) + "");
				try {
					sinhvien sv=sinhVienDao.findById(txtStudentID.getText());
					txtName.setText(sv.getHoVaTen());
					txtToan.setText(model.getValueAt(idx, 1) + "");
					txtVan.setText(model.getValueAt(idx, 2) + "");
					txtAnh.setText(model.getValueAt(idx, 3) + "");
					diemTrungBinh.setText(model.getValueAt(idx, 4)+"");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
}
