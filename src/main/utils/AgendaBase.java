package utils;

import java.util.ArrayList;
import java.util.List;

import exceptions.HorarioInvalidoException;
import exceptions.HorarioOcupadoException;

public class AgendaBase {

    static List<Atendimento> agendaAtendimentos = new ArrayList<>();
    
    /**
     * Busca um atendimento por meio do nome do paciente, data e horário do atendimento
     * 
     * @param nomePaciente Nome do paciente com o atendimento marcado
     * @param dataAtendimento Data do atendimento marcado
     * @param horarioAtendimento Horário do atendimento marcado
     * 
     * @return {@code atendimento} Se o atendimento seja encontrado;<br>
     *         {@code null} caso não seja encontrado
     */
    public static Atendimento buscarAtendimento(String nomePaciente, String dataAtendimento, Horario horarioAtendimento) {
        for (Atendimento atendimento : agendaAtendimentos) {
            if (atendimento.getNomePaciente().equals(nomePaciente) &&
                atendimento.getDataAtendimento().equals(dataAtendimento) &&
                atendimento.getHorarioAtendimento().getHora() == horarioAtendimento.getHora() &&
                atendimento.getHorarioAtendimento().getMinuto() == horarioAtendimento.getMinuto()){
                    return atendimento;
            }
        }
        return null;
    }

    //TODO TERMINAR FUNCAO COM O NOVO METODO DE CONVERSAO
    /**
     * Checa se o horário desejado está disponível para ser marcado
     * 
     * @param atendimentoParaMarcar Atendimento que será marcado
     * 
     * @throws HorarioOcupadoException Se o horário desejado está indisponível
     */
    private static void checarDisponibilidadeAtendimento (Atendimento atendimentoParaMarcar) {
        
        Horario horariosaposAtendimentoParaMarcar = HorarioAtendimento.calcularHorarioAposAtendimento(atendimentoParaMarcar);
        
        for(Atendimento atendimento: agendaAtendimentos){
            if (atendimento.getNomeMedico() != atendimentoParaMarcar.getNomeMedico() ||
                atendimento.getDataAtendimento() != atendimentoParaMarcar.getDataAtendimento()) {
                    continue;
            }

            int horaAtendimento = atendimento.getHorarioAtendimento().getHora();
            int horaAposAtendimento = HorarioAtendimento.calcularHorarioAposAtendimento(atendimento).getHora();
            int minAtendimento = atendimento.getHorarioAtendimento().getMinuto();
            int minAposAtendimento = HorarioAtendimento.calcularHorarioAposAtendimento(atendimento).getMinuto();
            
            int horaAtendimentoParaMarcar = atendimentoParaMarcar.getHorarioAtendimento().getHora();
            int minAtendimentoParaMarcar = atendimentoParaMarcar.getHorarioAtendimento().getMinuto();
            int horaAposAtendimentoParaMarcar = horariosaposAtendimentoParaMarcar.getHora();
            int minAposAtendimentoParaMarcar = horariosaposAtendimentoParaMarcar.getMinuto();
            
            //(Casos quando um Atendimento começa durante o horario do atendimento para marcar)---------------//

            if (horaAtendimento > horaAtendimentoParaMarcar
                && horaAtendimento < horaAposAtendimentoParaMarcar){

                throw new HorarioOcupadoException("O horário está ocupado");
            }

            if (horaAtendimento == horaAtendimentoParaMarcar
                && horaAtendimento == horaAposAtendimentoParaMarcar){
                    
                if (minAtendimento >= minAtendimentoParaMarcar
                && minAtendimento < minAposAtendimentoParaMarcar){

                    throw new HorarioOcupadoException("O horário está ocupado");
                }  
            }

            if (horaAtendimento == horaAtendimentoParaMarcar
                && horaAtendimento < horaAposAtendimentoParaMarcar){
                    
                    if (minAtendimento >= minAtendimentoParaMarcar){

                        throw new HorarioOcupadoException("O horário está ocupado");
                }
            }

            if (horaAtendimento > horaAtendimentoParaMarcar
                && horaAtendimento == horaAposAtendimentoParaMarcar){

                    if (minAtendimento < minAposAtendimentoParaMarcar){
                        
                        throw new HorarioOcupadoException("O horário está ocupado");
                }
            }

            //(Casos quando um Atendimento termina durante o horario do atendimento para marcar)---------------//

            if (horaAposAtendimento > horaAtendimentoParaMarcar
                && horaAposAtendimento < horaAposAtendimentoParaMarcar){
                    
                throw new HorarioOcupadoException("O horário está ocupado");
            }

            if (horaAposAtendimento == horaAtendimentoParaMarcar
                && horaAposAtendimento == horaAposAtendimentoParaMarcar){
                    
                if (minAposAtendimento > minAtendimentoParaMarcar
                && minAposAtendimento <= minAposAtendimentoParaMarcar){
                    
                    throw new HorarioOcupadoException("O horário está ocupado");
                } 
            }

            if (horaAposAtendimento == horaAtendimentoParaMarcar
                && horaAposAtendimento < horaAposAtendimentoParaMarcar){

                    if (minAposAtendimento > minAtendimentoParaMarcar){
                        
                        throw new HorarioOcupadoException("O horário está ocupado");
                }
            }

            if (horaAposAtendimento > horaAtendimentoParaMarcar
                && horaAposAtendimento == horaAposAtendimentoParaMarcar){

                    if (minAposAtendimento <= minAposAtendimentoParaMarcar){
                        
                        throw new HorarioOcupadoException("O horário está ocupado");
                }
            }
        }
    }

