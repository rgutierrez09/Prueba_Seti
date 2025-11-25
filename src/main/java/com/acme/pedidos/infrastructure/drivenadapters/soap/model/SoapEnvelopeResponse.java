package com.acme.pedidos.infrastructure.drivenadapters.soap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "Envelope")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SoapEnvelopeResponse {

    @JacksonXmlProperty(localName = "Header")
    private Object header;

    @JacksonXmlProperty(localName = "Body")
    private SoapBodyResponse body;

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SoapBodyResponse {

        @JacksonXmlProperty(localName = "EnvioPedidoAcmeResponse")
        private EnvioPedidoAcmeResponse envioPedidoAcmeResponse;
    }

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EnvioPedidoAcmeResponse {

        @JacksonXmlProperty(localName = "EnvioPedidoResponse")
        private EnvioPedidoResponse envioPedidoResponse;
    }

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EnvioPedidoResponse {

        @JacksonXmlProperty(localName = "Codigo")
        private String codigo;

        @JacksonXmlProperty(localName = "Mensaje")
        private String mensaje;
    }
}