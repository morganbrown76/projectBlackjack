package com.company;

/*
 * Blackjack.java
 *
 * Computer Science 111, Boston University
 * modified by: Laura K. Gross, laura.gross@bridgew.edu, November 14, 2018
 *
 * Worked on by: Morgan Brown, m16brown@student.bridgew.edy, November 21, 2018
 */

import java.util.*;

public class Blackjack {

    public static void main(String[] args) {
        System.out.println("Welcome to the game of Blackjack!");
        System.out.println();
        Scanner console = new Scanner(System.in);

        Deck deck = new Deck(); // Define a Deck object called deck.
        deck.shuffle(); // Shuffle it, using the shuffle method from the deck class.

        BlackjackDealer dealer = new BlackjackDealer(); // Define a dealer.
        ConsolePlayer player = new ConsolePlayer(console); // Define a console player.

        /* Declare a string called choice, which will be defined by user input
         * starting with y or not.
         */
        String choice;

        do {
            /* Play at least one hand of blackjack. Then the cards from the hand just played
             * will be set aside, and the next hand (if user desires one) will be dealt from
             * the cards that remain in the deck---unless fewer than ten cards remain,
             * in which case all previously played cards will be returned to the deck.
             * The full deck will be shuffled and used to deal the next hand.  (A future
             * feature might be to show the number of cards remaining in the deck at the end
             * of the hand and to show the resets when they occur.)
             */
            playHand(console, deck, player, dealer);

            System.out.print("play another hand (y/n)? ");
            choice = console.next();
            console.nextLine();

            if (deck.getCardsLeft() < 10) {
                deck.reset();
                deck.shuffle();
            }
        } while (choice.charAt(0) == 'y');
    }

    /* The dealCard method is a method to deal a card from the deck to the hand.
     */
    private static void dealCard(Deck deck, Hand hand) {
        if (deck.isEmpty()) { // If all the cards have been dealt from the deck
            deck.reset(); // return all the cards to the deck,
            deck.shuffle(); // and shuffle them.
        }

        hand.addCard(deck.dealCard()); // Deal a card from the deck, and add it to the hand.
    }

    /* The playHand method plays a hand of blackjack.
     */
    private static void playHand(Scanner console, Deck deck, Player player,
                                 Player dealer) {
        // Initialize hands: arrays that can hold up to 20 cards.
        // Initially the hands contain no cards.
        BlackjackHand playerHand = new BlackjackHand();
        BlackjackDealerHand dealerHand = new BlackjackDealerHand();

        // Deal the initial cards: two to the player, and two to the dealer.
        dealCard(deck, playerHand);
        dealCard(deck, playerHand);
        dealCard(deck, dealerHand);
        dealCard(deck, dealerHand);
        // Display the player's hand and one of the dealer's two cards.
        displayHands(dealerHand, playerHand);

        /* If player's score for the initial hand is 21, and dealer's isn't
         * then set the relevant field of BlackjackHand to show hand outcome is "Blackjack!"
         */
        if (playerHand.getValue() == 21 && !(dealerHand.getValue() == 21)) {
            playerHand.setBlackjack();  // You will need to uncomment this command when you have written
            // the method setBlackjack in the appropriate class.
        }

        /* While the player's hand value remains < 21, he or she has the option to keep
        taking a hit.  If the player wants a hit, deal a card, and display the hands.
        */
        while (playerHand.getValue() < 21 && player.wantsHit(playerHand, dealerHand)) {
            dealCard(deck, playerHand);
            displayHands(dealerHand, playerHand);
        }

        // Next it's the dealer's turn.
        dealerHand.setDealerTurn(true); // You will need to uncomment this command when you have written
        // the method setDealerTurn in the appropriate class.
        displayHands(dealerHand, playerHand); // The dealer reveals her hidden card.

        /* While the dealer's hand value remains < 21, keep checking if the dealer should
         * take a hit.  If the dealer should take a hit, deal a card, and display the hands.
         */
        while (dealerHand.getValue() < 21 && dealer.wantsHit(dealerHand, playerHand)) {
            dealCard(deck, dealerHand);
            displayHands(dealerHand, playerHand);
        }

        // Print the outcome of the hand of blackjack.
        printResult(playerHand, dealerHand);
    }

    /* The printResult method
     * Modify this method to print the outcome of the hand of blackjack.
     */

    private static void printResult(BlackjackHand playerHand, BlackjackDealerHand dealerHand) {
        int playerScore = playerHand.getValue();
        int dealerScore = dealerHand.getValue(); // keep these
        if (playerHand.isBlackjack) {
            System.out.println("Blackjack!");
        } else if (playerScore == dealerScore) {
            System.out.println("Push!");
        } else if (playerScore <=21 && playerScore > dealerScore) {
            System.out.println("You win!");
        } else if (playerScore <=21 && dealerScore > 21) {
            System.out.println("You win!");
        } else if (playerScore > 21) {
            System.out.println("You lose!");
        } else System.out.println("You lose!");
    }

        /* The displayHands method prints the contents of each player's hand and the corresponding
         *  value.  Note java automatically calls the toString method on a Hand object.
         */
        private static void displayHands (Hand dealerHand, Hand playerHand){
            System.out.println("dealer: " + dealerHand);
            System.out.println("player: " + playerHand);
            System.out.println();

        }


    }

