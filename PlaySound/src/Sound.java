import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sound extends JFrame {
	private JPanel buttonPanel;
	private JButton soundButton;
	private String soundPath;

	int indexOfMusic = 0;
	int numOfMusicFiles = 4;

	private void initJFrame() {
		this.setTitle("Play Sound Tutorial");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public Sound() {
		this.initJFrame();
		this.getContentPane().setBackground(Color.black);
		this.buttonPanel = new JPanel();

		buttonPanel.setBounds(300, 300, 200, 100);
		buttonPanel.setLayout(new BorderLayout());
		this.add(buttonPanel);

		soundButton = new JButton("Play Music Here.");
		soundButton.setFocusPainted(false);

		soundButton.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("addUser.png")));
		buttonPanel.add(soundButton, BorderLayout.CENTER);
		this.soundPath = "data/sound.wav";
		soundButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SoundEffect soundEffect = new SoundEffect();
				/*
				 * Khi không dùng getClassLoader() thì có thể /.
				 * soundEffect.setFile(this.getClass().getResource("/bgmusic.wav").getPath());
				 */
				soundEffect.setFile(this.getClass().getClassLoader().getResource("bgmusic.wav").getPath());
				soundEffect.playMusic();
			}
		});
	}

	public void test() {
		File f = new File(this.soundPath);
		System.out.println(f.canExecute());
	}

	public class SoundEffect {
		private Clip clip;

		public void setFile(String fileName) {
			try {
				File f = new File(fileName);
				AudioInputStream audio = AudioSystem.getAudioInputStream(f);
				clip = AudioSystem.getClip();
				clip.open(audio);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void playMusic() {
			clip.stop();
			clip.setFramePosition(0);
			clip.start();
		}
	}

	public static void main(String[] args) {
		Sound s = new Sound();
	}
}
