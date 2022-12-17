package implementation;

import actions.ChangePage;
import actions.OnPage;
import com.fasterxml.jackson.databind.node.ArrayNode;
import input.Input;

public class ReadActions {
    public ReadActions(final Input input, final ArrayNode output, final int i) {
        switch (input.getActions().get(i).getType()) {
            case "change page" -> {
               new ChangePage(input, output, i);
            }

            case "on page" -> {
                new OnPage(input, output, i);
            }

            default -> { }
        }
    }
}
