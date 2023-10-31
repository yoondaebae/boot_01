package net.toto.data.dao;

import net.toto.data.entity.ProductEntity;

public interface ProductDAO {

	ProductEntity saveProduct(ProductEntity productEntity);
	
	ProductEntity getProduct(String productId);
}
