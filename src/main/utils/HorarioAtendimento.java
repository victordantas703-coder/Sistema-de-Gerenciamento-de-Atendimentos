package utils;

import exceptions.HorarioInvalidoException;

public class HorarioAtendimento extends Horario{
    // O último termina até as 18h.
    static final int HORARIO_MAXIMO_AGENDAMENTO = 17;
    
    /**
     * Recebe o horário e passa para a superclasse para criar a instância de {@code Horario} e
     * valida se está dentro do bloco {@value DuracaoAtendimento#BLOCO_DURACAO_ATENDIMENTO} minutos e se está no período de agendamento
     * 
     * @param horario Horário do atendimento
     */
    public HorarioAtendimento(int horario) {
        super(horario);

        validarHorarioPeriodoAgendamento();
        validarHorarioBlocoAtendimento();
    }

    private void validarHorarioBlocoAtendimento() throws HorarioInvalidoException {
        if (!DuracaoAtendimento.checarMinutoMultiploDeBlocoAtendimento(this.getMinuto()))
            throw new HorarioInvalidoException("Minuto " + this.getMinuto() + " não corresponde com o bloco de atendimento de " + DuracaoAtendimento.BLOCO_DURACAO_ATENDIMENTO + " minutos");
    }

    private void validarHorarioPeriodoAgendamento() throws HorarioInvalidoException {
        if (this.getHora() > HORARIO_MAXIMO_AGENDAMENTO) throw new HorarioInvalidoException("Horário de atendimento após do período de agendamento");
    }

    /**
     * Calcula o horário após o atendimento no formato {@code Horario}
     * 
     * @param atendimento Atendimento a ser calculado o horário após o atendimento
     * 
     * @return Retorna um objeto {@code Horario}, resultado da soma do horário com a duração do atendimento
     */
    public static Horario calcularHorarioAposAtendimento(Atendimento atendimento) throws HorarioInvalidoException {
        
        DuracaoAtendimento.validarDuracaoAtendimento(atendimento.getDuracaoAtendimento());

        int horasBuffer = Horario.calcularHorasdeMinutos(atendimento.getDuracaoAtendimento());
        int minutosBuffer = Horario.calcularMinutosAposCalcularHorasDeMinutos(atendimento.getDuracaoAtendimento());

        Horario duracaoAtendimentoFormatado = new Horario();
        duracaoAtendimentoFormatado.setHora(horasBuffer);
        duracaoAtendimentoFormatado.setMinuto(minutosBuffer);
        
        Horario horarioSomado = Horario.somarHorarios(atendimento.getHorarioAtendimento(), duracaoAtendimentoFormatado);

        return horarioSomado;
    }

}
