package com.urna.urna.Service;

import com.urna.urna.Entity.Voto;
import com.urna.urna.Repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    public Voto registrarVoto(Voto voto){
        return votoRepository.save(voto);
    }
}
