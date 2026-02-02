package dev.emjeisom.miniagendamentox.infrastructure.mapper;

import dev.emjeisom.miniagendamentox.core.entities.Agendamento;
import dev.emjeisom.miniagendamentox.core.enums.StatusAgendamento;
import dev.emjeisom.miniagendamentox.infrastructure.dtos.AgendamentoCreateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AgendamentoCreateMapper {

    public AgendamentoCreateRequest toDto(Agendamento agendamento){
        return new AgendamentoCreateRequest(
                agendamento.titulo(),
                agendamento.descricao(),
                agendamento.dataInicio(),
                agendamento.dataFim(),
                agendamento.usuario()
        );
    }

    public Agendamento toEntity(AgendamentoCreateRequest agendamentoCreateRequest){
        return new Agendamento(
                null,
                agendamentoCreateRequest.titulo(),
                agendamentoCreateRequest.descricao(),
                agendamentoCreateRequest.dataInicio(),
                agendamentoCreateRequest.dataFim(),
                StatusAgendamento.AGENDADO,
                agendamentoCreateRequest.usuario(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }


}
