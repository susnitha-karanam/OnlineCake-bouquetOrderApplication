package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product)  {
		return productRepository.save(product);
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Product updateProductPrice(int pid, long price) throws Exception {
		Product product = productRepository.findById(pid).get();
		if(product != null) {
			product.setPrice(price);
			return productRepository.save(product);
			
		}else {
			throw new Exception("Product Not Exist");
		}
	}
	
	

}
