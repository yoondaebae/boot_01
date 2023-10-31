package net.toto.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.toto.data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String>{
	
}
