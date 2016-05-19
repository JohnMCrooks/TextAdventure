package com.crooks;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by johncrooks on 5/18/16.
 */
public class Player {
    String name;
    String weapon;
    String location;
    ArrayList<String> items = new ArrayList<String>();

    public void chooseName(){

        System.out.println("What is your name?\n");
        name = Main.scanner.nextLine();
        System.out.println("Hello, " + name);

    }

    public void chooseWeapon() throws Exception {

        System.out.println("Choose your weapon [sword/mace/staff]");
        weapon = Main.scanner.nextLine();

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
        location = Main.scanner.nextLine();
        if (location.equalsIgnoreCase("forest")){
            System.out.println("entering the dense forests of James Island");
        } else if (location.equalsIgnoreCase("tunnel")){
            System.out.println("you have entered the labryinth of sewers deep below Charleston. It does not smell great.");
        }else{
            throw new Exception("Invalid Location!");
        }
    }

    public void findItem(String item){
        System.out.println("You Stumble upon some something in the dark. Pick it up? [y/n]");
        String answer = Main.scanner.nextLine();
        if (answer.equalsIgnoreCase("y")){
            items.add(item);
            System.out.println("you picked up " + item + "! You now have " + items.size() + " items in your inventory.");
        }
    }
}
