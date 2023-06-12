package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.controllerMouse;
import model.mouse;

public class viewTool extends JFrame{
	private mouse modelMouse;
	private JPanel jPanel_center;
	private JLabel posX;
	private JLabel posY;
	private JLabel numOfClicks;
	private JLabel checkPos;

	public viewTool() {
		this.init();
		Font font= new Font("Arial",Font.BOLD,15);
		
		JPanel footer = new JPanel();
		footer.setLayout(new GridLayout(3, 3, 10, 10));
		JLabel pos= new JLabel("position:");
		pos.setFont(font);
		JLabel jLabel_numOfClicks= new JLabel("number of clicks:");
		jLabel_numOfClicks.setFont(font);
		JLabel jLabel_checkPos= new JLabel("mouse is in component:");
		jLabel_checkPos.setFont(font);
		posX= new JLabel("x=");
		posX.setFont(font);
		posY= new JLabel("y=");
		posY.setFont(font);
		numOfClicks= new JLabel("0");
		numOfClicks.setFont(font);
		checkPos= new JLabel();
		checkPos.setFont(font);
		footer.add(pos);
		footer.add(posX);
		footer.add(posY);
		footer.add(jLabel_numOfClicks);
		footer.add(numOfClicks);
		footer.add(new JLabel());
		footer.add(jLabel_checkPos);
		footer.add(checkPos);
		footer.add(new JLabel());
		
		
		//Panel center
		jPanel_center= new JPanel();
		jPanel_center.setBackground(Color.cyan);
		//Add sự kiện vào vị trí panel center cho các thao nhấn, di chuyển
		//vào, ra vùng add sự kiện và sự kiện di chuyển chuột
		controllerMouse ml= new controllerMouse(this);
		jPanel_center.addMouseListener(ml);
		jPanel_center.addMouseMotionListener(ml);
		this.setLayout(new BorderLayout());
		this.add(jPanel_center,BorderLayout.CENTER);
		this.add(footer,BorderLayout.SOUTH);
		
	}
	
	public void init() {
		this.modelMouse= new mouse();
		this.setTitle("Mini toll");
		this.setVisible(true);
		this.setSize(600, 400);
		//setSize trước khi setLocationRelative 
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addClicks() {
		this.modelMouse.click();
		this.numOfClicks.setText(this.modelMouse.getCount()+"");
		this.modelMouse.enter();
		this.checkPos.setText(this.modelMouse.getCheckPos());
	}
	
	public void updatePostion(int x,int y) {
		this.modelMouse.setX(x);
		this.modelMouse.setY(y);
		this.posX.setText(x+"");
		this.posY.setText(y+"");
	}
	
	public void enter() {
		this.modelMouse.enter();
		this.checkPos.setText(this.modelMouse.getCheckPos());
	}
	
	public void exit() {
		this.modelMouse.exit();
		this.checkPos.setText(this.modelMouse.getCheckPos());
	}
}
