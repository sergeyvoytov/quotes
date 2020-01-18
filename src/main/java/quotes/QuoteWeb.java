package quotes;

public class QuoteWeb {

    int id;
    String starWarsQuote;


    public QuoteWeb(int id, String starWarsQuote) {
        this.id = id;
        this.starWarsQuote = starWarsQuote;
    }

    @Override
    public String toString() {
        return " Author: " + id + ", the quote: " + starWarsQuote;
    }

}
