package com.creaciondenotas.creacionDeNotas.model.DTO;


import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Builder
@Getter @Setter
public class NotaReqDTO {
    @NotNull private String titulo;
    @Nullable private String contenido;
    @NotNull private Boolean archived;



}
