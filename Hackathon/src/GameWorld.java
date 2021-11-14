
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class GameWorld {

	ArrayList<Character> C = new ArrayList<>(); //Slot one is always player Slot 2 is enemy
	
	Setting[][] S = new Setting[5][5];
	
	Scanner sc = new Scanner(System.in);
	Swing Sw;
	int type;
	boolean nav = true;
	Character player;
	
	public Setting[][] createWorld(int z, Character P) {
		Setting[][] S = new Setting [5][5];
		this.player = P;
		this.type = z;
		System.out.println("Generating Game world" );
		int BX = (int)(Math.random()*5);
		int BY = (int)(Math.random()*5);
		if (BX == 0 && BY == 2) {
			System.out.println("Whoops, lets try that again.." );
			return createWorld(z, P);
		}
		S[BX][BY] = new Setting(z, false);
		S[BX][BY].boss = true;
		int counter = 0;
		for(int x = 0; x < 5 ; x++) {
			for(int y = 0; y < 5; y++) {
				
				System.out.println("Generating setting " +(++counter)+ "/25" );
				
				if((x != BX) || (y != BY)) {
					
					S[x][y] = new Setting(z, P);
					
				}
				if((x == 0 && y == 2)) {
					S[x][y] = new Setting(z, true);
					
					
				}
			}
		}
		
		
		return S;
	}
	

	//Setup for setting desc after movement

	void updateSwingText() {
		Sw.setMainText(S[player.location[0]][player.location[1]].getDescription());
		
	}
	void updateSwingStats() {
		Sw.setStats(player.hp,player.calculateDmg(),player.calculateDef());
	}
	void updateSwing() {
		updateSwingText();
		updateSwingStats();
	}

	void setSwingText(String s) {
		Sw.setMainText(s);
	}
	void setSwingButtons(String [] b) {
		Sw.updateButtons(b[0], b[1], b[2], b[3]);
	}

	void ButtonPress(int x) {
		if(nav)
			switch(x) {
			case 1: moveSouth(); break;
			case 2: moveNorth(); break;
			case 3: moveWest(); break;
			case 4: moveEast(); break;
			}
		else
			switch(x) {
			case 1: PlayerLocation().E.pos = PlayerLocation().E.pos1;
			case 2: PlayerLocation().E.pos = PlayerLocation().E.pos2;
			case 3: PlayerLocation().E.pos = PlayerLocation().E.pos3;
			case 4: PlayerLocation().E.pos = PlayerLocation().E.pos4;
			}
		PMove();
	}





























	public void moveEast() {
		if((player.location[1]+1 > 4)) {
			System.out.println("That's out of the field! ");
		}else{
			player.setLocation(player.location[0], player.location[1]+1);
			S[player.location[0]][player.location[1]].transferPlayerTo(S[player.location[0]][player.location[1]]);
			
		}
	}
	public void moveWest() {
		if((player.location[1]-1 < 0)) {
			System.out.println("That's out of the field! ");
			
		}else {
			player.setLocation(player.location[0], player.location[1]-1);
			S[player.location[0]][player.location[1]].transferPlayerTo(S[player.location[0]][player.location[1]]);
			
		}
	}
	public void moveNorth() {
		if((player.location[0]-1 < 0)) {
			System.out.println("That's out of the field! ");
		}else {
			player.setLocation(player.location[0]-1, player.location[1]);
			S[player.location[0]][player.location[1]].transferPlayerTo(S[player.location[0]][player.location[1]]);
			
		}
	}
	
	
	public void moveSouth() {
		if((player.location[0]+1 > 4)) {
			System.out.println("That's out of the field! ");

		}else {
			player.setLocation(player.location[0]+1, player.location[1]);
			S[player.location[0]][player.location[1]].transferPlayerTo(S[player.location[0]][player.location[1]]);
			
		}
	}
	
	public void PMove() {
		if(PlayerLocation().E!=null) {
			if(PlayerLocation().E.fin == true) {
				nav = true;
				System.out.println(playerMap());
				Sw.setMainText(PlayerLocation().getDescription() + "\nThe x represents you, the o's represent places you can go.\n" +
								"Please use the buttons to decide on where to go");
				Sw.updateButtons("South","North","West","East");
			
		}else if(PlayerLocation().E.fin == false){
			nav = false;
			PlayerLocation().E.doEvent();
			setSwingText(PlayerLocation().E.mainText);
			setSwingButtons(PlayerLocation().E.buttons);
		}
		}else
			nav = true;
			System.out.println(playerMap());
			Sw.setMainText(PlayerLocation().getDescription() + "\nThe x represents you, the o's represent places you can go.\n" +
							"Please use the buttons to decide on where to go");
			Sw.updateButtons("South","North","West","East");
		
	}
	
	public void move() {
		
	}
	
	// public void Inventory() {
		
	// 	System.out.println(P.getInventory());
	// 	System.out.println("\n You can use E, U, and V, to Equip, Use, and View items.");
	// 	String S = sc.nextLine();
	// 	if(S.equals("E")) {
	// 		System.out.println("  Which item would you like to equip?");
	// 		System.out.println(P.getInventory());
	// 		int I = sc.nextInt();
	// 		try{
	// 			if(!(I > P.Inventory.size()+1)) {
	// 				P.EquipItem(P.Inventory.get(I));
					
	// 			}
	// 		}catch(Exception E) {
	// 			System.out.println("Numbers please");
	// 		}
			
	// 	}
	// 	if(S.equals("U")) {
	// 		System.out.println("  Which item would you like to use?");
	// 		System.out.println(P.getInventory());
	// 		int I = sc.nextInt();
	// 		try{
	// 			if(!(I > P.Inventory.size()+1)) {
	// 				P.UseItem(P.Inventory.get(I));
					
	// 			}
	// 		}catch(Exception E) {
	// 			System.out.println("Numbers please");
	// 		}
	// 	}
	// 	if(S.equals("V")) {
	// 		System.out.println("  Which item would you like to view?");
	// 		System.out.println(P.getInventory());
	// 		int I = sc.nextInt();
	// 		try{
	// 			if(!(I > P.Inventory.size()+1)) {
	// 				//System.out.println(P.Inventory.get(I).desc);
	// 				System.out.println(P.Inventory.get(I).toString());
	// 				space();
	// 			}
	// 		}catch(Exception E) {
	// 			System.out.println("Numbers please");
	// 		}
	// 	}
	// 	if(S.equals("B")) {
			
	// 	}
	// 	else if(!(S.equals("V"))&&!(S.equals("E"))&&!(S.equals("U"))&&!(S.equals("B"))){
	// 		System.out.println("Input valid response");
	// 	}
		
		
		
	// }
	
	public String PlayerSettingDescription() {
		String S = "";
		
		
		
		
		return S;
	}
	
	public Setting PlayerLocation() {
		
		return S[player.location[0]][player.location[1]];
	}
	
	public String PlayerLocationName() {
		return S[player.location[0]][player.location[1]].getName();
	}
	
	public boolean isBoss(Setting x) {
		if(x.boss == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addCharacter(Character Char) {
		C.add(Char);
	}
	
	public void addPlayer(Character P) {
		C.add(0,P);
	}
	

	public GameWorld(Character P) {
		this.S = createWorld((int)(Math.random()*5),P);
		this.S[0][2].setPlayer(P);

		P.setLocation(0, 2);
		C.add(P);
	}
	
	
	public String settingNameMap() {
		String i = "";
		for(int x = 0; x < 5 ; x++) {
			for(int y = 0; y < 5; y++) {
				i = i.concat(this.S[x][y].getName() + ", ");
			}
			i = i.concat("\n");
		}
		
		return i;
	}
	
	public String playerMap() {
		String S = "";
		for(int x = 0; x < 5; x++) {
			for(int y = 0; y < 5; y++) {
				if(this.S[x][y] == this.S[player.location[0]][player.location[1]] ) {
					S = S.concat("x ");
				}else {
					S = S.concat("o ");
				}
			}
			S = S.concat("\n");
		}
		return S;
	}
	
	public void space() {
		System.out.println("\n Enter any value to continue. ");
		sc.next();
	}
	
	@Override
	public String toString() {
		return "GameWorld [C=" + C + ", S=" + Arrays.toString(S) + "]";
	}
}
