package com.acme.pedidos.infrastructure.entrypoints.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PedidoResponseDto {

    private EnviarPedidoRespuestaDto enviarPedidoRespuesta;

    @Data
    @Builder
    public static class EnviarPedidoRespuestaDto {
        private String codigoEnvio;
        private String estado;
    }
}
