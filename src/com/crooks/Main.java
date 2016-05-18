package com.crooks;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(" Welcome Traveler!");
        System.out.println("What is your name?\n");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Hello, " + name);

        System.out.println("Choose your weapon [sword/mace/staff]");
        String weapon = scanner.nextLine();

        if (weapon.equalsIgnoreCase("sword")){
            System.out.println("Watch the pointy side, it's dangerous");
        }else if( weapon.equalsIgnoreCase("mace")){
            System.out.println("blunt and useful, I dig it.");}
        else if(weapon.equalsIgnoreCase("staff")){
            System.out.println("good for the knees on those long journeys");
        } else{
            throw new Exception("Yo, Pick a real Weapon");
        }

        System.out.println("Choose your Location [forest/tunnel]");
        String location = scanner.nextLine();
        if (location.equalsIgnoreCase("forest")){
            System.out.println("entering the dense forests of James Island");
        } else if (location.equalsIgnoreCase("tunnel")){
            System.out.println("you have entered the labryinth of sewers deep below charleston");
        }else{
            throw new Exception("Invalid Location!");
        }

    }
}
