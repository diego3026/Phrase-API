package com.proyecto.mensaje.repositories;

import com.proyecto.mensaje.models.entities.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhraseRepository extends JpaRepository<Phrase, Long> {
}
