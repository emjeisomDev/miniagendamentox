package dev.emjeisom.miniagendamentox.infrastructure.presentation;

import dev.emjeisom.miniagendamentox.core.entities.Agendamento;
import dev.emjeisom.miniagendamentox.core.usecases.*;
import dev.emjeisom.miniagendamentox.infrastructure.dtos.AgendamentoCreateRequest;
import dev.emjeisom.miniagendamentox.infrastructure.dtos.AgendamentoResponse;
import dev.emjeisom.miniagendamentox.infrastructure.dtos.AgendamentoUpdateRequest;
import dev.emjeisom.miniagendamentox.infrastructure.mapper.AgendamentoCreateMapper;
import dev.emjeisom.miniagendamentox.infrastructure.mapper.AgendamentoResponseMapper;
import dev.emjeisom.miniagendamentox.infrastructure.mapper.AgendamentoUpdateRequestMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/agendamentos")
public class AgendamentoController {

    private final AtualizarAgendamentoUseCase atualizarAgendamentoUseCase;
    private final BuscarAgendamentoPorIdUseCase buscarAgendamentoPorIdUseCase;
    private final CancelarAgendamentoUseCase cancelarAgendamentoUseCase;
    private final ConcluirAgendamentoUseCase concluirAgendamentoUseCase;
    private final CriarAgendamentoUseCase criarAgendamentoUseCase;
    private final AgendamentoCreateMapper agendamentoCreateMapper;
    private final AgendamentoResponseMapper agendamentoResponseMapper;
    private final AgendamentoUpdateRequestMapper agendamentoUpdateRequestMapper;

    public AgendamentoController(AtualizarAgendamentoUseCase atualizarAgendamentoUseCase,
                                 BuscarAgendamentoPorIdUseCase buscarAgendamentoPorIdUseCase,
                                 CancelarAgendamentoUseCase cancelarAgendamentoUseCase,
                                 ConcluirAgendamentoUseCase concluirAgendamentoUseCase,
                                 CriarAgendamentoUseCase criarAgendamentoUseCase,
                                 AgendamentoCreateMapper agendamentoCreateMapper,
                                 AgendamentoResponseMapper agendamentoResponseMapper,
                                 AgendamentoUpdateRequestMapper agendamentoUpdateRequestMapper) {
        this.atualizarAgendamentoUseCase = atualizarAgendamentoUseCase;
        this.buscarAgendamentoPorIdUseCase = buscarAgendamentoPorIdUseCase;
        this.cancelarAgendamentoUseCase = cancelarAgendamentoUseCase;
        this.concluirAgendamentoUseCase = concluirAgendamentoUseCase;
        this.criarAgendamentoUseCase = criarAgendamentoUseCase;
        this.agendamentoCreateMapper = agendamentoCreateMapper;
        this.agendamentoResponseMapper = agendamentoResponseMapper;
        this.agendamentoUpdateRequestMapper = agendamentoUpdateRequestMapper;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> criarAgendamento(AgendamentoCreateRequest request){
        Agendamento criado = criarAgendamentoUseCase.execute(agendamentoCreateMapper.toEntity(request));

        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Agendamento criado com sucesso.");
        response.put("agendamento", agendamentoResponseMapper.toDto(criado));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(agendamentoResponseMapper.toDto(buscarAgendamentoPorIdUseCase.execute(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizarAgendamento(@PathVariable Long id, @RequestBody AgendamentoUpdateRequest request) {
        Agendamento existente = buscarAgendamentoPorIdUseCase.execute(id);

        if (existente == null) { return ResponseEntity.notFound().build(); }
        Agendamento atualizado = atualizarAgendamentoUseCase.execute(agendamentoUpdateRequestMapper.merge(existente, request));

        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Agendamento atualizado com sucesso.");
        response.put("agendamento", agendamentoResponseMapper.toDto(atualizado));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Map<String, Object>> cancelarAgendamento(@PathVariable Long id){
        Agendamento existente = buscarAgendamentoPorIdUseCase.execute(id);

        if (existente == null) { return ResponseEntity.notFound().build(); }
        Agendamento cancelado = cancelarAgendamentoUseCase.execute(id);

        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Agendamento atualizado com sucesso.");
        response.put("agendamento", agendamentoResponseMapper.toDto(cancelado));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/concluir")
    public ResponseEntity<Map<String, Object>> concluirAgendamento(@PathVariable Long id){
        Agendamento existente = buscarAgendamentoPorIdUseCase.execute(id);

        if (existente == null) { return ResponseEntity.notFound().build(); }
        Agendamento concluido = concluirAgendamentoUseCase.execute(id);

        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Agendamento atualizado com sucesso.");
        response.put("agendamento", agendamentoResponseMapper.toDto(concluido));
        return ResponseEntity.ok(response);
    }



}
