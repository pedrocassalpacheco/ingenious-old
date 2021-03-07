package com.soickm.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.soickm.domain.POC;

public interface POCRepository extends MongoRepository<POC, String> {

}