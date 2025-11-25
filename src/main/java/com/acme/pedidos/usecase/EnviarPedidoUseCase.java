package com.acme.pedidos.usecase;

import com.acme.pedidos.domain.model.EnvioResultado;
import com.acme.pedidos.domain.model.Pedido;
import com.acme.pedidos.domain.spi.EnvioPedidoPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EnviarPedidoUseCase {

    private final EnvioPedidoPort envioPedidoPort;

    public EnvioResultado ejecutar(Pedido pedido) {
        return envioPedidoPort.enviarPedido(pedido);
    }
}
