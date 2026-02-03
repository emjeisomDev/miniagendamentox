package dev.emjeisom.miniagendamentox.core.usecases;

import dev.emjeisom.miniagendamentox.core.entities.Agendamento;
import dev.emjeisom.miniagendamentox.core.gateway.AgendamentoGateway;

public class ConcluirAgendamentoUseCaseImpl implements ConcluirAgendamentoUseCase {
    private final AgendamentoGateway agendamentoGateway;

    public ConcluirAgendamentoUseCaseImpl(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }

    @Override
    public Agendamento execute(Long id) {
        if (agendamentoGateway.buscarAgendamentoPorId(id) == null){
            throw new IllegalArgumentException("Agendamento não encontrado");
        }
        return agendamentoGateway.concluirAgendamento(id);
    }
}
