
import java.util.*;
public class Character {
    String name;
    int pClass;

    int atk;
    int def;
    int hp; 
    int maxHP;
    ArrayList<Items> inventory = new ArrayList<>();
    Weapon wp;
    Armour ar;
    Potion po;
    String [] monsterNames = {"Mimic","Thug","Zombie"};
    Boolean isDefending;

    int [] location = new int [2];
    

    public Character(String name, int hp, int atk, int def){
        this.maxHP = hp;
        this.atk = atk; 
        this.def = def;
        this.name = name;
        this.hp = hp;
    }

    void atkBuff(int a){
        atk += a;
    }

    void equipArmour(Armour ar){
        this.ar = ar;
    }

    void equipWeapon(Weapon wp){
        this.wp = wp;
    }

    void equipPotion(Potion po){
        this.po = po;
    }

    int calculateDmg(){
        if(wp == null){
            return atk;
        } 
        return atk + wp.damage;
    }

    int calculateDef(){
        if(ar == null){
            return def;
        } 
        return def + ar.defense;
    }

    public void setLocation(int x, int y) {
            location[0] = x;
            location[1] = y;
        }

    void drinkPotion() {
        if (this.po != null) {
            switch(this.po.type) {
            case 0: case 1: case 2:
                this.hp += po.potionBuff[po.type];
                this.po = null;
                break;
            case 3: case 4: case 5:
                this.def += po.potionBuff[po.type];
                this.po = null;
                break;
            case 6: case 7: case 8:
                this.hp += po.potionBuff[po.type];
                this.po = null;
                break;
            }
        }
    }
        
    public String getLocation() {
        return "" + this.location[0] +", " + this.location[1];
    }

}
