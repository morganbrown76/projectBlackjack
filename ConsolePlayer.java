package com.company;
import java.util.*;

/*
 * ConsolePlayer.java
 *
 * Morgan Brown, Bridgewater State University, November 19th, 2018
 */

public class ConsolePlayer extends Player {
    private Scanner console;

    public ConsolePlayer(Scanner console) {
        this.console = console;
    }

    @Override
    public boolean wantsHit(Hand ownHand, Hand opponentHand) {
        System.out.println("Do you want another hit (y/n)? ");
        String choice = console.next();
        console.nextLine();
        return (choice.charAt(0) == 'y');
    }
}
