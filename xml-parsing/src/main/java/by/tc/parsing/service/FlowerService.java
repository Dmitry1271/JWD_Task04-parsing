package by.tc.parsing.service;

import by.tc.parsing.entity.Flower;
import by.tc.parsing.service.exception.ServiceException;

import java.util.List;

/**
 * Created by cplus on 19.11.2017.
 */
public interface FlowerService {
    List<Flower> parse(String command) throws ServiceException;
}
