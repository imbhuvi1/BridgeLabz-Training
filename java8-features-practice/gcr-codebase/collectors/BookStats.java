package gcr_codebase.collectors;

import java.util.*;
import java.util.stream.Collectors;

class Book {
    String genre;
    int pages;

    Book(String genre, int pages) {
        this.genre = genre;
        this.pages = pages;
    }

    String getGenre() { return genre; }
    int getPages() { return pages; }
}

public class BookStats {
    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
            new Book("Fiction", 300),
            new Book("Fiction", 250),
            new Book("Science", 400)
        );

        books.stream()
             .collect(Collectors.groupingBy(
                 Book::getGenre,
                 Collectors.summarizingInt(Book::getPages)
             ))
             .forEach((genre, stats) ->
                 System.out.println(
                     genre +
                     " -> Total: " + stats.getSum() +
                     ", Avg: " + stats.getAverage() +
                     ", Max: " + stats.getMax()
                 )
             );
    }
}

