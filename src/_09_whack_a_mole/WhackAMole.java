package _09_whack_a_mole;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackAMole implements ActionListener {
	JFrame frame;
	JPanel panel;
	
	Date StartTime;
	int moles;
	int misses;
	
	public static void main(String[] args) {
		new WhackAMole().Start();
	}
	
	void Start()
	{
		int rand = new Random().nextInt(9);
		drawButtons(rand);
	}
	
	void drawButtons(int mole)
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(475,500));
		panel = new JPanel();
		
		Dimension dim = new Dimension(150, 150);
		
		for (int i = 0; i < 9; i++)
		{
			JButton button = new JButton();
			button.setPreferredSize(dim);
			button.addActionListener(this);
			panel.add(button);
			if (i == mole)
			{
				button.setText("Mole!");
			}
		}
		
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton eventButton = (JButton) e.getSource();

		if (moles == 0)
		{
			startTimer();
		}
		
		if (eventButton.getText() == "Mole!")
		{
			moles ++;
			if (moles == 10)
			{
				frame.dispose();
				endGame(StartTime, moles);
			}
			else
			{
				int rand = new Random().nextInt(9);
				frame.dispose();
				drawButtons(rand);
			}
		}
		else
		{
			misses ++;
			if (misses == 5)
			{
				endGame(StartTime, moles);
			}
			speak("Miss");
		}
	}
	
	
	
	void startTimer()
	{
		StartTime = new Date();
	}
	
	
	
	private void endGame(Date timeAtStart, int molesWhacked) { 
	    Date timeAtEnd = new Date();
	    frame.dispose();
	    JOptionPane.showMessageDialog(null, "Your whack rate is "
	            + (molesWhacked / ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00))
	                  + " moles per second.");
	}
	
	
	
	
	static void speak(String words) {
        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                    + words + "');\"";
            try {
                Runtime.getRuntime().exec( cmd ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec( "say " + words ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }
}
