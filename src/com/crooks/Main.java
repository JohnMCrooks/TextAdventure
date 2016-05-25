package com.crooks;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Player p1;
    static final String SAVE_FILE = "game.json";


    public static void main(String[] args) throws Exception {
        p1 = loadGame(SAVE_FILE);
        if (p1 == null){
            p1 = new Player();
            System.out.println("Starting new game...\n");
        } else{
            System.out.println(" Found save file\n Start New Game instead? [y/n]");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")){
                p1 = new Player();
            }
        }

        if (p1.name ==null) p1.chooseName();
        if (p1.weapon == null) p1.chooseWeapon();
        if (p1.location==null) p1.chooseLocation();
        if (p1.items.isEmpty()) {
            p1.findItem("Armor");
            p1.findItem("Potion");
        }

        Enemy ogre = new Enemy("Ogre", 10, 10);

        p1.battle(ogre);
        saveGame(p1, SAVE_FILE);
    }


    public static String nextLine(){
        String line = scanner.nextLine();
        while (line.startsWith("/")){
            if (line.equals("/inv")){
                for ( String item : p1.items) {
                    System.out.println(item);
                }
            }else if(line.equals("/save")){
                saveGame(p1, SAVE_FILE);
                System.out.println("Your Game has Been Saved Succesfully!");
            }
            else {
                System.out.println("Command not found.");
            }

            line = scanner.nextLine();
        }
        return line;
    }

    public static void saveGame(Player p1, String filename) {
        JsonSerializer  serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(p1);

        File f = new File(filename);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Player loadGame(String filename){
        File f = new File(filename);
        try {
            Scanner scanner = new Scanner(f);
            scanner.useDelimiter("\\z");
            String contents = scanner.next();
            JsonParser parser = new JsonParser();
            return parser.parse(contents, Player.class);

        } catch (FileNotFoundException e) {
        }
        return null;
    }

}
