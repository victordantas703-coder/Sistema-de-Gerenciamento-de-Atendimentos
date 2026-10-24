import utils.AgendaBase;
import tests.*;

public class Main {
    public static void main(String[] args) {
        //TesteAgendaBase.testarChecarDisponibilidade();
        TesteFormatoHorario.testarCalcularHorarioAposAtendimento();
        TesteDuracaoAtendimento.testarValidarDuracaoAtendimento();
        AgendaBase agenda = new AgendaBase();
        agenda.adicionarAtendimento("Ana", "Dr. Silva", "2026-10-05", 900, 30);
        agenda.adicionarAtendimento("Bruno", "Dr. Silva", "2026-10-05", 900, 30);
        agenda.adicionarAtendimento("Carla", "Dra. Souza", "2026-10-05", 1400, 60);
        agenda.remarcarAtendimento("Ana", "2026-10-05", 900, "2026-10-06", 1000);
        agenda.listarAtendimentos("2026-10-05");
    }
}
