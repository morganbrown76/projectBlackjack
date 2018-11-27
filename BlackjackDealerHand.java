package com.company;

/*
 * BlackjackDealerHandjava
 *
 * COMP152, Bridgewater State University
 *
 * Morgan Brown, m16brown@student.bridgew.edu, November 18th, 2018
 */

public class BlackjackDealerHand extends BlackjackHand {

    private boolean TurnForDealer;

    public BlackjackDealerHand() {
        super();
        TurnForDealer = false;
    }


    public void setDealerTurn(boolean TurnForDealer) {
        this.TurnForDealer = TurnForDealer;
    }

    @Override
    public String toString() {
        if (TurnForDealer) {
            String str = ""; // Initialize str with the empty String.

            for (int i = 0; i < getNumCards(); i++) {
                str = str + (getCard(i)); // Concatenate the card in position i to str,
                // implicitly calling the toString method in the Card class.

                if (i < getNumCards() - 1) { // If we're not at the last Card in the Hand,
                    str += "  "; // then concatenate a space to prepare for printing the next Card.
                }
            }

            str = str + "  (value = " + getValue() + ")";

            return str;
        }
        else return "XX " + getCard(1);
    }
}
