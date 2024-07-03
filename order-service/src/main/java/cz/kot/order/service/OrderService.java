package cz.kot.order.service;

import cz.kot.order.client.InventoryClient;
import cz.kot.order.dto.OrderRequest;
import cz.kot.order.model.Order;
import cz.kot.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Service class - business logic
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    /**
     * Receives requests from the controller to place orders.
     * It places the orders and communicates with the repository to save them to the database.
     *
     * @param orderRequest order requested for placement
     */
    public void placeOrder(OrderRequest orderRequest) {
        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if (isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setSkuCode(orderRequest.skuCode());
            order.setPrice(orderRequest.price());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product with SkuCode " + orderRequest.skuCode() + " is not in stock");
        }
    }
}
