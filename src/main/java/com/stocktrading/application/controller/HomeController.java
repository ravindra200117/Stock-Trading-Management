package com.stocktrading.application.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.stocktrading.application.dao.TradeDao;
import com.stocktrading.application.model.Trade;


@Controller
public class HomeController 
{
	@Autowired
	private TradeDao tradeDao;
	
	@RequestMapping(path = "/home")
	public String home(Model m)
	{
		List<Trade> list = tradeDao.getAllTrade();
		m.addAttribute("tradeList",list);
		return "home";
	}
	
	@RequestMapping(path = "/addTrade")
	public String addTrade()
	{
		return "addtrade";
	}
	
	@RequestMapping(path = "/createTrade", method = RequestMethod.POST)
	public String createTrade(@ModelAttribute Trade trade, HttpSession session) 
	{
	
		System.out.println(trade);
		
		int i = tradeDao.saveTrade(trade);
		session.setAttribute("msg", "Register Sucessfully");
		return "addtrade";
	}
	
	@RequestMapping(path = "/editTrade/{id}")
	public String editTrade(@PathVariable int id, Model m)
	{
		Trade trade = tradeDao.getTradeById(id);
		m.addAttribute("trade",trade);
		return "edittrade";
	}
	
	@RequestMapping(path = "/updateTrade", method = RequestMethod.POST)
	public String updateTrade(@ModelAttribute Trade trade, HttpSession session) 
	{
		tradeDao.update(trade);
		session.setAttribute("msg", "Update Sucessfully");
		return "redirect:/home";
	}
	
	@RequestMapping(path = "/deleteTrade/{id}")
	public String deleteTrade(@PathVariable int id, HttpSession session) 
	{
		tradeDao.deleteTrade(id);
		session.setAttribute("msg", "delete Sucessfully");
		return "redirect:/home";
	}
}
