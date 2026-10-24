package exceptions;

public class HorarioOcupadoException extends RuntimeException {
    public HorarioOcupadoException(String mensage) {
        super(mensage);
    }
}
