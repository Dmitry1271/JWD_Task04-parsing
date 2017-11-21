package by.tc.parsing.service;

import by.tc.parsing.service.impl.FlowerServiceImpl;

/**
 * Created by cplus on 19.11.2017.
 */
public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private FlowerService flowerService = new FlowerServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public FlowerService getFlowerService() {
        return flowerService;
    }
}
