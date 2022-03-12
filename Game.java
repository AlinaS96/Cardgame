package Assignment8;
public class Game {
    public Card[] deck = new Card[52];
    public Player[] players;
    public Suit[] SuitArray = Suit.values();
    public Rank[] RankArray = Rank.values();

    public Game(Player[] players) {
        this.players = players;
        int k = 0;
        for (int i = 0; i < SuitArray.length; i++) {
            for (int j = 0; j < RankArray.length; j++) {
                deck[k] = new Card(SuitArray[i], RankArray[j]);
                k++;
            }
        }
        Player.getArrayLength(players.length);
    }

    public Game() {
        int k = 0;
        for (int i = 0; i < SuitArray.length; i++) {
            for (int j = 0; j < RankArray.length; j++) {
                deck[k] = new Card(SuitArray[i], RankArray[j]);
                k++;
            }
        }
    }

    public void deal() {
        int k = 0;
        if (players.length == 3) {
            int h = 0;
            Card[] tempDeckFor3 = new Card[51];
            int[] IGotMyRandomArrayFor3 = RandomMyCode(0, 50);
            for (int i = 0; i < deck.length; i++) {
                if (deck[i].rank == Rank.Deuce && deck[i].suit == Suit.Clubs) {
                } else {
                    tempDeckFor3[h++] = deck[i];
                }
            }
            for (int i = 0; i < players.length; i++) {
                for (int j = 0; j < 17; j++) {
                    players[i].hand[j] = tempDeckFor3[IGotMyRandomArrayFor3[k++]];
                }
            }
            for (int i = 0; i <deck.length ; i++) {
                if (deck[i].rank == Rank.Deuce && deck[i].suit == Suit.Clubs) {
                } else {
                    deck[i] = null;
                }
            }
        } else {
            int[] IGotMyRandomArray = RandomMyCode(0, 51);
            for (int i = 0; i < players.length; i++) {
                for (int j = 0; j < 52 / players.length; j++) {
                    players[i].hand[j] = deck[IGotMyRandomArray[k]];
                    deck[IGotMyRandomArray[k]] = null;
                    k++;
                }
            }
        }
    }

    public void reset() {
        int k = 0;
        for (int i = 0; i < SuitArray.length; i++) {
            for (int j = 0; j < RankArray.length; j++) {
                deck[k++] = new Card(SuitArray[i], RankArray[j]);
            }
        }
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < players[i].hand.length; j++) {
                players[i].hand[j] = null;
            }
        }
    }

    public void displayDeck() {
        System.out.print("\n{ ");
        for (int i = 0; i < deck.length; i++) {
            if (deck[i] == null) {

            } else {
                System.out.print(deck[i].rank + " of " + deck[i].suit + ", ");
            }
        }
        System.out.println(" }");
    }

    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        Player[] arr = {player1, player2};
        Game gameOfBridge = new Game(arr);
        gameOfBridge.deal();
        Card[] abc = player1.getHand(); // returns a hand containing 26 cards
        for (int i = 0; i <abc.length ; i++) {
            System.out.print(abc[i].rank + " of " + abc[i].suit + ", ");
        }
        System.out.println("\n");
        Card[] abc1=player2.getHand(); // returns a hand that contains the other 26 cards
        for (int i = 0; i <abc1.length ; i++) {
            System.out.print(abc1[i].rank + " of " + abc1[i].suit + ", ");
        }
        player2.sortHand();
        System.out.println("\n");
        Card[] abc2=player2.getHand(); // returns a hand with the same cards as before, but they are now sorted
        for (int i = 0; i <abc2.length ; i++) {
            System.out.print(abc2[i].rank + " of " + abc2[i].suit + ", ");
        }
        gameOfBridge.reset();
        System.out.println("\n");
        Card[] abc3=player1.getHand(); // returns an empty hand
        for (int i = 0; i <abc3.length ; i++) {
            System.out.print(abc3[i]+ ", ");
        }
        gameOfBridge.displayDeck(); // prints the deck that should contain every card
    }

    // universal usable method which generates an array of random numbers between any range.
    public static int[] RandomMyCode(int min, int max) {
        int[] a1 = new int[max-min+1];
        int good=0;
        int y1=0;
        if(min==0){
            double x = Math.random() * (max+1);
            y1 = (int) x;
            a1[y1]=0;
            good++;
        }
        for (int i = 0; i < a1.length; i++) {
            if(good>0 && i==y1){
            }
            else {
                int always = 0;
                int y = 0;
                while (always == 0) {
                    double x = Math.random() * (max + 1);
                    y = (int) x;
                    int g = 0;
                    int g1=0;
                    int epsilon=0;
                    if (min == 0) {
                        g1++;
                        for (int f = 0; f < a1.length; f++) {
                            if (a1[f] == y) {
                                g++;
                                break;
                            }
                        }
                    } else {
                        if (y > (min - 1)) {
                            epsilon++;
                            for (int f = 0; f < a1.length; f++) {
                                if (a1[f] == y) {
                                    g++;
                                    break;
                                }
                            }
                        }
                    }
                    if (g == 0 && g1>0 ) {
                        always++;
                    }
                    else if (g==0 && epsilon>0){
                        always++;
                    }
                }
                a1[i] = y;
            }
        }
        return a1;
    }
}

