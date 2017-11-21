package by.tc.parsing.dao;

import by.tc.parsing.dao.impl.FlowerDaoImpl;

/**
 * Created by cplus on 19.11.2017.
 */
public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private FlowerDAO flowerDAO = new FlowerDaoImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public FlowerDAO getFlowerDAO() {
        return flowerDAO;
    }
}
