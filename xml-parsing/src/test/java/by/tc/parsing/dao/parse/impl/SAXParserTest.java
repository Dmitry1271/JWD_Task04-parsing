package by.tc.parsing.dao.parse.impl;

import by.tc.parsing.entity.Flower;
import by.tc.parsing.entity.Multiplying;
import by.tc.parsing.entity.Soil;
import by.tc.parsing.service.ServiceFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cplus on 19.11.2017.
 */
public class SAXParserTest {
    private List<Flower> expected = new ArrayList<>();


    @Before
    public void init() {
        expected.add(new Flower("flower1", null, "green", "rose", Soil.GROUND, "Italy", new Flower.GrowingType("+27 cel", true, "5000 per/week"), Multiplying.CUTTINGS));
        expected.add(new Flower("flower2", "yellow", "green", "dandelion", Soil.PODZOLIC, "Belarus", new Flower.GrowingType("+25 cel", true, "4000 per/week"), Multiplying.SEEDS));
        expected.add(new Flower("flower3", "white", "green", "chamomile", Soil.SOD_PODZOLIC, "garden", new Flower.GrowingType("+25 cel", true, "4000 per/week"), Multiplying.SEEDS));
        expected.add(new Flower("flower4", "white", null, "eustoma", Soil.GROUND, "Belarus", new Flower.GrowingType("+25 cel", true, "4000 per/week"), Multiplying.SEEDS));
        expected.add(new Flower("flower5", null, "green", "loosestrife", Soil.PODZOLIC, "garden", new Flower.GrowingType("+28 cel", true, "4500 per/week"), Multiplying.SEEDS));
        expected.add(new Flower("flower6", null, null, "aster", Soil.GROUND, "Russia", new Flower.GrowingType("+23 cel", true, "5000 per/week"), Multiplying.SEEDS));
        expected.add(new Flower("flower7", null, "green", "tulp", Soil.PODZOLIC, "Ukraine", new Flower.GrowingType("+25 cel", true, "5000 per/week"), Multiplying.SEEDS));
    }

    @After
    public void destroy() {
        expected = null;
    }

    @Test
    public void execute() throws Exception {
        ServiceFactory instance = ServiceFactory.getInstance();
        List<Flower> allFlowers = instance.getFlowerService().parse("SAX");
        List<Flower> actual = allFlowers.subList(0, 7);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

}