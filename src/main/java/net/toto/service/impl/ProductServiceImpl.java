package net.toto.service.impl;

import org.springframework.stereotype.Service;

import net.toto.data.dto.ProductDto;
import net.toto.data.entity.ProductEntity;
import net.toto.data.handler.ProductDataHandler;
import net.toto.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

  ProductDataHandler productDataHandler;

  public ProductServiceImpl(ProductDataHandler productDataHandler) {
    this.productDataHandler = productDataHandler;
  }

  @Override
  public ProductDto saveProduct(String productId, String productName, int productPrice,
      int productStock) {
    ProductEntity productEntity =
        productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);

    ProductDto productDto =
        new ProductDto(productEntity.getProductId(), productEntity.getProductName(),
            productEntity.getProductPrice(), productEntity.getProductStock());

    return productDto;
  }

  @Override
  public ProductDto getProduct(String productId) {
    ProductEntity productEntity = productDataHandler.getProductEntity(productId);

    ProductDto productDto =
        new ProductDto(productEntity.getProductId(), productEntity.getProductName(),
            productEntity.getProductPrice(), productEntity.getProductStock());

    return productDto;
  }

}
