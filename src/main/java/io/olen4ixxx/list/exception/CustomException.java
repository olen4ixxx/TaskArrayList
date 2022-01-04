package io.olen4ixxx.list.exception;

/**
 * CustomException is the custom implementation of Exception class to use in CustomArrayList.
 *
 * Please see the olen4ixxx.github.io class for true identity
 * @author Leanid Nasanovich
 *
 */
public class CustomException extends Exception {
    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }
}
