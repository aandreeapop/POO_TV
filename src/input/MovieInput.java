package input;

import implementation.StartNavigation;

import java.util.ArrayList;

public final class MovieInput {
    private String name;
    private int year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;
    private int numLikes = 0;
    private double rating = 0;
    private int numRatings = 0;
    private ArrayList<Integer> ratings = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(final double rating) {
        this.rating = rating;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }

    /** Method that verifies if a movie is already purchased by the current user */
    public boolean isPurchased() {
        boolean isPurchased = false;
        for (MovieInput movie
                : StartNavigation.getStartNavigation().getCurrentUser().getPurchasedMovies()) {
            if (this.equals(movie)) {
                isPurchased = true;
                break;
            }
        }
        return isPurchased;
    }

    /** Method that verifies if a movie is already watched by the current user */
    public boolean isWatched() {
        boolean isWatched = false;
        for (MovieInput movie
                : StartNavigation.getStartNavigation().getCurrentUser().getWatchedMovies()) {
            if (this.equals(movie)) {
                isWatched = true;
                break;
            }
        }
        return isWatched;
    }

    /** Method that verifies if a movie is already liked by the current user */
    public boolean isLiked() {
        boolean isLiked = false;
        for (MovieInput movie
                : StartNavigation.getStartNavigation().getCurrentUser().getLikedMovies()) {
            if (this.equals(movie)) {
                isLiked = true;
                break;
            }
        }
        return isLiked;
    }

    /** Method that verifies if a movie is already rated by the current user */
    public boolean isRated() {
        boolean isRated = false;
        for (MovieInput movie
                : StartNavigation.getStartNavigation().getCurrentUser().getRatedMovies()) {
            if (this.equals(movie)) {
                isRated = true;
                break;
            }
        }
        return isRated;
    }
}
