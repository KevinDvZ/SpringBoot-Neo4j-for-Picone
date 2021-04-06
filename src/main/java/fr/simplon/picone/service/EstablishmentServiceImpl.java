package fr.simplon.picone.service;

import fr.simplon.picone.model.Establishment;
import fr.simplon.picone.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablishmentServiceImpl implements EstablishmentService {

    @Autowired
    EstablishmentRepository establishmentRepository;

    @Override
    public List<Establishment> returnAllEstablishment() {
       return establishmentRepository.findAll();
    }

    @Override
    public Establishment findEstablishmentById(Long id) { return establishmentRepository.findEstablishmentById(id); }


    @Override
public Establishment returnAddEstablishmentByEstablishment(Establishment establishment){
        return establishmentRepository.save(establishment);
    }
    @Override
    public void deleteEstablishment (long id){
        establishmentRepository.deleteById(id);


}
    @Override
    public Establishment returnUpdateEstablishmentByEstablishment(Establishment establishment) {
        return establishmentRepository.save(establishment);

    }

}