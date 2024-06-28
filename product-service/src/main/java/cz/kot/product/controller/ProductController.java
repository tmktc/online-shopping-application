package cz.kot.product.controller;

import cz.kot.product.dto.ProductRequest;
import cz.kot.product.dto.ProductResponse;
import cz.kot.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller - handles requests that come from the client
 */
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * Receives requests from the client for product creation.
     * It communicates with the service layer to create the products.
     * Once the products are created, they are sent back for confirmation.
     *
     * @param productRequest product requested for creation
     * @return a created product
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    /**
     * Receives requests from the client to retrieve all products.
     * It communicates with the service layer to fetch a the complete list products.
     * Once the service layer returns the list, it is sent back to he client.
     *
     * @return list of all products
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}

