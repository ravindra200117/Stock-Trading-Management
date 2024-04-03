package com.stocktrading.application.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trade_details")
public class Trade 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String tradeDateTime;
	
    private String stockName;
    
    private BigDecimal listingPrice;
    
    private int quantity;
    
    private String type; // buy or sell
    
    private BigDecimal pricePerUnit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getTradeDateTime() {
		return tradeDateTime;
	}

	public void setTradeDateTime(String tradeDateTime) {
		this.tradeDateTime = tradeDateTime;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public BigDecimal getListingPrice() {
		return listingPrice;
	}

	public void setListingPrice(BigDecimal listingPrice) {
		this.listingPrice = listingPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	@Override
	public String toString() {
		return "Trade [id=" + id + ", tradeDateTime=" + tradeDateTime + ", stockName=" + stockName + ", listingPrice="
				+ listingPrice + ", quantity=" + quantity + ", type=" + type + ", pricePerUnit=" + pricePerUnit + "]";
	}
    
    
    
}
