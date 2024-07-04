package cz.kot.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign client for communicating with the inventory-service
 */
@FeignClient(value = "inventory", url = "${inventory.url}")
public interface InventoryClient {

    /**
     * Checks if a specified quantity of a product is in stock.
     *
     * @param skuCode skuCode of the item to check
     * @param quantity quantity of the item to check
     * @return true if the given quantity of the product is in stock, false if not
     */
    @RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
