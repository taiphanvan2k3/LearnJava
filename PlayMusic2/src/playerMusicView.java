import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Color;

public class playerMusicView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private String fileName, filePath;
	private JLabel songNameLabel;
	private Thread startThread, resumeThread;
	long totalLength, timePause;
	private Player player;
	private File myFile;
	private JButton buttonStop;
	private JButton buttonResume;
	private JButton buttonPause;
	private JButton buttonPlay;
	private JButton buttonSelect;
	private FileInputStream fileInputStream;
	private BufferedInputStream bufferedInputStream;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		playerMusicView pl = new playerMusicView();

	}

	/**
	 * Create the frame.
	 */

	public void init() {
		this.setTitle("Music App");
		setBackground(new Color(153, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 254);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		this.startThread = new Thread(runnablePlay);
		this.resumeThread = new Thread(resumeThread);
	}

	public playerMusicView() {
		this.init();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		buttonSelect = new JButton("Select Music");
		buttonSelect.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonSelect.setBounds(260, 32, 118, 34);
		contentPane.add(buttonSelect);

		buttonPlay = new JButton("Play");
		buttonPlay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonPlay.setBounds(138, 117, 85, 34);
		contentPane.add(buttonPlay);

		buttonPause = new JButton("Pause");
		buttonPause.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonPause.setBounds(236, 117, 85, 34);
		contentPane.add(buttonPause);

		buttonResume = new JButton("Resume");
		buttonResume.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonResume.setBounds(329, 117, 85, 34);
		contentPane.add(buttonResume);

		buttonStop = new JButton("Stop");
		buttonStop.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		buttonStop.setBounds(424, 117, 85, 34);
		contentPane.add(buttonStop);

		songNameLabel = new JLabel("");
		songNameLabel.setBounds(214, 76, 216, 28);
		contentPane.add(songNameLabel);
		this.setActionListener();
	}

	public void setActionListener() {
		this.buttonSelect.addActionListener(this);
		this.buttonPlay.addActionListener(this);
		this.buttonPause.addActionListener(this);
		this.buttonResume.addActionListener(this);
		this.buttonStop.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Select Music")) {
			JFileChooser jFileChooser = new JFileChooser();
			jFileChooser.setCurrentDirectory(new File("E:\\BtJava\\PlayMusic"));
			jFileChooser.setDialogTitle("Select Mp3");
			jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jFileChooser.setFileFilter(new FileNameExtensionFilter("Files mp3", "mp3"));
			int val = jFileChooser.showOpenDialog(this);
			if (val == JFileChooser.APPROVE_OPTION) {
				myFile = jFileChooser.getSelectedFile();
				this.fileName = myFile.getName();
				this.filePath = myFile.getAbsolutePath();
			}
		} else if (src.equals("Play")) {
			this.startThread.start();
			songNameLabel.setText("Now playing:" + fileName);
		} else if (src.equals("Pause")) {
			this.songNameLabel.setText("Pausing");
			if (player != null) {
				try {
					this.timePause = fileInputStream.available();
					player.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} else if (src.equals("Resume")) {
			this.resumeThread.start();
		} else if (src.equals("Stop")) {
			this.songNameLabel.setText("Stop");
			if (player != null) {
				player.close();
				songNameLabel.setText("");
			}
		}
	}

	// Đa luồng khi bấm start,resume để khi thực hiện các chức năng
	// khác thì việc nghe ko bị dừng
	Runnable runnablePlay = new Runnable() {

		@Override
		public void run() {
			try {
				fileInputStream = new FileInputStream(myFile);
				bufferedInputStream = new BufferedInputStream(fileInputStream);
				try {
					player = new Player(bufferedInputStream);
					try {
						totalLength = fileInputStream.available();
					} catch (IOException e) {
						e.printStackTrace();
					}
					player.play();
				} catch (JavaLayerException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	};

	Runnable runnableResume = new Runnable() {

		@Override
		public void run() {
			try {
				// code for resume button
				fileInputStream = new FileInputStream(myFile);
				bufferedInputStream = new BufferedInputStream(fileInputStream);
				player = new Player(bufferedInputStream);
				fileInputStream.skip(totalLength - timePause);
				player.play();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (JavaLayerException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};
}
