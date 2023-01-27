package _10_slot_machine;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlotMachine {
	JFrame frame;
	JPanel panel;
	JLabel column1;
	JLabel column2;
	JLabel column3;
	int column1val;
	int column2val;
	int column3val;
	JButton spin;
	public static void main(String[] args) {
		new SlotMachine().start();
	}
	
	void start()
	{
		frame = new JFrame();
		panel = new JPanel();
		column1val = 0;
		column2val = 0;
		column3val = 0;
		column1 = new CreateLabelImage();
		column2 = new CreateLabelImage();
		column3 = new CreateLabelImage();
	}
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
	}
}
