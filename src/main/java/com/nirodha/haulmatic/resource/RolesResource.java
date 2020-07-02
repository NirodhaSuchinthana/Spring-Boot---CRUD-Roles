package com.nirodha.haulmatic.resource;

import com.nirodha.haulmatic.documents.Roles;
import com.nirodha.haulmatic.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RolesResource {

    private RolesRepository rolesRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public RolesResource(RolesRepository rolesRepository){
        this.rolesRepository = rolesRepository;
    }

    @PostMapping("/")
    public ResponseEntity<Roles> createRole(Roles roles){
        try {
            Roles _role = rolesRepository.save(new Roles(roles.getId(), roles.getOrganization(), roles.getFirstName(), roles.getLastName(),roles.getNicNo(), roles.getRoleType()));
            return new ResponseEntity<>(_role, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public List<Roles> getAll(){
        return rolesRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Roles> updateRole(@PathVariable("id") String id, @RequestBody Roles roleUpdate ){
        Optional<Roles> role = rolesRepository.findById(Integer.valueOf(id));

        if (role.isPresent()){
            Roles _role = role.get();

            _role.setOrganization(roleUpdate.getOrganization());
            _role.setFirstName(roleUpdate.getFirstName());
            _role.setLastName(roleUpdate.getLastName());
            _role.setNicNo(roleUpdate.getNicNo());
            _role.setRoleType(roleUpdate.getRoleType());

            return new ResponseEntity<>(rolesRepository.save(_role), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteAllRoles(){
        try {
            rolesRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteRole(@PathVariable("id") String id){
        Optional<Roles> role = rolesRepository.findById(Integer.valueOf(id));

        try {
            rolesRepository.deleteById(Integer.valueOf(id));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/deleteByNic")
    public ResponseEntity<HttpStatus> getRoleByNic(String nic){

        try {
            rolesRepository.deleteRolesByNicNo(nic,Roles.class);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
        }
    }

    @GetMapping("/get/{organization}")
    public ResponseEntity<List<Roles>> getRoleByOrganization(@PathVariable("organization") String organization){

        try {
            List<Roles> result = rolesRepository.findDistinctByOrganization(organization, Roles.class);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("get/{roleType}")
    public ResponseEntity<List<Roles>> getRoleByRoleType(@PathVariable("roleType") Roles.RoleType roleType){
        try {
            List<Roles> result = rolesRepository.findRolesByRoleType(roleType, Roles.class);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
