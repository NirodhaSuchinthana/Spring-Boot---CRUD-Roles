package com.nirodha.haulmatic.resource;

import com.nirodha.haulmatic.documents.Roles;
import com.nirodha.haulmatic.repository.RolesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesResource {

    private RolesRepository rolesRepository;

    public RolesResource(RolesRepository rolesRepository){
        this.rolesRepository = rolesRepository;
    }

    @GetMapping("/all")
    public List<Roles> getAll(){
        return rolesRepository.findAll();
    }
}
