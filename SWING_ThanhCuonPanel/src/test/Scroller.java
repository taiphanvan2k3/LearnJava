package test;
import java.awt.*;

import javax.swing.*;

public class Scroller extends JFrame {

    public Scroller() throws HeadlessException {
    	this.setVisible(true);
    	this.setSize(1000, 700);
        this.setLocationRelativeTo(null);
        final JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.red));
        panel.setPreferredSize(new Dimension(1000, 900));

        final JScrollPane scroll = new JScrollPane(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        JButton btn= new JButton("ABC");
        panel.add(btn);
    }

    public static void main(final String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Scroller().setVisible(true);
            }
        });
    }
}