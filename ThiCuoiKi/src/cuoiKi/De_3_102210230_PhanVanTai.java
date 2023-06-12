package cuoiKi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class De_3_102210230_PhanVanTai extends JFrame implements ActionListener {
	private JTextField txtImport;
	private JTextField txtKeyword;
	private JButton btnSearch;
	private JButton btnShowAll;
	private JTextArea txtOutput;
	private JButton btnDelete;

	private Graphics g;
	// Lưu trữ tất cả event của hệ thống
	private ArrayList<EventClock> listEvents = new ArrayList<>();
	private JPanel pnlClock;

	private void init() {
		this.setTitle("Dong Ho");
		this.setSize(800, 450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);

		// Thiết kế giao diện nửa bên phải màn hình
		JPanel pnlLeft = new JPanel();
		pnlLeft.setLayout(new GridLayout(3, 1, 20, 20));
		pnlLeft.add(new JLabel("Import data"));
		pnlLeft.add(new JLabel("Keyword"));
		btnDelete = new JButton("Delete");
		pnlLeft.add(btnDelete);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setLayout(new GridLayout(3, 1, 20, 20));

		JPanel pnlCenter1 = new JPanel();
		pnlCenter1.setLayout(new GridLayout(1, 2, 20, 20));
		txtImport = new JTextField();
		JButton btnImport = new JButton("Import file");
		pnlCenter1.add(txtImport);
		pnlCenter1.add(btnImport);

		txtKeyword = new JTextField();

		JPanel pnlCenter2 = new JPanel();
		pnlCenter2.setLayout(new GridLayout(1, 2, 20, 20));
		btnSearch = new JButton("Search");
		btnShowAll = new JButton("Show All");
		pnlCenter2.add(btnSearch);
		pnlCenter2.add(btnShowAll);

		pnlCenter.add(pnlCenter1);
		pnlCenter.add(txtKeyword);
		pnlCenter.add(pnlCenter2);

		JPanel pnlTop = new JPanel();
		pnlTop.setLayout(new BorderLayout(20, 20));
		pnlTop.setBorder(new EmptyBorder(20, 20, 20, 20));

		pnlTop.add(pnlLeft, BorderLayout.WEST);
		pnlTop.add(pnlCenter, BorderLayout.CENTER);

		JPanel pnlBottom = new JPanel();
		pnlBottom.setBorder(new EmptyBorder(20, 20, 20, 20));
		txtOutput = new JTextArea();
		pnlBottom.setLayout(new BorderLayout());
		pnlBottom.add(txtOutput, BorderLayout.CENTER);

		JPanel pnlInput = new JPanel();
		pnlInput.setLayout(new BorderLayout());
		pnlInput.setLayout(new BorderLayout());
		pnlInput.add(pnlTop, BorderLayout.NORTH);
		pnlInput.add(pnlBottom, BorderLayout.CENTER);

		// Thiết kế giao diện cho panelClock
		pnlClock = new JPanel();
		pnlClock.setBorder(new EmptyBorder(20, 20, 20, 20));
		pnlClock.setBackground(Color.white);
//		g = pnlClock.getGraphics();

		this.setLayout(new GridLayout(1, 2, 10, 10));
		this.add(pnlClock);
		this.add(pnlInput);

		btnImport.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);
		btnShowAll.addActionListener(this);
	}

	@Override
	public void paint(Graphics g1) {
		super.paint(g1);

		g = pnlClock.getGraphics();
		if (g != null) {
			g.setColor(Color.green);

			int posX = pnlClock.getLocation().x;
			int posY = pnlClock.getLocation().y;

			int width = pnlClock.getWidth();
			g.drawOval(posX + 30, posY + 30, width - 50, width - 50);

			g.setColor(Color.black);
			g.setFont(new Font("Arial", Font.BOLD, 16));
			g.drawString("12", width / 2 - 10, 20);
			g.drawString("6", width / 2 - 10, width);
			g.drawString("3", width - 10, width / 2 - 10);
			g.drawString("9", 10, width / 2 - 10);

			String events = getEventsInRange(new Date());
			g.drawString("Events:" + events, width - 150, 20);
		}

		try {
//			Thread.sleep(10000);
//			this.repaint();
		} catch (Exception e) {
		}
	}

	public De_3_102210230_PhanVanTai() {
		init();
		this.setVisible(true);
	}

	private Connection getConnection() {
		Connection cnn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;encrypt=true;" + "database=DUT;trustServerCertificate=true;";
			String username = "sa";
			String pass = "taiphan2403";
			cnn = DriverManager.getConnection(url, username, pass);
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cnn;
	}

	/**
	 * Gọi hàm này khi nhấn vào nút import file
	 */
	private void ReadFile() {
		String fileName = txtImport.getText().trim();
		if (fileName.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ tên file để đọc dữ liệu");
		}
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String src = null;
			while (true) {
				src = br.readLine();
				if (src == null || src.equals(""))
					break;
				InsertIntoDB(src);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void InsertIntoDB(String src) {
		String[] ds = src.split(", ");
		if (ds.length != 3) {
			JOptionPane.showMessageDialog(this, "Dữ liệu dòng này không hợp lệ");
			return;
		}

		int time = -1;
		try {
			time = Integer.valueOf(ds[2]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}

		try {
			Connection c = getConnection();
			String query = "insert into Dongho " + "values (?,?,?)";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, ds[0]);
			pst.setString(2, ds[1]);
			pst.setInt(3, time);
			if (pst.executeUpdate() > 0)
				System.out.println("Insert Success");
			c.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void GetRecordContainsKeyWord(String keyword) {
		try {
			txtOutput.setText("");
			Connection c = getConnection();
			String query = "select * from Dongho where name like '%" + keyword + "%'";
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(query);
			String tmp = "";
			int index = 1;
			while (rs.next()) {
				EventClock event = new EventClock();
				listEvents.add(event);
				event.name = rs.getString(1);
				event.time = rs.getString(2);
				event.duration = rs.getInt(3);
				tmp += index + ". " + event + "\n";
				index++;
			}
			txtOutput.setText(tmp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void DeleteRecords() {
		String keyWord = txtKeyword.getText().trim();
		if (keyWord.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khoá để đi xoá");
			return;
		}

		try {
			GetRecordContainsKeyWord(keyWord);
			Connection c = getConnection();
			String query = "delete from Dongho where name like '%" + keyWord + "%'";
			PreparedStatement pst = c.prepareStatement(query);
			int n = pst.executeUpdate();
			System.out.println(n);
			if (n > 0)
				System.out.println("Delete success " + n);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Hiển thị các event thoả mãn Time<=Giờ hệ thống <= Time +duration Dùng để hiển
	 * thị các event này lên panelClock
	 */
	private String getEventsInRange(Date currentTime) {
		// Lấy ra tất cả sự kiện trong hệ thống
		if (listEvents == null) {
			GetRecordContainsKeyWord("");
		}

		int systemHour = currentTime.getHours();
		int systemMinute = currentTime.getMinutes();
		String tmp = "";
		for (EventClock eventClock : listEvents) {
			String time = eventClock.time;
			String[] ds = time.split("h");
			int eventHour = Integer.valueOf(ds[0]);
			int eventMinute = Integer.valueOf(ds[1]);

			// Để có thể kiểm tra giờ hệ thống có nằm trong khoảng của event
			// hay không thì quy ra tổng số phút
			int startTime = eventHour * 60 + eventMinute;
			int endTime = startTime + eventClock.duration;
			int totalMinutesOfSystemClock = systemHour * 60 + systemMinute;

			if (startTime <= totalMinutesOfSystemClock && totalMinutesOfSystemClock <= endTime) {
				if (!tmp.isEmpty())
					tmp += "\n";
				tmp += eventClock.name;
			}
		}
		System.out.println(tmp);
		return tmp;
	}

	public static void main(String[] args) {
		new De_3_102210230_PhanVanTai();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Import file")) {
			ReadFile();
		} else if (src.equals("Delete")) {
			DeleteRecords();
		} else if (src.equals("Search")) {
			String keyWord = txtKeyword.getText().trim();
			GetRecordContainsKeyWord(keyWord);
		} else {
			// Show All và chỉ cần truyền keyword là "" là đủ vì đã dùng like '%...%' ở trên
			GetRecordContainsKeyWord("");
			getEventsInRange(new Date());
		}
	}
}

class EventClock {
	String name;
	String time;
	int duration;

	@Override
	public String toString() {
		return name + ", " + time + ", " + duration;
	}
}
