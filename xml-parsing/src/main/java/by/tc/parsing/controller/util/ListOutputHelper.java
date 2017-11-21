package by.tc.parsing.controller.util;

/**
 * Created by cplus on 21.11.2017.
 */
public final class ListOutputHelper {
    public static final int NUMBER_ELEMENTS_AT_PAGE = 4;

    private ListOutputHelper() {
    }

    public static int indexFirstElementOnPage(int current) {
        return (current - 1) * NUMBER_ELEMENTS_AT_PAGE;
    }

    public static int indexLastElementOnPage(int n, int current) {
        int indexFirst = indexFirstElementOnPage(current);
        if (indexFirst + NUMBER_ELEMENTS_AT_PAGE >= n) {
            return indexFirst + getNumberElementsLastPage(n);
        } else {
            return indexFirst + NUMBER_ELEMENTS_AT_PAGE;
        }
    }

    private static int getNumberElementsLastPage(int n) {
        return n % NUMBER_ELEMENTS_AT_PAGE;
    }


}
