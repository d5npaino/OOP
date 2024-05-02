// TODO: Implement the BaccaratCard class in this file
public class BaccaratCard extends Card {
    public BaccaratCard(Rank rank, Suit suit) {
        super(rank, suit);
    }

    @Override
    public int value() {
        int newVal = super.value() % 10;
        return newVal;
    }
}
