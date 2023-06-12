package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.controllerEmployee;
import controller.controllerTable;
import helper.Validator;
import helper.XFile;
import helper.formatCurrency;
import model.danhSachEmployee;
import model.employee;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class FormInfoEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNV, txtHoVaTen, txtAge, txtEmail, txtSalary;
	private JTable tableSV;
	private controllerEmployee ac;
	private controllerTable controllTable;
	private JButton btnNew, btnSave, btnDelete, btnFind, btnOpen, btnExit;
	private JButton btnFirst, btnLast, btnNext, btnPrevious;
	private DefaultTableModel defaultTableModel = null;
	private danhSachEmployee listEmployee = null;
	// isEditMode: để biết là đang chỉnh sửa hay save mới
	// và ngầm định là thêm mới
	private boolean isEditMode = false;
	private JLabel lblRecord;
	private static JLabel lblClock;

	// Dùng NumberFormat để định dạng lại số tiền hiển thị
	NumberFormat numberFormat;

	/**
	 * Launch the application.
	 */
	public FormInfoEmployee() {
		this.initJFrame();
		this.initComponents();
		// Add actionListener
		this.addActionListener();
		// Add mouseListener
		this.controllTable = new controllerTable(this);
		this.tableSV.addMouseListener(controllTable);
		// Nạp ngầm định employee thứ 1( nếu có) vào form
		this.loadEmployeeData();
		if (this.listEmployee.getSize() > 0) {
			this.updateTextFields(this.listEmployee.getEmployeeByIndex(0));
			this.lblRecord.setText("Record 1" + "/" + this.listEmployee.getSize());
			this.listEmployee.setCurrentIndex(0);
			this.tableSV.setRowSelectionInterval(0, 0);
			// Phải setCurrentIndex để lỡ mới vào mà bấm nút previous thì sẽ ko bị dính lỗi
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					FormInfoEmployee frame = new FormInfoEmployee();
					frame.setVisible(true);
					Thread t = new Thread() {
						public void run() {
							SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss aa");
							while (true) {
								Date d = new Date();
								lblClock.setText(df.format(d));
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
								}
							}
						}
					};
					t.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public void loadEmployeeData() {
		try {
			this.listEmployee.loadFromFile();
			this.listEmployee.renderToTable(defaultTableModel);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error:" + e.getMessage(), "Lỗi đọc file", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void initJFrame() {
		setTitle("Quản lý nhân viên");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Admin\\OneDrive - The University of Technology\\Ít dùng đến\\Pictures\\Saved Pictures\\ảnh1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 603);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		Locale lc = new Locale("vi", "vn");
		numberFormat = NumberFormat.getInstance(lc);
	}

	public void initTable() {
		tableSV = new JTable();
		tableSV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		// setFont cho các cột
		tableSV.getTableHeader().setFont(new Font("Time New Roman", Font.BOLD, 14));
		((DefaultTableCellRenderer) tableSV.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		this.defaultTableModel = new DefaultTableModel();
		// Dùng để thiết lập các tên cột của defaultModel
		defaultTableModel.setColumnIdentifiers(new Object[] { "Mã nhân viên", "Họ và tên", "Tuổi", "Email", "Lương" });
		this.tableSV.setModel(defaultTableModel);
		tableSV.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableSV.setRowHeight(25);
		tableSV.setBounds(84, 326, 467, 201);
		tableSV.getColumnModel().getColumn(0).setPreferredWidth(40);
		tableSV.getColumnModel().getColumn(2).setPreferredWidth(15);
		tableSV.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableSV.getColumnModel().getColumn(4).setPreferredWidth(15);
	}

	public void initComponents() {
		setResizable(false);

		this.listEmployee = new danhSachEmployee();
		this.ac = new controllerEmployee(this);

		setFont(new Font("Dialog", Font.BOLD, 16));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setHorizontalAlignment(SwingConstants.CENTER);
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menuFile);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuFile.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Save");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuFile.add(mntmNewMenuItem_1);
		
		JSeparator separator_2 = new JSeparator();
		menuFile.add(separator_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Close");
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuFile.add(mntmNewMenuItem_2);
		
		JSeparator separator_1 = new JSeparator();
		menuFile.add(separator_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Exit");
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuFile.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("About me");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);

		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTitle.setBounds(229, 10, 171, 26);
		contentPane.add(lblTitle);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 608, 7);
		contentPane.add(separator);

		JLabel lbl_maNV = new JLabel("Mã nhân viên");
		lbl_maNV.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbl_maNV.setBounds(10, 83, 94, 20);
		contentPane.add(lbl_maNV);

		JLabel lbl_hoVaTen = new JLabel("Họ và Tên");
		lbl_hoVaTen.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbl_hoVaTen.setBounds(10, 118, 69, 20);
		contentPane.add(lbl_hoVaTen);

		JLabel lbl_age = new JLabel("Tuổi");
		lbl_age.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbl_age.setBounds(10, 155, 45, 20);
		contentPane.add(lbl_age);

		JLabel lbl_email = new JLabel("Email");
		lbl_email.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbl_email.setBounds(10, 194, 45, 20);
		contentPane.add(lbl_email);

		JLabel lbl_salary = new JLabel("Lương");
		lbl_salary.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lbl_salary.setBounds(10, 232, 45, 20);
		contentPane.add(lbl_salary);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(138, 80, 262, 25);
		contentPane.add(txtMaNV);
		txtMaNV.setColumns(10);

		txtHoVaTen = new JTextField();
		txtHoVaTen.setColumns(10);
		txtHoVaTen.setBounds(138, 115, 262, 25);
		contentPane.add(txtHoVaTen);

		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(138, 152, 262, 25);
		contentPane.add(txtAge);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(138, 191, 262, 25);
		contentPane.add(txtEmail);

		txtSalary = new JTextField();
		txtSalary.setColumns(10);
		txtSalary.setBounds(138, 229, 262, 25);
		contentPane.add(txtSalary);

		btnNew = new JButton("New");

		btnNew.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNew.setBounds(516, 79, 85, 20);
		contentPane.add(btnNew);

		lblClock = new JLabel("New label");
		lblClock.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblClock.setBounds(541, 24, 117, 21);
		contentPane.add(lblClock);

		btnFirst = new JButton("|<");
		btnFirst.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFirst.setBounds(45, 294, 69, 21);
		contentPane.add(btnFirst);

		btnPrevious = new JButton("<<");
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPrevious.setBounds(138, 294, 85, 21);
		contentPane.add(btnPrevious);

		btnNext = new JButton(">>");
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNext.setBounds(237, 294, 85, 21);
		contentPane.add(btnNext);

		btnLast = new JButton(">|");
		btnLast.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLast.setBounds(345, 294, 85, 21);
		contentPane.add(btnLast);
		
		this.initTable();

		JScrollPane jscrollPane = new JScrollPane(tableSV);
		jscrollPane.setBounds(15, 360, 633, 161);

		contentPane.add(jscrollPane);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSave.setBounds(516, 109, 85, 20);
		contentPane.add(btnSave);

		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBounds(516, 139, 85, 20);
		contentPane.add(btnDelete);

		btnFind = new JButton("Find");
		btnFind.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnFind.setBounds(516, 169, 85, 20);
		contentPane.add(btnFind);

		btnOpen = new JButton("Open");
		btnOpen.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOpen.setBounds(516, 199, 85, 20);
		contentPane.add(btnOpen);

		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExit.setBounds(516, 233, 85, 20);
		contentPane.add(btnExit);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		horizontalBox.setBounds(488, 63, 145, 203);
		contentPane.add(horizontalBox);

		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		horizontalBox_1.setBounds(0, 343, 658, 194);
		contentPane.add(horizontalBox_1);

		lblRecord = new JLabel("");
		lblRecord.setEnabled(false);
		lblRecord.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblRecord.setBounds(470, 294, 163, 21);
		contentPane.add(lblRecord);
	}

	public danhSachEmployee getListEmployee() {
		return listEmployee;
	}

	public void addActionListener() {
		this.btnNew.addActionListener(ac);
		this.btnDelete.addActionListener(ac);
		this.btnSave.addActionListener(ac);
		this.btnOpen.addActionListener(ac);
		this.btnExit.addActionListener(ac);
		this.btnFind.addActionListener(ac);
		this.btnFirst.addActionListener(ac);
		this.btnPrevious.addActionListener(ac);
		this.btnNext.addActionListener(ac);
		this.btnLast.addActionListener(ac);
	}

	public void resetAllTextFields() {
		this.txtMaNV.setText("");
		this.txtHoVaTen.setText("");
		this.txtAge.setText("");
		this.txtEmail.setText("");
		this.txtSalary.setText("");
		isEditMode = false;
	}

	public void updateTextFields(employee e) {
		this.isEditMode = true;
		this.txtMaNV.setText(e.getId());
		this.txtHoVaTen.setText(e.getName());
		this.txtAge.setText(e.getAge() + "");
		this.txtEmail.setText(e.getEmail());
		this.txtSalary.setText(formatCurrency.format(e.getSalary()));
	}

	public void saveFunction() {
		try {
			// check các dữ liệu
			StringBuilder sb = new StringBuilder();
			Validator test = new Validator();
			boolean ok = true;
			test.checkEmpty(txtMaNV, sb, "Mã nhân viên đang trống.");
			test.checkEmpty(txtHoVaTen, sb, "Tên nhân viên đang trống.");
			test.checkAge(txtAge, sb);
			test.checkEmail(txtEmail, sb);
			test.checkSalary(txtSalary, sb);
			if (sb.toString().length() > 0) {
				JOptionPane.showMessageDialog(this, sb.toString(), "Invalid Data", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String maNV = this.txtMaNV.getText();
			employee tmp = this.listEmployee.searchEmployee(maNV);
			String name = this.txtHoVaTen.getText();
			int age = Integer.valueOf(this.txtAge.getText() + "");
			String email = this.txtEmail.getText();
			double salary = Double.valueOf(this.txtSalary.getText() + "");
			if (!isEditMode) {
				// textfield đang trống
				if (tmp != null)
					JOptionPane.showMessageDialog(this, "Nhân viên đã có trong danh sách.\nKhông thể thêm mới.");
				else {
					// Khi tmp==null thì bây giờ save đóng vai trò như thêm mới
					// nhân viên
					tmp = new employee(maNV, name, age, email, salary);
					this.listEmployee.insertEmployee(tmp);
					this.defaultTableModel.addRow(tmp.covertIntoRow());
					JOptionPane.showMessageDialog(this, "Thông tin nhân viên đã được thêm vào danh sách");
				}
			} else {
				// Nếu chỉnh sửa mà id lại ko tồn tại (tức là tmp==null)
				// thì in ra thông báo
				if (tmp == null)
					JOptionPane.showMessageDialog(this, "Không tồn tại nhân viên bạn cần sửa trong danh sách");
				else {
					// Thay đổi trên vùng nhớ của tmp
					tmp.setName(name);
					tmp.setAge(age);
					tmp.setEmail(email);
					tmp.setSalary(salary);
					this.listEmployee.renderToTable(defaultTableModel);
				}
			}
			// Thêm xong rồi thì xoá trắng các textfield
			this.resetAllTextFields();

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error:" + e.getMessage());
		}

	}

	public void deleteFunction() {
		try {
			String id = this.txtMaNV.getText();
			boolean canDelete = this.listEmployee.deleteById(id);
			if (canDelete) {
				int n = this.defaultTableModel.getRowCount();
				// Nên tìm ra vị trí cần xoá thay vì mỗi lần cứ render
				// ra bảng lại
				for (int i = 0; i < n; i++) {
					if (defaultTableModel.getValueAt(i, 0).equals(id)) {
						defaultTableModel.removeRow(i);
						break;
					}
				}
				JOptionPane.showMessageDialog(this, "Đã xoá thành công nhân viên.");
			} else
				JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên bạn cần xoá.");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error:" + e.getMessage());
		}

	}

	public void findFunction() {
		try {
			String maNV = this.txtMaNV.getText();
			employee res = this.listEmployee.searchEmployee(maNV);
			if (res == null)
				JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên bạn cần");
			else {
				updateTextFields(res);
				isEditMode = true;
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error:" + e.getMessage());
		}

	}

	public void openFunction() {
		JFileChooser fc= new JFileChooser("E:\\BTjava");
		int val=fc.showOpenDialog(this);
		if(val==JFileChooser.APPROVE_OPTION) {
			File f=fc.getSelectedFile();
			try {
				this.listEmployee.loadFromFile(f.getAbsolutePath());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void exitFunction() {
		try {
			this.listEmployee.writeIntoFile();
			System.exit(0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error:" + e.getMessage());
		}
	}

	// Hàm thực hiện in update thông tin các nhân viên khi
	// điều hướng lên các text field
	public void displayEmployee(int index) {
		this.tableSV.setRowSelectionInterval(index, index);
		this.lblRecord.setText("Record " + (index + 1) + "/" + this.listEmployee.getSize());
		employee e = this.listEmployee.getEmployeeByIndex(index);
		updateTextFields(e);
	}

	public void displayRowSelected(int index_row) {
		this.isEditMode = true;
		String id = defaultTableModel.getValueAt(index_row, 0) + "";
		employee e = this.listEmployee.searchEmployee(id);
		this.updateTextFields(e);
		// Cập nhật lại thứ tự của employee được chọn lên label
		this.listEmployee.setCurrentIndex(e);
		this.lblRecord.setText(
				"Record " + (this.listEmployee.getCurrentIndexEmployee() + 1) + "/" + this.listEmployee.getSize());
	}

	public int getSelectedRow() {
		return this.tableSV.getSelectedRow();
	}
}
