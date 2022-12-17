package ActionsType;

import com.fasterxml.jackson.databind.node.ArrayNode;
import implementation.WriteOutput;
import implementation.StartNavigation;
import input.Input;
import pages.*;

public class OnPage {
    public OnPage(Input input, ArrayNode output, int i) {
        switch (input.getActions().get(i).getFeature()) {
            case "register" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("register")) {
                    Register register = new Register(input.getActions().get(i).getCredentials(), input, output);
                    register.action();
                } else {
                    new WriteOutput(input, output, true);
                }

            }
            case "login" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("login")) {
                    Login login = new Login(input.getActions().get(i).getCredentials(), input, output);
                    login.action();
                } else {
                    new WriteOutput(input, output, true);
                }
            }

            case "search" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("movies")) {
                    Movies movies = new Movies(input.getActions().get(i).getStartsWith(), input);
                    movies.search();
                    new WriteOutput(input, output, false);
                } else {
                    new WriteOutput(input, output, true);
                }
            }

            case "filter" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("movies")) {
                    Movies movies = new Movies(input.getActions().get(i).getFilters(), input);
                    movies.filter(input.getActions().get(i));
                    new WriteOutput(input, output, false);
                } else {
                    new WriteOutput(input, output, true);
                }
            }

            case "buy tokens" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("upgrades")) {
                    Upgrades upgrades = new Upgrades(input.getActions().get(i).getCount());
                    upgrades.buyTokens();
                    if (upgrades.isError()) {
                        new WriteOutput(input, output, true);
                    }
                } else {
                    new WriteOutput(input, output, true);
                }
            }

            case "buy premium account" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("upgrades")) {
                    Upgrades upgrades = new Upgrades();
                    upgrades.buyPremiumAccount();
                    if (upgrades.isError()) {
                        new WriteOutput(input, output, true);
                    }
                } else {
                    new WriteOutput(input, output, true);
                }
            }

            case "purchase" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("see details")) {
                    SeeDetails seeDetails = new SeeDetails();
                    seeDetails.purchase();
                    new WriteOutput(input, output, seeDetails.isError());
;                } else {
                    new WriteOutput(input, output, true);
                }
            }

            case "watch" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("see details")) {
                    SeeDetails seeDetails = new SeeDetails();
                    seeDetails.watch();
                    new WriteOutput(input, output, seeDetails.isError());
                } else {
                    new WriteOutput(input, output, true);
                }
            }

            case "like" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("see details")) {
                    SeeDetails seeDetails = new SeeDetails();
                    seeDetails.like();
                    new WriteOutput(input, output, seeDetails.isError());
                } else {
                    new WriteOutput(input, output, true);
                }
            }

            case "rate" -> {
                if (StartNavigation.getStartNavigation().getCurrentPage().equals("see details")) {
                    SeeDetails seeDetails = new SeeDetails(input.getActions().get(i).getRate());
                    seeDetails.rate();
                    //if (seeDetails.isError()) {
                        new WriteOutput(input, output, seeDetails.isError());
                    //}
                } else {
                    new WriteOutput(input, output, true);
                }
            }
        }
    }
}
