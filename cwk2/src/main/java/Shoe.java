// TODO: Implement the Shoe class in this file

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class Shoe extends CardCollection {
    private LinkedList<BaccaratCard> cards;

    public Shoe(int numDecks) throws CardException {
        if (numDecks != 6 && numDecks != 8) {
            throw new CardException("Deck size invalid, can only play with 6 or 8 decks.");
        }

        cards = new LinkedList<>();

        for (int i = 0; i < numDecks; i++) {
            for (Card.Suit s : Card.Suit.values()) {
                for (Card.Rank r : Card.Rank.values()) {
                    cards.add(new BaccaratCard(r, s));
                }
            }
        }

    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public BaccaratCard deal() throws CardException {

        try {
            return cards.remove(0);
        } catch (Exception e) {
            throw new CardException("Shoe is empty");
        }
    }

    public int size() {
        return cards.size();
    }
}
