package com.urna.urna.Service;

import com.urna.urna.Entity.Candidato;
import com.urna.urna.Entity.Eleitor;
import com.urna.urna.Entity.enums.Status;
import com.urna.urna.Entity.enums.StatusCandidato;
import com.urna.urna.Repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public Candidato saveCandidato(Candidato candidato){
        candidato.setStatusCandidato(StatusCandidato.ATIVO);
        return candidatoRepository.save(candidato);
    }

    public void setCandidatoInativo(Long id){
        Optional<Candidato> candatoOp = candidatoRepository.findById(id);

        if (candatoOp.isPresent()){
            Candidato candidato = candatoOp.get();
            candidato.setStatusCandidato(StatusCandidato.INATIVO);
            candidatoRepository.save(candidato);
        }else {
            throw new RuntimeException("Candidato nao exite");
        }
    }

    public List<Candidato> findAll(){
        return candidatoRepository.findAll();
    }
}
