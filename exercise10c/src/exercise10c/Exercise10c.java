package exercise10c;

import javax.swing.*;
import java.awt.event.*;

public class Exercise10c extends JFrame {
	public Exercise10c() {
	  
		//Create three buttons.
		JButton jbtDog = new JButton("Dog");
		JButton jbtCat = new JButton("Cat");
		JButton jbtBird = new JButton("Bird");
		
		//Create a panel and add the buttons.
		JPanel p1 = new JPanel();
		p1.add(jbtDog);
		p1.add(jbtCat);
		p1.add(jbtBird);
		

		//Add the panel to the frame.
		add(p1); 

		//Create the listeners.
		DogListenerClass listener1 = new DogListenerClass();
		CatListenerClass listener2 = new CatListenerClass();
		BirdListenerClass listener3 = new BirdListenerClass();
		    
		
		//Register the listeners.
		jbtDog.addActionListener(listener1);
		jbtCat.addActionListener(listener2);
		jbtBird.addActionListener(listener3);
		
	}
  
	public static void main(String[] args) {
		JFrame frame = new Exercise10c();
		frame.setTitle("Lab 2");
		frame.setSize(200, 150);
		frame.setLocation(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class DogListenerClass implements ActionListener {
	@Override 
	public void actionPerformed(ActionEvent e) {
		System.out.println("BARK BARK!");
	}
}

class CatListenerClass implements ActionListener {
	@Override 
	public void actionPerformed(ActionEvent e) {
		System.out.println("meow");
	}
}

class BirdListenerClass implements ActionListener {
	@Override 
	public void actionPerformed(ActionEvent e) {
		System.out.println("chirp chirp");
	}
}




