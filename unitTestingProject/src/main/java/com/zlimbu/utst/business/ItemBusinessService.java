package com.zlimbu.utst.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlimbu.utst.data.ItemRepository;
import com.zlimbu.utst.model.Item;

@Service
public class ItemBusinessService {

	@Autowired
	private ItemRepository itemRepository;

	public Item retrieveHardCodedItem() {
		return new Item(2, "Book", 23, 45);
	}

	public List<Item> retrieveAll() {
		List<Item> myList = itemRepository.findAll();
		return myList.stream().map(x -> {
			x.setValue(x.getId() * x.getQuantity() + x.getPrice());
			return x;
		}).collect(Collectors.toList());

	}

}
