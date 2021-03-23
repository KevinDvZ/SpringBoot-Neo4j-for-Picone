package fr.simplon.picone.controller;


import fr.simplon.picone.model.Admin;
import fr.simplon.picone.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @CrossOrigin("*")
    @GetMapping("/adminHome")
    public List<Admin> findNodes(){
        return adminService.findNodes();
    }

    @CrossOrigin("*")
    @GetMapping(value = "/adminHome/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Admin> findNodesById(@PathVariable Long id){
        return adminService.findNodesById(id);
    }

    @CrossOrigin("*")
    @GetMapping(value = "/adminHome/{id}/{relation}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Admin> findNodesByIdAndRelation(@PathVariable Long id, @PathVariable String relation){
        return adminService.findByIdAndByRelation(id, relation);
    }

}
