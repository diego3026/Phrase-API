package com.proyecto.mensaje.services.impl;

import com.proyecto.mensaje.models.dtos.save.PhraseRequest;
import com.proyecto.mensaje.models.dtos.save.PhraseUpdate;
import com.proyecto.mensaje.models.dtos.send.PhraseResponse;
import com.proyecto.mensaje.models.entities.Phrase;
import com.proyecto.mensaje.models.mappers.PhraseMapper;
import com.proyecto.mensaje.repositories.PhraseRepository;
import com.proyecto.mensaje.services.PhraseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PhraseServiceImpl implements PhraseService {
    private final PhraseRepository phraseRepository;
    private final PhraseMapper phraseMapper;
    private final Random random = new Random();

    public PhraseServiceImpl(PhraseRepository phraseRepository, PhraseMapper phraseMapper) {
        this.phraseRepository = phraseRepository;
        this.phraseMapper = phraseMapper;
    }

    @Override
    public List<PhraseResponse> findAll() {
        List<Phrase> phrases = phraseRepository.findAll();
        return phrases.stream().map(phraseMapper::phraseToPhraseResponse).toList();
    }

    @Override
    public PhraseResponse findById(Long id) {
        Phrase phrase = phraseRepository.findById(id).orElseThrow(() -> new RuntimeException("phrase not found"));
        return phraseMapper.phraseToPhraseResponse(phrase);
    }

    @Override
    public PhraseResponse findPhrase() {
        List<Phrase> phrases = phraseRepository.findAll();
        if (phrases.isEmpty()) {
            throw new IllegalArgumentException("phrases is empty");
        }
        int index = random.nextInt(phrases.size());
        return phraseMapper.phraseToPhraseResponse(phrases.get(index));
    }

    @Override
    public PhraseResponse update(Long id, PhraseUpdate phraseUpdate) {
        Phrase phraseReceived = phraseMapper.phraseUpdateToPhrase(phraseUpdate);
        Phrase phraseFind = phraseRepository.findById(id).orElseThrow(() -> new RuntimeException("phrase not found"));
        phraseFind.updatePhrase(phraseReceived);
        return phraseMapper.phraseToPhraseResponse(phraseRepository.save(phraseFind));
    }

    @Override
    public PhraseResponse save(PhraseRequest phraseRequest) {
        Phrase phrase = phraseMapper.phraseRequestToPhrase(phraseRequest);
        return phraseMapper.phraseToPhraseResponse(phraseRepository.save(phrase));
    }

    @Override
    public void deleteById(Long id) {
        phraseRepository.findById(id).orElseThrow(() -> new RuntimeException("phrase not found"));
        phraseRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        phraseRepository.deleteAll();
    }
}
