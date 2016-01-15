import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener{
	static JButton[] Button = new JButton[10];
	static JTextField text;
	static JButton addButton;
	static JButton subButton;
	static JButton multButton;
	static JButton divButton;
	static JButton eqButton;
	boolean newNumber = true;
	double opnd1 = 0, opnd2= 0, res = 0;
	char operator = '+';
	
	
	public void actionPerformed(ActionEvent e) {
		for (int i=0; i<=9; ++i) {
			if(e.getSource() == Button[i]) {
				addDigit(i);return;
			}
		}
		if (e.getSource() == addButton ){
			opnd1 = Double.parseDouble(text.getText()); 
			newNumber = true;
			operator = '+'; return;
		}else if (e.getSource() == subButton ){
			opnd1 = Double.parseDouble(text.getText()); 
			newNumber = true;
			operator = '-'; return;
		}else if (e.getSource() == multButton ){
			opnd1 = Double.parseDouble(text.getText()); 
			newNumber = true;
			operator = '*'; return;
		}else if (e.getSource() == divButton ){
			opnd1 = Double.parseDouble(text.getText()); 
			newNumber = true;
			operator = '/'; return;
		}
		if (e.getSource() == eqButton) {
			opnd2 = Double.parseDouble(text.getText()); 
			switch (operator) {
				case '/': res = opnd1 / opnd2; break; 
				case '*': res = opnd1 * opnd2; break; 
				case '-': res = opnd1 - opnd2; break; 
				case '+': res = opnd1 + opnd2; break;
				}
			display(""+res);
			newNumber = true; 
			return;
		}
	}
	
	public void addDigit(int i){
		if(newNumber){
			display("" + i);
			newNumber = false;
		}else{
			display(text.getText()+i);
		}
	}
	
	public void display(String s){
		text.setText(s);
	}

	public static void main(String[] args){
		JFrame frm = new JFrame("Calculator");
		Container content = frm.getContentPane();
		ActionListener AL = new Calculator();
		content.setLayout((new BorderLayout()));
		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.add(new JLabel("CSC 20 Lab 08", JLabel.CENTER), BorderLayout.NORTH);
		text = new JTextField("0.");
		text.addActionListener(AL);
		panel1.add( text, BorderLayout.SOUTH);
		text.setHorizontalAlignment(JTextField.RIGHT);
		content.add(panel1, BorderLayout.NORTH);
		JPanel panel2 = new JPanel(new GridLayout(4, 5));
		panel2.add(new JButton("BkSP"));
		panel2.add(new JButton("CE"));
		panel2.add(new JButton("C"));
		divButton = new JButton("/");
		panel2.add(divButton);
		divButton.addActionListener(AL);
		panel2.add(new JButton("sqrt"));
		for (int i=7; i>0; i=i-3){
			Button[i] = new JButton(""+i);
			Button[i].addActionListener(AL);
			panel2.add(Button[i]);
			Button[i+1] = new JButton(""+(i+1));
			Button[i+1].addActionListener(AL);
			panel2.add(Button[i+1]);
			Button[i+2] = new JButton(""+(i+2));
			Button[i+2].addActionListener(AL);
			panel2.add(Button[i+2]);
			if(i == 7){
				multButton = new JButton("*");
				panel2.add(multButton);
				multButton.addActionListener(AL);
				panel2.add(new JButton("%"));
			}else if(i == 4){
				subButton = new JButton("-");
				panel2.add(subButton);
				subButton.addActionListener(AL);
				panel2.add(new JButton("1/x"));
			}else if(i == 1){
				addButton = new JButton("+");
				panel2.add(addButton);
				addButton.addActionListener(AL);
				panel2.add(new JButton("+/-"));
			}
		}
		content.add(panel2, BorderLayout.CENTER);	
		JPanel panel3 = new JPanel(new GridLayout(1, 3));
		Button[0] = new JButton("0");
		panel3.add(Button[0]);
		Button[0].addActionListener(AL);
		panel3.add(new JButton("."));
		eqButton = new JButton("=");
		panel3.add(eqButton);
		eqButton.addActionListener(AL);
		content.add(panel3, BorderLayout.SOUTH);
		frm.pack();
		frm.setSize(318,220);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}
	
}


		

