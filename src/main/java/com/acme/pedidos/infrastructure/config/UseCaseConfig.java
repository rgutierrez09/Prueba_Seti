package com.acme.pedidos.infrastructure.config;

import com.acme.pedidos.domain.spi.EnvioPedidoPort;
import com.acme.pedidos.usecase.EnviarPedidoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UseCaseConfig {

    @Bean
    public EnviarPedidoUseCase enviarPedidoUseCase(EnvioPedidoPort envioPedidoPort) {
        return new EnviarPedidoUseCase(envioPedidoPort);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}