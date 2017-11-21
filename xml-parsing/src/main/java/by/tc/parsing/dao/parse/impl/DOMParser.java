package by.tc.parsing.dao.parse.impl;

import by.tc.parsing.dao.parse.Command;
import by.tc.parsing.dao.parse.help.MenuDOMParser;
import by.tc.parsing.entity.Flower;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

/**
 * Created by cplus on 19.11.2017.
 */
public class DOMParser implements Command {
    private static final String PATH = "/flowers/flowers.xml";

    @Override
    public List<Flower> execute() throws IOException, SAXException {
        return MenuDOMParser.doParsing(PATH);
    }
}
