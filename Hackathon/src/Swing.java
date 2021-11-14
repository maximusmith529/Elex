


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Swing {

    JFrame gameWindow = new JFrame();
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, invPanel, statPanel, areaPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, atkLabel, atkLabelNumber, defLabel, defLabelNumber;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90); 
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 26), smallFont = new Font("Times New Roman", Font.PLAIN, 24);
	JButton startButton, choice1, choice2, choice3, choice4, invButton, areaButton;
    JTextArea mainTextArea;
    Swing s = this;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	Character player;
    GameWorld GW;
    boolean first = true;
    public Swing(Character p) {
		player = p;
    	
		//Game window creation, where all the JSwing is stored
		gameWindow = new JFrame();
		gameWindow.setSize(800, 600); //actual top to down is 560 pixels || side to side is 785 pixels
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.getContentPane().setBackground(Color.black);
		gameWindow.setLayout(null);
		gameWindow.setVisible(true);
		
		con = gameWindow.getContentPane();
		
		//Beginning of creation of the title screen layout
		//Panel for the title text
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100,100,600,150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("StartTrek");
		titleNameLabel.setForeground(Color.WHITE);
		titleNameLabel.setFont(titleFont);
		
		//panel for the start button
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300,400,200,100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		startButtonPanel.add(startButton);
		
		titleNamePanel.add(titleNameLabel);
		con.add(titleNamePanel);
		con.add(startButtonPanel);
	
	
	
	
}
	public void createGameScreen() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		
		
		//mainTextPanel creation
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(145,0,495,410);
		mainTextPanel.setBackground(Color.BLACK); //default black
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("Main text area for the poggers Beowulf game for lit ");
		mainTextArea.setBackground(Color.BLACK); //default black
		mainTextArea.setForeground(Color.white);
		mainTextArea.setBounds(0,0,495,410);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		mainTextPanel.add(mainTextArea);
		
		
		//choice bar creation
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(145,410,495,150);
		choiceButtonPanel.setBackground(Color.BLACK); //default black
		choiceButtonPanel.setLayout(new GridLayout(2,6));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(smallFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(smallFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(smallFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(smallFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		
		
		choiceButtonPanel.add(choice1);
		choiceButtonPanel.add(choice2);
		choiceButtonPanel.add(choice3);
		choiceButtonPanel.add(choice4);
		
		//statPanel creation
		
		statPanel = new JPanel();
		statPanel.setBounds(0,150,145,260);
		statPanel.setBackground(Color.BLACK); //default black
		statPanel.setLayout(new GridLayout(6,1));
		con.add(statPanel);
		hpLabel = new JLabel("Health: ");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		statPanel.add(hpLabel);
		hpLabelNumber = new JLabel(""+player.hp);
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		statPanel.add(hpLabelNumber);
		
		atkLabel = new JLabel("Attack: ");
		atkLabel.setFont(normalFont);
		atkLabel.setForeground(Color.white);
		statPanel.add(atkLabel);
		atkLabelNumber = new JLabel(""+player.atk);
		atkLabelNumber.setFont(normalFont);
		atkLabelNumber.setForeground(Color.white);
		statPanel.add(atkLabelNumber);
		
		defLabel = new JLabel("Defense: ");
		defLabel.setFont(normalFont);
		defLabel.setForeground(Color.white);
		statPanel.add(defLabel);
		defLabelNumber = new JLabel(""+player.def);
		defLabelNumber.setFont(normalFont);
		defLabelNumber.setForeground(Color.white);
		statPanel.add(defLabelNumber);
		
		//enemy name
		
//		enemyLabel = new JLabel("Enemy: ");
//		enemyLabel.setFont(normalFont);
//		enemyLabel.setForeground(Color.white);
//		statPanel.add(enemyLabel);
//		enemyLabelNumber = new JLabel("");
//		enemyLabelNumber.setFont(normalFont);
//		enemyLabelNumber.setForeground(Color.white);
//		statPanel.add(enemyLabelNumber);
//		
		//area sprite panel creation :: the side panel, currently useless
		
		areaPanel = new JPanel();
		areaPanel.setBounds(640,0,145,410);
		areaPanel.setBackground(Color.black); //default black
		con.add(areaPanel);
		
		//invPanel and areaButton creation
		
		invPanel = new JPanel();
		invPanel.setBounds(0,410,145,150);
		invPanel.setBackground(Color.BLACK); //default black
		invPanel.setLayout(new GridLayout(2,1));
		con.add(invPanel);
		
		invButton = new JButton("Inventory");
		invButton.setBackground(Color.black);
		invButton.setForeground(Color.white);
		invButton.setFont(normalFont);
		invButton.setFocusPainted(false);
		invButton.addActionListener(choiceHandler);
		invButton.setActionCommand("inv");
		invPanel.add(invButton);
		
		areaButton = new JButton("Area");
		areaButton.setBackground(Color.black);
		areaButton.setForeground(Color.white);
		areaButton.setFont(normalFont);
		areaButton.setFocusPainted(false);
		areaButton.addActionListener(choiceHandler);
		areaButton.setActionCommand("area");
		invPanel.add(areaButton);
		
		
		//NPC and PC sprite panel creation
		
//		PCPanel = new JPanel();
//		PCPanel.setBounds(640,405,145,155);
//		PCPanel.setBackground(Color.black); //default black
//		
//		PCImageLabel = new JLabel();
//		
//		PCImage = new ImageIcon(".//trekkImages//captain2.png");
//		PCImageLabel.setBackground(Color.WHITE);
//		PCImageLabel.setIcon(PCImage);
//		PCPanel.add(PCImageLabel);
//			
//		con.add(PCPanel);
//		
//		NPCPanel = new JPanel();
//		NPCPanel.setBounds(0,-5,145,155);
//		NPCPanel.setBackground(Color.BLACK); //default black
//		
//		NPCImageLabel = new JLabel();
//		
//		NPCImage = new ImageIcon(".//trekkImages//StartTrekSymbol.png");
//		NPCImageLabel.setIcon(NPCImage);
//		NPCPanel.add(NPCImageLabel);
//		
//		con.add(NPCPanel);
		
		setMainText("Welcome to Elex!\n"+
				  "This is a game designed to emulate the adventures found in games like DnD \n"+
				  "Feel free to explore to your hearts content using the buttons below, but be careful, \n"+ 
				  "you're not the only one exploring...");
	
		updateButtons("Continue", "", "", "");
	}
	
	
	//Used by Area.java to update button names
	public void updateButtons(String z, String x, String c, String v) {
		choice1.setText(z);
		choice2.setText(x);
		choice3.setText(c);
		choice4.setText(v);
	}
	
	
	//used by Area.java to set this.mainTextArea.text
	public void setMainText(String S) {
		mainTextArea.setText(S);
	}
	
	//assigns an environment to the class
	public void setGW(GameWorld x) {
		GW = x;
	}
	
	//changes the text on the left panel
	public void setStats(int hp, int atk, int def) {
		hpLabelNumber.setText(""+hp);
		atkLabelNumber.setText(""+atk);
		defLabelNumber.setText(""+def);
	}	
	
	
	


    public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			createGameScreen();
			
		}
	}


    //actionListeners for choice buttons
	public class ChoiceHandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			String yourChoice = event.getActionCommand();
			
			if(first == true && yourChoice == "c1") {
				GW.nav = false;
				GW.PMove();
			}
				
				switch(yourChoice) {
					case "c1": GW.ButtonPress(1);break;
					case "c2": GW.ButtonPress(2);break;
					case "c3": GW.ButtonPress(3);break;
					case "c4": GW.ButtonPress(4);break;
				}
			
			//Probably something like GW.PlayerLocation.buttonPress(1);break;

			
			}
			
		
			
		}
	}
