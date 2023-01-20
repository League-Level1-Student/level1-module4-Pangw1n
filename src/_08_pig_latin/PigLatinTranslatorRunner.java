package _08_pig_latin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game_tools.Sound;

public class PigLatinTranslatorRunner implements ActionListener {
	public static void main(String[] args) {
		new PigLatinTranslatorRunner().run();
	}
	PigLatinTranslator translator = new PigLatinTranslator();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField englishInput = new JTextField();
	JTextField piglatinInput = new JTextField();
	JButton convertenla = new JButton();
	JButton convertlaen = new JButton();
	JButton speak = new JButton();
	
	void run()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension inputdim = new Dimension(400,25);
		Dimension convertdim = new Dimension(100,25);
		
		englishInput.setPreferredSize(inputdim);
		piglatinInput.setPreferredSize(inputdim);
		
		convertenla.setPreferredSize(convertdim);
		convertlaen.setPreferredSize(convertdim);
		speak.setPreferredSize(convertdim);
		
		convertenla.addActionListener(this);
		convertlaen.addActionListener(this);
		speak.addActionListener(this);
		
		convertenla.setText(">>");
		convertlaen.setText("<<");
		speak.setText("Speak");
		
		panel.add(englishInput);
		panel.add(convertenla);
		panel.add(convertlaen);
		panel.add(piglatinInput);
		panel.add(speak);
		
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton pressedButton = (JButton) e.getSource();
		
		if (pressedButton == convertenla)
		{
			piglatinInput.setText(translator.translateEnglishToPigLatin(englishInput.getText()));
		}
		else if (pressedButton == convertlaen)
		{
			englishInput.setText(translator.translatePigLatinToEnglish(piglatinInput.getText()));
		}
		else if (pressedButton == speak)
		{
			Sound.speak(piglatinInput.getText());
		}
	}
}
