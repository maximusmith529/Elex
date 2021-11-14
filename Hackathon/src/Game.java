
public class Game {
	
	
	//Base classes
	Character player;
	Swing S; 
	GameWorld GW; 
	boolean LiveBoss = true;

	
	public Game(Character player) {	
		this.player = player;
		System.out.println(player.name);
		
		GW  = new GameWorld(player);
		S  = new Swing(player);
		GW.Sw = S;
		S.GW = GW;
		S.createGameScreen();
		
//		while((LiveBoss == true) && (player.hp > 0)) {
//			//C.get(0).location[0]
//			if(GW.S[GW.player.location[0]][GW.player.location[1]].hasEvent == true) {
//				
//				GW.S[GW.player.location[0]][GW.player.location[1]].E.doEvent();
//				GW.S[GW.player.location[0]][GW.player.location[1]].hasEvent = false;
//				
//			}
//			
//			//Insert Event Stuff
//			GW.PMove();
//		}
	}
	
	
	public static void main(String[] args) {
		PCCreator pc = new PCCreator();
		
		
	}
	
	
	
	
	
}
