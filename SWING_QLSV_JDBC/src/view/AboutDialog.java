package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the dialog.
	 */

	public AboutDialog(JFrame frame,boolean modal) {
		super(frame, modal);
		setBounds(100, 100, 468, 393);
		this.setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JLabel lblPicture = new JLabel("");
		lblPicture.setHorizontalAlignment(SwingConstants.CENTER);
		lblPicture.setBounds(10, 49, 175, 187);
		contentPanel.add(lblPicture);
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ SINH VIÊN");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(88, 21, 313, 38);
		contentPanel.add(lblNewLabel_1);
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 71, 434, 3);
		contentPanel.add(separator);
		JLabel lblNewLabel_2 = new JLabel("Đơn vị:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(225, 88, 61, 30);
		contentPanel.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("Tác giả:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(225, 142, 61, 30);
		contentPanel.add(lblNewLabel_3);
		JLabel lblNewLabel_4 = new JLabel("Learn From Home");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(294, 88, 135, 30);
		contentPanel.add(lblNewLabel_4);
		JLabel lblNewLabel_5 = new JLabel("Phan Văn Tài");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_5.setBounds(294, 142, 129, 30);
		contentPanel.add(lblNewLabel_5);
		JSeparator separator2 = new JSeparator();
		separator.setBounds(20, 287, 434, 12);
		contentPanel.add(separator);
		JButton btnClose = new JButton("Đóng");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnClose.setBounds(331, 309, 113, 33);
		contentPanel.add(btnClose);
		lblPicture.setIcon(new ImageIcon(this.getClass().getResource("/student_128px.png")));
		btnClose.setIcon(new ImageIcon(this.getClass().getResource("/exit.png")));
	}

	private void closeWindow() {
		this.dispose();
	}
}
