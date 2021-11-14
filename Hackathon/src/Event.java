
import java.util.*;

//Combat Event
//Loot Chest Event
//Health Pool Event

public class Event {
    Scanner sc = new Scanner(System.in);
    int type, input;
    Character P;
    int playerState, enemyState;
    String Names[] = {"Combat", "Loot", "Health"};
    String mainText;
    String[] buttons = new String[4];
    String pos; //
    String pos2; 
    String pos3; 
    String pos4; 
    String pos1; 
     
    boolean fin = false;

    Character enemy; // For combat only
    Character boss; // For boss only

    // Randomizing events
     Random randGen = new Random();
     int rando = randGen.nextInt(10);
    Boolean randomizer = (rando >= 5) ? true : false;

    public Event (Character P) {
		this.P = P;
		this.type = (int) (Math.random() * 3);
	}
	
	public void doEvent() {
		if(this.type == 0) {
			pos = "enemyCombatStart";
			combat();
		}
		if(this.type == 1) {
			pos = "lootChestStart";
			lootChest();
		}
		if(this.type == 2) {
			pos = "healthPoolStart";
			healthPool();
		}
	}

    //Boss (combat but lines are changed)
    public void bossCombat(Character boss){
        switch(pos){
            case "bossStart":
                mainText = "You come across a decrepit room, filled with rubble and vines. The floor is littered with rusted weapons and the skeletons of past warriors.\n" +
                "At the end of the room is a lone throne, occupied by a black helmet. You explore the room, seeking any loot that happens to catch your, only\n"+
                "fail at finding anything of value. All that is left is to approach the lone black helmet that sits on the throne, as your get closer you feel\n"+
                "a sudden pressure from an ominous force, the eyes of the hemet glows and rises into the air. A deep, thunderous voice fills the room, 'You who has\n"+
                "entered my domain has entered so without my permission, such defiance requires punishment, come here fool, attack the steel of my blade' Suddendly\n"+
                "a giant entity appears from the helmet, all the weapons rise and head towards its right hand and forms a giant blade, the voice bellows again 'Here\n"+
                "I come warrior'";

                buttons[0] = "Continue";
                buttons[1] = " ";
                buttons[2] = " ";
                buttons[3] = " ";

                pos1 = "bossCombatStart";
                pos2 = " ";
                pos3 = " ";
                pos4 = " ";
                break;

            case "bossFight":
                 mainText = "Boss fight! You've come across " + boss.name + "! Get ready to fight!";
                 pos = "bossFightStart";
                 combatLoop(P, boss);
                 break;

        }
}

    //Combat
    public void combat() {
        switch(pos){
            case "enemyCombatStart":
            mainText = "You have came across a " + enemy.name + "! What do you do:";
            pos = "combatStart";
            enemy = new Character(P.monsterNames[(int)Math.random()*P.monsterNames.length],(int)Math.random()*15,(int)Math.random()*15,(int)Math.random()*15);
            combatLoop(P, enemy);
            break;
        }
}

