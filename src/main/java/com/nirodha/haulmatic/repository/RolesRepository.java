package com.nirodha.haulmatic.repository;

import com.nirodha.haulmatic.documents.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RolesRepository extends MongoRepository<Roles, Integer> {
}
