package com.acme.pedidos.infrastructure.entrypoints.rest.dto;

import lombok.Data;

@Data
public class PedidoRequestDto {

    private EnviarPedidoDto enviarPedido;

    @Data
    public static class EnviarPedidoDto {
        private String numPedido;
        private String cantidadPedido;
        private String codigoEAN;
        private String nombreProducto;
        private String numDocumento;
        private String direccion;
    }
}
