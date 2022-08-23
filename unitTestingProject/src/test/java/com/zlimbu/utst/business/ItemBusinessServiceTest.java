package com.zlimbu.utst.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.zlimbu.utst.data.ItemRepository;
import com.zlimbu.utst.model.Item;

public class ItemBusinessServiceTest {
	@InjectMocks
	private ItemBusinessService itemBusinessService;
	
	@Mock
	private ItemRepository itemRepository;
	
	@BeforeEach
	void SetUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testRetrieveAll() {
		
		when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1, "pen",45, 3)
				,new Item(2, "book",75, 2)
				,new Item(3, "marble",23, 4)
				,new Item(4, "sweet",76, 7)
				));
		List<Item> retrieveAll = this.itemBusinessService.retrieveAll();
		assertEquals(retrieveAll, Arrays.asList(new Item(1, "pen",45, 3)
				,new Item(2, "book",75, 2)
				,new Item(3, "marble",23, 4)
				,new Item(4, "sweet",76, 7)
				));
		retrieveAll.forEach(System.out::println);
	
		
	}

}
