import java.util.Scanner;
import java.util.Random;
public class BlackJack {
        static Scanner scnr = new Scanner(System.in);
        static Random rng = new Random();
            public static void main(String[] args) {
                Deck deck = new Deck();
                Player theHouse = new Player(deck.getRandomACard(), deck.getRandomACard());
                Player player1 = new Player(deck.getRandomACard(), deck.getRandomACard());

                System.out.println("Houses Hand " + theHouse.getPlayerHand());

                System.out.println("Player 1's Hand " + player1.getPlayerHand());
                int playerResult = generatePlayersHand(player1, deck);

                System.out.println("Houses Turn");
                int houseResult = theHouse.getCardValueTotal();
                if (playerResult <= 21) {
                    houseResult = generateComputersHand(theHouse, deck);
                }

                determineWinner(houseResult, playerResult);

            }
            public static int generateComputersHand(Player theHouse, Deck deck){
                System.out.println(theHouse.getPlayerHand());
                System.out.println(theHouse.getCardValueTotal());

                while ( theHouse.getCardValueTotal() < 17) {

                    theHouse.addNewCard(deck.getRandomACard());
                    System.out.println(theHouse.getPlayerHand());
                    System.out.println(theHouse.getCardValueTotal());
                }
                return theHouse.getCardValueTotal();
            }
            public static int generatePlayersHand(Player player, Deck deck){
                String userHitOrStay = " ";

                System.out.println(player.getPlayerHand());
                System.out.println(player.getCardValueTotal());

                if (player.getCardValueTotal() != 21) {
                    while (userHitOrStay.charAt(0) != 's' && player.getCardValueTotal() < 21){
                        System.out.println("Will you hit or stay? (h/s)");
                        userHitOrStay = scnr.nextLine();
                        if (userHitOrStay.charAt(0) == 'h') {
                            player.addNewCard(deck.getRandomACard());
                        }
                        System.out.println(player.getPlayerHand());
                        System.out.println(player.getCardValueTotal());
                    }
                }

                return player.getCardValueTotal();
            }

            public static void determineWinner(int houseResult, int playerResult){
                if (playerResult == 21 && houseResult != 21) {
                    System.out.println("Player 1 wins");
                }
                else if (houseResult == 21){
                    System.out.println("House wins");
                }
                else if (playerResult > 21){
                    System.out.println("House wins");
                }
                else if (houseResult > 21){
                    System.out.println("Player 1 wins");
                }
                else if (playerResult > houseResult){
                    System.out.println("Player 1 wins");
                }
                else if (houseResult > playerResult){
                    System.out.println("House wins");
                }
                else {
                    System.out.println("its a tie");
                }
            }
}
