package javaHigh.exp6.forth;

public class MovieManager {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Inception");
        movie1.addGenre(MovieGenre.ACTION);
        movie1.addGenre(MovieGenre.DRAMA);
        movie1.addGenre(MovieGenre.FANTASY);

        Movie movie2 = new Movie("Titanic");
        movie2.addGenre(MovieGenre.DRAMA);
        movie2.addGenre(MovieGenre.ROMANCE);

        System.out.println(movie1);
        movie1.removeGenre(MovieGenre.DRAMA);
        System.out.println("After removing DRAMA from Inception:");
        System.out.println(movie1);

        System.out.println(movie2);
    }
}

