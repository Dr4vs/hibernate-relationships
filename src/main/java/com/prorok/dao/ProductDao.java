package com.prorok.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.prorok.model.Product;

@Transactional
@Repository
public class ProductDao extends GenericDao<Product, Long> {

	
}
