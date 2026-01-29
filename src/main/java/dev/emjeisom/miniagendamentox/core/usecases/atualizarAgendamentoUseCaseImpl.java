package dev.emjeisom.miniagendamentox.core.usecases;

import dev.emjeisom.miniagendamentox.core.entities.Agendamento;
import dev.emjeisom.miniagendamentox.core.gateway.AgendamentoGateway;

import java.time.LocalDateTime;

public class atualizarAgendamentoUseCaseImpl implements atualizarAgendamentoUseCase {

    private final AgendamentoGateway agendamentoGateway;

    public atualizarAgendamentoUseCaseImpl(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }

    @Override
    public Agendamento execute(Agendamento agendamento) {
        var existente = agendamentoGateway.buscarAgendamentoPorId(agendamento.id());
        if (existente == null){
            throw new IllegalArgumentException("Agendamento não encontrado");
        }
        return agendamentoGateway.atualizarAgendamento(
                new Agendamento(
                        existente.id(),
                        agendamento.titulo(),
                        agendamento.descricao(),
                        agendamento.dataInicio(),
                        agendamento.dataFim(),
                        existente.status(),
                        existente.usuario(),
                        existente.criadoEm(),
                        LocalDateTime.now()
                )
        );
    }

}
