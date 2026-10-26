package utils;

import exceptions.DuracaoInvalidaException;
import exceptions.HorarioInvalidoException;

public class Atendimento {
    private String nomePaciente;
    private String nomeMedico;
    private String dataAtendimento;
    private Horario horarioAtendimento;
    private int duracaoAtendimento;
    private String situacaoAtendimento;

    public String getNomePaciente() {
        return this.nomePaciente;
    }

    public String getNomeMedico() {
        return this.nomeMedico;
    }

    public String getDataAtendimento() {
        return this.dataAtendimento;
    }
    
    public Horario getHorarioAtendimento(){
        return this.horarioAtendimento;
    }
    
    public int getDuracaoAtendimento() {
        return this.duracaoAtendimento;
    }

    public String getSituacaoAtendimento(){
        return this.situacaoAtendimento;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public void setHorarioAtendimento(Horario horario){
        horarioAtendimento = horario;
    }
    
    public void setDuracaoAtendimento(int duracao) {
        duracaoAtendimento = duracao;
    }

    public void setSituacaoAtendimento(String situacao){
        situacaoAtendimento = situacao;
    }
    
    /**
     * Recebe os dados do atendimento, cria o objeto {@code Horario} para o horário do atendimento,
     * valida se o horário é válido, e por fim atribui esses dados ao objeto {@code Atendimento}
     * 
     * @param nomePaciente Nome do paciente vinculado ao atendimento
     * @param nomeMedico Nome do médico que realizará o atendimento
     * @param data Data na qual ocorrerá o atendimento
     * @param horario Horário no qual ocorrerá o atendimento
     * @param duracao Duração do atendimento
     * @param situacao Situação do atendimento: {@code MARCADO}
     */
    public Atendimento(
        String nomePaciente,
        String nomeMedico,
        String data,
        int horario,
        int duracao,
        String situacao ) {
            try {
                Horario horarioFormatado = new HorarioAtendimento(horario);
                DuracaoAtendimento.validarDuracaoAtendimento(duracao);

                this.nomePaciente = nomePaciente;
                this.nomeMedico = nomeMedico;
                this.dataAtendimento = data;
                this.horarioAtendimento = horarioFormatado;
                this.duracaoAtendimento = duracao;
                this.situacaoAtendimento = situacao;

            } catch (HorarioInvalidoException e) {
                System.out.println("Horário de atendimento do(a) paciente " + nomePaciente + " inválido");
                throw e;
            } catch (DuracaoInvalidaException e) {
                System.out.println("Duração de atendimento do(a) paciente " + nomePaciente + " inválida");
                throw e;
            }
    }

    
}
