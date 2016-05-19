package com.crooks;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Player p1 = new Player();

    public static void main(String[] args) throws Exception {
        System.out.println(" Welcome Traveler!");

        p1.chooseName();
        p1.chooseWeapon();
        p1.chooseLocation();
        p1.findItem("Armor");
        p1.findItem("potion");

//        System.out.println("type a number");
//        String num = scanner.nextLine();
//        int num1 = Integer.valueOf(num);
//
//        if (num1<0){
//            System.out.println("That's a negative number.");
//        }else if (num1>=0){
//            System.out.println("that's a positive number!");
//        }else {
//            throw new Exception("Dude, come on.  that's not a number...");
//        }

    }

    public static String nextLine(){
        String line = scanner.nextLine();
        while (line.startsWith("/")){
            if (line.equals("/inv")){
                for ( String item : p1.items) {
                    System.out.println(item);
                }
            }
            else {
                System.out.println("Command not found.");
            }

            line = scanner.nextLine();
        }
        return line;
    }


}
