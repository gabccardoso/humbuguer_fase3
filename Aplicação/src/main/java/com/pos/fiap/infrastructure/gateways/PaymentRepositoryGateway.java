package com.pos.fiap.infrastructure.gateways;

import com.pos.fiap.application.gateways.PaymentGateway;
import com.pos.fiap.infrastructure.controllers.WebhookController;
import com.pos.fiap.infrastructure.controllers.enums.StatusPayment;
import com.pos.fiap.infrastructure.persistence.PaymentEntity;
import com.pos.fiap.infrastructure.persistence.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.net.URI;

public class PaymentRepositoryGateway implements PaymentGateway {

    private final PaymentRepository paymentRepository;
    private final String webhookUrl = "/webhooks/pagamentos";
    private final String  webhookApiKey = "123";

    public PaymentRepositoryGateway(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public String findPaymentStatus(Long orderId) {
        PaymentEntity paymentEntity = paymentRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
        return paymentEntity.getStatusPayment().name();
    }

    @Override
    public StatusPayment createPayment(Long orderId) {
        PaymentEntity paymentEntity = new PaymentEntity(orderId);
        paymentEntity.setStatusPayment(StatusPayment.APROVADO);
        paymentRepository.save(paymentEntity);
        this.enviarNotificacao(paymentEntity.getStatusPayment().name());
        return paymentEntity.getStatusPayment();
    }

    private void enviarNotificacao(String mensagem) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + webhookApiKey);

        String payload = "{\"Seu pagamento foi\": \"" + mensagem.toLowerCase() + "\"}";

        HttpEntity<String> requestEntity = new HttpEntity<>(payload, headers);
        HttpServletRequest currentRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String currentUrl = currentRequest.getRequestURL().toString();
        String baseUrl = currentUrl.substring(0, currentUrl.indexOf(currentRequest.getRequestURI()));

        URI uri = URI.create(baseUrl+webhookUrl);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);
    }
}
