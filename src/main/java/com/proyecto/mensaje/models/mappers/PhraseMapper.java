package com.proyecto.mensaje.models.mappers;

import com.proyecto.mensaje.models.dtos.save.PhraseRequest;
import com.proyecto.mensaje.models.dtos.send.PhraseResponse;
import com.proyecto.mensaje.models.entities.Phrase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhraseMapper {
    Phrase phraseRequestToPhrase(PhraseRequest phraseRequest);
    Phrase phraseUpdateToPhrase(Phrase phrase);
    PhraseResponse phraseToPhraseResponse(Phrase phrase);
}
