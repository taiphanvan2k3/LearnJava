package deJava2022;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class De_2_102210230_PhanVanTai extends JFrame implements ActionListener {
	private HashMap<String, Team> map = new HashMap<>();
	private List<Team> ranking;
	private JTextField txtFileName;
	private JButton btnImport;
	private JTextArea textArea;
	private JButton btnRank;
	private JButton btnSearch;
	private JButton btnWonteams;

	private JTextField txtSchool;

	private void init() {
		this.setResizable(false);
		this.setTitle("Quan ly ket qua ICPC");
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel1.setLayout(new GridLayout(1, 3, 20, 20));
		JLabel lbl1 = new JLabel("Import data");
		txtFileName = new JTextField(20);
		btnImport = new JButton("Import file");
		panel1.add(lbl1);
		panel1.add(txtFileName);
		panel1.add(btnImport);

		JPanel panel2 = new JPanel();
//		Do panel2 các phần tử nó ko thuộc dạng layout nào cả nên dùng null
		panel2.setLayout(null);
		JLabel lbl2 = new JLabel("Keyword");
		txtSchool = new JTextField(30);

		panel2.add(lbl2);
		panel2.add(txtSchool);
		lbl2.setBounds(20, 20, 80, 30);
		txtSchool.setBounds(210, 20, 360, 30);

		JPanel panel3 = new JPanel();
		panel3.setBorder(new EmptyBorder(10, 20, 20, 20));
		panel3.setLayout(new GridLayout(1, 3, 30, 30));
		btnRank = new JButton("Ranking");
		btnSearch = new JButton("Search");
		btnWonteams = new JButton("Won teams");
		panel3.add(btnRank);
		panel3.add(btnSearch);
		panel3.add(btnWonteams);

		JPanel pnlAll = new JPanel();
		pnlAll.setLayout(new GridLayout(3, 1, 10, 10));
		pnlAll.add(panel1);
		pnlAll.add(panel2);
		pnlAll.add(panel3);

		JPanel panelTextArea = new JPanel();
		panelTextArea.setBorder(new EmptyBorder(20, 20, 20, 20));

		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		panelTextArea.setLayout(new BorderLayout());
		panelTextArea.add(scroll, BorderLayout.CENTER);
//		panelTextArea.setLayout(new GridLayout(1, 1));
//		panelTextArea.add(scroll);

		this.setLayout(new BorderLayout());
		this.add(pnlAll, BorderLayout.NORTH);
		this.add(panelTextArea, BorderLayout.CENTER);

		btnImport.addActionListener(this);
		btnRank.addActionListener(this);
		btnSearch.addActionListener(this);
		btnWonteams.addActionListener(this);
	}

	private Connection getConnection() {
		Connection cnn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;encrypt=true;" + "database=DUT;trustServerCertificate=true;";
			String username = "sa";
			String pass = "taiphan2403";
			cnn = DriverManager.getConnection(url, username, pass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cnn;
	}

	private void InsertTeam(Team t) {
		try {
			Connection c = getConnection();
			String query = "insert into ICPC " + "values (?,?,?,?,?)";
			PreparedStatement pst = c.prepareStatement(query);
			pst.setString(1, t.teamName);
			pst.setString(2, t.uniName);
			pst.setString(3, t.problemID);
			pst.setInt(4, t.Time);
			pst.setString(5, t.result);
			int n = pst.executeUpdate();
			if (n > 0)
				System.out.println("Insert successfully");
			c.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void ReadFile(String fileName) {
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str_show = "";
			while (true) {
				String str = br.readLine();
				if (str == null || str.equals(""))
					break;
				String[] ds = str.split(",");
				Team t = new Team();
				t.teamName = ds[0];
				t.uniName = ds[1];
				t.problemID = ds[2];
				t.Time = Integer.valueOf(ds[3]);
				t.result = ds[4];
				InsertTeam(t);
				if (!str_show.isEmpty())
					str_show += "\n";
				str_show += str;
			}
			textArea.setText(str_show);
			br.close();
			fr.close();
		} catch (Exception e) {
		}
	}

	private ArrayList<Team> ExecuteQuery() {
		String query = "select *from ICPC";
		try {
			Connection c = getConnection();
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(query);
			ArrayList<Team> li = new ArrayList<>();
			while (rs.next()) {
				Team t = new Team();
				t.teamName = rs.getString(1);
				t.uniName = rs.getString(2);
				t.problemID = rs.getString(3);
				t.Time = rs.getInt(4);
				t.result = rs.getString(5);
				li.add(t);
			}
			c.close();
			return li;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	private void calculateRanking() {
		ArrayList<Team> li = ExecuteQuery();
		for (Team team : li) {
			if (team.result.equals("AC")) {
				Team tmp = null;
				if (map.containsKey(team.teamName)) {
					tmp = map.get(team.teamName);
					if (!tmp.problems.contains(team.problemID)) {
						tmp.AC_count++;
						tmp.problems.add(team.problemID);
					}
				} else {
					tmp = team;
					tmp.AC_count = 1;
					tmp.problems.add(tmp.problemID);
					map.put(tmp.teamName, tmp);
				}
				tmp.submitLastTime = Math.max(tmp.submitLastTime, team.Time);
			} else {
				if (!map.containsKey(team.teamName))
					map.put(team.teamName, team);
			}
		}

		ranking = new ArrayList<>();
		for (Map.Entry<String, Team> entry : map.entrySet()) {
			ranking.add(entry.getValue());
		}

		Collections.sort(ranking);
		for (int i = 1; i < ranking.size(); i++) {
			Team prev = ranking.get(i - 1);
			Team curr = ranking.get(i);
			if (curr.AC_count != prev.AC_count || curr.submitLastTime > prev.submitLastTime) {
				curr.rank = prev.rank + 1;
			} else
				curr.rank = prev.rank;
		}
	}

	private void calculateRanking2() {
		try {
			Connection c = getConnection();
			String query = "select *from icpc " + "order by teamName,time";
			PreparedStatement pst = c.prepareStatement(query);
			ranking = new ArrayList<>();
			HashMap<String, Team> hashMap = new HashMap<>();
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String teamName = rs.getString(1);
				String problemID = rs.getString("problemID");
				Team tmp = null;
				if (hashMap.containsKey(teamName)) {
					tmp = hashMap.get(teamName);
				} else {
					tmp = new Team();
					tmp.teamName = teamName;
					tmp.uniName = rs.getString(2);
					ranking.add(tmp);
					hashMap.put(teamName, tmp);
				}

				if (rs.getString("result").equals("AC")) {
					if (!tmp.problems.contains(problemID)) {
						tmp.AC_count++;
						tmp.problems.add(problemID);
						tmp.totalTimeSubmit += Integer.valueOf(rs.getInt("time"));
					}
				}
			}

			Collections.sort(ranking);
			for (int i = 1; i < ranking.size(); i++) {
				Team prev = ranking.get(i - 1);
				Team curr = ranking.get(i);
				if (curr.AC_count != prev.AC_count || curr.totalTimeSubmit > prev.totalTimeSubmit) {
					curr.rank = prev.rank + 1;
				} else
					curr.rank = prev.rank;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void Search(String uniName) {
		String str = "";
		if (ranking == null)
			calculateRanking();
		for (Team team : ranking) {
			if (team.uniName.equals(uniName)) {
				if (!str.isEmpty())
					str += "\n";
				str += team.rank + ", " + team;
			}
		}
		textArea.setText(str);
	}

	private void WonTeams() {
		if (ranking == null)
			calculateRanking();
		ArrayList<Team> li = new ArrayList<>();
		HashMap<String, Team> map = new HashMap<>();
		for (Team team : ranking) {
			if (!map.containsKey(team.uniName)) {
				li.add(team);
				map.put(team.uniName, team);
			} else {
				Team inserted = map.get(team.uniName);
				if (team.rank == inserted.rank)
					li.add(team);
			}
		}

		String str = "";
		int stt = 1;
		for (Team team : li) {
			if (!str.isEmpty())
				str += "\n";
			str += (stt++) + ", " + team;
		}
		textArea.setText(str);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Import file")) {
			ReadFile(txtFileName.getText());
		} else if (src.equals("Ranking")) {
			calculateRanking2();
			String str = "1," + ranking.get(0);
			for (int i = 1; i < ranking.size(); i++) {
				Team curr = ranking.get(i);
				str += "\n" + curr.rank + "," + curr;
			}
			textArea.setText(str);
		} else if (src.equals("Search")) {
			String uniName = txtSchool.getText();
			Search(uniName);
		} else {
			WonTeams();
		}
	}

	public De_2_102210230_PhanVanTai() {
		init();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new De_2_102210230_PhanVanTai();
	}
}

class Team implements Comparable<Team> {
	String teamName;
	String uniName;
	String problemID;
	int Time;
	String result;

	int rank;
	int AC_count;
	int totalTimeSubmit;
	int submitLastTime;
	List<String> problems = new ArrayList<>();

	public Team() {
		totalTimeSubmit = 0;
		AC_count = 0;
		rank = 1;
	}

	@Override
	public int compareTo(Team o) {
		if (this.AC_count != o.AC_count)
			return o.AC_count - this.AC_count;
		// return this.submitLastTime - o.submitLastTime;
		return this.totalTimeSubmit - o.totalTimeSubmit;
	}

	@Override
	public String toString() {
//		return this.teamName + "," + this.uniName + "," + AC_count + "," + submitLastTime;
		return this.teamName + "," + this.uniName + "," + AC_count + "," + totalTimeSubmit;
	}
}
