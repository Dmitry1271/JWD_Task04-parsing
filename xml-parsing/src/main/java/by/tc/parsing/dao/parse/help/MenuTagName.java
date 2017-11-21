package by.tc.parsing.dao.parse.help;

/**
 * Created by cplus on 19.11.2017.
 */
public enum MenuTagName {
    FLOWER("flower"), NAME("name"), SOIL("soil"), ORIGIN("origin"), GROWING_TIPS("growing-tips"),
    TEMPERATURE("temperature"), LIGHTING("lighting"), WATERING("watering"), MULTIPLYING("multiplying"), FLOWERS("flowers");

    private String tagName;

    MenuTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }
}
