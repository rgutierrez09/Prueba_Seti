package com.acme.pedidos.infrastructure.entrypoints.rest;

import com.acme.pedidos.domain.model.EnvioResultado;
import com.acme.pedidos.domain.model.Pedido;
import com.acme.pedidos.infrastructure.entrypoints.rest.dto.PedidoRequestDto;
import com.acme.pedidos.infrastructure.entrypoints.rest.dto.PedidoResponseDto;
import com.acme.pedidos.usecase.EnviarPedidoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final EnviarPedidoUseCase enviarPedidoUseCase;

    @PostMapping("/enviar")
    public PedidoResponseDto enviarPedido(@RequestBody PedidoRequestDto request) {

        PedidoRequestDto.EnviarPedidoDto r = request.getEnviarPedido();

        Pedido pedido = Pedido.builder()
                .numPedido(r.getNumPedido())
                .cantidadPedido(r.getCantidadPedido())
                .codigoEAN(r.getCodigoEAN())
                .nombreProducto(r.getNombreProducto())
                .numDocumento(r.getNumDocumento())
                .direccion(r.getDireccion())
                .build();

        EnvioResultado resultado = enviarPedidoUseCase.ejecutar(pedido);

        return PedidoResponseDto.builder()
                .enviarPedidoRespuesta(
                        PedidoResponseDto.EnviarPedidoRespuestaDto.builder()
                                .codigoEnvio(resultado.getCodigoEnvio())
                                .estado(resultado.getEstado())
                                .build()
                )
                .build();
    }
}