    // Combat loop
    public void combatLoop(Character P, Character enemy) {
        //Original Stats
        // int ogPDef = P.def;
        // int ogEnDef = enemy.def;

        //Combat com = new Combat();
        while(enemy.hp > 0 && P.hp > 0) {
            switch(pos){
                case "combatLoopStart":
                    //mainText = " ";
                    buttons[0] = "[1] Attack";
                    buttons[1] = "[2] Defend";
                    buttons[2] = "[3] Use Potion";
                    buttons[3] = "";

                    pos1 = "combatLoopAttack";
                    pos2 = "combatLoopDefend";
                    pos3 = "combatLoopPotion";
                    pos4 = " ";
                break;
                case "combatLoopAttack":
                    playerState = 0;
                    playerTurn();
                    enemyTurn();
                    buttons[0] = "[1] Attack";
                    buttons[1] = "[2] Defend";
                    buttons[2] = "[3] Use Potion";
                    buttons[3] = "";

                    pos1 = "combatLoopAttack";
                    pos2 = "combatLoopDefend";
                    pos3 = "combatLoopPotion";
                    pos4 = " ";

                break;
                case "combatLoopDefend":
                    playerState = 1;
                    playerTurn();
                    enemyTurn();
                    buttons[0] = "[1] Attack";
                    buttons[1] = "[2] Defend";
                    buttons[2] = "[3] Use Potion";
                    buttons[3] = "";

                    pos1 = "combatLoopAttack";
                    pos2 = "combatLoopDefend";
                    pos3 = "combatLoopPotion";
                    pos4 = " ";
                break;
                case "combatLoopPotion":
                    playerState = 2;
                    playerTurn();
                    enemyTurn();
                    buttons[0] = "[1] Attack";
                    buttons[1] = "[2] Defend";
                    buttons[2] = "[3] Use Potion";
                    buttons[3] = "";

                    pos1 = "combatLoopAttack";
                    pos2 = "combatLoopDefend";
                    pos3 = "combatLoopPotion";
                    pos4 = " ";
                break;
                }

    //     int eChoice = randGen.nextInt(4);

    //     switch(inp){
    //         case 1:
    //             switch(eChoice) {
    //                 case 1:
    //                     System.out.println(enemy.name + " also attacked you!");
    //                     com.attack(P, enemy);
    //                     com.attack(enemy, P);
    //                     break;
    //                 case 2:
    //                     System.out.println(enemy.name + " tried to defend!");
    //                     com.defend(enemy);
    //                     com.attack(P, enemy);
    //                     break;
    //                 case 3:
    //                     System.out.println(enemy.name + " drank a potion!");
    //                     enemy.drinkPotion();
    //                     com.attack(P, enemy);
    //                     break;
    //             }
    //             break;
    //         case 2:
    //             switch(eChoice) {
    //                 case 1:
    //                     com.defend(P);
    //                     com.attack(enemy, P);
    //                     break;
    //                 case 2:
    //                     System.out.println(enemy.name + " also tried to defend!");
    //                     com.defend(enemy);
    //                     com.defend(P);
    //                     break;
    //                 case 3:
    //                     System.out.println(enemy.name + " drank a potion!");
    //                     com.defend(P);
    //                     enemy.drinkPotion();
    //                     break;
    //             }
    //             break;
    //         case 3:
    //             if (P.po != null) {
    //                 switch(eChoice) {
    //                     case 1:
    //                         System.out.println(enemy.name + " attacked you!");
    //                         P.drinkPotion();
    //                         com.attack(enemy, P);
    //                         break;
    //                     case 2:
    //                         System.out.println(enemy.name + " tried to defend!");
    //                         P.drinkPotion();
    //                         com.defend(enemy);
    //                         break;
    //                     case 3:
    //                         System.out.println(enemy.name + " also drank a potion!");
    //                         P.drinkPotion();
    //                         enemy.drinkPotion();
    //                         break;
    //                 }
    //             } else {
    //                 System.out.println("You dont have any potions!");
    //             }
    //             break;
    //         default:
    //             System.out.println("Invalid input! Please try again.");
    //             break;
    //     }
    // }
    // enemy.def = ogEnDef;
    // P.def = ogPDef;
        }fin = true;
    }

    public void enemyTurn() {
		int state = (int)Math.random()*3;
		int damage = enemy.calculateDmg();
		System.out.println(damage);
		
		switch(state) {
		case 0:
			mainText = mainText+" \n The "+enemy.name+ " attacked you! \nThey dealt "+damage+"."; 
			P.hp -= damage - P.def;
			break;
		case 1:
            mainText = mainText+" \n The "+enemy.name+ " is defending.";break;		
        case 2: 
            mainText = mainText+" \n The "+enemy.name+ " drank a potion!.";
            enemy.drinkPotion();break;
        }
	}


