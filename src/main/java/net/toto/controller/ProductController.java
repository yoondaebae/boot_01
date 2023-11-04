package net.toto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import net.toto.common.exception.Constants.ExceptionClass;
import net.toto.common.exception.TotoNetException;
import net.toto.data.dto.ProductDto;
import net.toto.service.ProductService;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	//http://localhost:8080/api/v1/product/{productId}
	@GetMapping("/product/{productId}")
	public ProductDto getProduct(@PathVariable String productId) {
		long startTime = System.currentTimeMillis();
		LOGGER.info("[ProductController] perform {} of TOTO Net API.","getProduct");
		ProductDto productDto = productService.getProduct(productId);
		
		LOGGER.info("[ProductController] Response :: productId = {}, productName = {},productPrice = {},productStock = {}, Response Time = {}ms",
				productDto.getProductId(), productDto.getProductName(), productDto.getProductPrice(), productDto.getProductStock(),(System.currentTimeMillis() - startTime));
		return productDto;
	}
	
	//http://localhost:8080/api/v1/product
	@PostMapping("/product")
	public ProductDto createProduct(@Valid @RequestBody ProductDto productDto) {
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
	
	@PostMapping("/product/exception")
	public void exceptionTest() throws TotoNetException {
		//throw new TotoNetException(ExceptionClass.PRODUCT, HttpStatus.BAD_REQUEST, "의도한 에러가 발생했습니다.");
		throw new TotoNetException(ExceptionClass.PRODUCT, HttpStatus.FORBIDDEN, "접근이 금지되었습니다.");
	}
}
