package by.tc.parsing.dao.parse;

/**
 * Created by cplus on 19.11.2017.
 */
public enum CommandName {
    DOM, SAX, StAX;

    public static boolean isContainsCommand(String command) {
        for (CommandName elem : values()) {
            if (command.equals(elem.name())) {
                return true;
            }
        }
        return false;
    }
}
