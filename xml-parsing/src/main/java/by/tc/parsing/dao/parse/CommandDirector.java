package by.tc.parsing.dao.parse;

import by.tc.parsing.dao.parse.impl.DOMParser;
import by.tc.parsing.dao.parse.impl.SAXParser;
import by.tc.parsing.dao.parse.impl.StAXParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cplus on 19.11.2017.
 */
public class CommandDirector {
    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandDirector() {
        commands.put(CommandName.SAX, new SAXParser());
        commands.put(CommandName.StAX, new StAXParser());
        commands.put(CommandName.DOM, new DOMParser());
    }

    public Command takeCommand(String name) {
        CommandName commandName = CommandName.valueOf(name);
        return commands.get(commandName);
    }
}
