package by.tc.parsing.dao.parse.help.util;

/**
 * Created by cplus on 19.11.2017.
 */
public final class Transformator {
    private Transformator() {
    }

    public static String getEnumFromString(String string) {
        return string.trim().toUpperCase().replace("-", "_");
    }
}
