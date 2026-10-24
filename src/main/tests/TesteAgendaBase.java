package tests;

import exceptions.*;
import utils.DuracaoAtendimento;
import utils.AgendaBase;

public class TesteAgendaBase {
    public static AgendaBase agenda = new AgendaBase();

    public static void testarChecarDisponibilidade () {
        agenda.adicionarAtendimento("João", "Dr. Carlos", "2026-11-10", 1100, 60);
        agenda.adicionarAtendimento("Maria", "Dr. Carlos", "2026-11-10", 1000, 120);

        agenda.adicionarAtendimento("Pedro", "Dra. Fernanda", "2026-11-11", 1030, 30);
        agenda.adicionarAtendimento("Ana", "Dra. Fernanda", "2026-11-11", 1015, 30);

        agenda.adicionarAtendimento("Lucas", "Dr. Roberto", "2026-11-12", 1030, 60);
        agenda.adicionarAtendimento("Julia", "Dr. Roberto", "2026-11-12", 1015, 45);

        agenda.adicionarAtendimento("Marcos", "Dra. Amanda", "2026-11-13", 1115, 60);
        agenda.adicionarAtendimento("Sofia", "Dra. Amanda", "2026-11-13", 1000, 90);

        agenda.adicionarAtendimento("Diego", "Dr. Mendes", "2026-11-14", 930, 60);
        agenda.adicionarAtendimento("Laura", "Dr. Mendes", "2026-11-14", 900, 120);

        agenda.adicionarAtendimento("Bruno", "Dra. Beatriz", "2026-11-15", 930, 60);
        agenda.adicionarAtendimento("Carla", "Dra. Beatriz", "2026-11-15", 1015, 30);

        agenda.adicionarAtendimento("Tiago", "Dr. Henrique", "2026-11-16", 930, 60);
        agenda.adicionarAtendimento("Paula", "Dr. Henrique", "2026-11-16", 1015, 45);

        agenda.adicionarAtendimento("Vitor", "Dra. Camila", "2026-11-17", 1015, 60);
        agenda.adicionarAtendimento("Aline", "Dra. Camila", "2026-11-17", 1000, 90);

        agenda.adicionarAtendimento("Nal do canal", "Dr. Vrau neles(sou totao)", "2026-11-18", 1000, 60);
        agenda.adicionarAtendimento("Pikomon", "Dra. Vrau neles(sou totao)", "2026-11-18", 1100, 90);

        agenda.adicionarAtendimento("Cachorra", "Dr. Totao", "2026-11-19", 1000, 60);
        agenda.adicionarAtendimento("Cavalo", "Dr. Totao", "2026-11-19", 900, 60);
    }
}
