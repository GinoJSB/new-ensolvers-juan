package com.creaciondenotas.creacionDeNotas.model.Entity.mapper;

import com.creaciondenotas.creacionDeNotas.model.DTO.NoteReqDTO;
import com.creaciondenotas.creacionDeNotas.model.DTO.NoteResponseDTO;
import com.creaciondenotas.creacionDeNotas.model.Entity.Note;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface NoteMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Note updateNoteReqDTOToNote(NoteReqDTO dto, @MappingTarget Note note);
    NoteResponseDTO noteToNoteResponseDTO(Note note);
    List<NoteResponseDTO> notesToNotesResponseDTO(List<Note> notes);
}
