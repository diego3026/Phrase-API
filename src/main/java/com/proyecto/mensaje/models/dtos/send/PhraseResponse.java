package com.proyecto.mensaje.models.dtos.send;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PhraseResponse {
    private Long id;
    private String phrase;
    private String author;
}
