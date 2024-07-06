package cz.kot.order.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface InventoryClient {

    /**
     * Checks if a specified quantity of a product is in stock.
     *
     * @param skuCode skuCode of the item to check
     * @param quantity quantity of the item to check
     * @return true if the given quantity of the product is in stock, false if not
     */
    @GetExchange("/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
