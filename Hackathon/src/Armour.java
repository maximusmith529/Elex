

public class Armour extends Items{
    String armourNames[] = {"Iron Boob Plate","Cloak", "Iron Shield", "Unarmed", "Hide", "Chain Mail"};

    String armourNamesLeg[] = {"Dragon Chest Plate", "Shield of the Gudrag's Tree", "Protective force of the Beyond", "Dregs Bones"};

    String armourDesc[] = {"Durable armour capable of defening your from most things",
                           "An adequate piece of cloth that provides decent coverage from the elements but not so much from enemies",
                            "A decently aged shield, still able to preventing incoming harm",
                            "Stupid yet fearless to face your enemies withour protection",
                            "Simple protection made from the strong skin of cows",
                            "Armor made of multiple small metal rings, flexible and capable of providing decent protection from others"};

    String armourDescLeg[] = {"Armor made from the of the legendry dragons, impervious to most things",
                              "A shield made from the legendary tree of Gudrag, almost as tough as him",
                              "A ring that calls upon life from beyond to protect your from the dangers you may face",
                              "The suit of armor worn by Dreg, a warrior known for slaughtering many enemies during his time"};

    int armourDefense[] = {4,2,4,0,3,4};
    int armourDefenseLeg[] = {9,10,8,9};
    int defense;

    public Armour(){
        int r = (int)Math.random()*7;
        int l = (int)Math.random()*5;
        if((int)(Math.random()*2) == 0){
        name = armourNames[r];
        desc = armourDesc[r];
        defense = armourDefense[r]; 
        } else {
        name = armourNamesLeg[l];
        desc = armourDescLeg[l];
        defense = armourDefenseLeg[l];
    }
  }
}