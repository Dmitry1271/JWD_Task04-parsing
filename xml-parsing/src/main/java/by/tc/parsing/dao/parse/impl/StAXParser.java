package by.tc.parsing.dao.parse.impl;

import by.tc.parsing.dao.parse.Command;
import by.tc.parsing.dao.parse.help.MenuStAXParser;
import by.tc.parsing.entity.Flower;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by cplus on 19.11.2017.
 */
public class StAXParser implements Command {
    public static final String PATH = "/flowers/flowers.xml";

    @Override
    public List<Flower> execute() throws FileNotFoundException, XMLStreamException {
        XMLInputFactory instance = XMLInputFactory.newInstance();
        InputStream inputStream = this.getClass().getResourceAsStream(PATH);

        XMLStreamReader reader = instance.createXMLStreamReader(inputStream);
        return MenuStAXParser.parse(reader);
    }
}
