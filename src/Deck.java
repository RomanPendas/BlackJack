import java.util.Random;
import java.util.ArrayList;
public class Deck {
    private Random rng = new Random();
    private int[] deck = {2,3,4,5,6,7,8,9,10,10,10,10,11};
        public Deck(){
        }

    public int getRandomACard() {
        return  deck[rng.nextInt(deck.length)];
    }
}
