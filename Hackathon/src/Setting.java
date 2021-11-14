


public class Setting {

	
	
	String [][] Environment = {/*Caves*/{"Entrance","Pit Room","Tunnel","Dead End","Boss Room"},
			
					 			/*Ruins*/{"Entrance","Statue","Hallway","Tower","Boss Room"},
					 
					 			/*Bandit Camp*/{"Entrance","Blacksmith","Clearing","Cafeteria","Boss Room"},
					 
					 			/*Woods*/{"Entrance","Clearing","Old Statue","Hut","Boss Room"},
					 
					 			/*Prison*/{"Entrance","Jail Cell","Cafeteria","Clearing","Boss Room"}};
	
	String[][] EDescriptions = {	/*Caves*/{"the openening of a great cavern. Large and ominous, it begs you to enter.","a pit, within the middle of a chamber, seeming to go on forever downward. ","a borehole, or a tunnel within the cavern, its length extends past your sight.","a dead end, you see no way forward and only the way back. ","Boss Room"},
			
								 	/*Ruins*/{"the entrance to a great ruin of an old civilization. Dusty and ancient, it wants to be discovered. ","a large statue of a man in full armor with a visored helm. He's standing tall holding a sword that is planted into the statue's foundation. ","a hallway, long and ominous, you can't yet see its end. ","a tower, tall but old, old but strong. ","Boss Room"},
								 
								 	/*Bandit Camp*/{"the entrance to an encampment of bandits. It seems to taunt you, saying there's no way you could challenge it.","a blacksmith's workshop. Cluttered with half finished weapons, armor, and forging tools. ","a large clearing with a few training dummies along the edge. ","a building, if it can be called that, with no walls and benches underneath, being supported by pillars at the corners. It seems to be a place to eat. ","Boss Room"},
								 
								 	/*Woods*/{"an opening into the ancient forest. Looking inside you think you see something staring back... ","a clearing in the forest, void of trees and with manageable low grass. ","an ancient statue, cracked and made of stone, it still stands against the elements. Despite the enroaching forest it still stands tall. ","an ancient statue that is still standing despite the enroaching forest. It will probably last for a long while, despite the elements. ","Boss Room"},
								 
								 	/*Prison*/{"The entrance to a towering, walled building, with no roof. It looms above you.","a room, seperated by metal bars. It looks cold and ominous, not somewhere you'd want to be. ","a room with no windows. Inside are benches with tables. ","an open ceiling clearing with a sandy floor.","Boss Room"}};
	
	String[] Start = {"You find yourself at ","Looking around you see ", "You are at ", "You see "};
	
	Boolean boss = false;
	
	String name;
	String description;
	Character P;
	Character A;
	Event E;
	Boolean hasEvent = false;
	public void createEntrance(int x) {
		this.name = Environment[x][0];
		this.description = EDescriptions[x][0];
	}
	
	public void createBoss(int x) {
		this.name = Environment[x][Environment[x].length-1];
		this.description = EDescriptions[x][Environment[x].length-1];
	}
	
	
	public void setSetting(int x, Character PE) {
		int y = (int)(Math.random()*Environment[x].length);
		if(y != 0 && y != Environment[x].length -1 ) {
			this.name = Environment[x][y];
			this.description = generateSettingDescription(x);
			if(Math.random() < .5) {
				//Insert Event Generation
				
			this.E = new Event(PE); //Temporary Event Generation
			this.hasEvent = true;
			}
		}
		else {
			setSetting(x, PE);
		}
		
	}
	

	
	public void setPlayer(Character P) {
		this.P = P;
		
	}
	
	public void setAI(Character A) {
		this.A = A;
	}
	
	//Player Transfer from setting to setting

	public void transferCharactersFrom(Setting S) {//to this one from another
		this.A = S.A;
		this.P = S.P;
		S.A = null;
		S.P = null;
	}
	
	public void transferCharactersTo(Setting S) {//from this one to another
		S.A = this.A;
		S.P = this.P;
		this.A = null;
		this.P = null;
	}
	
	public void transferPlayerTo(Setting S) {//from this one to another
		S.P = this.P;
		this.P = null;
		
	}
	public void transferPlayerFrom(Setting S) {//to this one from another
		this.P = S.P;
		S.P = null;
	}
	
	//Getters n Setters

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public String generateSettingDescription(int z) {
		String S = "";
		
		int r = (int)(Math.random()*Start.length);
		S = S.concat(Start[r]);
		r = (int)(Math.random()*EDescriptions.length);
		S = S.concat(EDescriptions[z][r]);
		
		if((r == EDescriptions.length - 1)||(r == 0)) {
			S = generateSettingDescription(z);
		}
		return S;
	}
	
	
	
	
	
	
	
	
	public Setting(int z, Character PE) {
		setSetting(z, PE);
	}
	public Setting(int z,boolean location) { //False == Boss True == Entrance
		if (location == true) {
			createEntrance(z);
		}else {
			createBoss(z);
		}
	}

	@Override
	public String toString() {
		return "Setting [name=" + name + ", description=" + description + ", boss=" + boss + "]";
	}

	
	
	

}
