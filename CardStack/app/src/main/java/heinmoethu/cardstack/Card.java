package heinmoethu.cardstack;

/** Class representing a card
 * Created by Hein Moe Thu on 10/1/2017.
 */
class Card {
    private int num;
    private Suit s;

    Card(int num, Suit s){
        this.num=num;
        this.s=s;
    }

    int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    Suit getSuit() {
        return s;
    }

    public void setSuit(Suit s) {
        this.s = s;
    }
}
