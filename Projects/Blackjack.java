/*
 * Name: Danielle Moore
 * Date: 11/16/2024
 * Description: This program builds a simple blackjack game
 */

package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {
    // initializing variables
    int numPlayers;
    int dealerHandSum;
    int dealerHandAceCount;
    Card[][] playersHands;
    Card[] dealerHand;

    Blackjack(int numPlayers) {
        this.numPlayers = numPlayers;
        this.playersHands = new Card[numPlayers][11];
        this.dealerHand = new Card[11];
    }// end of default constructor

    // Method to deal initial cards to players
    public void dealInitialCards(ArrayList<Card> cardDeck) {

        // dealing initial cards to players
        System.out.println("Dealing cards to players...");
        for (int i = 0; i < numPlayers; i++) {
            this.playersHands[i][0] = cardDeck.remove(cardDeck.size() - 1);
            System.out.println("Player " + (i + 1) + " hand: " + handToString(this.playersHands[i]));
        } // end of for loop

        // The hidden card for the dealer
        this.dealerHand[0] = cardDeck.remove(cardDeck.size() - 1);
        this.dealerHandSum += this.dealerHand[0].getCardValue();
        System.out.println("Dealer's 1st card: [hidden for now].");

        // dealing 2nd cards to players
        System.out.println("Dealing 2nd card to players...");
        for (int i = 0; i < this.numPlayers; i++) {
            this.playersHands[i][1] = cardDeck.remove(cardDeck.size() - 1);
            System.out.println("Player " + (i + 1) + " hand: " + handToString(this.playersHands[i]));
        } // end of for loop

        // dealing 2nd card to dealer (showing the 1st card & hiding the 2nd card [this
        // is how it's done at the casinos])
        System.out.println("Dealing 2nd card to dealer...");
        this.dealerHand[1] = cardDeck.remove(cardDeck.size() - 1);
        this.dealerHandSum += this.dealerHand[0].getCardValue();
        System.out.println("Dealer's 1st card: " + this.dealerHand[0].toString());
    }// end of method dealInitialCards

    // Method to calculate sum of hand
    public int calculateHandSum(Card[] hand) {
        int handSum = 0;
        int aceCount = 0;

        for (int cardNum = 0; cardNum < hand.length; cardNum++) {
            if (hand[cardNum] != null) {
                handSum += hand[cardNum].getCardValue();
                if (hand[cardNum].getCardValue() == 11) {
                    aceCount++;
                }
            }
        } // end of for loop

        while (handSum > 21 && aceCount > 0) {
            handSum -= 10;
            aceCount--;
        } // end of while loop

        return handSum;
    }// end of calculateHandSum

    // Method to format a player's hand (Card[] array) into a string
    public String handToString(Card[] hand) {
        StringBuilder handString = new StringBuilder();

        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null) { // Only process non-null cards
                handString.append(hand[i].toString()); // Append the card's string representation
                if (i < hand.length - 1 && hand[i + 1] != null) { // Check if it's not the last card
                    handString.append(", ");
                }
            }
        }

        return handString.toString(); // Return the formatted string
    }// end of handToString

    // Method for starting blackjack game
    public void startBlackjackGame() {

        // Initializing hit or stay variable
        String hitOrStay;

        // building deck of cards and shuffling
        System.out.println("Building deck of cards and shuffling...");
        CardDeck deck = new CardDeck();
        deck.shuffleDeck();
        // System.out.println(deck);

        // dealing initial cards to players
        dealInitialCards(deck);

        // Creating scanner object
        Scanner userHitOrStay = new Scanner(System.in); // creating a scanner object for user input on hit or stay

        for (int i = 0; i < this.numPlayers; i++) {
            if (calculateHandSum(this.playersHands[i]) == 21) {
                System.out.println("Player " + (i + 1) + " has 21!");
                continue;
            }
            System.out.println("Player " + (i + 1) + " this is your current hand sum: "
                    + calculateHandSum(this.playersHands[i]) + ". Would you like to hit or stay? (h/s)");
            hitOrStay = userHitOrStay.nextLine();

            // Tracking index of next card
            int nextCardIndex = 2;

            while (hitOrStay.equals("h") & calculateHandSum(this.playersHands[i]) < 21) {
                this.playersHands[i][nextCardIndex] = deck.remove(deck.size() - 1);
                nextCardIndex++; // Incrementing index of next card

                // Displaying updated hand for player
                System.out.println("Player " + (i + 1) + " hand: " + handToString(this.playersHands[i]) + ". Hand sum: "
                        + calculateHandSum(this.playersHands[i]));

                // Checking if player busts or has 21. If neither continue asking player to hit
                // or stay
                if (calculateHandSum(this.playersHands[i]) > 21) {
                    System.out.println("Player " + (i + 1) + " busts!");
                    break;
                } else if (calculateHandSum(this.playersHands[i]) == 21) {
                    System.out.println("Player " + (i + 1) + " has 21!");
                    break;
                } else {
                    System.out.println("Would you like to hit or stay Player " + (i + 1) + " ? (h/s)");
                    hitOrStay = userHitOrStay.nextLine();
                }
            }
        }

        // Dealer's turn
        System.out.println("Dealer's turn...");
        // dealer's hand sum
        this.dealerHandSum = calculateHandSum(this.dealerHand);
        System.out.println("Original dealer's hand: " + handToString(this.dealerHand) + ". Original hand sum: "
                + this.dealerHandSum); // display dealer's hand

        // Tracking index of next card for dealer
        int dealerNextCardIndex = 2;
        while (this.dealerHandSum < 16) {

            this.dealerHand[dealerNextCardIndex] = deck.remove(deck.size() - 1);
            dealerNextCardIndex++; // Incrementing index of next card

            this.dealerHandSum = calculateHandSum(this.dealerHand);
            System.out.println("Dealer's hand: " + handToString(this.dealerHand) + ". Hand sum: "
                    + calculateHandSum(this.dealerHand));
        }

        // Determining the winners
        for (int i = 0; i < this.numPlayers; i++) {
            if (calculateHandSum(this.playersHands[i]) > 21) {
                System.out.println("Player " + (i + 1) + " busted. Player " + (i + 1) + " lost their bet.");
            } else if (calculateHandSum(this.playersHands[i]) > this.dealerHandSum
                    && calculateHandSum(this.playersHands[i]) <= 21) {
                System.out.println("Player " + (i + 1) + " beats the dealer! Player " + (i + 1) + " wins!");
            } else if (calculateHandSum(this.playersHands[i]) == this.dealerHandSum
                    && calculateHandSum(this.playersHands[i]) <= 21) {
                System.out.println(
                        "Player " + (i + 1) + " ties with the dealer. Player " + (i + 1) + " gets their bet back.");
            } else {
                System.out
                        .println("Player " + (i + 1) + " loses to the dealer. Player " + (i + 1) + " lost their bet.");
            }
        } // end of for loop

        userHitOrStay.close();// closing scanner object
    }// end of startBlackjackGame

}
