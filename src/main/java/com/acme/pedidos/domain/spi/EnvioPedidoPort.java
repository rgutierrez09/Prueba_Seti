package com.acme.pedidos.domain.spi;

import com.acme.pedidos.domain.model.EnvioResultado;
import com.acme.pedidos.domain.model.Pedido;

public interface EnvioPedidoPort {

    EnvioResultado enviarPedido(Pedido pedido);

}
