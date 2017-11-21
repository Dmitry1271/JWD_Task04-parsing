package by.tc.parsing.dao;

import by.tc.parsing.dao.exception.DAOException;
import by.tc.parsing.entity.Flower;

import java.util.List;

/**
 * Created by cplus on 19.11.2017.
 */
public interface FlowerDAO {
    List<Flower> parse(String command) throws DAOException;
}
