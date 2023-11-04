package net.toto.data.handler.impl;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import net.toto.data.dao.ProductDAO;
import net.toto.data.entity.ProductEntity;
import net.toto.data.handler.ProductDataHandler;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {

  ProductDAO productDAO;

  public ProductDataHandlerImpl(ProductDAO productDAO) {
    this.productDAO = productDAO;
  }

  @Override
  public ProductEntity saveProductEntity(String productId, String productName, int productPrice,
      int productStock) {
    ProductEntity productEntity =
        new ProductEntity(productId, productName, productPrice, productStock);
    return productDAO.saveProduct(productEntity);
  }

  @Override
  public ProductEntity getProductEntity(String productId) {

    return productDAO.getProduct(productId);
  }

}
