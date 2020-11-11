package com.residwi.microservice.product.service.mapper;

import com.residwi.microservice.product.dto.ProductDto;
import com.residwi.microservice.product.entity.Product;
import com.residwi.microservice.product.request.CreateProductRequest;
import com.residwi.microservice.product.request.UpdateProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDTO(Product product);

    List<ProductDto> toDTOs(List<Product> product);

    Product toEntity(CreateProductRequest createProductRequest);

    Product toEntity(UpdateProductRequest updateProductRequest, @MappingTarget Product product);

}
