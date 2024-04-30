package excep;

public class MyException extends Exception {
    public MyException(String message) {
        super("это моё объявленное исключение типа Exception\n" + message);
    }
}

