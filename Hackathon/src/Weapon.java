

public class Weapon extends Items{
    
    String weaponNames [] = {"Spear","Sword", "Daggers","Wooden Bow","War Hammer","Unarmed"};

    String weaponNamesLeg [] = {"Flaming Blade of Inoxia", "Daggers of the Void", "Eldritch Bow", "Spear of Chaos"};

    String weaponDesc [] = {"A stick with a sharp iron point, seems to be in good condition",
                            "Edged iron blade, has a good feel about it",
                            "Two sharp baldes, light, quick, and deadly",
                            "A decent bow with strange engrvings",
                            "Large, heavy, and strong wepaon capable of crushing your foes ",
                            "Used the power your fist beat your enemies"};

    String weaponDescLeg [] = {"A legendary blade known for its ability to blaze through hoards of enemies",
                               "Blades baseked in the darkness of the void, corrupting all who wield them",
                               "A bow of legends made by elves, wielder was capable of piercing throough the heavens with each shot",
                               "A spear that leaves nothing but destruction and death in its path"};

    int wepDamage[] = {5,4,2,3,7,1};
    int wepDamegeLeg[] = {12,8,9,15};
    int damage;

    public Weapon() {
        int r = (int)Math.random()*7;
        int l = (int)Math.random()*5;
        if((int)(Math.random() * 2) == 0) {
        name = weaponNames[r];
        desc = weaponDesc[r];
        damage = wepDamage[r];
        } else {
        name =  weaponNamesLeg[l];
        desc = weaponDescLeg[l];
        damage = wepDamegeLeg[l];
    }
  }
}
