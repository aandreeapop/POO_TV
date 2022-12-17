package implementation;

import com.fasterxml.jackson.databind.node.ArrayNode;
import input.Input;

public class NavigateSite {
    public NavigateSite(final Input input, final ArrayNode output) {
       StartNavigation.getStartNavigation().start(input);

        for (int i = 0; i < input.getActions().size(); i++) {
            new ReadActions(input, output, i);
        }
    }
}
