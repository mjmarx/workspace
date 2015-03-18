package lab5;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab5 extends JFrame {

	private JButton jbtSubmit = new JButton("Submit");
	private JTextField jbtTxt = new JTextField(30);
	private JTextArea jbtArea = new JTextArea(2,30);
	

	
	public Lab5(){
		jbtArea.setEditable(false);
		add(jbtTxt, BorderLayout.NORTH);
		add(jbtSubmit, BorderLayout.CENTER);
		add(jbtArea, BorderLayout.SOUTH);
		
		SubmitListener s1 = new SubmitListener();
		jbtSubmit.addActionListener(s1);
	}
	
	public static void main(String[] args){
		Lab5 frame = new Lab5();
		frame.setTitle("My furst GUI");
		frame.setSize(300, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	class SubmitListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e){
			String temp = jbtTxt.getText();
			temp = temp.toUpperCase();
			jbtArea.setText(temp);
		}
	}
	
}
