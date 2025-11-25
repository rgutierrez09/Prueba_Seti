package com.acme.pedidos.infrastructure.entrypoints.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soap-mock")
public class SoapMockController {

    @PostMapping(value = "/envio", produces = MediaType.TEXT_XML_VALUE)
    public String mockSoapResponse() {
        return """
        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:env="http://WSDLs/EnvioPedidos/EnvioPedidosAcme">
           <soapenv:Header/>
           <soapenv:Body>
              <env:EnvioPedidoAcmeResponse>
                 <EnvioPedidoResponse>
                    <Codigo>80375472</Codigo>
                    <Mensaje>Entregado exitosamente al cliente</Mensaje>
                 </EnvioPedidoResponse>
              </env:EnvioPedidoAcmeResponse>
           </soapenv:Body>
        </soapenv:Envelope>
        """;
    }
}