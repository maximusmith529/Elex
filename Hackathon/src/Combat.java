
public class Combat {
    Character combatants [] = new Character[2];
    
    public Combat(){
        
    }

    void attack(Character attacker, Character defender){
        int dmg = attacker.calculateDmg() - defender.calculateDef();

        if (dmg > 0) {
            defender.hp -= dmg;
            System.out.println(defender.name + " was attacked by " + attacker.name + " and lost " + dmg + " hp!");
        } else if (dmg == 0) {
            System.out.println(defender.name + " was attacked by " + attacker.name + " but didn't take any damage!");
        } else {
            attacker.hp -= dmg;
            System.out.println(attacker.name + " attacked " + defender.name + " but it was naturally reflected back and lost " + dmg + " hp!");
        }
    }

    void defend(Character defender) {
        defender.def *= 1.35;
    }
}