    /**
     * Adiciona um atendimento ao vetor de atendimentos.
     * 
     * @param nomePaciente Nome do paciente que está marcando o atendimento
     * @param nomeMedico Nome do médico que realizará o atendimento
     * @param dataAtendimento Data em que o atendimento ocorrerá
     * @param horario Horário do atendimento
     * @param duracaoAtendimento Duração do atendimento em minutos (15 a 120 minutos)
     */
    public void adicionarAtendimento(String nomePaciente, String nomeMedico, String dataAtendimento, int horario, int duracaoAtendimento) {  
        try {
            Atendimento novoAtendimento = new Atendimento(nomePaciente, nomeMedico, dataAtendimento, horario, duracaoAtendimento, "MARCADO");
            checarDisponibilidadeAtendimento(novoAtendimento);
            
            agendaAtendimentos.add(novoAtendimento);
            
            System.out.println("Atendimento marcado para " + nomePaciente);
        } catch (HorarioOcupadoException e) {
            System.out.println("Horario ocupado");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    /**
     * Remarca o atendimento de acordo com o nome do paciente, a data e o horário do atendimento
     * 
     * @param nomePaciente Nome do paciente que está remarcando o atendimento
     * @param dataAtendimento Data em que o atendimento ocorreria
     * @param horario Horário em que o atendimento seria realizado
     * @param novaDataAtendimento Nova data para o atendimento
     * @param novoHorario Novo horário para o atendimento
     */
    public void remarcarAtendimento(String nomePaciente, String dataAtendimento, int horario, String novaDataAtendimento, int novoHorario) {
        try {
            Horario horarioFormatado = new HorarioAtendimento(horario);
            Horario novoHorarioFormatado = new HorarioAtendimento(novoHorario);

            Atendimento atendimentoMarcadoEncontrado = buscarAtendimento(nomePaciente, dataAtendimento, horarioFormatado);
            if(atendimentoMarcadoEncontrado == null) {
                System.out.println("Atendimento de paciente " + nomePaciente + " para remarcação não encontrado");
                return;
            }
            desmarcarAtendimento(nomePaciente, dataAtendimento, horario);

            atendimentoMarcadoEncontrado.setDataAtendimento(novaDataAtendimento);
            atendimentoMarcadoEncontrado.setHorarioAtendimento(novoHorarioFormatado);

            checarDisponibilidadeAtendimento(atendimentoMarcadoEncontrado);

            System.out.println("Remarcado");

        } catch (HorarioInvalidoException e) {
            System.out.println("Horário de atendimento do(a) paciente " + nomePaciente + " inválido");
            System.out.println(e.getMessage());
            return;
        } catch (HorarioOcupadoException e) {
            System.out.println("Horário de atendimento para remarcação do(a) paciente " + nomePaciente + " ocupado");
            return;
        }
    }

    /**
     * Remove o atendimento do vetor de atendimentos
     * 
     * @param nomePaciente Nome do paciente que está desmarcando o atendimento
     * @param dataAtendimento Data em que o atendimento ocorreria
     * @param horario Horário em que o atendimento seria realizado
     */
    public void desmarcarAtendimento(String nomePaciente, String dataAtendimento, int horario) {
        try{
            Horario horarioFormatado = new HorarioAtendimento(horario);
            Atendimento atendimentoParaRemover = buscarAtendimento(nomePaciente, dataAtendimento, horarioFormatado);
            if (atendimentoParaRemover == null) {
                System.out.println("Atendimento de paciente " + nomePaciente + " para remoção não encontrado");
                return;
            }
            agendaAtendimentos.remove(atendimentoParaRemover);
        } catch (HorarioInvalidoException e){
            System.out.println("Horário de atendimento para remoção do(a) paciente " + nomePaciente + " inválido");
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Lista todos os atendimentos marcados para o dia indicado
     * 
     * @param dataAtendimento Data dos atendimento a serem listados
     */
    public void listarAtendimentos(String dataAtendimento) {
        for (Atendimento atendimento : agendaAtendimentos) {
            if (atendimento.getDataAtendimento().equals(dataAtendimento)) {
                System.out.println(atendimento.getHorarioAtendimento().getHora() + " " + atendimento.getNomePaciente() + " " + atendimento.getNomeMedico() + " " + atendimento.getSituacaoAtendimento());
            }
        }
    }
    
}