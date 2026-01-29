package dev.emjeisom.miniagendamentox.core.usecases;

import dev.emjeisom.miniagendamentox.core.entities.Agendamento;
import dev.emjeisom.miniagendamentox.core.gateway.AgendamentoGateway;

public class cancelarAgendamentoUseCaseImpl implements  cancelarAgendamentoUseCase {
    private final AgendamentoGateway agendamentoGateway;

    public cancelarAgendamentoUseCaseImpl(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }

    @Override
    public Agendamento execute(Long id) {
        if (agendamentoGateway.buscarAgendamentoPorId(id) == null){
            throw new IllegalArgumentException("Agendamento não encontrado");
        }
        return agendamentoGateway.cancelarAgendamento(id);
    }
}
