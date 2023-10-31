package net.toto.data.handler;

import net.toto.data.entity.ProductEntity;

public interface ProductDataHandler {
	
	ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);
	
	ProductEntity getProductEntity(String productId);
}
