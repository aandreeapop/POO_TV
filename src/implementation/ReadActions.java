package implementation;

import ActionsType.ChangePage;
import ActionsType.OnPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import input.Input;

public class ReadActions {
    public ReadActions(Input input, ArrayNode output, int i) {
        switch (input.getActions().get(i).getType()) {
            case "change page" -> {
               new ChangePage(input, output, i);
            }

            case "on page" -> {
                new OnPage(input, output, i);
            }
        }
    }
}
