package com.zlimbu.utst.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zlimbu.utst.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

}
