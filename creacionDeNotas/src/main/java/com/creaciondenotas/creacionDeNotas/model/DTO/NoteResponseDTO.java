package com.creaciondenotas.creacionDeNotas.model.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class NoteResponseDTO {
    private Long id;
    private String titulo;
    private String contenido;
    private boolean archived;
}
