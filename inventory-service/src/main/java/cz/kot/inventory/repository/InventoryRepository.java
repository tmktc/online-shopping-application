package cz.kot.inventory.repository;

import cz.kot.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository - communicates with the MySQL database
 */
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    /**
     * Receives request form service to check whether the given product is in stock in the given quantity
     *
     * @param skuCode  skuCode of the product to check the stock status
     * @param quantity quantity that is expected to be in stock
     * @return true if the given product is in stock in the expected quantity, false if not
     */
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}
