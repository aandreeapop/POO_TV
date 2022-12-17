package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import implementation.WriteOutput;
import implementation.StartNavigation;
import input.Input;
import pages.Logout;
import pages.Movies;
import pages.SeeDetails;

public class ChangePage {
    private boolean error;
    public ChangePage(final Input input, final ArrayNode output, final int i) {
        error = false;
        String changePageTo = input.getActions().get(i).getPage();
        switch (changePageTo) {
            case "login":
            case "register":
                if (!StartNavigation.getStartNavigation().getCurrentPage()
                        .equals("Homepage neautentificat")) {
                    error = true;
                } else {
                    StartNavigation.getStartNavigation().setCurrentPage(changePageTo);
                }
                break;
            case "logout":
                if (StartNavigation.getStartNavigation().getCurrentPage()
                        .equals("Homepage neautentificat")
                        || StartNavigation.getStartNavigation().getCurrentPage().equals("login")
                        || StartNavigation.getStartNavigation().getCurrentPage()
                        .equals("register")) {
                    error = true;
                } else {
                    Logout logout = new Logout();
                    logout.action();
                }
                break;
            case "movies":
                if (!StartNavigation.getStartNavigation().getCurrentPage().
                        equals("Homepage autentificat")
                        && !StartNavigation.getStartNavigation().getCurrentPage().equals("upgrades")
                        && !StartNavigation.getStartNavigation().getCurrentPage().
                        equals("see details")
                        && !StartNavigation.getStartNavigation().getCurrentPage().
                        equals("movies")) {
                    error = true;
                } else {
                    StartNavigation.getStartNavigation().setCurrentPage(changePageTo);
                    Movies movies = new Movies(input);
                    movies.action();
                    new WriteOutput(output, false);
                }
                break;
            case "see details":
                if (!StartNavigation.getStartNavigation().getCurrentPage().equals("movies")) {
                    error = true;
                } else {
                    SeeDetails seeDetails = new SeeDetails(input.getActions().get(i).getMovie());
                    seeDetails.action();
                    if (!seeDetails.isError()) {
                        StartNavigation.getStartNavigation().setCurrentPage(changePageTo);
                    }
                    new WriteOutput(output, seeDetails.isError());
                }
                break;
            case "upgrades":
                if (!StartNavigation.getStartNavigation().getCurrentPage().equals("see details")
                        && !StartNavigation.getStartNavigation().getCurrentPage().
                        equals("Homepage autentificat")) {
                    error = true;
                } else {
                    StartNavigation.getStartNavigation().setCurrentPage(changePageTo);
                }
                break;
            default:
        }

        if (error) {
            new WriteOutput(output, true);
        }

    }
}
