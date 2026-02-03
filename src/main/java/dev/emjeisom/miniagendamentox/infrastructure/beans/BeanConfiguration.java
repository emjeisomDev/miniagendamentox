package dev.emjeisom.miniagendamentox.infrastructure.beans;

import dev.emjeisom.miniagendamentox.core.gateway.AgendamentoGateway;
import dev.emjeisom.miniagendamentox.core.usecases.*;
import dev.emjeisom.miniagendamentox.infrastructure.gateway.AgendamentoRepositoryGateway;
import dev.emjeisom.miniagendamentox.infrastructure.mapper.AgendamentoEntityMapper;
import dev.emjeisom.miniagendamentox.infrastructure.persistence.AgendamentoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarAgendamentoUseCase criarAgendamentoUseCase(AgendamentoGateway agendamentoGateway){
        return new CriarAgendamentoUseCaseImpl(agendamentoGateway);
    }

    @Bean
    public AtualizarAgendamentoUseCase atualizarAgendamentoUseCase(AgendamentoGateway agendamentoGateway){
        return new AtualizarAgendamentoUseCaseImpl(agendamentoGateway);
    }

    @Bean
    public BuscarAgendamentoPorIdUseCase buscarAgendamentoPorIdUseCase(AgendamentoGateway agendamentoGateway){
        return new BuscarAgendamentoPorIdUseCaseImpl(agendamentoGateway);
    }

    @Bean
    public CancelarAgendamentoUseCase cancelarAgendamentoUseCase(AgendamentoGateway agendamentoGateway){
        return new CancelarAgendamentoUseCaseImpl(agendamentoGateway);
    }

    @Bean
    public ConcluirAgendamentoUseCase concluirAgendamentoUseCase(AgendamentoGateway agendamentoGateway){
        return new ConcluirAgendamentoUseCaseImpl(agendamentoGateway);
    }

    @Bean
    public AgendamentoGateway agendamentoGateway(
            AgendamentoRepository repository,
            AgendamentoEntityMapper mapper
    ){
        return new AgendamentoRepositoryGateway(repository, mapper);
    }


}
