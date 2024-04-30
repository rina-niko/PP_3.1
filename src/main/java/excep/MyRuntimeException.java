package excep;

public class MyRuntimeException extends RuntimeException {
    public MyRuntimeException(String message) {
        super("это моё необъявляемое исключение типа RuntimeException\n" + message);
    }
}
