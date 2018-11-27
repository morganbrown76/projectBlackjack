package com.company;
/*
 * BlackjackDealer.java
 *
 * COMP152, Bridgewater State University
 *
 * Morgan Brown, m16brown@student.bridgew.edu, November 18th, 2018
 */

public class BlackjackDealer extends Player {
    public boolean wantsHit(Hand ownHand, Hand opponentHand) {
        if (ownHand.getValue() < 17) {
            return true;
        } else if (opponentHand.getValue() == 21) {
            if ((ownHand.getValue() < 17)) {
                return true;
            } else
                return false;
        }
            return false;
    }
}