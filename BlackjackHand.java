package com.company;

/*
 * BlackjackHand.java
 *
 * COMP152, Bridgewater State University
 *
 * Morgan Brown, m16brown@student.bridgew.edu, November 18th, 2018
 */
public class BlackjackHand extends Hand {

    public BlackjackHand() {
        super(20);
    }

    public boolean isBlackjack;

    public void setBlackjack() {
        isBlackjack = true;
    }

    @Override
    public int getValue() {
        int totalHand = 0; // total of Hand
        int lowAceTotal = 0;
        int highAceTotal = 0;
        for (int i = 0; i < getNumCards(); i++) {
            if (getCard(i).isAce()) {
                lowAceTotal += 11;
                highAceTotal += 1;
                if (lowAceTotal <= 21) {
                    totalHand = lowAceTotal;
                }
                else totalHand = highAceTotal;
            } else
                if (getCard(i).isFaceCard()) {
                lowAceTotal += 10;
                highAceTotal += 10;
                if (lowAceTotal <=21) {
                    totalHand = lowAceTotal;
                }
                else totalHand = highAceTotal;
            } else {
                lowAceTotal += getCard(i).getDefaultValue();
                highAceTotal += getCard(i).getDefaultValue();
                if (lowAceTotal <= 21) {
                    totalHand = lowAceTotal;
                }
                else totalHand = highAceTotal;

            }
        }
        return totalHand;
    }
}