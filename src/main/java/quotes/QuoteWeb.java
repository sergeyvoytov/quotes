package quotes;

public class QuoteWeb extends Quote {

    String quoteAuthor;
    String quoteText;


    @Override
    public String toString() {
        return "Author: " + quoteAuthor + ", the quote: " + quoteText;
    }

}
