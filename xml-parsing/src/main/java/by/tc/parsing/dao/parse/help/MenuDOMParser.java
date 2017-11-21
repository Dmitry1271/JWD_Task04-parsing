package by.tc.parsing.dao.parse.help;

import by.tc.parsing.dao.parse.help.util.Transformator;
import by.tc.parsing.dao.parse.help.constant.TagAttributeConstants;
import by.tc.parsing.entity.Flower;
import by.tc.parsing.entity.Multiplying;
import by.tc.parsing.entity.Soil;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.tc.parsing.dao.parse.help.MenuTagName.*;

/**
 * Created by cplus on 19.11.2017.
 */
public final class MenuDOMParser {
    private static final Logger Logger = LogManager.getLogger(MenuDOMParser.class);

    private MenuDOMParser() {
    }

    public static List<Flower> doParsing(String path) throws IOException, SAXException {
        DOMParser parser = new DOMParser();
        parser.parse(new InputSource(MenuDOMParser.class.getResourceAsStream(path)));

        Logger.info("Start parse DOM");

        Document document = parser.getDocument();
        Element root = document.getDocumentElement();
        NodeList flowerNodes = root.getElementsByTagName(FLOWER.getTagName());

        Logger.info("End parse DOM");

        return getFlowerList(flowerNodes);
    }

    private static List<Flower> getFlowerList(NodeList nodeList) {
        List<Flower> flowerList = new ArrayList<>();
        Flower flower = null;

        int size = nodeList.getLength();

        for (int i = 0; i < size; ++i) {
            flower = new Flower();
            Element flowerElement = (Element) nodeList.item(i);

            setFlower(flower,flowerElement);

            flowerList.add(flower);
        }
        return flowerList;
    }

    private static void setFlower(Flower flower, Element flowerElement){
        Flower.GrowingType growingType = new Flower.GrowingType();

        flower.setId(flowerElement.getAttribute(TagAttributeConstants.FLOWER_ID));
        flower.setLeavesColor(flowerElement.getAttribute(TagAttributeConstants.FLOWER_LEAVES_COLOR));
        flower.setStemColor(flowerElement.getAttribute(TagAttributeConstants.FLOWER_STEM_COLOR));

        flower.setName(getSingleChild(flowerElement, NAME.getTagName()).getTextContent().trim());
        flower.setSoil(Soil.valueOf(Transformator.getEnumFromString(getSingleChild(flowerElement, SOIL.getTagName()).getTextContent())));
        flower.setOrigin(getSingleChild(flowerElement, ORIGIN.getTagName()).getTextContent().trim());

        Element growingTypeElement = getSingleChild(flowerElement, GROWING_TIPS.getTagName());
        growingType.setTemperature(getSingleChild(growingTypeElement, TEMPERATURE.getTagName()).getTextContent().trim());
        growingType.setLighting(Boolean.valueOf(getSingleChild(growingTypeElement, LIGHTING.getTagName()).getTextContent().trim()));
        growingType.setWatering(getSingleChild(growingTypeElement, WATERING.getTagName()).getTextContent().trim());

        flower.setGrowingType(growingType);

        flower.setMultiplying(Multiplying.valueOf(Transformator.getEnumFromString(
                getSingleChild(flowerElement, MULTIPLYING.getTagName()).getTextContent())));
    }

    private static Element getSingleChild(Element element, String childName) {
        int firstNodeElement = 0;
        NodeList nodeList = element.getElementsByTagName(childName);
        return (Element) nodeList.item(firstNodeElement);
    }
}
