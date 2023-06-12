package deJava2022;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class test extends JFrame implements ActionListener {
	private void init() {
		this.setResizable(false);
		this.setSize(700, 400);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);

		JPanel pnl1 = new JPanel();
		pnl1.setLayout(new GridLayout(6, 2, 50, 15));
		pnl1.setBorder(new EmptyBorder(20, 50, 40, 50));

		JLabel lbl = new JLabel("Độ dài cạnh a:");
		JLabel lbl2 = new JLabel("Độ dài cạnh b:");
		JLabel lbl3 = new JLabel("Độ dài cạnh c:");

		pnl1.add(lbl);
		pnl1.add(new JTextArea());
		pnl1.add(lbl2);
		pnl1.add(new JTextArea());
		pnl1.add(lbl3);
		pnl1.add(new JTextArea());

		pnl1.add(new JLabel(""));
//		pnl1.add(new JButton("Tính diện tích"));
		JComboBox<String> combobox = new JComboBox<>(new String[] { "Từ trái sang phải", "Từ phải sang trái" });

		JList<String> li = new JList<>(new String[] { "Trái sang", "Phải sang" });
		li.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					System.out.println("Selected: " + li.getSelectedValue());
				}
			}
		});
		pnl1.add(combobox);
		pnl1.add(new JLabel(""));
		pnl1.add(new JButton("Tính chu vi"));

		JLabel lbl4 = new JLabel(" ".repeat(10) + "Kết quả:");
		pnl1.add(lbl4);
		pnl1.add(new JTextArea());
		combobox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String str = combobox.getSelectedItem().toString();
				System.out.println(str);
			}
		});
		this.setLayout(new BorderLayout());
		this.add(pnl1, BorderLayout.CENTER);
	}

	private void init2() {
		this.setSize(700, 400);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);

		JPanel pnlLeft = new JPanel();
		pnlLeft.setBackground(Color.red);
		pnlLeft.setBorder(new EmptyBorder(10, 100, 10, 10));
		pnlLeft.setLayout(new GridLayout(6, 1, 20, 20));
		pnlLeft.add(new JLabel("Độ dài cạnh a:"));
		pnlLeft.add(new JLabel("Độ dài cạnh a:"));
		pnlLeft.add(new JLabel("Độ dài cạnh a:"));
		pnlLeft.add(new JLabel(""));
		pnlLeft.add(new JLabel(""));
		pnlLeft.add(new JLabel("Kết quả"));

		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(6, 1, 20, 20));
		pnlCenter.setBorder(new EmptyBorder(10, 60, 20, 100));
		pnlCenter.add(new JTextField());
		pnlCenter.add(new JTextField());
		pnlCenter.add(new JTextField());
		pnlCenter.add(new JButton("Tính diện tích"));
		pnlCenter.add(new JButton("Tính chu vi"));
		pnlCenter.add(new JTextField());

		this.setLayout(new BorderLayout());
		this.add(pnlLeft, BorderLayout.WEST);
		this.add(pnlCenter, BorderLayout.CENTER);
	}

	private void init3() {
		this.setSize(700, 400);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);

		JPanel pnlLeft = new JPanel();
		pnlLeft.setLayout(new GridLayout(3, 1, 20, 20));
		pnlLeft.setBorder(new EmptyBorder(20, 20, 20, 20));

		pnlLeft.add(new JLabel("Import data"));
		pnlLeft.add(new JLabel("Keyword"));
		JButton btnRank = new JButton("Ranking");
		pnlLeft.add(btnRank);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(3, 1, 20, 20));
		pnlCenter.setBorder(new EmptyBorder(20, 20, 20, 20));

		JPanel pnlCenter1 = new JPanel();
		pnlCenter1.setLayout(new GridLayout(1, 2, 20, 20));
		JTextField txtFile = new JTextField();
		JButton btnImport = new JButton("Import file");
		pnlCenter1.add(txtFile);
		pnlCenter1.add(btnImport);

		JTextField txtKeyword = new JTextField();

		JPanel pnlCenter2 = new JPanel();
		pnlCenter2.setLayout(new GridLayout(1, 2, 20, 20));
		JButton btnSearch = new JButton("Search");
		JButton btnWonteams = new JButton("Won teams");

		pnlCenter2.add(btnSearch);
		pnlCenter2.add(btnWonteams);

		pnlCenter.add(pnlCenter1);
		pnlCenter.add(txtKeyword);
		pnlCenter.add(pnlCenter2);

		JPanel pnlTop = new JPanel();
		pnlTop.setLayout(new BorderLayout(20, 20));
		pnlTop.add(pnlLeft, BorderLayout.WEST);
		pnlTop.add(pnlCenter, BorderLayout.CENTER);

		JPanel pnlBottom = new JPanel();
		pnlBottom.setLayout(new BorderLayout());
		pnlBottom.setBorder(new EmptyBorder(20, 20, 20, 20));
		JTextArea txtOutput = new JTextArea();
		pnlBottom.add(txtOutput, BorderLayout.CENTER);
		
		this.setLayout(new BorderLayout(20, 20));
		this.add(pnlTop, BorderLayout.NORTH);
		this.add(pnlBottom, BorderLayout.CENTER);
	}

	public test() {
		init3();
		this.setVisible(true);
	}

	public static void main(String[] args) {
//		try {
//			FileReader fr = new FileReader("./src/lamBai/input.txt");
//			BufferedReader br = new BufferedReader(fr);
//			String str = null;
//			while (true) {
//				str = br.readLine();
//				if (str == null)
//					break;
//				System.out.println(str);
//			}
//			br.close();
//			fr.close();
//		} catch (Exception e2) {
//			System.out.println(e2.getMessage());
//		}
		new test();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
