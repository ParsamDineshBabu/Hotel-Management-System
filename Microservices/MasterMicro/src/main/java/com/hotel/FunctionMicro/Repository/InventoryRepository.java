package com.hotel.FunctionMicro.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.FunctionMicro.entity.Inventory;


@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String>{

}
