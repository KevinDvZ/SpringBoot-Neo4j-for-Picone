package fr.simplon.picone.service;

import fr.simplon.picone.model.Mood;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MoodService {

        List<Mood> findNodes();

        Optional<Mood> findNodesById(Long id);

    }

