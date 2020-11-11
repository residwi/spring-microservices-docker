package com.residwi.microservice.product.controller;

import com.residwi.microservice.product.dto.ApiResponse;
import com.residwi.microservice.product.dto.ProductDto;
import com.residwi.microservice.product.request.CreateProductRequest;
import com.residwi.microservice.product.request.UpdateProductRequest;
import com.residwi.microservice.product.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/", produces = "application/json")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @ApiOperation(value = "Get all products")
    public ResponseEntity<ApiResponse<List<ProductDto>>> getAll() {
        List<ProductDto> products = productService.list();

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "OK",
                        products
                ));
    }

    @PostMapping
    @ApiOperation(value = "Create new product")
    public ResponseEntity<ApiResponse<ProductDto>> createProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
        ProductDto product = productService.create(createProductRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiResponse<>(
                        HttpStatus.CREATED.value(),
                        "CREATED",
                        product
                ));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get product by id")
    public ResponseEntity<ApiResponse<ProductDto>> getProduct(@PathVariable Long id) {
        ProductDto product = productService.get(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "OK",
                        product
                ));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update product by id  ")
    public ResponseEntity<ApiResponse<ProductDto>> updateProduct(@PathVariable Long id, @Valid @RequestBody UpdateProductRequest updateProductRequest) {
        ProductDto product = productService.update(id, updateProductRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "OK",
                        product
                ));
    }
}
