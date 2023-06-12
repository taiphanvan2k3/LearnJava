package Lab;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

public class ThreadClock extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ThreadClock t= new ThreadClock();
		t.setAction();
	}

	/**
	 * Create the frame.
	 */
	public ThreadClock() {
		setFont(new Font("Dialog", Font.PLAIN, 16));
		setBackground(Color.CYAN);
		setTitle("Đồng hồ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 406, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Show Time");
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(121, 97, 146, 39);
		contentPane.add(btnNewButton);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	public void setAction() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat simpleDateFormat= new SimpleDateFormat("hh:mm:ss aa");
				Thread t= new Thread() {
					public void run() {
						btnNewButton.setEnabled(false);
						while(true) {
							Date d1= new Date();
							Calendar d=Calendar.getInstance();
							btnNewButton.setText(simpleDateFormat.format(d.getTime()));
							//btnNewButton.setText(simpleDateFormat.format(d));
							try {
								this.sleep(998);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								break;
							}
						}
					}
				};
				t.start();
			}
		});
	}
}
