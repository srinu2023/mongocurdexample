package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Product;
import com.example.demo.model.ResourceNotFoundException;
import com.example.demo.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService  {

	@Autowired
	ProductRepository productRepository;
	@Override
	public Product createProduct(Product product) {
				return productRepository.save(product);
	}
	@Override
	public Product updateProduct(Product product) {
		Optional<Product> productDb=this.productRepository.findById(product.getId());
		if(productDb.isPresent()){
			Product productUpdate=productDb.get();
			productUpdate.setId(product.getId());
			productUpdate.setName(product.getName());
			productUpdate.setDescription(product.getDescription());
			productRepository.save(productUpdate);
			return productUpdate;
		}
		else{
			throw new ResourceNotFoundException("Record not found id:"+product.getId());
		}
		
	}
	@Override
	public List<Product> getAllProduct() {
		return this.productRepository.findAll();
	}
	@Override
	public Product getProductById(Long productId) {
		Optional<Product> productDb=this.productRepository.findById(productId);
		if(productDb.isPresent()){
			return productDb.get();
		}
		else{
			throw new ResourceNotFoundException("Record not found with id:"+productId);
		}
	}
	@Override
	public void deleteProduct(long productId) {
		Optional<Product> productDB=this.productRepository.findById(productId);
		if(productDB.isPresent()){
			this.productRepository.delete(productDB.get());
		}
		else{
			throw new ResourceNotFoundException("Record not found with id:"+productId);
		}
	}
	

}
