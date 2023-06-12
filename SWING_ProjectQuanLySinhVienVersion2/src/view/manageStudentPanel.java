package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.SwingConstants;

//Tạo ra panel này để mỗi lần thì sẽ setPanel khác cho giao diện
//Lúc thì quản lý sinh viên,lúc thì quản lý điểm
public class manageStudentPanel extends JPanel {
	private JTextField txtMaSV;
	private JTextField txtTen;
	private DefaultTableModel defaultTableModel;
	private JTable table;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JTextField txtDiaChi;

	/**
	 * Create the panel.
	 */
	public void initTable() {
		table = new JTable();
		table.setBounds(32, 390, 621, 192);
		defaultTableModel = (DefaultTableModel) table.getModel();
		defaultTableModel.setColumnIdentifiers(
				new Object[] { "MSSV", "Họ và tên", "Email", "Số điện thoại", "Giới tính", "Địa chỉ", "Hình" });
		this.table.setModel(defaultTableModel);
	}

	public manageStudentPanel() {
		setLayout(null);
		this.setVisible(true);
		JLabel lblNewLabel = new JLabel("Quản Lý Sinh Viên");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(289, 17, 178, 29);
		add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 44, 675, 10);
		add(separator);

		JLabel lblNewLabel_1 = new JLabel("Mã SV");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(32, 88, 61, 13);
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Họ và tên");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(32, 122, 75, 21);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(32, 167, 45, 21);
		add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Số ĐT");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(32, 203, 45, 21);
		add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Giới Tính");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(32, 242, 75, 21);
		add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Địa chỉ");
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(32, 276, 75, 21);
		add(lblNewLabel_1_5);

		JLabel lblPicture = new JLabel("");
		lblPicture.setBounds(504, 76, 165, 192);
		add(lblPicture);

		txtMaSV = new JTextField();
		txtMaSV.setBounds(129, 83, 250, 25);
		add(txtMaSV);
		txtMaSV.setColumns(10);

		txtTen = new JTextField();
		txtTen.setBounds(129, 118, 250, 25);
		add(txtTen);
		txtTen.setColumns(10);

		JButton btnNewButton = new JButton("New");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(492, 306, 85, 21);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(587, 306, 85, 21);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_2.setBounds(492, 337, 85, 21);
		add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_3.setBounds(587, 337, 85, 21);
		add(btnNewButton_3);
		this.initTable();
		JScrollPane jscrollpane = new JScrollPane(table);
		jscrollpane.setBounds(33, 397, 652, 115);
		add(jscrollpane);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		verticalBox.setBounds(494, 56, 191, 230);
		add(verticalBox);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(129, 160, 250, 29);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(129, 200, 250, 29);
		add(txtSDT);
		
		JRadioButton radioBtnNam = new JRadioButton("Nam");
		radioBtnNam.setSelected(true);
		radioBtnNam.setFont(new Font("Times New Roman", Font.BOLD, 14));
		radioBtnNam.setBounds(124, 238, 103, 21);
		
		
		JRadioButton radioBtnNu = new JRadioButton("Nữ");
		radioBtnNu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		radioBtnNu.setBounds(255, 238, 103, 21);
		//Add 2 radioButton vào ButtonGroup để chỉ hiển thị chọn 1 là Nam/Nữ thôi
		ButtonGroup gr= new ButtonGroup();
		gr.add(radioBtnNam);
		gr.add(radioBtnNu);
		this.add(radioBtnNam);
		this.add(radioBtnNu);
		txtDiaChi = new JTextField();
		txtDiaChi.setHorizontalAlignment(SwingConstants.LEFT);
		txtDiaChi.setBounds(32, 295, 347, 84);
		add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		//Do không truyền được this vào actionPerformed nên buộc phải tạo ra đối tượng contentPanel
		JPanel contentPanel=this;
		JPopupMenu popup= new JPopupMenu();
		popup.setBounds(438, 216, 18, 16);
		JMenuItem jMenuItemLoadAnh= new JMenuItem("Tải ảnh");
		jMenuItemLoadAnh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc= new JFileChooser("E:\\Icon\\");
				int val=fc.showOpenDialog(contentPanel);
				if(val==fc.CANCEL_OPTION)
					return;
				File f= fc.getSelectedFile();
				ImageIcon img= new ImageIcon(f.getPath());
				lblPicture.setIcon(img);
			}
		});
		
		JMenuItem jMenuItemRemove= new JMenuItem("Xoá ảnh");
		jMenuItemRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblPicture.setIcon(null);
			}
		});
		popup.add(jMenuItemLoadAnh);
		popup.addSeparator();
		popup.add(jMenuItemRemove);
		this.add(popup);
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.isPopupTrigger())
					popup.show(e.getComponent(), e.getX(), e.getY());
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger())
					popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public static void main(String[] args) {
		JFrame frame= new JFrame();
		frame.setSize(800,800);
		manageStudentPanel panel= new manageStudentPanel();
		frame.setVisible(true);
		frame.getContentPane().add(panel);
	}
}
