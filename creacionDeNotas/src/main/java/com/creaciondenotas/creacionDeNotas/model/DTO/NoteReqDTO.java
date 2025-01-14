package com.creaciondenotas.creacionDeNotas.model.DTO;


import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;


@Builder
@Getter
@Setter
public class NoteReqDTO {
    @NotNull private String titulo;
    @Nullable private String contenido;
    @NotNull private Boolean archived;
    @NotNull private List<Long> categoryIds;
}
