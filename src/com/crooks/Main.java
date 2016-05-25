package com.crooks;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

        Enemy ogre = new Enemy("Ogre", 10, 10);

        p1.battle(ogre);

    }


    public static String nextLine(){
        String line = scanner.nextLine();
        while (line.startsWith("/")){
            if (line.equals("/inv")){
                for ( String item : p1.items) {
                    System.out.println(item);
                }
            }else if(line.equals("/save")){
                saveGame();
                System.out.println("Your Game has Been Saved Succesfully!");
            }
            else {
                System.out.println("Command not found.");
            }

            line = scanner.nextLine();
        }
        return line;
    }

    public static void saveGame() {
        JsonSerializer  serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(p1);

        File f = new File("game.json");
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
