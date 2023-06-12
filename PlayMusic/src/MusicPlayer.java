import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

//implementing ActionListener interface
public class MusicPlayer implements ActionListener {
	JFrame frame;
	JLabel songNameLabel = new JLabel();
	JButton selectButton = new JButton("Select Mp3");
	JButton playButton = new JButton("Play");
	JButton pauseButton = new JButton("Pause");
	JButton resumeButton = new JButton("Resume");
	JButton stopButton = new JButton("Stop");
	JFileChooser fileChooser;
	FileInputStream fileInputStream;
	BufferedInputStream bufferedInputStream;
	File myFile = null;
	String filename;
	String filePath;
	long totalLength;
	long pause;
	Player player;
	Thread playThread;
	Thread resumeThread;

	MusicPlayer() {
		prepareGUI();
		addActionEvents();
		playThread = new Thread(runnablePlay);
		resumeThread = new Thread(runnableResume);

	}

	public static void main(String[] args) {
		new MusicPlayer();
	}

	public void prepareGUI() {
		frame = new JFrame();
		frame.setTitle("Music Player");
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.pink);
		frame.setSize(440, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		selectButton.setBounds(160, 10, 100, 30);
		frame.add(selectButton);

		songNameLabel.setBounds(100, 50, 300, 30);
		frame.add(songNameLabel);

		playButton.setBounds(30, 110, 100, 30);
		frame.add(playButton);

		pauseButton.setBounds(120, 110, 100, 30);
		frame.add(pauseButton);

		resumeButton.setBounds(210, 110, 100, 30);
		frame.add(resumeButton);

		stopButton.setBounds(300, 110, 100, 30);
		frame.add(stopButton);

	}

	public void addActionEvents() {
		// registering action listener to buttons
		selectButton.addActionListener(this);
		playButton.addActionListener(this);
		pauseButton.addActionListener(this);
		resumeButton.addActionListener(this);
		stopButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == selectButton) {
			// code for selecting our mp3 file from dialog window
			fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("E:\\BTJava\\PlayMusic"));
			fileChooser.setDialogTitle("Select Mp3");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setFileFilter(new FileNameExtensionFilter("Mp3 files", "mp3"));
			if (fileChooser.showOpenDialog(selectButton) == JFileChooser.APPROVE_OPTION) {
				myFile = fileChooser.getSelectedFile();
				filename = fileChooser.getSelectedFile().getName();
				filePath = fileChooser.getSelectedFile().getPath();
			}
		}
		if (e.getSource() == playButton) {
			// starting play thread
			System.out.println(playThread.isAlive());
			if(!playThread.isAlive())
				playThread.start();
			songNameLabel.setText("now playing : " + filename);
		}

		if (e.getSource() == pauseButton) {
			System.out.println(this.playThread.isAlive());
			System.out.println(this.resumeThread.isAlive());
			if (player != null) {
				try {
					pause = fileInputStream.available();
					player.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		if (e.getSource() == resumeButton) {
			// starting resume thread
			if (!resumeThread.isAlive())
				resumeThread.start();				
		}
		if (e.getSource() == stopButton) {
			// code for stop button
			if (player != null) {
				player.close();
				songNameLabel.setText("");
			}

		}

	}

	Runnable runnablePlay = new Runnable() {
		@Override
		public void run() {
			try {
				// code for play button
				fileInputStream = new FileInputStream(myFile);
				bufferedInputStream = new BufferedInputStream(fileInputStream);
				player = new Player(bufferedInputStream);
				totalLength = fileInputStream.available();
				player.play();// starting music
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (JavaLayerException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	};

	Runnable runnableResume = new Runnable() {
		@Override
		public void run() {
			try {
				// code for resume button
				fileInputStream = new FileInputStream(myFile);
				fileInputStream.skip(totalLength - pause);
				bufferedInputStream = new BufferedInputStream(fileInputStream);
				player = new Player(bufferedInputStream);
				player.play();
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (JavaLayerException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	};
}