package org.example.exceptions;

public class ErroTratadoException extends Exception {

    private static final long serialVersionUID = 1L;

    public ErroTratadoException(String message) {
        super(message);
    }

    public ErroTratadoException(String message, Throwable cause) {
        super(message, cause);
    }
}
