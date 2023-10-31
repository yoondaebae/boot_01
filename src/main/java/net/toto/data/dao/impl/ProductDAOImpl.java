package net.toto.data.dao.impl;

import org.springframework.stereotype.Service;

import net.toto.data.entity.ProductEntity;
import net.toto.data.repository.ProductRepository;

@Service
public class ProductDAOImpl implements net.toto.data.dao.ProductDAO {

	ProductRepository productRepository;
	
	public ProductDAOImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public ProductEntity saveProduct(ProductEntity productEntity) {
		productRepository.save(productEntity);
		return productEntity;
	}

	@Override
	public ProductEntity getProduct(String productId) {
		ProductEntity productEntity = productRepository.getReferenceById(productId);
		return productEntity;
	}

}
