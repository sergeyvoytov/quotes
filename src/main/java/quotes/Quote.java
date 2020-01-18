package quotes;

import com.google.gson.Gson;

public class Quote {
    String author;
    String text;

    public Quote(String author, String text) {
        this.author = author;
        this.text = text;
    }


    @Override
    public String toString() {
        return "Author: " + author + ", the quote: " + text;
    }

}


