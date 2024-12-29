/*
 * Name: Danielle Moore
 * Date: 11/16/2024
 * Description: This program builds a deck of cards.
 */

package Project;

//Import classes
import java.util.ArrayList;
import java.util.Random;

public class CardDeck extends ArrayList<Card> {
    // CardDeck constructor
    CardDeck() {
        // declaring variables
        String[] values = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K" };
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

        // Create deck of cards
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < values.length; j++) {
                this.add(new Card(values[j], suits[i]));
            }
        }
    }// end of constructor

    // Method to shuffle the deck of cards
    public void shuffleDeck() {
        Random rand = new Random();
        for (int i = 0; i < this.size(); i++) {
            int randomIndex = rand.nextInt(this.size());
            Card currentCard = this.get(i);
            Card randomCard = this.get(randomIndex);
            this.set(i, randomCard);
            this.set(randomIndex, currentCard);
        } // end of for loop

    }// end of shuffleDeck

    // overriding toString method so that when we print deck
    @Override
    public String toString() {
        String deckString = "[";
        for (int i = 0; i < this.size(); i++) {
            deckString += this.get(i).toString();

            if (i < this.size() - 1) {
                deckString += ", ";
            } // end of if statement

        } // end of for loop

        deckString += "]";
        return deckString;
    }// end of toString

}
// end of CardDeck class
