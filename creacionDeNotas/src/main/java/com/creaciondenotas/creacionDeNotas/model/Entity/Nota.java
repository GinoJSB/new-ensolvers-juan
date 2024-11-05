package com.creaciondenotas.creacionDeNotas.model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String contenido;
    private boolean archived=false;

    public Nota() {
    }

    public Nota(Long id, String titulo, String contenido, boolean archived) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.archived = archived;
    }
}




