package com.prorok.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.prorok.model.Client;
@Transactional
@Repository
public class ClientDao extends GenericDao<Client, Long>{

	@Override
	public Client get(Long key) {
		Client client = super.get(key);
		client.getOrders().size();
		return client;
	}

}
