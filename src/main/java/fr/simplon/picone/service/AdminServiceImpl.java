package fr.simplon.picone.service;


import fr.simplon.picone.model.Admin;
import fr.simplon.picone.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> findNodes() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> findNodesById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public List<Admin> findByIdAndByRelation( Long id, String relation) {
        return adminRepository.findChildNodes(relation, id);
    }

}
