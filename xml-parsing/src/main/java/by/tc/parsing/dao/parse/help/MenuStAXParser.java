package by.tc.parsing.dao.parse.help;

import by.tc.parsing.dao.parse.help.util.Transformator;
import by.tc.parsing.entity.Flower;
import by.tc.parsing.entity.Multiplying;
import by.tc.parsing.entity.Soil;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by cplus on 19.11.2017.
 */
public final class MenuStAXParser {
    private static final Logger Logger = LogManager.getLogger(MenuStAXParser.class);

    private MenuStAXParser() {
    }

    public static List<Flower> parse(XMLStreamReader reader) throws XMLStreamException {
        Logger.info("Start parse StAX");
        List<Flower> flowerList = new ArrayList<>();
        Flower flower = null;
        Flower.GrowingType growingType = null;
        MenuTagName tagName = null;
        String text = null;

        while (reader.hasNext()) {
            int type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    tagName = MenuTagName.valueOf(Transformator.getEnumFromString(reader.getLocalName()));
                    switch (tagName) {
                        case FLOWER:
                            flower = new Flower();
                            flower.setId(reader.getAttributeValue(null, "id"));
                            flower.setLeavesColor(reader.getAttributeValue(null, "leaves-color"));
                            flower.setStemColor(reader.getAttributeValue(null, "stem-color"));
                            break;
                        case GROWING_TIPS:
                            growingType = new Flower.GrowingType();
                            break;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    tagName = MenuTagName.valueOf(Transformator.getEnumFromString(reader.getLocalName()));
                    switch (tagName) {
                        case NAME:
                            flower.setName(text);
                            break;
                        case SOIL:
                            flower.setSoil(Soil.valueOf(Transformator.getEnumFromString(text)));
                            break;
                        case ORIGIN:
                            flower.setOrigin(text);
                            break;
                        case TEMPERATURE:
                            growingType.setTemperature(text);
                            break;
                        case LIGHTING:
                            growingType.setLighting(Boolean.valueOf(text));
                            break;
                        case WATERING:
                            growingType.setWatering(text);
                            break;
                        case MULTIPLYING:
                            flower.setMultiplying(Multiplying.valueOf(Transformator.getEnumFromString(text)));
                            break;
                        case GROWING_TIPS:
                            flower.setGrowingType(growingType);
                            break;
                        case FLOWER:
                            flowerList.add(flower);
                            break;
                    }
            }
        }
        Logger.info("End parse StAX");
        return flowerList;
    }

}
