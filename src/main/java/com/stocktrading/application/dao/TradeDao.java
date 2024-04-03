package com.stocktrading.application.dao;

import java.util.List;

import com.stocktrading.application.model.Trade;

public interface TradeDao 
{
	public int saveTrade(Trade trade);

	public Trade getTradeById(int id);

	public List<Trade> getAllTrade();

	public void update(Trade trade);

	public void deleteTrade(int id);

}
