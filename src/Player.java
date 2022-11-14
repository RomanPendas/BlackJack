import java.util.ArrayList;
public class Player {
    private ArrayList<Integer> playerHand = new ArrayList<Integer>();
    private int cardValueTotal;

    public Player(int firstCard, int secondCard) {
        playerHand.add(firstCard);
        playerHand.add(secondCard);
    }
    public int getCardValueTotal(){
        cardValueTotal = 0;
        for (Integer integer : playerHand) {
            cardValueTotal += integer;
        }
        return cardValueTotal;
    }

    public ArrayList<Integer> getPlayerHand() {
        return playerHand;
    }
    public void addNewCard(int newCard){
        playerHand.add(newCard);
    }
}
