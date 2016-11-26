package fernandoperez.moviesdiary.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fernandoperez on 11/26/16.
 */

public class Movie {


    private String title;
    private String director;

    public Movie() {}

    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return this.title + " - " + this.director;
    }

    public static List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<Movie>();

        movies.add(new Movie("Mulholland Drive", "David Lynch"));
        movies.add(new Movie("Interstellar", "Christopher Nolan"));
        movies.add(new Movie("Kill Bill", "Quentin Tarantino"));
        movies.add(new Movie("The Texas Chain Saw Massacre", "Tobe Hooper"));
        movies.add(new Movie("Videodrome", "David Cronemberg"));
        movies.add(new Movie("My Neighbor Totoro", "Hayao Miyazaki"));
        movies.add(new Movie("Scream", "Wes Craven"));
        movies.add(new Movie("Vertigo", "Alfred Hitchcock"));
        movies.add(new Movie("No Country For Old Men", "Joel and Ethan Coen"));
        movies.add(new Movie("Carrie", "Brian De Palma"));
        movies.add(new Movie("Rosemary's Baby", "Roman Polanski"));

        return movies;
    }

}
