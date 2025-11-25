package com.acme.pedidos.infrastructure.drivenadapters.soap;

import com.acme.pedidos.domain.model.EnvioResultado;
import com.acme.pedidos.domain.model.Pedido;
import com.acme.pedidos.domain.spi.EnvioPedidoPort;
import com.acme.pedidos.infrastructure.drivenadapters.soap.model.SoapEnvelopeRequest;
import com.acme.pedidos.infrastructure.drivenadapters.soap.model.SoapEnvelopeResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class SoapEnvioPedidoAdapter implements EnvioPedidoPort {

    private final RestTemplate restTemplate;
    private final String endpointUrl;
    private final XmlMapper xmlMapper;

    public SoapEnvioPedidoAdapter(
            RestTemplate restTemplate,
            @Value("${acme.soap.envio-pedidos-endpoint}") String endpointUrl
    ) {
        this.restTemplate = restTemplate;
        this.endpointUrl = endpointUrl;
        this.xmlMapper = new XmlMapper();
        // 🔥 Ignorar cualquier tag desconocido que venga en el XML
        this.xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public EnvioResultado enviarPedido(Pedido pedido) {
        try {
            String xmlRequest = buildSoapRequest(pedido);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.TEXT_XML);

            HttpEntity<String> entity = new HttpEntity<>(xmlRequest, headers);

            log.info("Request SOAP a {}:\n{}", endpointUrl, xmlRequest);

            ResponseEntity<String> response = restTemplate.postForEntity(
                    endpointUrl,
                    entity,
                    String.class
            );

            String xmlResponse = response.getBody();
            log.info("Response SOAP:\n{}", xmlResponse);

            return parseSoapResponse(xmlResponse);

        } catch (Exception e) {
            log.error("Error enviando pedido SOAP", e);
            throw new RuntimeException("Error comunicándose con servicio SOAP", e);
        }
    }

    private String buildSoapRequest(Pedido pedido) throws Exception {
        SoapEnvelopeRequest envelope = new SoapEnvelopeRequest();
        SoapEnvelopeRequest.SoapBodyRequest body = new SoapEnvelopeRequest.SoapBodyRequest();
        SoapEnvelopeRequest.EnvioPedidoAcme envio = new SoapEnvelopeRequest.EnvioPedidoAcme();
        SoapEnvelopeRequest.EnvioPedidoRequest req = new SoapEnvelopeRequest.EnvioPedidoRequest();

        req.setPedido(pedido.getNumPedido());
        req.setCantidad(pedido.getCantidadPedido());
        req.setEan(pedido.getCodigoEAN());
        req.setProducto(pedido.getNombreProducto());
        req.setCedula(pedido.getNumDocumento());
        req.setDireccion(pedido.getDireccion());

        envio.setEnvioPedidoRequest(req);
        body.setEnvioPedidoAcme(envio);
        envelope.setBody(body);

        return xmlMapper.writeValueAsString(envelope);
    }

    private EnvioResultado parseSoapResponse(String xml) throws Exception {
        SoapEnvelopeResponse envelope =
                xmlMapper.readValue(xml, SoapEnvelopeResponse.class);

        SoapEnvelopeResponse.EnvioPedidoResponse resp = envelope
                .getBody()
                .getEnvioPedidoAcmeResponse()
                .getEnvioPedidoResponse();

        return EnvioResultado.builder()
                .codigoEnvio(resp.getCodigo())
                .estado(resp.getMensaje())
                .build();
    }
}