package com.creaciondenotas.creacionDeNotas.service;

import com.creaciondenotas.creacionDeNotas.model.DTO.NoteReqDTO;
import com.creaciondenotas.creacionDeNotas.model.DTO.NoteResponseDTO;
import com.creaciondenotas.creacionDeNotas.model.Entity.Note;

import java.util.List;

public interface INotasService  {

    //metodo para crear una nota
    public void saveNotas (Note noti);

    //metodo para borrar una nota
    public void deleteNotas (Long id);

    public NoteResponseDTO findNotas(Long id);


    //metodo para archivar nota
    public void archiveNotas (Long id, boolean archived);


    NoteResponseDTO updateNote(Long id, NoteReqDTO notiReqDTO);

    List<NoteResponseDTO> getNotas();
}
