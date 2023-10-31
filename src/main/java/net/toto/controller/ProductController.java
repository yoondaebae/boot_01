package net.toto.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.toto.data.dto.ProductDto;
import net.toto.service.ProductService;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	//http://localhost:8080/api/v1/product/{productId}
	@GetMapping("/product/{productId}")
	public ProductDto getProduct(@PathVariable String productId) {
		return productService.getProduct(productId);
	}
	
	//http://localhost:8080/api/v1/product
	@PostMapping("/product")
	public ProductDto createProduct(@RequestBody ProductDto productDto) {
		String productId = productDto.getProductId();
		String productName = productDto.getProductName();
		int productPrice = productDto.getProductPrice();
		int productStock = productDto.getProductStock();
		
		return productService.saveProduct(productId, productName, productPrice, productStock);
	}
	
	//http://localhost:8080/api/v1/product/{productId}
	@DeleteMapping("/product/{productId}")
	public ProductDto deleteProduct(@PathVariable String productId) {
		return null;
	}
}
