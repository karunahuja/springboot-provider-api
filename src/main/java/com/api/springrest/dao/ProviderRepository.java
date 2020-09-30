package com.api.springrest.dao;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.api.springrest.entities.Provider;

public interface ProviderRepository extends MongoRepository<Provider,Integer> {

  public Provider findByFirstName(String firstName);
  public List<Provider> findByLastName(String lastName);

}