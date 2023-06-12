package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.ThucDonController;
import model.ThucDonModel;

public class ThucDonView extends JFrame {
	private JCheckBox jCheckBox_MilkTea;
	private JCheckBox jCheckBox_Coca;
	private JCheckBox jCheckBox_cake;
	private JLabel jLabel_hoaDon;
	private JRadioButton jRadioButton_Rice;
	private JRadioButton jRadioButton_Bread;
	private JRadioButton jRadioButton_Noodle;
	public ButtonGroup buttonGroup_monChinh;
	public ArrayList<JCheckBox> list_monPhu;

	private ThucDonModel thucDonModel;

	public ThucDonView() {
		this.thucDonModel = new ThucDonModel();
		this.init();
		Font font = new Font("Arial", Font.BOLD, 20);
		JLabel jLabel_title = new JLabel("THỰC ĐƠN MÓN ĂN", JLabel.CENTER);
		jLabel_title.setFont(font);
		this.setLayout(new BorderLayout());
		this.add(jLabel_title, BorderLayout.NORTH);

		// jPanel món chính
		JPanel jPanel_monChinh = new JPanel();
		jPanel_monChinh.setLayout(new GridLayout(1, 3));
		jRadioButton_Rice = new JRadioButton("Cơm");
		jRadioButton_Rice.setFont(font);
		jRadioButton_Bread = new JRadioButton("Bánh mì");
		jRadioButton_Bread.setFont(font);
		jRadioButton_Noodle = new JRadioButton("Mì");
		jRadioButton_Noodle.setFont(font);

		// Phải add 3 jRadioButton vào cùng 1 ButtonGroup
		// mới có thể chọn 1 trong 3 chức năng,
		buttonGroup_monChinh = new ButtonGroup();
		buttonGroup_monChinh.add(jRadioButton_Rice);
		buttonGroup_monChinh.add(jRadioButton_Bread);
		buttonGroup_monChinh.add(jRadioButton_Noodle);
		jPanel_monChinh.add(jRadioButton_Rice);
		jPanel_monChinh.add(jRadioButton_Bread);
		jPanel_monChinh.add(jRadioButton_Noodle);

		// jPanel món phụ (có thể chọn nhiều món phụ) =>JCheckBox
		JPanel jPanel_monPhu = new JPanel();
		jCheckBox_MilkTea = new JCheckBox("Trà sữa");
		jCheckBox_MilkTea.setFont(font);
		jCheckBox_Coca = new JCheckBox("Coca");
		jCheckBox_Coca.setFont(font);
		jCheckBox_cake = new JCheckBox("Bánh ngọt");
		jCheckBox_cake.setFont(font);
		jPanel_monPhu.setLayout(new GridLayout(1, 3));
		list_monPhu = new ArrayList<>();
		list_monPhu.add(jCheckBox_MilkTea);
		list_monPhu.add(jCheckBox_Coca);
		list_monPhu.add(jCheckBox_cake);
		jPanel_monPhu.add(jCheckBox_MilkTea);
		jPanel_monPhu.add(jCheckBox_Coca);
		jPanel_monPhu.add(jCheckBox_cake);

		// Panel món ăn gồm 2 jpanel là món chính và món phụ
		JPanel jPanel_monAn = new JPanel();
		jPanel_monAn.setLayout(new GridLayout(2, 1));
		jPanel_monAn.add(jPanel_monChinh);
		jPanel_monAn.add(jPanel_monPhu);

		// Thanh toán
		JPanel jPanel_thanhToan = new JPanel();
		jLabel_hoaDon = new JLabel();

		JButton jButton_thanhToan = new JButton("Thanh toán");
		jButton_thanhToan.setFont(font);
		jButton_thanhToan.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThucDonView.class.getResource("icon_pay.png"))));
		jPanel_thanhToan.setLayout(new GridLayout(1, 2));
		jPanel_thanhToan.add(jLabel_hoaDon);
		jPanel_thanhToan.add(jButton_thanhToan);

		// Thêm sự kiện cho các JRadioButton và JCheckBox
		ActionListener ac = new ThucDonController(this);
		
		//Ko cần addActionListener cũng được, chỉ cần Add cho button thanh toán thôi
		//là được, việc còn lại là xem option nào đc chọn trong controller
		
		
//		jRadioButton_Rice.addActionListener(ac);
//		jRadioButton_Bread.addActionListener(ac);
//		jRadioButton_Noodle.addActionListener(ac);
//		jCheckBox_MilkTea.addActionListener(ac);
//		jCheckBox_Coca.addActionListener(ac);
//		jCheckBox_cake.addActionListener(ac);
		jButton_thanhToan.addActionListener(ac);
		
		this.add(jPanel_monAn, BorderLayout.CENTER);
		this.add(jPanel_thanhToan, BorderLayout.SOUTH);
	}

	public void init() {
		this.setTitle("Thực đơn");
		this.setSize(900, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void setMonChinh(String src) {
		this.thucDonModel.setMonChinh(src);
	}

	public void setMonPhu(String src) {
		this.thucDonModel.setMonPhu(src);
	}

	public void updateTongTien() {
		this.thucDonModel.tinhTongTien();
		
	}
	public void InHoaDon() {
		String str="Món chính:"+this.thucDonModel.getMonChinh()+
				"   Món phụ:"+this.thucDonModel.getMonPhu()+
				"   Tổng tiền:"+this.thucDonModel.getTongTien();
		this.jLabel_hoaDon.setText(str);
	}
}
