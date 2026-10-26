package tests;

import exceptions.*;
import utils.DuracaoAtendimento;

public class TesteDuracaoAtendimento {
    public static void testarValidarDuracaoAtendimento(){
        
        DuracaoAtendimento.validarDuracaoAtendimento(120);
        
        try {
            DuracaoAtendimento.validarDuracaoAtendimento(-100);
            assert false : "Era para dar DuracaoInvalidaException";
        } catch (DuracaoInvalidaException e) {
            // Capturou o DuracaoInvalidaException, como esperado
        }

        try {
            DuracaoAtendimento.validarDuracaoAtendimento(50);
            assert false : "Era para dar DuracaoInvalidaException";
        } catch (DuracaoInvalidaException e) {
            // Capturou o DuracaoInvalidaException, como esperado
        }

        try {
            DuracaoAtendimento.validarDuracaoAtendimento(500);
            assert false : "Era para dar DuracaoInvalidaException";
        } catch (DuracaoInvalidaException e) {
            // Capturou o DuracaoInvalidaException, como esperado
        }
    }
}
