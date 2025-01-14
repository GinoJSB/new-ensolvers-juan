package com.creaciondenotas.creacionDeNotas.service;

import com.creaciondenotas.creacionDeNotas.model.DTO.NoteReqDTO;
import com.creaciondenotas.creacionDeNotas.model.DTO.NoteResponseDTO;
import com.creaciondenotas.creacionDeNotas.model.Entity.Note;
import com.creaciondenotas.creacionDeNotas.model.Entity.mapper.NoteMapper;
import com.creaciondenotas.creacionDeNotas.repository.INotasRepository;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class NotasService implements INotasService {

    private final INotasRepository repository;
    private final NoteMapper noteMapper;

    public NotasService(INotasRepository repository, NoteMapper noteMapper) {
        this.repository = repository;
        this.noteMapper = noteMapper;
    }

    @Override
    public List<NoteResponseDTO> getNotas() {
        List<Note> notes = repository.findAll();

        return noteMapper.notesToNotesResponseDTO(notes);
    }

    @Override
    public void saveNotas(NoteReqDTO dto) {
        // agarrar el array de categorias, tipo dto.getCategoryIds();
        // va a armar una lista List<Category> categories = categoryService.findAllById(dto.getCategoryIds());
        // cuando ya lo tenga, crea el objeto Note desde el NoteReqDTO.
        // todo: Recuerde ignorar la property de categoryIds en el mapping.
        // ya luego de que haga el mapper, sin las categorias, ahora si lo setea a mano las categorys que las obtuvo de categoryService.findAllById();

        // y ahi guarda.
        //repository.save(note);
    }

    @Override
    public void deleteNotas(Long id) {
        repository.deleteById(id);
    }

    @Override
    public NoteResponseDTO findNotas(Long id) {
        Optional<Note> noteOpt = repository.findById(id);

        return noteMapper.noteToNoteResponseDTO(getNoteIfPresent(noteOpt, id));
    }

    @Override
    public NoteResponseDTO updateNote(Long id, NoteReqDTO notiReqDTO) {
        Optional<Note> noteOpt = repository.findById(id);

        Note note = noteMapper.updateNoteReqDTOToNote(notiReqDTO, getNoteIfPresent(noteOpt, id));
        repository.save(note);

        return noteMapper.noteToNoteResponseDTO(note);
    }

    @Override
    public void archiveNotas(Long id, boolean archived) {
        Optional<Note> noteOpt = repository.findById(id);

        Note note = getNoteIfPresent(noteOpt, id);

        note.setArchived(archived);
        repository.save(note);
    }

    private Note getNoteIfPresent(Optional<Note> note, Long id) {
        if (note.isEmpty()) {
            throw new EntityNotFoundException("Note with id: " + id + " not found");
        }

        return note.get();
    }
}
