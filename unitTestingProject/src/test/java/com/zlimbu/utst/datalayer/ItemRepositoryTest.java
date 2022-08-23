package com.zlimbu.utst.datalayer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.zlimbu.utst.data.ItemRepository;
import com.zlimbu.utst.model.Item;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ItemRepositoryTest {

	@Autowired
	ItemRepository repository;

	@Test
	public void testFindAll() {

		List<Item> items = repository.findAll();

		assertEquals(3, items.size());
	}

}
