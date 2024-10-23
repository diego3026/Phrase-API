package com.proyecto.mensaje.controllers;

import com.proyecto.mensaje.models.dtos.save.PhraseRequest;
import com.proyecto.mensaje.models.dtos.save.PhraseUpdate;
import com.proyecto.mensaje.models.entities.Phrase;
import com.proyecto.mensaje.services.PhraseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phrases")
@AllArgsConstructor
public class PhraseController {
    private final PhraseService phraseService;

    @GetMapping
    private ResponseEntity<?> getAll(){
        return ResponseEntity.ok(phraseService.findAll());
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(phraseService.findById(id));
    }

    @GetMapping("/random")
    private ResponseEntity<?> getPhraseRandom(){
        return ResponseEntity.ok(phraseService.findPhrase());
    }

    @PostMapping
    private ResponseEntity<?> create(@RequestBody PhraseRequest phraseRequest){
        return ResponseEntity.ok(phraseService.save(phraseRequest));
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable Long id, @RequestBody PhraseUpdate phraseUpdate){
        return ResponseEntity.ok(phraseService.update(id, phraseUpdate));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id){
        phraseService.deleteById(id);
        return ResponseEntity.ok("phrase deleted");
    }

    @DeleteMapping
    private ResponseEntity<?> deleteAll(){
        phraseService.deleteAll();
        return ResponseEntity.ok("phrases deleted");
    }
}
