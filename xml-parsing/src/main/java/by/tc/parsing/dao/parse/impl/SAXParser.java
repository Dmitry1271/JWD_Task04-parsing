package by.tc.parsing.dao.parse.impl;

import by.tc.parsing.dao.parse.Command;
import by.tc.parsing.dao.parse.help.MenuSAXHandler;
import by.tc.parsing.entity.Flower;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by cplus on 19.11.2017.
 */
public class SAXParser implements Command {
    private final static String PATH = "/flowers/flowers.xml";

    @Override
    public List<Flower> execute() throws IOException, SAXException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        MenuSAXHandler handler = new MenuSAXHandler();
        reader.setContentHandler(handler);
        reader.setErrorHandler(handler);
        reader.parse(new InputSource(this.getClass().getResourceAsStream(PATH)));
        return handler.getFlowerList();
    }
}
