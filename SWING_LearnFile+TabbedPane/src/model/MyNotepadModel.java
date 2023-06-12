package model;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyNotepadModel extends JFrame {
	private String tenFile, content;

	public MyNotepadModel() {
		this.tenFile = this.content = "";
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
