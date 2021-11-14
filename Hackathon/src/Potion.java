

import java.util.HashMap;

public class Potion extends Items{
    HashMap<String, Integer> potions = new HashMap<String, Integer>();

    
    String potionName[] = {"Lesser Wrath","Wrath", "Greater Wrath", "Lesser Stone", "Stone", "Greater Stone", "Lesser Healing", "Healing", "Greater Healing"};

    String potionDescr[] = {"If consumed will grant the user little strength",
                            "If consumed will grant the user some strength",
                            "If consumed will grant the user immense strength",
                            "If consumed will grant the user little defense",
                            "If consumed will grant the user some defense",
                            "If consumed will grant the user immense defense",
                            "If consumed will grant the user little health",
                            "If consumed will grant the user some health",
                            "If consumed will grant the user immense health"};
                            
    int potionBuff[] = {3,6,9,3,6,9,3,6,9};
    int buff;
    int type; //defense = 0 || attack = 1 || healing = 2

    public Potion(){
        int r = (int)Math.random()*7;
        name = potionName[r];
        desc = potionDescr[r];
        buff = potionBuff[r];
    }

    void Wrath(int a, int b){
        a += b;
    }

     void Stone(int d, int c){
        d += c;
    }

    void Healing(int e, int f){
        e += f;
    }
}