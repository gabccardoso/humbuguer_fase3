package com.pos.fiap.infrastructure.controllers;

import com.pos.fiap.application.useCases.OrderInteractor;
import com.pos.fiap.domain.entities.Order;
import com.pos.fiap.infrastructure.controllers.dto.OrderDTO;
import com.pos.fiap.infrastructure.controllers.dto.OrderDTOMapper;
import com.pos.fiap.infrastructure.controllers.enums.Status;
import com.pos.fiap.infrastructure.controllers.gerenciadores.GerenciadorAutenticacao;
import com.pos.fiap.infrastructure.gateways.OrderRepositoryGateway;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/pedido")
public class OrderController {

    private final OrderInteractor orderInteractor;
    private final OrderDTOMapper orderDTOMapper;
    private final GerenciadorAutenticacao gerenciadorAutenticacao;

    public OrderController(OrderInteractor orderInteractor, OrderDTOMapper orderDTOMapper, GerenciadorAutenticacao gerenciadorAutenticacao) {
        this.orderInteractor = orderInteractor;
        this.orderDTOMapper = orderDTOMapper;
        this.gerenciadorAutenticacao = gerenciadorAutenticacao;
    }

    @GetMapping(value = "buscarPedidos")
    public ResponseEntity<List<OrderDTO>> buscarPedidos(){
        List<Order> orders = orderInteractor.findOrders();
        List<OrderDTO> ordersDTO = new ArrayList<>();
        for(Order order : orders){
            ordersDTO.add(orderDTOMapper.toOrderDTO(order));
        }
        return ResponseEntity.ok(ordersDTO);
    }

    @PostMapping(value = "criarPedido")
    public ResponseEntity<Long> criarPedido(@Valid @RequestBody OrderDTO orderDTO, @RequestHeader(value = "token", required = false) String token){
        Long clientId = token != null ? gerenciadorAutenticacao.usuarioAutenticado(token) : null;
        orderDTO.setClientId(clientId);
        Long orderId = orderInteractor.createOrder(orderDTOMapper.toOrder(orderDTO));
        return ResponseEntity.ok(orderId);
    }

    @PostMapping(value = "adicionarItens/{pedidoId}")
    public ResponseEntity<OrderDTO> adicionarItensAoPedido(@PathVariable Long pedidoId, @RequestBody Map<Long, Integer> itensPedido) {
        Order order = orderInteractor.updateOrderItens(pedidoId, itensPedido);
        return ResponseEntity.ok(orderDTOMapper.toOrderDTO(order));
    }

    @PutMapping(value = "alterarStatusPedido/{pedidoId}")
    public ResponseEntity<OrderDTO> alterarStatusPedido(@PathVariable Long pedidoId, @RequestParam String status){
        Status statusNovo = Status.valueOf(status.toUpperCase());
        Order order = orderInteractor.updateOrderStatus(pedidoId, statusNovo);
        return ResponseEntity.ok(orderDTOMapper.toOrderDTO(order));
    }
}
