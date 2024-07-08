package cz.kot.product.dto;

import java.math.BigDecimal;

/**
 * Product dto that is sent to the client
 *
 * @param id
 * @param name
 * @param description
 * @param skuCode
 * @param price
 */
public record ProductResponse(String id, String name, String description,
                              String skuCode, BigDecimal price) {
}