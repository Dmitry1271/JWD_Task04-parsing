package by.tc.parsing.dao.parse;

import by.tc.parsing.entity.Flower;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

/**
 * Created by cplus on 19.11.2017.
 */
public interface Command {
    List<Flower> execute() throws SAXException, IOException, XMLStreamException;
}
