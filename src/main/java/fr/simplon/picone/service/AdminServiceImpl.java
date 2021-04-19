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
    AdminRepository adminRepository;

    @Override
    public List<Admin> findNodes()throws Exception {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> findNodesById(Long id)throws Exception {
        return adminRepository.findById(id);
    }

    @Override
    public List<Admin> findByIdAndByRelation(Long id, String relation)throws Exception {
        return adminRepository.findChildNodes(relation, id);
    }

    @Override
    public Admin addAdmin(Admin admin) throws Exception{
        return adminRepository.save(admin);
    }

    @Override
    public Admin upadateAdmin(Admin user) {
        return adminRepository.save(user);
    }

    @Override
    public void deleteAdmin(Long id) {
         adminRepository.deleteById(id);
    }
}
