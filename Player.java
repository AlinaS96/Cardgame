package Assignment8;
public class Player {
    Game game = new Game();
    public Card[] hand = new Card[52];
    public static int abc=0;

    public static void main(String[] args) {}

    public static void getArrayLength(int bcd){abc=bcd;}

    public Card[] getHand() {
        Card[] returningHand = new Card[52/abc];
        if(hand[0]==null){
            for (int i = 0; i < returningHand.length; i++) {
                returningHand[i] = hand[i];
            }
        }
        else {
            for (int i = 0; i < returningHand.length; i++) {
                returningHand[i] = hand[i];
            }
        }
        return returningHand;
    }

    public void sortHand() {
        if (hand[0] == null) {
        } else {
            Card[] SortedHandArray = new Card[52 / abc];
            int k = 0;
            for (int i = 0; i < game.deck.length; i++) {
                for (int j = 0; j < SortedHandArray.length; j++) {
                    if (game.deck[i].suit == hand[j].suit && game.deck[i].rank == hand[j].rank) {
                        SortedHandArray[k++] = game.deck[i];
                    }
                }
            }
            for (int i = 0; i < SortedHandArray.length; i++) {
                 hand[i] = SortedHandArray[i];
            }
        }
    }
}
