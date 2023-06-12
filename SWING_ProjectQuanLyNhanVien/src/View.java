import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame{
	private JPanel contentPane;
	public View() {
		FormLogin f=new FormLogin();
		f.setVisible(true);
		//this.setContentPane(f);
	}
	
	public static void main(String[] args) {
		new View();
	}
}
