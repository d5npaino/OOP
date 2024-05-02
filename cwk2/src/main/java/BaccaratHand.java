// TODO: Implement the BaccaratHand class in the file

import java.util.List;
import java.util.LinkedList;

public class BaccaratHand extends CardCollection {
    private LinkedList<BaccaratCard> cards;

    public BaccaratHand() {
        cards = new LinkedList<>();
    }

    public void add(BaccaratCard card) {
        cards.add(card);
    }

    @Override
    public int value() {
        int sum = 0;
        for (BaccaratCard card : cards) {
            sum += card.value();
        }
        sum %= 10;
        return sum;
    }

    public String toString() {
        String fullString = "";
        int count = 0;
        for (BaccaratCard card : cards) {
            fullString += card.toString();
            count++;
            if (count != cards.size()) {
                fullString += " ";
            }

        }
        return fullString;
    }

    public boolean isNatural() {
        if (cards.size() == 2 && value() > 7) {
            return true;
        } else {
            return false;
        }
    }

    public int cardValue(int index) {
        return cards.get(index).value();
    }

    // without saying these methods again is uses the superclass 'cards' list
    // instead even though this is inside a subclass which has its own 'cards'
    // variable :/
    public int size() {
        return cards.size();
    }

    public void discard() {
        cards.clear();
    }
}