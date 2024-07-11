package cz.kot.inventory.service;

import cz.kot.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service class - business logic
 */
@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    /**
     * Receives requests from the controller for stock check.
     * It communicates with the repository to check whether the given product is in stock in the given quantity.
     *
     * @param skuCode skuCode of the product to check the stock status
     * @param quantity quantity that is expected to be in stock
     * @return true if the given product is in stock in the expected quantity, false if not
     */
    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}
