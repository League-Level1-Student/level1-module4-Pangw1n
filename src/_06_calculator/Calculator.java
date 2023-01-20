package _06_calculator;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JPanel inputs = new JPanel();
	JPanel operators = new JPanel();
	JLabel output = new JLabel();
	JTextField input1 = new JTextField();
	JTextField input2 = new JTextField();
	JButton add = new JButton();
	JButton sub = new JButton();
	JButton multi = new JButton();
	JButton div = new JButton();
	
	void run() {
		frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 250));
        frame.add(panel);
		
        
        
        Dimension inputsPanelSize = new Dimension(400, 40);
		inputs.setPreferredSize(inputsPanelSize);
        panel.add(inputs);
		
		Dimension inputSize = new Dimension(180, 30);
		input1.setPreferredSize(inputSize);
		input2.setPreferredSize(inputSize);
		
		inputs.add(input1);
		inputs.add(input2);
		
		

        Dimension operatorsPanelSize = new Dimension(400, 40);
        operators.setPreferredSize(operatorsPanelSize);
		panel.add(operators);
		
		Dimension buttonSize = new Dimension(90, 30);
		add.setPreferredSize(buttonSize);
		sub.setPreferredSize(buttonSize);
		multi.setPreferredSize(buttonSize);
		div.setPreferredSize(buttonSize);
		
		add.addActionListener(this);
		sub.addActionListener(this);
		multi.addActionListener(this);
		div.addActionListener(this);
		
		add.setText("Add");
		sub.setText("Sub");
		multi.setText("Multi");
		div.setText("Div");
		
		operators.add(add);
		operators.add(sub);
		operators.add(multi);
		operators.add(div);
		
		Dimension outputPanelSize = new Dimension(400, 40);
		output.setPreferredSize(outputPanelSize);
		panel.add(output);
		
		output.setHorizontalAlignment((int) output.CENTER_ALIGNMENT);
		output.setPreferredSize(outputPanelSize);
		output.setText("Output");
		
		frame.pack();
	}
	
	int add(int num1, int num2) {
		int output;
		output = num1 + num2;
		return output;
	}
	
	int sub(int num1, int num2) {
		int output;
		output = num1 - num2;
		return output;
	}
	
	int multi(int num1, int num2) {
		int output;
		output = num1 * num2;
		return output;
	}
	
	int div(int num1, int num2) {
		int output;
		output = num1 / num2;
		return output;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton pressedButton = (JButton) e.getSource();
		
		int num1 = Integer.parseInt(input1.getText());
		int num2 = Integer.parseInt(input2.getText());
		
		if(pressedButton == add)
		{
			output.setText(add(num1, num2) + "");
		}
		if(pressedButton == sub)
		{
			output.setText(sub(num1, num2) + "");
		}
		if(pressedButton == multi)
		{
			output.setText(multi(num1, num2) + "");
		}
		if(pressedButton == div)
		{
			output.setText(div(num1, num2) + "");
		}
	}
}
