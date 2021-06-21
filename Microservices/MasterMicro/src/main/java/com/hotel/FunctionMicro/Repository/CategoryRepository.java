package com.hotel.FunctionMicro.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.FunctionMicro.entity.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
