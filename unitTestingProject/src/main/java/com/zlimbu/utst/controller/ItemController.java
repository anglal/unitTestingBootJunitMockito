package com.zlimbu.utst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zlimbu.utst.business.ItemBusinessService;
import com.zlimbu.utst.model.Item;

@RestController
public class ItemController {

	@Autowired
	private ItemBusinessService businessService;

	@GetMapping("/dummy-item")
	public Item getItem() {
		return new Item(1, "pencil", 12, 5);
	}

	@GetMapping("/item-from-business-service")
	public Item getItemFrinBusinessService() {
		return this.businessService.retrieveHardCodedItem();
	}

	@GetMapping("/get-all-items")
	public List<Item> getAllItems() {
		List<Item> items = this.businessService.retrieveAll();

		return items;
	}

}
