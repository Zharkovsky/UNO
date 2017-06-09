import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Алена on 09.06.2017.
 */
public class CardDeck {
    ArrayList<Card> deck = new ArrayList<>();

    CardDeck() {
        Random rnd = new Random(System.nanoTime());

        for (Card c: Card.values()) {
            for (int i = 0; i < c.getCount(); i++)
                deck.add(c);
        }

        for (int i = 0; i < deck.size(); i++) {
            int index = rnd.nextInt(deck.size());
            Card temp = deck.get(i);
            deck.set(i, deck.get(index));
            deck.set(index, temp);
            // swap(deck, i, rnd.nextInt(deck.size()));
        }
    }

    public Card getCard(int i){
        Card card = get(i);
        eraseCard(i);
        return card;
    }

    private Card get(int i){
        return deck.get(i);
    }

    private void eraseCard(int i){
        deck.remove(i);
    }

    public void display() {
        for(Card c: deck){
            System.out.println(c);
        }
    }

    public void addCard(Card card){
        deck.add(card);
    }
}
