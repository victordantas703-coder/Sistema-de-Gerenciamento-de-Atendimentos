package tests;

import utils.*;
import exceptions.*;

public class TesteFormatoHorario {

    public static void testarCalcularHorarioAposAtendimento(){
        Atendimento atendimentoTeste1 = new Atendimento(null, null, null, 1030, 90, null);
        Horario horarioAposAtendimento = HorarioAtendimento.calcularHorarioAposAtendimento(atendimentoTeste1);
        assert (horarioAposAtendimento.getHora() == 12 && horarioAposAtendimento.getMinuto() == 0) : "Deveria ser 12:00";

        Atendimento atendimentoTeste2 = new Atendimento(null, null, null, 1630, 30, null);
        horarioAposAtendimento = HorarioAtendimento.calcularHorarioAposAtendimento(atendimentoTeste2);
        assert (horarioAposAtendimento.getHora() == 17 && horarioAposAtendimento.getMinuto() == 0) : "Deveria ser 17:00";

        Atendimento atendimentoTeste3 = new Atendimento(null, null, null, 1630, 90, null);
        horarioAposAtendimento = HorarioAtendimento.calcularHorarioAposAtendimento(atendimentoTeste3);
        assert (horarioAposAtendimento.getHora() == 18 && horarioAposAtendimento.getMinuto() == 0) : "Deveria ser 18:00";

        try {
            Atendimento atendimentoTeste4 = new Atendimento(null, null, null, 1700, 75, null);
            horarioAposAtendimento = HorarioAtendimento.calcularHorarioAposAtendimento(atendimentoTeste4);
            assert false : "Deveria da excessão HorarioInvalidoException";
        } catch (HorarioInvalidoException e) {
            // Capturou o HorarioInvalidoException, como esperado
        }

        
    }
}
