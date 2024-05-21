package javaHigh.exp6.forth;

import java.util.EnumSet;

public class Movie {
    private String title;
    private EnumSet<MovieGenre> genres;

    public Movie(String title) {
        this.title = title;
        this.genres = EnumSet.noneOf(MovieGenre.class);
    }

    public void addGenre(MovieGenre genre) {
        genres.add(genre);
    }

    public void removeGenre(MovieGenre genre) {
        genres.remove(genre);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genres=" + genres +
                '}';
    }
}

