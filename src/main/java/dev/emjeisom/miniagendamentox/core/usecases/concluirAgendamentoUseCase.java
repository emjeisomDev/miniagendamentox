package dev.emjeisom.miniagendamentox.core.usecases;

import dev.emjeisom.miniagendamentox.core.entities.Agendamento;

public interface concluirAgendamentoUseCase {
    Agendamento execute(Long id);
}
