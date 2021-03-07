package com.soickm.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.soickm.domain.POC;
import org.springframework.data.repository.CrudRepository;

public interface POCSRepository extends CrudRepository<POC, String> {

}