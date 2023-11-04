package net.toto.service;

import net.toto.data.dto.ProductDto;

public interface ProductService {

  ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);

  ProductDto getProduct(String productId);
}
