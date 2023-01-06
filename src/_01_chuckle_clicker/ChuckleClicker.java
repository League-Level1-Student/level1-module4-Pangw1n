package _01_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton jokeButton;
	JButton punchlineButton;
	public static void main(String[] args) {
		ChuckleClicker chuckleClicker = new ChuckleClicker();
		chuckleClicker.MakeButtons();
	}
	
	void MakeButtons()
	{
		frame = new JFrame();
		
		frame.setVisible(true);
		
		panel = new JPanel();
		
		jokeButton = new JButton();
		jokeButton.setText("Joke");
		jokeButton.addActionListener(this);
		punchlineButton = new JButton();
		punchlineButton.setText("Punchline");
		punchlineButton.addActionListener(this);
		
		frame.add(panel);
		panel.add(jokeButton);
		panel.add(punchlineButton);
		
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jokeButton)
		{
			JOptionPane.showMessageDialog(null, "What do you call a cow with no legs?");
		}
		else if (e.getSource() == punchlineButton)
		{
			JOptionPane.showMessageDialog(null, "Ground beef!");
		}
	}
	
	
}
