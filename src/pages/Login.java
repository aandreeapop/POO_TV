package pages;

import com.fasterxml.jackson.databind.node.ArrayNode;
import implementation.WriteOutput;
import implementation.StartNavigation;
import input.ActionsInput;
import input.CredentialsInput;
import input.Input;

public class Login extends ActionsInput implements Page {

    private Input input;
    //private StartNavigation startNavigation;
    private ArrayNode output;

    public Login(CredentialsInput credentials, Input input, ArrayNode output) {
        super(credentials);
        this.input = input;
        //this.startNavigation = startNavigation;
        this.output = output;
    }

    @Override
    public void action() {
        boolean error = true;
        for (int i = 0; i < input.getUsers().size(); i++) {
            if (this.getCredentials().getName().equals(input.getUsers().get(i).getCredentials().getName())) {
                if (this.getCredentials().getPassword().equals(input.getUsers().get(i).getCredentials().getPassword())) {
                    error = false;
                    StartNavigation.getStartNavigation().setCurrentUser(input.getUsers().get(i));
                    StartNavigation.getStartNavigation().setCurrentPage("Homepage autentificat");
                    break;
                }
            }
        }

        if (error) {
            StartNavigation.getStartNavigation().setCurrentPage("Homepage neautentificat");
        }

        new WriteOutput(input, output, error);
    }
}
