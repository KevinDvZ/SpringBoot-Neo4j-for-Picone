package fr.simplon.picone.service;

import fr.simplon.picone.model.Mood;

import fr.simplon.picone.repository.MoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoodServiceImpl implements MoodService{


    @Autowired
    private MoodRepository moodRepository;

    @Override
    public List<Mood> findNodes() {
        return moodRepository.findAll();
    }

    @Override
    public Optional<Mood> findNodesById(Long id) {
        return moodRepository.findById(id);
    }
}
