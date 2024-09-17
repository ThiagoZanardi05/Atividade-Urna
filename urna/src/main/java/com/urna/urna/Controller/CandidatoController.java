package com.urna.urna.Controller;

import com.urna.urna.Entity.Candidato;
import com.urna.urna.Service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {
    @Autowired
    CandidatoService candidatoService;

    @PostMapping("/saveCandidato")
    public ResponseEntity<Candidato> saveCandidato(@RequestBody Candidato candidato){
        try {
            Candidato candidatoSalvo = candidatoService.saveCandidato(candidato);
            return ResponseEntity.ok(candidatoSalvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/inativar/{id}")
    public ResponseEntity<String> inativarCandidato(@PathVariable Long id) {
        candidatoService.setCandidatoInativo(id);
        return ResponseEntity.ok("Candidato inativado com sucesso");
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<Candidato>>findAll(){
        try {
            List<Candidato> candidatos = candidatoService.findAll();
            return ResponseEntity.ok(candidatos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
