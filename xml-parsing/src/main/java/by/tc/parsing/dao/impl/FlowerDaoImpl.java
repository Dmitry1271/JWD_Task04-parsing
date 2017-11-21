package by.tc.parsing.dao.impl;

import by.tc.parsing.dao.FlowerDAO;
import by.tc.parsing.dao.exception.DAOException;
import by.tc.parsing.dao.parse.CommandDirector;
import by.tc.parsing.entity.Flower;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

/**
 * Created by cplus on 19.11.2017.
 */
public class FlowerDaoImpl implements FlowerDAO {
    @Override
    public List<Flower> parse(String command) throws DAOException {
        CommandDirector commandDirector = new CommandDirector();
        try {
            return commandDirector.takeCommand(command).execute();
        } catch (SAXException | IOException | XMLStreamException e) {
            throw new DAOException(e);
        }
    }
}
