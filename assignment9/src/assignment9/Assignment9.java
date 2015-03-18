package assignment9;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Assignment9 extends JFrame {
	//text fields and submit button
	JButton addDogButton = new JButton("Add Dog");
	JTextField nameText = new JTextField(30);
	JTextField ageText = new JTextField(30);
	JTextField breedText = new JTextField(30);
	JTextArea prints = new JTextArea(20,20);
	
	public Assignment9(){
		//make panel and add fields
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4,1));
		p1.add(nameText);
		p1.add(ageText);
		p1.add(breedText);
		p1.add(addDogButton);
		//make labels
		JLabel name = new JLabel("Name");
		JLabel age = new JLabel("Age");
		JLabel breed = new JLabel("Breed");
		JLabel submit = new JLabel ("Submit");
		//make second panel and add labels
		JPanel p2 = new JPanel();	
		p2.setLayout(new GridLayout(4,1));
		p2.add(name);
		p2.add(age);
		p2.add(breed);
		p2.add(submit);
		
		//Keeping GUI organized? 
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(1,2));
		p3.add(p2);
		p3.add(p1);
		
		add(p3, BorderLayout.NORTH);
		add(prints, BorderLayout.SOUTH);
		
		addDogListener s1 = new addDogListener();
		addDogButton.addActionListener(s1);
	}
	
	public static void main(String[] args){
		Assignment9 frame = new Assignment9();
		frame.setTitle("Project");
		frame.setSize(400, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	class addDogListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e){
			//could be saved as a dog object and use toString() ??
			String temp = "\n Dog Added \n Name: " + nameText.getText();
			temp+= "\n Age: " + ageText.getText();
			temp+= "\n Breed: " + breedText.getText() + "\n";
			prints.append(temp);
		}
	}
	
}
