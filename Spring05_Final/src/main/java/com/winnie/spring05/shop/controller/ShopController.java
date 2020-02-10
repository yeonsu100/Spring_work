package com.winnie.spring05.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.winnie.spring05.shop.service.ShopService;

@Controller
public class ShopController {
	@Autowired
	private ShopService service;
}
