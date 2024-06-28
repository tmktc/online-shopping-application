package cz.kot.product.dto;

import java.math.BigDecimal;

/**
 * Product dto that is sent by the client
 *
 * @param id
 * @param name
 * @param description
 * @param price
 */
public record ProductRequest(String id, String name, String description, BigDecimal price) {
}
