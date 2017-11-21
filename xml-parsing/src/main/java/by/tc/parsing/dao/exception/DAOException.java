package by.tc.parsing.dao.exception;

/**
 * Created by cplus on 19.11.2017.
 */
public class DAOException extends Exception {
    private static final long serialVersionUID = -4653009174699924963L;

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
