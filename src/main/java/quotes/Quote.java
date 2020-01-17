package quotes;

import com.google.gson.Gson;

public class Quote {
    String author;
    String text;


    @Override
    public String toString() {
        return "Author: " + author + ", the quote: " + text;
    }

}


