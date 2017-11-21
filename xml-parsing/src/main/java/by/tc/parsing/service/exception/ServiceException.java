package by.tc.parsing.service.exception;

/**
 * Created by cplus on 19.11.2017.
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = -1357955830893473467L;

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
