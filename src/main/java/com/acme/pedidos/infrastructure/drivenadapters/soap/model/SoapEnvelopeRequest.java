package com.acme.pedidos.infrastructure.drivenadapters.soap.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "Envelope")
public class SoapEnvelopeRequest {

    @JacksonXmlProperty(localName = "Body")
    private SoapBodyRequest body;

    @Data
    @NoArgsConstructor
    public static class SoapBodyRequest {

        @JacksonXmlProperty(localName = "EnvioPedidoAcme")
        private EnvioPedidoAcme envioPedidoAcme;
    }

    @Data
    @NoArgsConstructor
    public static class EnvioPedidoAcme {

        @JacksonXmlProperty(localName = "EnvioPedidoRequest")
        private EnvioPedidoRequest envioPedidoRequest;
    }

    @Data
    @NoArgsConstructor
    public static class EnvioPedidoRequest {

        @JacksonXmlProperty(localName = "pedido")
        private String pedido;

        @JacksonXmlProperty(localName = "Cantidad")
        private String cantidad;

        @JacksonXmlProperty(localName = "EAN")
        private String ean;

        @JacksonXmlProperty(localName = "Producto")
        private String producto;

        @JacksonXmlProperty(localName = "Cedula")
        private String cedula;

        @JacksonXmlProperty(localName = "Direccion")
        private String direccion;
    }
}
