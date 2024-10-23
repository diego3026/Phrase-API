package com.proyecto.mensaje.models.dtos.save;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhraseRequest {
    private String phrase;
    private String author;
}
