package pages;

import com.fasterxml.jackson.databind.node.ArrayNode;
import implementation.WriteOutput;
import implementation.StartNavigation;
import input.ActionsInput;
import input.CredentialsInput;
import input.Input;
import input.UserInput;

import java.util.ArrayList;

public final class Register extends ActionsInput implements Page {
    private Input input;
    private ArrayNode output;

   public Register(final CredentialsInput credentials, final Input input, final ArrayNode output) {
        super(credentials);
        this.input = input;
        this.output = output;
    }


    @Override
    public void action() {
        boolean error = false;
        for (int i = 0; i < input.getUsers().size(); i++) {
            if (this.getCredentials().getName().equals(input.getUsers().get(i).getCredentials().
                    getName())) {
                error = true;
                break;
            }
        }

        if (!error) {
            UserInput user = new UserInput(this.getCredentials());
            user.setNumFreePremiumMovies(15);
            user.setLikedMovies(new ArrayList<>());
            user.setRatedMovies(new ArrayList<>());
            user.setWatchedMovies(new ArrayList<>());
            user.setPurchasedMovies(new ArrayList<>());
            input.getUsers().add(user);
            StartNavigation.getStartNavigation().setCurrentUser(user);
            StartNavigation.getStartNavigation().setCurrentPage("Homepage autentificat");
        } else {
            StartNavigation.getStartNavigation().setCurrentPage("Homepage neautentificat");
        }

        new WriteOutput(output, error);



    }

}
