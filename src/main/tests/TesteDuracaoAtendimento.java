package tests;

import exceptions.*;
import utils.DuracaoAtendimento;

public class TesteDuracaoAtendimento {
    public static void testarValidarDuracaoAtendimento(){
        try {
            DuracaoAtendimento.validarDuracaoAtendimento(120);
        } catch (DuracaoInvalidaException e) {

        }
    }
}
