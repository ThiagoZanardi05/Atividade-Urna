package com.urna.urna.Controller;

import com.urna.urna.Entity.Voto;
import com.urna.urna.Service.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voto")
public class VotoController {

    @Autowired
    private VotoService votoService;

    @PostMapping("/registrar")
    public ResponseEntity<Voto> registrarVoto(@RequestBody Voto voto){
        Voto votoSalvo = votoService.registrarVoto(voto);
        return ResponseEntity.ok(votoSalvo);
    }
}
