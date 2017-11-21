package by.tc.parsing.service.impl;

import by.tc.parsing.dao.DAOFactory;
import by.tc.parsing.dao.exception.DAOException;
import by.tc.parsing.entity.Flower;
import by.tc.parsing.service.FlowerService;
import by.tc.parsing.service.exception.ServiceException;

import java.util.List;

/**
 * Created by cplus on 19.11.2017.
 */
public class FlowerServiceImpl implements FlowerService {
    @Override
    public List<Flower> parse(String command) throws ServiceException {
        DAOFactory instance = DAOFactory.getInstance();

        try {
            return instance.getFlowerDAO().parse(command);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
