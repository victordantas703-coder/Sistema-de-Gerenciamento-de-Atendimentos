package exceptions;

public class HorarioInvalidoException extends RuntimeException {
    public HorarioInvalidoException(String mensage) {
        super(mensage);
    }
}
