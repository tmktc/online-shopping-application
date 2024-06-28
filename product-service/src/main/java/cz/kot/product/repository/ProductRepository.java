package cz.kot.product.repository;

import cz.kot.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository - communicates with the database
 */
public interface ProductRepository extends MongoRepository<Product, String> {
}
