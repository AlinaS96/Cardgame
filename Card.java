package Assignment8;
public class Card {
    public Suit suit;
    public Rank rank;
    Card card;
    public Card(Suit suit, Rank rank) {this.suit = suit; this.rank = rank;}
    public Suit getSuit() {
        return suit;
    }
    public void setSuit(Suit suit) {
        this.suit = suit;
    }
    public Rank getRank() {
        return rank;
    }
    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
