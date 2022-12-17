package implementation;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.Input;
import input.MovieInput;
import input.UserInput;

import java.util.ArrayList;

public class StartNavigation {
    private String currentPage;
    private ArrayList<MovieInput> currentMoviesList;
    private UserInput currentUser;

    private static StartNavigation startNavigation = null;
    private StartNavigation() {}

    public static StartNavigation getStartNavigation() {
        if (startNavigation == null) {
            startNavigation = new StartNavigation();
        }
        return startNavigation;
    }

    public void start (Input input) {
        this.currentPage = "Homepage neautentificat";
        this.currentMoviesList = new ArrayList<>();
        for (int i = 0; i < input.getUsers().size(); i++) {
            input.getUsers().get(i).setNumFreePremiumMovies(15);
            input.getUsers().get(i).setLikedMovies(new ArrayList<>());
            input.getUsers().get(i).setRatedMovies(new ArrayList<>());
            input.getUsers().get(i).setWatchedMovies(new ArrayList<>());
            input.getUsers().get(i).setPurchasedMovies(new ArrayList<>());
        }
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public ArrayList<MovieInput> getCurrentMoviesList() {
        return currentMoviesList;
    }

    public void setCurrentMoviesList(ArrayList<MovieInput> currentMoviesList) {
        this.currentMoviesList = currentMoviesList;
    }

    public UserInput getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserInput currentUser) {
        this.currentUser = currentUser;
    }
}
