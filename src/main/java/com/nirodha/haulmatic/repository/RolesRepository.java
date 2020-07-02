package com.nirodha.haulmatic.repository;

import com.nirodha.haulmatic.documents.Roles;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.management.relation.Role;
import java.util.List;

public interface RolesRepository extends MongoRepository<Roles, Integer> {
    void deleteRolesByNicNo(String nicNo, Class<Roles> rolesClass);
    List<Roles> findDistinctByOrganization(String organization, Class<Roles> rolesClass);
    List<Roles> findRolesByRoleType(Roles.RoleType roleType, Class<Roles> rolesClass);
}
