package com.howtodoinjava.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.howtodoinjava.entity.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl extends AHibernateRepository<Product, Integer> implements ProductDAO {

	@Override
	public void create(Product product) {
		savePO(product);
	}
}
