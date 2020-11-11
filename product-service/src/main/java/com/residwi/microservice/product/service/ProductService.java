package com.residwi.microservice.product.service;

import com.residwi.microservice.product.dto.ProductDto;
import com.residwi.microservice.product.request.CreateProductRequest;
import com.residwi.microservice.product.request.UpdateProductRequest;

import java.util.List;

public interface ProductService {

    ProductDto create(CreateProductRequest createProductRequest);

    ProductDto update(Long id, UpdateProductRequest updateProductRequest);

    ProductDto get(Long userId);

    List<ProductDto> list();

}
