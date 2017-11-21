package by.tc.parsing.controller.util;

/**
 * Created by cplus on 21.11.2017.
 */
public final class ListOutputHelper {
    private static final int ADDITIONAL_PAGE = 1;
    public static final int NUMBER_ELEMENTS_AT_PAGE = 4;

    private ListOutputHelper() {
    }

    public static int indexFirstElementOnPage(int currentPageIndex) {
        return (currentPageIndex - 1) * NUMBER_ELEMENTS_AT_PAGE;
    }

    public static int getIndexLastElementOnPage(int n, int currentPageIndex) {
        int indexFirst = indexFirstElementOnPage(currentPageIndex);
        if (indexFirst + NUMBER_ELEMENTS_AT_PAGE > n) {
            return indexFirst + getNumberElementsLastPage(n);
        } else {
            return indexFirst + NUMBER_ELEMENTS_AT_PAGE;
        }
    }

    private static int getNumberElementsLastPage(int n) {
        return n % NUMBER_ELEMENTS_AT_PAGE;
    }

    public static int getNumberPages(int n) {
        if (getNumberElementsLastPage(n) == 0) {
            return n / NUMBER_ELEMENTS_AT_PAGE;
        } else {
            return n / NUMBER_ELEMENTS_AT_PAGE + ADDITIONAL_PAGE;
        }
    }


}
