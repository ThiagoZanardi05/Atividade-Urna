package com.urna.urna.Controller;

import com.urna.urna.Entity.Eleitor;
import com.urna.urna.Service.EleitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eleitor")
public class EleitorController {
    @Autowired
    EleitorService eleitorService;

    @PostMapping("/saveEleitor")
    public ResponseEntity<Eleitor> saveEleitor(@RequestBody Eleitor eleitor) {
        try {
            Eleitor eleitorSalvo = eleitorService.saveEleitor(eleitor);
            return ResponseEntity.ok(eleitorSalvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Eleitor>> findAll() {
        try {
            List<Eleitor> eleitores = eleitorService.findAll();
            return ResponseEntity.ok(eleitores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
