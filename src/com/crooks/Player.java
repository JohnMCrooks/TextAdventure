package com.crooks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by johncrooks on 5/18/16.
 */
public class Player extends Character {
    String weapon;
    String location;

    ArrayList<String> items = new ArrayList<String>();

    public Player() {
        this.health = 20;
        this.damage = 20;
    }

    public void chooseName(){

        System.out.println("What is your name?\n");
        name = Main.nextLine();
        System.out.printf("Hello, %s", name);

    }

    public void chooseWeapon() throws Exception {

        System.out.println("Choose your weapon [sword/mace/staff]");
        weapon = Main.nextLine();

        if (weapon.equalsIgnoreCase("sword")){
            System.out.println("Watch the pointy side, it's dangerous");
        }else if( weapon.equalsIgnoreCase("mace")){
            System.out.println("blunt and useful, I dig it.");}
        else if(weapon.equalsIgnoreCase("staff")){
            System.out.println("good for the knees on those long journeys");
        } else{
            throw new Exception("Yo, Pick a real Weapon");
        }
    }

    public void chooseLocation() throws Exception {
        System.out.println("Choose your Location [forest/tunnel]");
        location = Main.nextLine();
        if (location.equalsIgnoreCase("forest")){
            System.out.println("entering the dense forests of James Island");
        } else if (location.equalsIgnoreCase("tunnel")){
            System.out.println("you have entered the labryinth of sewers deep below Charleston. It does not smell great.");
        }else{
            throw new Exception("Invalid Location!");
        }
    }

    public void findItem(String item){
        System.out.printf("You Stumble upon some something in the dark. Pick it up? [y/n]");
        String answer = Main.nextLine();
        if (answer.equalsIgnoreCase("y")){
            items.add(item);
            System.out.printf("you picked up %s! \n You now have %s items in your inventory.\n\n", item, items.size());
        }
    }
}
