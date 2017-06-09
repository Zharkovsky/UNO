import java.util.ArrayList;
import java.util.List;

/**
 * Created by Алена on 09.06.2017.
 */
abstract public class Player {

    String name;
    private List<Card> cards = new ArrayList<>();

    abstract public void makeStep(Card currentCard);

    public void pickUpCard(Card card){
        cards.add(card);
    }

    public Card getCard(int i){
        Card card = get(i);
        eraseCard(i);
        return card;
    }

    private Card get(int i){
        return cards.get(i);
    }

    private void eraseCard(int i){
        cards.remove(i);
    }

    public int getNumberOfCards(){
        return cards.size();
    }

    public void addCard(Card card){
        cards.add(card);
    }
}
