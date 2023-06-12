package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.ThucDonController;
import model.ThucDonModel;

//Phải extends WindowAdapter thay vì extends JFrame như trước
public class ThucDonView extends WindowAdapter {
	// Tạo đối tượng JFrame là biến toàn cục
	public JFrame f;
	public JLabel jLabel_hoaDon;
	private ThucDonModel thucDonModel;

	public JComboBox<String> jComboBox_monChinh;
	public JList<String> jList_monPhu;

	public ThucDonView() {
		f = new JFrame();

		this.thucDonModel = new ThucDonModel();
		this.init();
		Font font = new Font("Arial", Font.BOLD, 20);
		JLabel jLabel_title = new JLabel("THỰC ĐƠN MÓN ĂN", JLabel.CENTER);
		jLabel_title.setFont(font);
		f.setLayout(new BorderLayout());
		f.add(jLabel_title, BorderLayout.NORTH);

		// jPanel món chính bằng JComboxBox
		JPanel jPanel_monChinh = new JPanel();
		JLabel jLabel_monChinh = new JLabel("Món chính");
		jLabel_monChinh.setFont(font);
		String ds[] = { "Cơm", "Bánh mì", "Mì" };
		jComboBox_monChinh = new JComboBox<String>(ds);
		jPanel_monChinh.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));
		jPanel_monChinh.add(jLabel_monChinh);
		jPanel_monChinh.add(jComboBox_monChinh);

		// jPanel món phụ (có thể chọn nhiều món phụ và số lượng món rất nhiều) =>JList
		JPanel jPanel_monPhu = new JPanel();
		String ds_monPhu[] = { "Trà sữa", "Coca", "Bánh ngọt" };
		jList_monPhu = new JList<String>(ds_monPhu);
		jList_monPhu.setFont(font);
		jPanel_monPhu.setLayout(new BorderLayout());
		jPanel_monPhu.add(jList_monPhu, BorderLayout.CENTER);
		
		// Tạo thanh cuộn cho JList
		// C1: tạo thanh cuộn có component là JList
		JScrollPane jScrollPane = new JScrollPane(jList_monPhu);

		// C2:
		// JScrollPane jScrollPane = new JScrollPane(jPanel_monPhu);
		
		// Panel món ăn gồm 2 jpanel là món chính và món phụ
		JPanel jPanel_monAn = new JPanel();
		jPanel_monAn.setLayout(new BorderLayout());
		jPanel_monAn.add(jPanel_monChinh, BorderLayout.NORTH);
		jPanel_monAn.add(jScrollPane, BorderLayout.CENTER);

		// Chức năng thanh toán
		JPanel jPanel_thanhToan = new JPanel();
		jLabel_hoaDon = new JLabel();

		JButton jButton_thanhToan = new JButton("Thanh toán");
		jButton_thanhToan.setFont(font);
		
		//Tạo icon cho button thanh toán
		jButton_thanhToan.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(ThucDonView.class.getResource("icon_pay.png"))));
		jPanel_thanhToan.setLayout(new GridLayout(1, 2));
		jPanel_thanhToan.add(jLabel_hoaDon);
		jPanel_thanhToan.add(jButton_thanhToan);

		// Chỉ đơn giản add action listener cho nút thanh toán thôi
		ActionListener ac = new ThucDonController(this);
		jButton_thanhToan.addActionListener(ac);

		// Xử lí sự kiện tắt cửa sổ bằng cách addWindowListener
		f.addWindowListener(this);
		f.add(jPanel_monAn, BorderLayout.CENTER);
		f.add(jPanel_thanhToan, BorderLayout.SOUTH);
	}

	// Xử lí sự kiện tắt cửa sổ JFrame
	public void windowClosing(WindowEvent e) {
		int a = JOptionPane.showConfirmDialog(f, "Are you sure?");
		if (a == JOptionPane.YES_OPTION) {
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	public void init() {
		f.setTitle("Thực đơn");
		f.setSize(900, 500);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	public int getTongTien() {
		return this.thucDonModel.getTongTien();
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
		String str = "Món chính:" + this.thucDonModel.getMonChinh() + "   Món phụ:" + this.thucDonModel.getMonPhu()
				+ "   Tổng tiền:" + this.thucDonModel.getTongTien();
		this.jLabel_hoaDon.setText(str);
	}
}
