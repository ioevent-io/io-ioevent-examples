package io.ioevent.samples.fileprocessing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.ioevent.samples.fileprocessing.domain.Product;

public interface  ProductRepository  extends MongoRepository<Product, String>{

}
