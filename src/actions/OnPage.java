package actions;

import com.fasterxml.jackson.databind.node.ArrayNode;
import implementation.WriteOutput;
import implementation.StartNavigation;
import input.ActionsInput;
import input.Input;
import pages.Movies;
import pages.SeeDetails;
import pages.Upgrades;
import pages.Login;
import pages.Register;

public class OnPage {
    public OnPage(final Input input, final ArrayNode output, final int i) {
        ActionsInput action = input.getActions().get(i);
        switch (action.getFeature()) {
            case "register" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("register")) {
                    Register register = new Register(action.getCredentials(), input, output);
                    register.action();
                } else {
                    new WriteOutput(output, true);
                }

            }
            case "login" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("login")) {
                    Login login = new Login(action.getCredentials(), input, output);
                    login.action();
                } else {
                    new WriteOutput(output, true);
                }
            }

            case "search" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("movies")) {
                    Movies movies = new Movies(action.getStartsWith(), input);
                    movies.search();
                    new WriteOutput(output, false);
                } else {
                    new WriteOutput(output, true);
                }
            }

            case "filter" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("movies")) {
                    Movies movies = new Movies(action.getFilters(), input);
                    movies.filter(input.getActions().get(i));
                    new WriteOutput(output, false);
                } else {
                    new WriteOutput(output, true);
                }
            }

            case "buy tokens" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("upgrades")) {
                    Upgrades upgrades = new Upgrades(action.getCount());
                    upgrades.buyTokens();
                    if (upgrades.isError()) {
                        new WriteOutput(output, true);
                    }
                } else {
                    new WriteOutput(output, true);
                }
            }

            case "buy premium account" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("upgrades")) {
                    Upgrades upgrades = new Upgrades();
                    upgrades.buyPremiumAccount();
                    if (upgrades.isError()) {
                        new WriteOutput(output, true);
                    }
                } else {
                    new WriteOutput(output, true);
                }
            }

            case "purchase" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("see details")) {
                    SeeDetails seeDetails = new SeeDetails();
                    seeDetails.purchase();
                    new WriteOutput(output, seeDetails.isError());
                } else {
                    new WriteOutput(output, true);
                }
            }

            case "watch" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("see details")) {
                    SeeDetails seeDetails = new SeeDetails();
                    seeDetails.watch();
                    new WriteOutput(output, seeDetails.isError());
                } else {
                    new WriteOutput(output, true);
                }
            }

            case "like" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("see details")) {
                    SeeDetails seeDetails = new SeeDetails();
                    seeDetails.like();
                    new WriteOutput(output, seeDetails.isError());
                } else {
                    new WriteOutput(output, true);
                }
            }

            case "rate" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("see details")) {
                    SeeDetails seeDetails = new SeeDetails(input.getActions().get(i).getRate());
                    seeDetails.rate();
                    //if (seeDetails.isError()) {
                        new WriteOutput(output, seeDetails.isError());
                    //}
                } else {
                    new WriteOutput(output, true);
                }
            }

            default -> { }
        }
    }
}
