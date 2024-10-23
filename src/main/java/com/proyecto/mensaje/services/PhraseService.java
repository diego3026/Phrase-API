package com.proyecto.mensaje.services;

import com.proyecto.mensaje.models.dtos.save.PhraseRequest;
import com.proyecto.mensaje.models.dtos.save.PhraseUpdate;
import com.proyecto.mensaje.models.dtos.send.PhraseResponse;

import java.util.List;

public interface PhraseService {
    List<PhraseResponse> findAll();
    PhraseResponse findById(Long id);
    PhraseResponse findPhrase();
    PhraseResponse update(Long id, PhraseUpdate phraseUpdate);
    PhraseResponse save(PhraseRequest phraseRequest);
    void deleteById(Long id);
    void deleteAll();
}
