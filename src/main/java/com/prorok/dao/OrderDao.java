package com.prorok.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.prorok.model.Order;

@Transactional
@Repository
public class OrderDao extends GenericDao<Order, Long> {

}
