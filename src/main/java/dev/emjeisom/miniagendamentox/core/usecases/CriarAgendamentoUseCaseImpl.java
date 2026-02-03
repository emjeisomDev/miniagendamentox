package dev.emjeisom.miniagendamentox.core.usecases;

import dev.emjeisom.miniagendamentox.core.entities.Agendamento;
import dev.emjeisom.miniagendamentox.core.gateway.AgendamentoGateway;

public class CriarAgendamentoUseCaseImpl implements CriarAgendamentoUseCase {
    private final AgendamentoGateway agendamentoGateway;
    public CriarAgendamentoUseCaseImpl(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }

    @Override
    public Agendamento execute(Agendamento agendamento) {
        return agendamentoGateway.criarAgendamento(agendamento);
    }




}
