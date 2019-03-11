import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class GUI {
	
	private int FLAG=0; //used for determining the function of the confirm button is panel_2
	AtmInterface b=new atm();
	int historycount=0; //used for history navigation and is reseted every balance inquiry or returning from panel_2 to panel_1
	JFrame frame;
	private JTextField textField;
	


	public GUI() {initialize();}

	private void initialize() {
		//----------------setting frame and pane-------------------------
		frame = new JFrame("Simple ATM GUI");
		frame.setBounds(100,100,   350, 200); 
		//these bounds are changed later after the first panel (named panel) through the submuit button actionlistener
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
                
		//-----------------setting panels------------------------
		JPanel panel = new JPanel();
		JPanel panel_1 = new JPanel();
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel, "panel");
		frame.getContentPane().add(panel_1, "panel1");
		frame.getContentPane().add(panel_2, "keyboardPlane");
		panel.setLayout(null);
		panel_1.setLayout(null);
		panel_2.setLayout(null);
		
		
		//-----------------first panel items---------------------
		JLabel lblEnterSerialNumber = new JLabel("Enter card number :");
		lblEnterSerialNumber.setBounds(10, 0, 200, 40);
		panel.add(lblEnterSerialNumber);
		textField = new JTextField();
		textField.setBounds(10, 30, 200, 40);
		panel.add(textField);
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(10, 80, 200, 30);
		panel.add(btnNewButton);

		//-----------------second panel items---------------------
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(0, 30, 200, 40);
		panel_1.add(btnDeposit);
		
		JButton btnCurrent = new JButton("Balance inquiry");
		btnCurrent.setBounds(0, 140, 130, 30);
		panel_1.add(btnCurrent);
		
		JButton btnWithdraw = new JButton("withdraw");
		btnWithdraw.setBounds(0, 80, 200, 40);
		panel_1.add(btnWithdraw);

                
		
		JButton btnPrevious = new JButton("previous");
		btnPrevious.setBounds(0, 220, 100, 30);
		panel_1.add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(300, 220, 100, 30);
		panel_1.add(btnNext);
		
		JLabel Label1 = new JLabel("History navigation");
		Label1.setBounds(150, 220, 160, 20);
		panel_1.add(Label1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(0, 175, 400, 40);
		panel_1.add(textArea_2);
		textArea_2.setEditable(false);
	
		//--------------------third panel items---------------------
		        JButton btn1 = new JButton("1");
                JButton btn2 = new JButton("2");
                JButton btn3 = new JButton("3");
                JButton btn4 = new JButton("4");
                JButton btn5 = new JButton("5");
                JButton btn6 = new JButton("6");
                JButton btn7 = new JButton("7");
                JButton btn8 = new JButton("8");
                JButton btn9 = new JButton("9");
                JButton btn0 = new JButton("0");
		        panel_2.add(btn1);
                panel_2.add(btn2);
                panel_2.add(btn3);
                panel_2.add(btn4);
                panel_2.add(btn5);
                panel_2.add(btn6);
                panel_2.add(btn7);
                panel_2.add(btn8);
                panel_2.add(btn9);
                panel_2.add(btn0);
		btn1.setBounds(10, 100, 100, 40);
		btn2.setBounds(120, 100, 100, 40);
        btn3.setBounds(230, 100, 100, 40);
		btn4.setBounds(10, 140, 100, 40);
		btn5.setBounds(120, 140, 100, 40);
		btn6.setBounds(230, 140, 100, 40);
		btn7.setBounds(10, 180, 100, 40);
        btn8.setBounds(120, 180, 100, 40);
        btn9.setBounds(230, 180, 100, 40);
        btn0.setBounds(120, 220, 100, 40);
		JButton btnbackspace = new JButton("<--");
		btnbackspace.setBounds(230, 220, 100, 40);
		panel_2.add(btnbackspace);
		JButton btnReturn = new JButton("return");
		btnReturn.setBounds(340, 0, 90, 40);
		panel_2.add(btnReturn);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 40, 320, 50);
		panel_2.add(textArea);
                textArea.setEditable(false);
		JButton btnClear = new JButton("Clear All");
		btnClear.setBounds(10, 220, 100, 40);
		panel_2.add(btnClear);
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.setBounds(340, 49, 90, 40);
		panel_2.add(btnConfirm);
		JLabel label2 = new JLabel("");  //set from action listeners as this label will change depending on withdraw or deposit 
		label2.setBounds(10, 0, 310, 30);
		panel_2.add(label2);
		
           //-----------1st panel actionlisteners------------------------------------------------------------------------
                
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s1=textField.getText();
				if(b.CardValidator(s1)) {
                    frame.setBounds(100,100,   450, 320);
					panel_1.setVisible(true);
				panel.setVisible(false);}
			    	else
			    		JOptionPane.showMessageDialog(null, "ERROR,Invalid card number");
			    	
				}});
		
	 //-----------2nd panel actionlisteners--------------------------------------------------------------------
		
		
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(historycount!=0) {
				if(historycount<2)
					historycount=2;
			
				String s=b.history(--historycount);
				if(s!=null)
				textArea_2.setText(s);}}});
			
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(historycount>5)
					historycount=5;
				String s=b.history(++historycount);
				if(s!=null)
				textArea_2.setText(s);
				else
					historycount--;}});
	
		btnCurrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double cur=b.balanceinquiry();
				textArea_2.setText("CURRENT balance is: "+Double.toString(cur));
				historycount=0;    
			}});

		
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FLAG=1;
				panel_2.setVisible(true);
				panel_1.setVisible(false);
				label2.setText("Enter the amount u wish to DEPOSIT");
			}});
		
	
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FLAG=2;
				panel_2.setVisible(true);
				panel_1.setVisible(false);
				label2.setText("Enter the amount u wish to WITHDRAW");
			
			}});
		
		//------third panel actionlisteners---------------
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textArea.getText().equals("")) {
				if (FLAG==1) {
					 String s1=textArea.getText();
					 Double re=Double.parseDouble(s1);
					 int i1=b.deposit(re);
					 if(i1!=0)
					 JOptionPane.showMessageDialog(null, "SUCCESS, Deposit complete");
						else
							JOptionPane.showMessageDialog(null, "ERROR,Deposit failed invalid amount");
					}else 
						if(FLAG==2) { String s1=textArea.getText();
					 Double re=Double.parseDouble(s1);
						int i2= b.withdraw(re);
						if(i2!=0)
						 JOptionPane.showMessageDialog(null, "SUCCESS, Withdraw complete");
						else
							JOptionPane.showMessageDialog(null, "ERROR, withdraw failed insuffient funds");
						
						
					}}else
						JOptionPane.showMessageDialog(null, "ERROR, plz enter a number");
		}	});
		
		
		
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                 textArea.append("0");
			}
		});
		
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("1");
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("2");
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("3");
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("4");
			}
		});
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("5");
			}
		});
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("6");
			}
		});
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("7");
			}
		});
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("8");
			}
		});
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.append("9");
			}
		});
		btnbackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str;
				str=textArea.getText();
				textArea.setText(str.substring(0, str.length() - 1));
				
				
			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
			}
		});
		
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText(null);
				historycount=0; 
				textArea_2.setText("");
				panel_2.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		
		
	}
}
