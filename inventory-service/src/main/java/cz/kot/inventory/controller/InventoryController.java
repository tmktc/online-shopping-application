package cz.kot.inventory.controller;

import cz.kot.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller - handles requests that come from the client
 */
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    /**
     * Receives requests from the client for stock check.
     * It communicates with the service layer to check the stock status.
     * Once the status of the stock is checked, a status confirmation is sent back to the client.
     *
     * @param skuCode  skuCode of the product to check the stock status
     * @param quantity quantity that is expected to be in stock
     * @return true if the given product is in stock in the expected quantity, false if not
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        return inventoryService.isInStock(skuCode, quantity);
    }
}
