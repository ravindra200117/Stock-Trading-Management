package com.stocktrading.application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.stocktrading.application.model.Trade;

@Repository   //built on the top of the classes that manage the code related to the database.
public class TradeDaoImpl implements TradeDao
{

	@Autowired //used for automatic dependency injection.
	private HibernateTemplate hibernateTemplate;  // helper class that is used to simplify the data access code
	
	@Transactional   //to wrap a method in a database transaction. It allows us to set propagation, isolation, timeout, read-only, and rollback conditions for our transaction.
	public int saveTrade(Trade trade) {
		
		int i = (Integer) hibernateTemplate.save(trade);
		return i;
	}

	
	public Trade getTradeById(int id) {
		Trade trade = hibernateTemplate.get(Trade.class, id);
		return trade;
	}

	
	public List<Trade> getAllTrade() {
		List<Trade> list = hibernateTemplate.loadAll(Trade.class);
		return list;
	}

	@Transactional
	public void update(Trade trade) {
		hibernateTemplate.update(trade);
	}

	@Transactional
	public void deleteTrade(int id) {
		Trade trade = hibernateTemplate.get(Trade.class, id);
		hibernateTemplate.delete(trade);
	}
	
}
