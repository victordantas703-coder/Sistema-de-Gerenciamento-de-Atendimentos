package utils;

import exceptions.HorarioInvalidoException;

public class Horario {
    // Segundo as regras de negócio, atendimentos só podem começar entre 8h e 17h;
    static final int EXPEDIENTE_MINIMO_ATENDIMENTO = 8;
    static final int EXPEDIENTE_MAXIMO_ATENDIMENTO = 18;

    static final int COEFICIENTE_FORMATACAO_HORARIO = 100;
    static final int MINUTOS_POR_HORA = 60;
    static final int MINUTO_MINIMO = 0;
    static final int MINUTO_MAXIMO = 59;

    private int hora;
    private int minuto;

    public void setHora(int hora){
        this.hora = hora;
    }

    public void setMinuto(int minuto){
        this.minuto = minuto;
    }

    public int getHora(){
        return this.hora;
    }

    public int getMinuto(){
        return this.minuto;
    }

    /**
     * Inicializa o objeto {@code Horario} com valores padrão
     */
    public Horario() {
        this.hora = 0;
        this.minuto = 0;
    }

    /**
     * Inicializa o objeto {@code Horario} com valores passados por parâmetro
     * e valida se esse horário é válido
     * 
     * @param horario Horário a ser criado
     * 
     * @throws HorarioInvalidoException Se o horário passado for inválido
     */
    public Horario(int horario) throws HorarioInvalidoException {
        this.hora = calcularHora(horario);
        this.minuto = calcularMinuto(horario);

        validarHorario();
    }

    private static int calcularHora(int horario){
        return horario / COEFICIENTE_FORMATACAO_HORARIO;
    }

    private static int calcularMinuto(int horario){
        return horario % COEFICIENTE_FORMATACAO_HORARIO;
    }

    private void validarHora() throws HorarioInvalidoException {
        if (hora < EXPEDIENTE_MINIMO_ATENDIMENTO || hora > EXPEDIENTE_MAXIMO_ATENDIMENTO)
            throw new HorarioInvalidoException("Horário fora do expediente");
    }

    private void validarMinuto() throws HorarioInvalidoException {
        if (minuto < MINUTO_MINIMO || minuto > MINUTO_MAXIMO)
            throw new HorarioInvalidoException("Minuto " + minuto + " inválido");
    }

    private void validarHararioDentroLimiteExpediente(){
        if (getHora() == EXPEDIENTE_MAXIMO_ATENDIMENTO &&
            getMinuto() > MINUTO_MINIMO) {
                throw new HorarioInvalidoException("Horário ou pós-atendimento fora do expediente");
        }
    }

    private void validarHorario() throws HorarioInvalidoException {
        validarHora();
        validarMinuto();
        validarHararioDentroLimiteExpediente();
    }

    /**
     * Soma dois objetos {@code Horario}, por meio da soma das horas e minutos respectivos
     * 
     * @param horario1 Primeiro horário a ser somado
     * @param horario2 Segundo horário a ser somado
     * 
     * @throws HorarioInvalidoException Se o horário passado for inválido
     * 
     * @return Retorna um objeto {@code Horario}, resultado da soma dos dois horários
     */
    public static Horario somarHorarios(Horario horario1, Horario horario2) throws HorarioInvalidoException {
        Horario horarioSomado = new Horario();

        horarioSomado.hora =  horario1.hora + horario2.hora;
        horarioSomado.minuto =  horario1.minuto + horario2.minuto;

        if(horarioSomado.minuto >= MINUTOS_POR_HORA) {
            horarioSomado.hora += horarioSomado.minuto / MINUTOS_POR_HORA;
            horarioSomado.minuto -= MINUTOS_POR_HORA;
        }
        if(horarioSomado.hora > EXPEDIENTE_MAXIMO_ATENDIMENTO)
            horarioSomado.hora = horarioSomado.hora - EXPEDIENTE_MAXIMO_ATENDIMENTO;
        
        horarioSomado.validarHorario();

        return horarioSomado;
    }

    /**
     * Transforma os minutos em horas (divisão inteira por {@value #MINUTOS_POR_HORA})
     * 
     * @param minutos Minutos a serem transformados
     * 
     * @return Retorna as horas transformadas a partir dos minutos
     */
    public static int calcularHorasdeMinutos(int minutos){
        return minutos / MINUTOS_POR_HORA;
    }

    /**
     * Calcula os minutos descartando as horas inteiras (resto de {@code minutos} por {@value #MINUTOS_POR_HORA})
     * 
     * @param minutos Minutos a serem transformados
     * 
     * @return Retorna os minutos restantes
     */
    public static int calcularMinutosAposCalcularHorasDeMinutos(int minutos){
        return minutos % MINUTOS_POR_HORA;
    }
}