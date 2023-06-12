package viewLoadDataFromDB;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import database.JDBCUtil;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class StudentListForm extends JFrame {

	private JPanel contentPane;
	private JButton btnViewDetail;
	private JButton btnLoadData;
	private JComboBox comboStudentName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					StudentListForm frame = new StudentListForm();
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
	public StudentListForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		initCOmponents();
		// Add action Listener
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoadDataActionPeformed(e);
			}
		});

		btnViewDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnViewDetailActionPeformed(e);
			}
		});
	}

	private void initCOmponents() {
		btnLoadData = new JButton("Load Data");

		btnLoadData.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLoadData.setBounds(152, 190, 119, 21);
		contentPane.add(btnLoadData);

		btnViewDetail = new JButton("View Detail");
		btnViewDetail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnViewDetail.setBounds(296, 190, 111, 21);
		contentPane.add(btnViewDetail);

		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblStudentName.setBounds(88, 60, 119, 30);
		contentPane.add(lblStudentName);

		comboStudentName = new JComboBox();
		comboStudentName.setBounds(217, 61, 190, 30);
		contentPane.add(comboStudentName);
	}

	private void btnViewDetailActionPeformed(ActionEvent e) {
		String name = comboStudentName.getSelectedItem().toString();
		StudentDetailForm detailForm = new StudentDetailForm();
		detailForm.detailView(name);
	}

	private void btnLoadDataActionPeformed(ActionEvent e) {
		loadData();
	}

	private void loadData() {
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			c = JDBCUtil.getConnection();
			String sql = "select *from student";
			pst = c.prepareStatement(sql);
			rs = pst.executeQuery();
			comboStudentName.removeAllItems();
			while (rs.next()) {
				String str = rs.getString("username");
				comboStudentName.addItem(str);
			}
			btnLoadData.setEnabled(false);
		} catch (Exception e) {
		} finally {
			try {
				rs.close();
				pst.close();
				c.close();
				System.out.println("Đã đóng");
			} catch (Exception e2) {
			}
		}
	}
}
