package fr.simplon.picone.service;

import fr.simplon.picone.model.Admin;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public interface AdminService {

    List<Admin> findNodes();

    Optional<Admin> findNodesById(Long id);

    List<Admin> findByIdAndByRelation(Long id, String relation);
}

