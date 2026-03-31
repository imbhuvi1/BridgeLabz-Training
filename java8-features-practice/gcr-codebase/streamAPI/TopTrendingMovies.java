package gcr_codebase.streamapi;

import java.util.*;
import java.util.stream.*;

class Movie {
    String title;
    double rating;
    int year;
    
    Movie(String title, double rating, int year) {
        this.title = title;
        this.rating = rating;
        this.year = year;
    }
    
    @Override
    public String toString() {
        return title + " (" + year + ") - " + rating;
    }
}

public class TopTrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Avengers", 8.4, 2019),
            new Movie("Oppenheimer", 8.8, 2023),
            new Movie("Dune", 8.3, 2021),
            new Movie("Barbie", 7.2, 2023),
            new Movie("Inception", 9.0, 2010),
            new Movie("Godfather", 9.2, 1972),
            new Movie("Spider-Man", 8.1, 2021),
            new Movie("Titanic", 8.7, 1997)
        );
        
        // Top 5 trending movies: recent years + high rating
        List<Movie> top5 = movies.stream()
            .filter(m -> m.year >= 2015)           // Recent movies
            .sorted((m1, m2) -> {
                if (m1.rating != m2.rating)
                    return Double.compare(m2.rating, m1.rating); // High rating first
                return Integer.compare(m2.year, m1.year);       // Then recent
            })
            .limit(5)
            .collect(Collectors.toList());
            
        System.out.println("Top 5 Trending Movies:");
        top5.forEach(System.out::println);
    }
}
