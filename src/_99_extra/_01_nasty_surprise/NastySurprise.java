package _99_extra._01_nasty_surprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySurprise implements ActionListener {
	public static void main(String[] args) {
		new NastySurprise().Start();
	}
	
	JFrame frame;
	JPanel panel;
	JButton trickButton;
	JLabel label;
	JButton treatButton;
	
	void Start()
	{
		frame = new JFrame();
		panel = new JPanel();
		frame.add(panel);
		frame.setVisible(true);
		
		
		trickButton = new JButton();
		trickButton.setText("Trick!");
		trickButton.addActionListener(this);
		panel.add(trickButton);
		
		label = new JLabel();
		label.setText("or");
		panel.add(label);
		
		treatButton = new JButton();
		treatButton.setText("Treat!");
		treatButton.addActionListener(this);
		panel.add(treatButton);
		
		frame.pack();
	}
	
	private void showPictureFromTheInternet(String imageUrl) {
	    try {
	        URL url = new URL(imageUrl);
	        Icon icon = new ImageIcon(url);
	        JLabel imageLabel = new JLabel(icon);
	        JFrame frame = new JFrame();
	        frame.add(imageLabel);
	        frame.setVisible(true);
	        frame.pack();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton pressedButton = (JButton) e.getSource();
		
		if (pressedButton == trickButton)
		{
			showPictureFromTheInternet("https://hips.hearstapps.com/hmg-prod/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=0.752xw:1.00xh;0.175xw,0&resize=1200:*");
		}
		else if (pressedButton == treatButton)
		{
			showPictureFromTheInternet("https://i.ytimg.com/vi/EEwGzd6hQ9g/hqdefault.jpg");
		}
	}
}
