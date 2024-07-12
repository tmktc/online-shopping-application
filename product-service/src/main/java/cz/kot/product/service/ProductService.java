package cz.kot.product.service;

import cz.kot.product.dto.ProductRequest;
import cz.kot.product.dto.ProductResponse;
import cz.kot.product.model.Product;
import cz.kot.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class - business logic
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    /**
     * Receives requests from the controller to create products.
     * It creates the products and communicates with the repository to save them to the database.
     * The created products are then sent back to the controller for confirmation.
     *
     * @param productRequest product requested for creation
     * @return a created product
     */
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .skuCode(productRequest.skuCode())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product created successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getSkuCode(), product.getPrice());
    }

    /**
     * Receives requests from the controller to retrieve all products.
     * It communicates with the repository to fetch all products from the database.
     * The result is then returned to the controller.
     *
     * @return list of all products
     */
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getSkuCode(), product.getPrice()))
                .toList();
    }
}
