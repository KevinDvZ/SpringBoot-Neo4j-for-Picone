package fr.simplon.picone.service;

import fr.simplon.picone.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AdminService {

    List<Admin> findNodes() throws Exception;

    Optional<Admin> findNodesById(Long id) throws Exception;

    List<Admin> findByIdAndByRelation(Long id, String relation) throws Exception;

    Admin addAdmin(Admin admin) throws Exception;

    Admin upadateAdmin(Admin admin) throws Exception;

    void deleteAdmin(Long id);
}

