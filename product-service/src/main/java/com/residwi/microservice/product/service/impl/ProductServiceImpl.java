package com.residwi.microservice.product.service.impl;

import com.residwi.microservice.product.dto.ProductDto;
import com.residwi.microservice.product.entity.Product;
import com.residwi.microservice.product.handler.NotFoundException;
import com.residwi.microservice.product.repository.ProductRepository;
import com.residwi.microservice.product.request.CreateProductRequest;
import com.residwi.microservice.product.request.UpdateProductRequest;
import com.residwi.microservice.product.service.ProductService;
import com.residwi.microservice.product.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDto create(CreateProductRequest createProductRequest) {
        Product product = productRepository.save(productMapper.toEntity(createProductRequest));
        return productMapper.toDTO(product);
    }

    @Override
    public ProductDto update(Long id, UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(id)
                .orElseThrow(NotFoundException::new);

        return productMapper.toDTO(productRepository.save(productMapper.toEntity(updateProductRequest, product)));
    }

    @Override
    public ProductDto get(Long id) {
        Product product = findByIdOrThrowNotFound(id);

        return productMapper.toDTO(product);
    }

    @Override
    public List<ProductDto> list() {
        List<Product> products = productRepository.findAll();

        return productMapper.toDTOs(products);
    }

    private Product findByIdOrThrowNotFound(Long id) {
        return productRepository.findById(id).orElseThrow(NotFoundException::new);
    }

}
