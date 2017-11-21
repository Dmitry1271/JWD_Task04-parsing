package by.tc.parsing.dao.parse.help;

import by.tc.parsing.dao.parse.help.util.Transformator;
import by.tc.parsing.dao.parse.help.constant.TagAttributeConstants;
import by.tc.parsing.entity.Flower;
import by.tc.parsing.entity.Multiplying;
import by.tc.parsing.entity.Soil;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by cplus on 19.11.2017.
 */
public class MenuSAXHandler extends DefaultHandler {
    private static final Logger Logger = LogManager.getLogger(MenuSAXHandler.class);

    private List<Flower> flowerList = new ArrayList<>();
    private Flower flower;
    private StringBuilder text;
    private Flower.GrowingType growingType;

    public List<Flower> getFlowerList() {
        return flowerList;
    }

    @Override
    public void startDocument() throws SAXException {
        Logger.info("start parse SAX");
    }

    @Override
    public void endDocument() throws SAXException {
        Logger.info("end parse SAX");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text = new StringBuilder();

        if (localName.equals(MenuTagName.FLOWER.getTagName())) {
            flower = new Flower();

            flower.setId(attributes.getValue(TagAttributeConstants.FLOWER_ID));
            flower.setLeavesColor(attributes.getValue(TagAttributeConstants.FLOWER_LEAVES_COLOR));
            flower.setStemColor(attributes.getValue(TagAttributeConstants.FLOWER_STEM_COLOR));

        } else if (localName.equals(MenuTagName.GROWING_TIPS.getTagName())) {
            growingType = new Flower.GrowingType();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        MenuTagName tagName = MenuTagName.valueOf(Transformator.getEnumFromString(localName));
        switch (tagName) {
            case NAME:
                flower.setName(text.toString());
                break;
            case SOIL:
                flower.setSoil(Soil.valueOf(Transformator.getEnumFromString(text.toString())));
                break;
            case ORIGIN:
                flower.setOrigin(text.toString());
                break;
            case TEMPERATURE:
                growingType.setTemperature(text.toString());
                break;
            case LIGHTING:
                growingType.setLighting(Boolean.valueOf(text.toString()));
                break;
            case WATERING:
                growingType.setWatering(text.toString());
                break;
            case GROWING_TIPS:
                flower.setGrowingType(growingType);
                break;
            case MULTIPLYING:
                flower.setMultiplying(Multiplying.valueOf(Transformator.getEnumFromString(text.toString())));
                break;
            case FLOWER:
                flowerList.add(flower);
                flower = null;
                break;
        }
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        Logger.warn(e);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        Logger.error(e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        Logger.fatal(e);
    }
}
