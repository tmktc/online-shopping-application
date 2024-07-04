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
     * Firstly, it checks whether the given products are in stock in the given quantities
     * through communication with inventory service.
     * If the products are in stock, it places the orders and communicates with the repository
     * to save them to the database.
     * If the products are not in stock, it throws a RuntimeException.
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
