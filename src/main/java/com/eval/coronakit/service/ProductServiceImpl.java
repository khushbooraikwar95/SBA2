package com.eval.coronakit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.ProductMasterRepository;
import com.eval.coronakit.entity.ProductMaster;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMasterRepository repository;

	@Override
	@Transactional
	public ProductMaster addNewProduct(ProductMaster product) {
		if (null != product) {
			repository.save(product);
		}
		return product;
	}

	@Override
	public List<ProductMaster> getAllProducts() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public ProductMaster deleteProduct(int productId) {
//		ProductMaster product = repository.getOne(productId);
		repository.deleteById(productId);
		return null;
	}

	@Override	
	public ProductMaster getProductById(int productId) {
		return repository.getOne(productId);
	}

}
