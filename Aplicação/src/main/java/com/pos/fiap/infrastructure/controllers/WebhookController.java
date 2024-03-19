package com.pos.fiap.infrastructure.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.net.URI;

@RestController
public class WebhookController {




    @PostMapping("webhooks/pagamentos")
    public void receberNotificacao(@RequestBody String payload,
                                   @RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false)
                                   String authorizationHeader){
        String token = authorizationHeader.substring(7);
        if (authorizationHeader.startsWith("Bearer ")) {
            if (token.equals("123")) {
                // O token é válido, processar a notificação x
                System.out.println(payload);

            }
        }
    }
}
