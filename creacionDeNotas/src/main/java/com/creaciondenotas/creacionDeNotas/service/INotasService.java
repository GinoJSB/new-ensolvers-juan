package com.creaciondenotas.creacionDeNotas.service;

import com.creaciondenotas.creacionDeNotas.model.DTO.NotaReqDTO;
import com.creaciondenotas.creacionDeNotas.model.DTO.NoteResponseDTO;
import com.creaciondenotas.creacionDeNotas.model.Entity.Nota;

import java.util.List;

public interface INotasService  {

    //metodo para crear una nota
    public void saveNotas (Nota noti);

    //metodo para borrar una nota
    public void deleteNotas (Long id);

    //metodo para encontrar una persona
    public Nota findNotas  (Long id);


    //metodo para archivar nota
    public void archiveNotas (Long id, boolean archived);


    NoteResponseDTO updateNote(Long id, NotaReqDTO notiReqDTO);

    List<Nota> getNotas();
}
