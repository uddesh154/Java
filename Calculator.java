import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Calculator extends JFrame{
	private JPanel panButtons;
	private JTextField txtDisplay;
	private JButton btnDigits[],btnOp[],btnDot,btnEqual;
	private float a,b,ans;
	private char oper;

	public Calculator(){
		btnDigits = new JButton[10];

		for(int i=0;i<10;i++){
			btnDigits[i] = new JButton(Integer.toString(i));
		}

		btnOp = new JButton[4];
		String op[]={"+","-","*","/"};
		for(int i=0;i<4;i++){
			btnOp[i] = new JButton(op[i]);
		}

		btnDot = new JButton(".");
		btnEqual = new JButton("=");
		
		txtDisplay = new JTextField();
		txtDisplay.setEditable(false);
		txtDisplay.setHorizontalAlignment(JTextField.RIGHT);

		panButtons = new JPanel();
		panButtons.setLayout(new GridLayout(4,4));
		panButtons.add(btnDigits[1]);
		panButtons.add(btnDigits[2]);
		panButtons.add(btnDigits[3]);
		panButtons.add(btnOp[0]);
		panButtons.add(btnDigits[4]);
		panButtons.add(btnDigits[5]);
		panButtons.add(btnDigits[6]);
		panButtons.add(btnOp[1]);
		panButtons.add(btnDigits[7]);
		panButtons.add(btnDigits[8]);
		panButtons.add(btnDigits[9]);
		panButtons.add(btnOp[2]);
		panButtons.add(btnDigits[0]);
		panButtons.add(btnDot);
		panButtons.add(btnEqual);
		panButtons.add(btnOp[3]);

		setTitle("Calculator");
		setSize(400,400);
		add(txtDisplay,"North");
		add(panButtons,"Center");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnDot.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				String s = txtDisplay.getText();
				int i = s.indexOf(".");
				if(i==-1) s += ".";
				txtDisplay.setText(s);
			}
		});

		for(int i=0;i<10;i++){
			btnDigits[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					String s = txtDisplay.getText();
					s += ae.getActionCommand();
					txtDisplay.setText(s);
				}
			});
		}		

		for(int i=0;i<4;i++){
			btnOp[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					oper = ae.getActionCommand().charAt(0);
					a = Float.parseFloat(txtDisplay.getText());
					txtDisplay.setText("");
				}
			});
		}		

		btnEqual.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				b = Float.parseFloat(txtDisplay.getText());
				switch(oper)
				{
				case '+':
					ans = a+b;
					break;
				case '-':
					ans = a-b;
					break;
				case '*':
					ans = a*b;
					break;
				case '/':
					ans = a/b;
				}
				txtDisplay.setText(Float.toString(ans));
			}
		});
	}

	public static void main(String args[]){
		new Calculator();
	}
} 
