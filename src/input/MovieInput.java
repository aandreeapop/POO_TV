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

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    public ArrayList<Integer> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public void setCountriesBanned(ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }

    public boolean isPurchased() {
        boolean isPurchased = false;
        for (MovieInput movie : StartNavigation.getStartNavigation().getCurrentUser().getPurchasedMovies()) {
            if (this.equals(movie)) {
                isPurchased = true;
                break;
            }
        }
        return isPurchased;
    }

    public boolean isWatched() {
        boolean isWatched = false;
        for (MovieInput movie : StartNavigation.getStartNavigation().getCurrentUser().getWatchedMovies()) {
            if (this.equals(movie)) {
                isWatched = true;
                break;
            }
        }
        return isWatched;
    }

    public boolean isLiked() {
        boolean isLiked = false;
        for (MovieInput movie : StartNavigation.getStartNavigation().getCurrentUser().getLikedMovies()) {
            if (this.equals(movie)) {
                isLiked = true;
                break;
            }
        }
        return isLiked;
    }

    public boolean isRated() {
        boolean isRated = false;
        for (MovieInput movie : StartNavigation.getStartNavigation().getCurrentUser().getRatedMovies()) {
            if (this.equals(movie)) {
                isRated = true;
                break;
            }
        }
        return isRated;
    }
}
