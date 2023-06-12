package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import javax.swing.JFileChooser;

import view.MyNotePadView;

public class MyNotepadController implements ActionListener {
	private MyNotePadView myNotePadView;

	public MyNotepadController(MyNotePadView myNotePadView) {
		this.myNotePadView = myNotePadView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JFileChooser fc = new JFileChooser();
		if (src.equals("Open")) {
			int returnVal = fc.showOpenDialog(this.myNotePadView);
			File f = fc.getSelectedFile();
			if (f == null)
				return;
			this.myNotePadView.updateJLabel(f.getAbsolutePath());
			this.myNotePadView.myNotepadModel.setTenFile(f.getAbsolutePath());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String fileName = f.getName();
				// Chỉ đọc file dạng text lên
				if (fileName.endsWith(".txt")) {
					String res = "";
					try {
						List<String> allText = Files.readAllLines(f.toPath(), StandardCharsets.UTF_8);
						int n = allText.size();
						for (int i = 0; i < n; i++) {
							res += allText.get(i);
							if (i < n - 1)
								res += "\n";
						}
						this.myNotePadView.myNotepadModel.setContent(res);
						this.myNotePadView.updateJTextArea(res);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else
					this.myNotePadView.updateJTextArea("File đang mở không đúng định dạng");
			}
		} // Bấm save
		else {
			String tenFile = this.myNotePadView.myNotepadModel.getTenFile();
			String content = this.myNotePadView.jTextArea.getText();
			// Khi vừa bật jFrame lên thì jLabel đang rỗng thì hiển thị cửa sổ để người dùng chọn file
			if (tenFile.length() == 0) {
				int returnVal = fc.showSaveDialog(this.myNotePadView);
				File f = fc.getSelectedFile();
				if (f == null)
					return;
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String name=f.getName();
					if(name.endsWith(".txt"))
						tenFile=f.getAbsolutePath();
					else System.out.println("Vui lòng chọn file .txt");
				}
			}
			File f= new File(tenFile);
			try {
				PrintWriter pw=new PrintWriter(f, "utf-8");
				pw.print(content);
				pw.flush();
				pw.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			
		}
	}

}
