package _10_slot_machine;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	JFrame frame;
	JPanel panel;
	JLabel column1;
	JLabel column2;
	JLabel column3;
	int column1val;
	int column2val;
	int column3val;
	String cherry = "Cherry.jpeg";
	String lemon = "Lemon.png";
	String orange = "Orange.png";
	JButton spin;
	public static void main(String[] args) {
		SlotMachine slots = new SlotMachine();
		slots.start();
	}
	
	void start()
	{
		frame = new JFrame();
		panel = new JPanel();
		spin = new JButton();
		column1val = 0;
		column2val = 0;
		column3val = 0;
		try {
			column1 = createLabelImage(cherry);
			column2 = createLabelImage(orange);
			column3 = createLabelImage(lemon);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dimension size = new Dimension(250, 250);
		column1.setPreferredSize(size);
		column2.setPreferredSize(size);
		column3.setPreferredSize(size);
		spin.setPreferredSize(size);
		spin.setText("Spin");
		spin.addActionListener(this);
		panel.add(column1);
		panel.add(column2);
		panel.add(column3);
		panel.add(spin);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	
	public void Spin()
	{
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
	
	private String valToImage(int val)
	{
		if (val == 0)
		{
			return cherry;
		}
		else if (val == 1)
		{
			return orange;
		}
		else if (val == 2)
		{
			return lemon;
		}
		else
		{
			return cherry;
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		column1val = new Random().nextInt(2);
		column2val = new Random().nextInt(2);
		column3val = new Random().nextInt(2);
		
		try {
			column1 = createLabelImage(cherry);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			column2 = createLabelImage(cherry);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			column3 = createLabelImage(cherry);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (column1val == column2val && column2val == column3val)
		{
			JOptionPane.showMessageDialog(null, "You Win!");
		}
		
		frame.pack();
	}
}
