package exercise10b;
import javax.swing.*;
import java.awt.BorderLayout;

public class Exercise10b extends JFrame {

	JButton jbtSubmit = new JButton("Submit");
	
	public Exercise10b(){


		JPanel p = new JPanel();
		p.add(jbtSubmit); //I did these differently on purpose
		p.add(new JButton("Cancel"));  
		
		add(p, BorderLayout.SOUTH);

	}
	
	public static void main(String[] args){
		Exercise10b frame = new Exercise10b();
		frame.setTitle("My furst GUI");
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	

	
}
