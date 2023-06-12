import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class GiaoDienTestJDBC extends JFrame implements ActionListener {
	JTextField txtIP;
	JTextField txtDBName;
	private JTextField txtUser;
	private JButton btnLogin;
	private JTextField txtTable;
	private JButton btnShow;
	private JTextField txtPass;

	private Connection cnn;
	private JTable table;

	private void initComponents() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(3);
		JPanel pnlTop = new JPanel();

		JPanel pnlLeftTop = new JPanel();
		pnlLeftTop.setLayout(new GridLayout(2, 4));
		JLabel lblIp = new JLabel("IP");
		txtIP = new JTextField(10);
		JLabel lblDBname = new JLabel("Database Name");
		txtDBName = new JTextField(10);
		JLabel lblUser = new JLabel("User");
		txtUser = new JTextField(10);
		JLabel lbPass = new JLabel("Pass");
		txtPass = new JTextField(10);
		pnlLeftTop.add(lblIp);
		pnlLeftTop.add(txtIP);
		pnlLeftTop.add(lblDBname);
		pnlLeftTop.add(txtDBName);
		pnlLeftTop.add(lblUser);
		pnlLeftTop.add(txtUser);
		pnlLeftTop.add(lbPass);
		pnlLeftTop.add(txtPass);

		JPanel pnlRightTop = new JPanel();
		btnLogin = new JButton("LOGIN");
		pnlRightTop.add(btnLogin);

		pnlTop.add(pnlLeftTop);
		pnlTop.add(pnlRightTop);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new BorderLayout());
		JPanel pnlTopCenter = new JPanel();
		JLabel lblTable = new JLabel("Table");
		txtTable = new JTextField(10);
		btnShow = new JButton("Show");
		pnlTopCenter.add(lblTable);
		pnlTopCenter.add(txtTable);
		pnlTopCenter.add(btnShow);

		JPanel pnlCenterCenter = new JPanel();
		table = new JTable();
		pnlCenterCenter.add(table);
		pnlCenter.add(pnlTopCenter, BorderLayout.NORTH);
		pnlCenter.add(pnlCenterCenter);

		btnLogin.addActionListener(this);
		btnShow.addActionListener(this);

		this.setLayout(new BorderLayout());
		this.add(pnlTop, BorderLayout.NORTH);
		this.add(pnlCenter, BorderLayout.CENTER);
	}

	public GiaoDienTestJDBC() {
		initComponents();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new GiaoDienTestJDBC();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		String IP = txtIP.getText();
		if (IP.equals("")) {
			IP = "localhost";
			txtIP.setText(IP);
		}
		String DatabaseName = txtDBName.getText();
		String user = txtUser.getText();
		String pass = txtPass.getText();
		if (user.equals("")) {
			user = "root";
			txtUser.setText(user);
		}
		if (src.equals("LOGIN")) {

			try {
				cnn = JDBCUtils.getConnection(IP, DatabaseName, user, pass);
				if (cnn != null && !DatabaseName.equals("")) {
					JOptionPane.showMessageDialog(this, "Kết nối thành công");
					cnn.close();
				} else {
					JOptionPane.showMessageDialog(this, "Kết nối thất bại");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			if (cnn == null)
				JOptionPane.showMessageDialog(this, "Bạn cần đăng nhập trước");
			else {
				String tableName = txtTable.getText();
				if (tableName.equals(""))
					JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên bảng");
				else {
					DefaultTableModel model = new DefaultTableModel();
					try {
						cnn = JDBCUtils.getConnection(IP, DatabaseName, user, pass);
						Statement st = cnn.createStatement();
						ResultSet rs = st.executeQuery("select *from " + tableName);
						ResultSetMetaData rsmd = rs.getMetaData();
						for (int i = 0; i < rsmd.getColumnCount(); i++) {
							model.addColumn(rsmd.getColumnName(i + 1));
						}
						table.setModel(model);
						TableColumnModel columnModel = table.getColumnModel();

						while (rs.next()) {
							model.addRow(new Object[] { rs.getInt(1), rs.getString(2), rs.getInt(3) });
						}

						model.fireTableStructureChanged();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
}
