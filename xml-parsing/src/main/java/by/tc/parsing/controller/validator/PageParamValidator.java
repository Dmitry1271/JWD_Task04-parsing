package by.tc.parsing.controller.validator;

/**
 * Created by cplus on 21.11.2017.
 */
public final class PageParamValidator {
    private static final String REGEX_PARAM = "[1-9][0-9]*";

    private PageParamValidator() {
    }

    public static boolean isValidPageParam(String param, int maxValue) {
        if (param != null && param.matches(REGEX_PARAM)) {
            if (Integer.parseInt(param) <= maxValue) {
                return true;
            }
        }
        return false;
    }
}
