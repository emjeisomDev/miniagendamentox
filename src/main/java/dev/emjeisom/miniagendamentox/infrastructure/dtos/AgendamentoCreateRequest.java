package dev.emjeisom.miniagendamentox.infrastructure.dtos;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record AgendamentoCreateRequest(
        @NotBlank @Size(max = 120) String titulo,
        @Size(max = 4000) String descricao,
        @NotNull LocalDateTime dataInicio,
        @NotNull LocalDateTime dataFim,
        @NotBlank @Size(max = 80) String usuario
) {
}
