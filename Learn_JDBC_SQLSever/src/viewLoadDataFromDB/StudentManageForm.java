package viewLoadDataFromDB;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.JDBCUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class StudentManageForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtStudentID;
	private JTextField txtName;
	private JTextField txtPass;
	private JTable table;
	private DefaultTableModel modelTable = null;
	private JButton btnNew;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					StudentManageForm frame = new StudentManageForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private void initTable() {
		if (modelTable == null) {
			modelTable = new DefaultTableModel();
			modelTable.setColumnIdentifiers(new Object[] { "StudenId", "Name", "Password" });
			table.setModel(modelTable);
		}
		while (modelTable.getRowCount() > 0)
			modelTable.removeRow(0);
		String sql = "select *from student";
		try (
				// Cấu trúc try này cho phép tự động đóng kết nối
				Connection c = JDBCUtil.getConnection();
				PreparedStatement pst = c.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {
			// viết xử lí
			while (rs.next()) {
				Vector<String> row = new Vector();
				row.add(rs.getInt("idStudent") + "");
				row.add(rs.getString("username"));
				row.add(rs.getString("pass"));
				modelTable.addRow(row);
			}
			modelTable.fireTableDataChanged();
		} catch (Exception E) {

		}

	}

	public StudentManageForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Student ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(37, 31, 91, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(37, 68, 91, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(37, 108, 91, 15);
		contentPane.add(lblNewLabel_2);

		txtStudentID = new JTextField();
		txtStudentID.setBounds(138, 28, 208, 19);
		contentPane.add(txtStudentID);
		txtStudentID.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(138, 65, 208, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtPass = new JTextField();
		txtPass.setBounds(138, 105, 208, 19);
		contentPane.add(txtPass);
		txtPass.setColumns(10);

		btnNew = new JButton("New");

		btnNew.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNew.setBounds(376, 27, 77, 21);
		contentPane.add(btnNew);

		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBounds(376, 64, 77, 21);
		contentPane.add(btnDelete);

		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.setBounds(474, 65, 88, 21);
		contentPane.add(btnUpdate);

		btnSave = new JButton("Save");

		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSave.setBounds(474, 27, 88, 21);
		contentPane.add(btnSave);

		table = new JTable();
		table.setBounds(41, 173, 532, 139);
		contentPane.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(32, 162, 535, 159);
		contentPane.add(scrollPane);
		this.initTable();
		this.addActionListener();
	}

	private void addActionListener() {
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtStudentID.setText("");
				txtName.setText("");
				txtPass.setText("");
			}
		});

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewStudent();
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeStudent();
			}
		});

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateStudent();
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loadDataFromTableInToTextFiled();
			}
		});
	}

	private void loadDataFromTableInToTextFiled() {
		int idx = table.getSelectedRow();
		txtStudentID.setText(modelTable.getValueAt(idx, 0) + "");
		txtName.setText(modelTable.getValueAt(idx, 1) + "");
		txtPass.setText(modelTable.getValueAt(idx, 2) + "");
	}

	public void addNewStudent() {
		if (txtName.getText().equals("") || txtPass.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Name or Password is empty");
			return;
		}

		String sql = "insert into student values (?,?,?)";
		try (Connection c = JDBCUtil.getConnection(); PreparedStatement pst = c.prepareStatement(sql);) {

			int idStudent = 0;
			try {
				idStudent = Integer.valueOf(this.txtStudentID.getText());
			} catch (Exception e) {
				txtStudentID.setBackground(Color.red);
				JOptionPane.showMessageDialog(this, "Student ID is invalid");
			}
			String name = this.txtName.getText();
			String pass = this.txtPass.getText();

			pst.setInt(1, idStudent);
			pst.setString(2, name);
			pst.setString(3, pass);
			int cnt = pst.executeUpdate();
			if (cnt > 0) {
				JOptionPane.showMessageDialog(this, "Insert successfully");
				// Khi thêm thành công vào DB chỉ cần add thêm 1 bản ghi chứ
				// không render lại bảng
				modelTable.addRow(new Object[] { idStudent, name, pass });
				modelTable.fireTableDataChanged();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error:" + e.getMessage());
		}
	}

	public void removeStudent() {
		if(JOptionPane.showConfirmDialog(this, "Do you want to remove this record?") == JOptionPane.YES_OPTION) {
			String sql = "delete from student where idStudent=?";
			try (Connection c = JDBCUtil.getConnection(); PreparedStatement pst = c.prepareStatement(sql);) {
				pst.setInt(1, Integer.valueOf(txtStudentID.getText()));
				int cnt = pst.executeUpdate();
				if (cnt > 0) {
					JOptionPane.showMessageDialog(this, "Remove successfully");
					// Khi thêm thành công vào DB chỉ cần add thêm 1 bản ghi chứ
					// không render lại bảng
					initTable();
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Error:" + e.getMessage());
			}
		}
	}
	
	public void updateStudent() {
		String sql = "update student set username=?,pass=? "
				+ "where idStudent=?";
		try (Connection c = JDBCUtil.getConnection(); PreparedStatement pst = c.prepareStatement(sql);) {
			pst.setString(1, txtName.getText());
			pst.setString(2, txtPass.getText());
			pst.setInt(3, Integer.valueOf(txtStudentID.getText()));
			int cnt = pst.executeUpdate();
			if (cnt > 0) {
				JOptionPane.showMessageDialog(this, "Update successfully");
				// Khi thêm thành công vào DB chỉ cần add thêm 1 bản ghi chứ
				// không render lại bảng
				initTable();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error:" + e.getMessage());
		}
	}
}
