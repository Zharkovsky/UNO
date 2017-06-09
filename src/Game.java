import java.util.Random;

/**
 * Created by Алена on 09.06.2017.
 */
public class Game {
    RealPlayer realPlayer;
    CardDeck cardDeck;
    private int currentTurn = 0;
    private Card currentCard;

    public void start(){

        System.out.println("Let`s play!");

        boolean win = false;

        cardDeck = new CardDeck();
        currentCard = cardDeck.getCard(0);
        currentTurn = firstPlayer();

        while(!win){
            if (currentTurn == 0){
                //bot turn
            }
            else{
                //player turn

                //if current card is action-card
                if (!makeAction(currentCard)){
                    //make something
                    int command = 0;
                    Card userCard;
                    //read command
                    command--;

                    if (command < 0 || command > realPlayer.getNumberOfCards()){
                        pickUpCard(realPlayer);
                    }
                    else{
                        //make action
                        userCard = realPlayer.getCard(command);
                        boolean rightStep = checker(currentCard,userCard);

                        if (!rightStep){
                            //say user that he is stupid
                            realPlayer.addCard(userCard);
                        }
                        else{
                            cardDeck.addCard(currentCard);
                            currentCard = userCard;
                        }
                    }
                }
            }

            changeOfTurn(currentTurn);
        }

    }

    public int firstPlayer(){
        Random rnd = new Random(System.nanoTime());
        return rnd.nextInt(2);
    }

    private void changeOfTurn(int currentTurn){
        this.currentTurn = (currentTurn == 0)?1:0;
    }

    private boolean makeAction(Card currentCard){
        if(currentCard.toString().contains("SKIP"))
            return true;
        if (currentCard.toString().contains("REVERSE"))
            return true;

        if(currentCard.toString().contains("PICK_UP_TWO")){
            //pick up
            return true;
        }
        if(currentCard.toString().contains("PICK_UP_FOUR")){
            //pick up
            //ask color
            return true;
        }

        if(currentCard.toString().contains("CHOOSE_COLOR")){
            //ask color
            return false;
        }

        return false;
    }

    public void pickUpCard(Player player){
        player.pickUpCard(cardDeck.getCard(0));
    }

    private boolean checker(Card currentCard, Card userCard){
        return true;
    }
}
