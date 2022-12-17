package pages;

import implementation.StartNavigation;

import java.util.ArrayList;

public class Logout implements Page{
    //private StartNavigation startNavigation;

    public Logout() {}

    @Override
    public void action() {
        StartNavigation.getStartNavigation().setCurrentPage("Homepage neautentificat");
        StartNavigation.getStartNavigation().setCurrentUser(null);
        StartNavigation.getStartNavigation().setCurrentMoviesList(new ArrayList<>());
    }
}
