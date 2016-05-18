package com.crooks;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println(" Welcome Traveler!");

        Player p1 = new Player();

        p1.chooseName();
        p1.chooseWeapon();
        p1.chooseLocation();

    }
}
