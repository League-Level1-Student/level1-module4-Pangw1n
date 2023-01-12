package _03_typing_tutor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	char currentLetter;
	
	void setup() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel);
		panel.add(label);
		
		currentLetter = generateRandomLetter();
		
		label.setText(currentLetter + "");
		label.setFont(label.getFont().deriveFont(50.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		frame.addKeyListener(this);
		
		frame.pack();
	}
	
	char generateRandomLetter() {
	    Random r = new Random();
	    return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e);
		if (e.getKeyChar() == currentLetter)
		{
			currentLetter = generateRandomLetter();
			label.setText(currentLetter + "");
			panel.setBackground(Color.GREEN);
		}
		else
		{
			panel.setBackground(Color.RED);
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
