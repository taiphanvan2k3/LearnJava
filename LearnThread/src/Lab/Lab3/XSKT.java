package Lab.Lab3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class XSKT extends JFrame{

	private JPanel contentPane;
	private JTextField textField_chuc;
	private JTextField textField_donVi;
	private JTextField textField_Tram;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XSKT frame = new XSKT();
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
	public XSKT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("XỔ SỐ KIẾN THIẾT");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(122, 33, 197, 38);
		contentPane.add(lblNewLabel);

		JButton btnStartTram = new JButton("Start");
		btnStartTram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t= new randomThread(textField_Tram);
				t.start();
				btnStartTram.setEnabled(false);
			}
		});
		btnStartTram.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnStartTram.setBounds(71, 188, 65, 21);
		contentPane.add(btnStartTram);

		JLabel lblNewLabel_1 = new JLabel("Trăm");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(71, 105, 45, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Chục");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(190, 105, 45, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Đơn vị");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(292, 105, 45, 13);
		contentPane.add(lblNewLabel_2_1);

		JButton btnStartChuc = new JButton("Start");
		btnStartChuc.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnStartChuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t= new randomThread(textField_chuc);
				t.start();
				btnStartChuc.setEnabled(false);
			}
		});
		btnStartChuc.setBounds(178, 188, 71, 21);
		contentPane.add(btnStartChuc);

		JButton btnStartDonVi = new JButton("Start");
		btnStartDonVi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t= new randomThread(textField_donVi);
				t.start();
				btnStartDonVi.setEnabled(false);
			}
		});
		btnStartDonVi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnStartDonVi.setBounds(288, 188, 75, 21);
		contentPane.add(btnStartDonVi);

		textField_chuc = new JTextField();
		textField_chuc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_chuc.setEditable(false);
		textField_chuc.setHorizontalAlignment(SwingConstants.CENTER);
		textField_chuc.setBounds(178, 152, 71, 19);
		contentPane.add(textField_chuc);
		textField_chuc.setColumns(10);

		textField_donVi = new JTextField();
		textField_donVi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_donVi.setEditable(false);
		textField_donVi.setHorizontalAlignment(SwingConstants.CENTER);
		textField_donVi.setBounds(288, 152, 75, 19);
		contentPane.add(textField_donVi);
		textField_donVi.setColumns(10);

		textField_Tram = new JTextField();
		textField_Tram.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Tram.setEditable(false);
		textField_Tram.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Tram.setBounds(72, 152, 71, 19);
		contentPane.add(textField_Tram);
		textField_Tram.setColumns(10);
	}
}
