package dev.emjeisom.miniagendamentox.core.entities;

import dev.emjeisom.miniagendamentox.core.enums.StatusAgendamento;

import java.time.LocalDateTime;

public record Agendamento(
        Long id,
        String titulo,
        String descricao,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        StatusAgendamento status,
        String usuario,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm
) {
}
