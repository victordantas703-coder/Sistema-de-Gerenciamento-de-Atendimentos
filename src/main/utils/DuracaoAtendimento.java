package utils;

public class DuracaoAtendimento {
    // Segundo as regras de negócio, a duração dos atendimentos devem variar entre 15 a 120 minutos
    static final int DURACAO_MINIMA_ATENDIMENTO = 15;
    static final int DURACAO_MAXIMA_ATENDIMENTO = 120;
    static final int BLOCO_DURACAO_ATENDIMENTO = 15;

    /**
     * Valida se a duração do atendimento está entre {@value #DURACAO_MINIMA_ATENDIMENTO} e {@value #DURACAO_MAXIMA_ATENDIMENTO} minutos
     * 
     * @param duracaoAtendimento Duração em minutos a ser validada
     * 
     * @throws IllegalArgumentException Se a duração do atendimento não estiver no intervalo de 
     * {@value #DURACAO_MINIMA_ATENDIMENTO} e {@value #DURACAO_MAXIMA_ATENDIMENTO} minutos ou
     * se não for múltiplo de {@value #BLOCO_DURACAO_ATENDIMENTO}
     */
    public static void validarDuracaoAtendimento(int duracaoAtendimento) {
        if (duracaoAtendimento < DURACAO_MINIMA_ATENDIMENTO)
            throw new IllegalArgumentException("Duração do atendimento menor que " + DURACAO_MINIMA_ATENDIMENTO);
        if (duracaoAtendimento > DURACAO_MAXIMA_ATENDIMENTO)
            throw new IllegalArgumentException("Duração do atendimento maior que " + DURACAO_MAXIMA_ATENDIMENTO);
        if (!checarMinutoMultiploDeBlocoAtendimento(duracaoAtendimento))
            throw new IllegalArgumentException("Duração do atendimento não corresponde com o bloco de atendimento de " + BLOCO_DURACAO_ATENDIMENTO + " minutos" );
    }
    
    /**
     * Checa se os minutos são múltiplos de {@value #BLOCO_DURACAO_ATENDIMENTO}
     * 
     * @param minutoValidar Minutos a serem validados
     * 
     * @return {@code true} Se {@code minutoValidar} for múltiplo de {@value #BLOCO_DURACAO_ATENDIMENTO};<br>
     *         {@code false} Caso não seja múltiplo
     */
    public static boolean checarMinutoMultiploDeBlocoAtendimento(int minutoValidar) {
        if (minutoValidar % BLOCO_DURACAO_ATENDIMENTO == 0)
            return true;
        return false;
    }
}
