package Lab11.exception;

public class InvalidSQLException extends RuntimeException {
    private InvalidSQLException(String message){
            super(message);
    }

}
