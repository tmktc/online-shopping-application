package cz.kot.order.dto;

import java.math.BigDecimal;

/**
 * Order dto that is sent by the client
 *
 * @param id
 * @param orderNumber
 * @param skuCode
 * @param price
 * @param quantity
 */
public record OrderRequest(Long id, String orderNumber, String skuCode,
                           BigDecimal price, Integer quantity) {
}
