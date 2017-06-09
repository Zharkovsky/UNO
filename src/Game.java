import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Алена on 09.06.2017.
 */
public class Game {
    Player realPlayer;
    Player botPlayer;
    CardDeck cardDeck;
    private int currentTurn = 0;
    private Card currentCard;

    public void start(){

        System.out.println("Let`s play!");
        System.out.println("");
        System.out.println("Enter your name: ");

        String realPlayerName = "Bob";
        //read name

        realPlayer = new RealPlayer(realPlayerName);
        botPlayer = new BotPlayer();

        cardDeck = new CardDeck();
        currentCard = cardDeck.getCard(0);

        realPlayer.numberOfCards = 7;
        botPlayer.numberOfCards = 7;

        giveOutCards(realPlayer);
        giveOutCards(botPlayer);

        boolean win = false;
        currentTurn = firstPlayer();

        while(!win){
            if (currentTurn == 0){
                //bot turn
            }
            else{
                //player turn
                //show his cards

                //if current card isn`t action-card
                if (!makeAction(currentCard,realPlayer)){
                    int command = 0;
                    Card userCard;
                    //read command
                    command--;

                    if (command < 0 || command >= realPlayer.getNumberOfCards()){
                        pickUpCard(realPlayer);
                        realPlayer.numberOfCards++;
                    }
                    else{
                        userCard = realPlayer.putCard(command);
                        boolean rightStep = checker(currentCard,userCard);

                        if (!rightStep){                       //check turn
                            while(!rightStep){
                                realPlayer.addCard(userCard);   //возврат карты
                                System.out.println("Wrong choice. Choose another card.");
                                //read command
                                userCard = realPlayer.putCard(command);
                                rightStep = checker(currentCard,userCard);
                            }
                        }
                        else{
                            cardDeck.addCard(currentCard);
                            currentCard = userCard;       //put user`s card on desk
                            realPlayer.numberOfCards--;
                        }
                    }
                }
            }

            changeOfTurn(currentTurn);

            if (realPlayer.numberOfCards == 0 || botPlayer.numberOfCards == 0)
                win = true;
        }

        if (realPlayer.numberOfCards == 0){
            System.out.println("You are winner of this round");
        }
        else
            System.out.println("Don`t worry! Let`s play again!");

        return;
    }

    public int firstPlayer(){
        Random rnd = new Random(System.nanoTime());
        return rnd.nextInt(2);
    }

    private void changeOfTurn(int currentTurn){
        this.currentTurn = (currentTurn == 0)?1:0;
    }

    private void giveOutCards(Player player){
        Card card;
        for (int i = 0; i < 7; i++){
            card = cardDeck.getCard(0);
            player.addCard(card);
        }
    }

    private boolean makeAction(Card currentCard, Player player){
        if(currentCard.toString().contains("SKIP"))
            return true;
        if (currentCard.toString().contains("REVERSE"))
            return true;

        if(currentCard.toString().contains("PICK_UP_TWO")){
            for (int i = 0; i < 2; i++){
                Card card = cardDeck.getCard(0);
                player.addCard(card);
            }
            player.numberOfCards += 2;
            return true;
        }
        if(currentCard.toString().contains("PICK_UP_FOUR")){
            for (int i = 0; i < 4; i++){
                Card card = cardDeck.getCard(0);
                player.addCard(card);
            }

            player.numberOfCards += 4;
            //ask color
            //установить цвет
            return true;
        }

        if(currentCard.toString().contains("CHOOSE_COLOR")){
            //ask color
            //установить цвет
            return false;
        }

        return false;
    }

    public void pickUpCard(Player player){
        player.addCard(cardDeck.getCard(0));
    }

    private boolean checker(Card currentCard, Card userCard){ //private!!!!!!!!!
        //взяли цвет карты
        int beginIndex = userCard.toString().lastIndexOf("_");
        int endIndex = userCard.toString().length();
        String color = userCard.toString().substring(beginIndex, endIndex);

        //берем первую часть названия карт
        beginIndex = 0;
        int endUserIndex = userCard.toString().lastIndexOf("_");
        int endCurrentIndex = currentCard.toString().lastIndexOf("_");

        String commandNameOfUser = userCard.toString().substring(beginIndex, endUserIndex);
        String commandNameOfCurrent = currentCard.toString().substring(beginIndex, endCurrentIndex);

        System.out.println(commandNameOfCurrent);
        System.out.println(commandNameOfUser);

        if (currentCard.toString().contains(color) || commandNameOfCurrent.toString().equals(commandNameOfUser)) {
            return true;
        }

        return false;
    }
}
