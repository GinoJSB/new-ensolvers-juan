package com.creaciondenotas.creacionDeNotas.model.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "note_id", referencedColumnName = "id")
    private Note note;
}