    public void playerTurn() {
		int damage = P.calculateDmg();
		System.out.println(damage+"p");
		switch(playerState) {
		case 0:
			mainText = "You attack the "+enemy.name+ " dealing "+damage+".";
			enemy.hp -= damage - enemy.def;
			break;
		case 1:
            mainText ="You try your best to defend against the oncoming attack.";break;
        case 2: 
            mainText = " \n You drink your potion!";
            P.drinkPotion();break;
		}
		
	}











    //Loot
    public void lootChest() {
        switch(pos){

            case "lootChestStart":
            mainText = "You've come across a locked chest! Decide what to do:";
            buttons[0] = "[1] Examine it";
            buttons[1] = "[2] Smash it open";
            buttons[2] = "[3] Walk away";
            buttons[3] = " ";
            pos1 = "lootChestExamine";
            pos2 = "lootChestSmash";
            pos3 = "lootChestWalk";
            pos4 = " ";
            break;
    
            case "lootChestExamine":
                if(randomizer){
                    mainText = "This chest seems to be a trap! It's a monster, you've got to battle it!";
                    buttons[0] = "Combat";
                    buttons[1] = " ";
                    buttons[2] = " ";
                    buttons[3] = " ";

                    pos1 = "combatStart";
                    pos2 = " ";
                    pos3 = " ";
                    pos4 = " ";
                } else {
                    mainText = "It LOOKS like a normal chest, do you want to:";
                    buttons[0] = "[1] Open it";
                    buttons[1] = "[2] Walk away";
                    buttons[2] = " ";
                    buttons[3] = " ";

                    pos1 = "lootChestOpen";
                    pos2 = "lootChestWalk";
                    pos3 = " ";
                    pos4 = " ";
                }
                break;

            case "lootChestOpen":
                pos = "openChestStart";
                openChest();
                break;

            case "lootChestWalk":
                fin = true;
                return;
                

            case "lootChestSmash":
                pos = "openChestSmash";
                openChest();
                break;
        }
    }

    // Helper function to open the chest
    void openChest() {
        if (randomizer) {
            if (0 <= rando && rando <= 2) {
                Weapon w = new Weapon();
                mainText = "Congrats! You just found a " + w.name;
                getItem(w);
            } else if (3 <= rando && rando <= 5) {
                Armour a = new Armour();
                mainText = "Congrats! You just found a " + a.name;
                getItem(a);
            } else {
                Potion p = new Potion();
                mainText = "Congrats! You just found a " + p.name;
                getItem(p);
            }
        } else {
            mainText = "It was a trap! You've taken " + rando + " damage!";
            P.hp -= rando;
        }
    }

    //Helper function to swap or pick up item
    void getItem( Items i){
        switch(pos){
            case "getItemStart":
            mainText = "Do you want to get this item? (It will replace your current item if you have one)";
            buttons[0] = "[1] Yes";
            buttons[1] = "[2] No";

            pos1 = "getItemYes";
            pos2 = "getItemNo";
            pos3 = " ";
            pos4 = " ";
            break;

          case "getItemYes":
          mainText = " ";
           if(i instanceof Weapon){
                   P.wp = (Weapon) i;
               } else if(i instanceof Armour){
                   P.ar = (Armour) i;
               } else if(i instanceof Potion){
                   P.po = (Potion) i;
               }
               fin = true;
               break;

            case "getItemNo":
            fin = true;
            return;
        }
        }

   
    //Health
    public void healthPool() {
         switch(pos){
             case "healthPoolStart":
                mainText = "There is a mysterious red potion! What do you plan on doing?";
                buttons[0] = "[1] Drink it";
                buttons[1] = "[2] Walk away";

                pos1 = "healthPoolDrink";
                pos2 = "healthPoolWalk";
                pos3 = " ";
                pos4 = " ";
                break;

             case "healthPoolDrink":
                mainText = "After drinking the strange potion you feel weird";
                P.hp += (rando >= 5) ? 5 : -5;
                fin = true;
                break;

             case "healthPoolWalk":
                fin = true;
                return;
         }
    }
}