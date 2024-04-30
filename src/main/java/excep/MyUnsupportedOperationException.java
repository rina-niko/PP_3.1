package excep;

public class MyUnsupportedOperationException extends UnsupportedOperationException {
    public MyUnsupportedOperationException(String message) {
        super("Невозможно изменить неизменяемый элемент библиотеки\n" + message);
    }

}
