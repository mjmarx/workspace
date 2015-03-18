package assignment10;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUI extends JFrame {

	private JTextField nameField = new JTextField(15);
	private JTextField ageField = new JTextField(15);
	private JTextField breedField = new JTextField(15);
	
	private JLabel nameLabel = new JLabel("Name");
	private JLabel ageLabel = new JLabel("Age");
	private JLabel breedLabel = new JLabel("Breed");
	private JLabel addLabel = new JLabel("Submit");
	
	private JTextArea jta = new JTextArea(30,2);
	
	private JButton add = new JButton("Add Animal");
	private JButton average = new JButton("Average Age");
	
	private JRadioButton jrbDog = new JRadioButton("Dog");
	private JRadioButton jrbCat = new JRadioButton("Cat");
	
	private Manager m1 = new Manager();
	
	public GUI() {
		JPanel p1 = new JPanel(new GridLayout(4,2));
		p1.add(nameLabel);
		p1.add(nameField);
		p1.add(ageLabel);
		p1.add(ageField);
		p1.add(breedLabel);
		p1.add(breedField);
		p1.add(addLabel);
		p1.add(add);
		
		ButtonGroup b1 = new ButtonGroup();
		b1.add(jrbDog);
		b1.add(jrbCat);
		JPanel p2 = new JPanel(new GridLayout(1,2));
		p2.add(jrbDog);
		p2.add(jrbCat);
	
		SubmitListener s1 = new SubmitListener();
		add.addActionListener(s1);
		average.addActionListener(s1);
		
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.WEST);
		add(average,BorderLayout.EAST);
		add(jta);
	}
	
	class SubmitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == add) {
				if(jrbDog.isSelected()) {
					jta.append(m1.addDog(nameField.getText(), Integer.parseInt(ageField.getText()), breedField.getText()));
				}
			
				if(jrbCat.isSelected()) {
					jta.append(m1.addCat(nameField.getText(), Integer.parseInt(ageField.getText()), breedField.getText()));
				}
			}
			else if(e.getSource() == average) {
				jta.append("\nAverage Age: " + m1.averageAge() + "\n\n");
			}
		}
	}
	
	public static void main(String[] args) {
		GUI frame = new GUI();
		frame.setTitle("Project");
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}