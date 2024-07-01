package cz.kot.order.controller;

import cz.kot.order.dto.OrderRequest;
import cz.kot.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    /**
     * Receives requests from the client for order placement.
     * It communicates with th service layer to place the orders.
     * Once the orders are placed, a confirmation is sent back to the client.
     *
     * @param orderRequest order requested for placement
     * @return confirmation
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order placed successfully";
    }
}
