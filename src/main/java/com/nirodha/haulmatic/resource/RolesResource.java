package com.nirodha.haulmatic.resource;

import com.nirodha.haulmatic.documents.Roles;
import com.nirodha.haulmatic.repository.RolesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RolesResource {

    private RolesRepository rolesRepository;

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
}
