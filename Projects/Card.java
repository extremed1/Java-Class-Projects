/*
 * Name: Danielle Moore
 * Data: 11/16/2024
 * Description: This class creates a card object
 */

package Project;

public class Card {
    // Declare variables

    String value;
    String suit;

    // Card constructor
    Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    // Method to get the value of the card
    public int getCardValue() {
        if ("AJQK".contains(value)) {
            if (value.equals("A")) {
                return 11;
            } else {
                return 10;
            }
        }
        return Integer.parseInt(value);
    }// end of getCardValue

    // Overriding toString method so that when we print card, it prints
    // out the value and suit of each card like "A-Hearts"
    @Override
    public String toString() {
        return value + "-" + suit;
    }// end of toString

}// end of card class