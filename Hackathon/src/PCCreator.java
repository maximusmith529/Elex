

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PCCreator {

	JFrame PCWindow;
	Container con;
	JPanel nameTextPanel, inputTextPanel, buttonPanel;
	JLabel nameText, HP, ATK, DEF, Points;
	JTextField t;
	JButton submit, pHP, mHP, pATK, mATK, pDEF, mDEF;
	buttonHandler bHandler = new buttonHandler();
	String playerName;
	int hp = 0;
	int atk = 0;
	int def = 0;
	int points = 20;
	Character player;
	public class buttonHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String choice = event.getActionCommand();
			switch(choice) {
			case "pHP":
				if(points > 0) {
					hp++;
					points--;
				}
				break;
			case "mHP":
				if(points < 20 && hp > 0) {
					hp--;
					points++;
				}
				break;
			case "pATK":
				if(points > 0) {
					atk++;
					points--;
				}
				break;
			case "mATK":
				if(points < 20 && atk > 0) {
					atk--;
					points++;
				}
				break;
			case "pDEF":
				if(points > 0) {
					def++;
					points--;
				}
				break;
			case "mDEF":
				if(points < 20 && def > 0) {
					def--;
					points++;
				}
				break;
			case "Submit":
				PCWindow.setVisible(false);
				updateNums();
				playerName = t.getText();
				submit();
				
				return;
			}
			updateNums();
			}
		}
	
	
	public void submit() {
		player = new Character(playerName, hp, atk, def);
		System.out.println(player.name);
		new Game(player);
	}
	
	public void updateNums() {
		HP.setText(""+hp);
		ATK.setText(""+atk);
		DEF.setText(""+def);
	}
	
	
	public PCCreator() {
		
		
		PCWindow = new JFrame();
		PCWindow.setSize(250,230);
		
		PCWindow.getContentPane().setBackground(Color.black);
		
		nameTextPanel = new JPanel();
		nameTextPanel.setBounds(16,50,200,200);
		nameTextPanel.setBackground(Color.BLACK);
		
		inputTextPanel = new JPanel();
		inputTextPanel.setBounds(0,0,0,0);
		inputTextPanel.setBackground(Color.BLACK);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(0,50,20,20);
		buttonPanel.setBackground(Color.BLACK);
		
		pHP = new JButton("+HP");
		pHP.setBackground(Color.black);
		pHP.addActionListener(bHandler);
		pHP.setActionCommand("pHP");
		
		mHP = new JButton("-HP");
		mHP.setBackground(Color.black);
		mHP.addActionListener(bHandler);
		mHP.setActionCommand("mHP");
		
		pATK = new JButton("+ATK");
		pATK.setBackground(Color.black);
		pATK.addActionListener(bHandler);
		pATK.setActionCommand("pATK");
		
		mATK = new JButton("-ATK");
		mATK.setBackground(Color.black);
		mATK.addActionListener(bHandler);
		mATK.setActionCommand("mATK");

		pDEF = new JButton("+DEF");
		pDEF.setBackground(Color.black);
		pDEF.addActionListener(bHandler);
		pDEF.setActionCommand("pDEF");
		
		mDEF = new JButton("-DEF");
		mDEF.setBackground(Color.black);
		mDEF.addActionListener(bHandler);
		mDEF.setActionCommand("mDEF");
		
		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setActionCommand("Submit");
		submit.addActionListener(bHandler);
		
		nameText = new JLabel("What is your name?");
		nameText.setForeground(Color.WHITE);
		
		HP = new JLabel(""+hp);
		ATK = new JLabel(""+atk);
		DEF = new JLabel(""+def);
		
		t = new JTextField(12);
		t.setBounds(100,100,100,100);
		PCWindow.setVisible(true);
		
		con = PCWindow.getContentPane();
		
		
		
		inputTextPanel.add(t);
		inputTextPanel.add(nameText);

		nameTextPanel.add(pHP);
		nameTextPanel.add(HP);
		nameTextPanel.add(mHP);
		nameTextPanel.add(pATK);
		nameTextPanel.add(ATK);
		nameTextPanel.add(mATK);
		nameTextPanel.add(pDEF);
		nameTextPanel.add(DEF);
		nameTextPanel.add(mDEF);
		
		nameTextPanel.add(submit);
		con.add(nameTextPanel);
		con.add(inputTextPanel);
	
		
	}
	
}


/* pHP = new JButton("+HP");
		pHP.setBackground(Color.black);
		pHP.addActionListener(bHandler);
		pHP.setActionCommand("pHP");
		
		mHP = new JButton("-HP");
		mHP.setBackground(Color.black);
		mHP.addActionListener(bHandler);
		mHP.setActionCommand("mHP");
		
		pATK = new JButton("+ATK");
		pATK.setBackground(Color.black);
		pATK.addActionListener(bHandler);
		pATK.setActionCommand("pATK");
		
		mATK = new JButton("-ATK");
		mATK.setBackground(Color.black);
		mATK.addActionListener(bHandler);
		mATK.setActionCommand("mATK");

		pDEF = new JButton("+DEF");
		pDEF.setBackground(Color.black);
		pDEF.addActionListener(bHandler);
		pDEF.setActionCommand("pDEF");
		
		mDEF = new JButton("-DEF");
		mDEF.setBackground(Color.black);
		mDEF.addActionListener(bHandler);
		mDEF.setActionCommand("mDEF"); */