package input;

import java.util.ArrayList;

public final class Input {
    private ArrayList<UserInput> users;
    private ArrayList<MovieInput> movies;
    private ArrayList<ActionsInput> actions;

    public Input(ArrayList<UserInput> users, ArrayList<MovieInput> movies, ArrayList<ActionsInput> actions) {
        this.users = users;
        this.movies = movies;
        this.actions = actions;
    }

    public Input(){
    }

    public ArrayList<UserInput> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserInput> users) {
        this.users = users;
    }

    public ArrayList<MovieInput> getMovies() {
        return movies;
    }

    public ArrayList<ActionsInput> getActions() {
        return actions;
    }
}
