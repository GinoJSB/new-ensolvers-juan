package com.creaciondenotas.creacionDeNotas.service;

import com.creaciondenotas.creacionDeNotas.model.DTO.NotaReqDTO;
import com.creaciondenotas.creacionDeNotas.model.DTO.NoteResponseDTO;
import com.creaciondenotas.creacionDeNotas.model.Entity.Nota;
import com.creaciondenotas.creacionDeNotas.repository.INotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class NotasService implements INotasService {

    @Autowired
    private INotasRepository notiRepo;

    @Override
    public List<Nota> getNotas() {
        return notiRepo.findAll();
    }

    @Override
    public void saveNotas(Nota noti) {
        notiRepo.save(noti);
    }

    @Override
    public void deleteNotas(Long id) {
        notiRepo.deleteById(id);
    }

    @Override
    public Nota findNotas(Long id) {
        return notiRepo.findById(id).orElse(null);
    }

    @Override
    public NoteResponseDTO updateNote(Long id, NotaReqDTO notiReqDTO) {
        Optional<Nota> notiOpt = notiRepo.findById(id);

        if (notiOpt.isEmpty()) {
            throw new EntityNotFoundException("Nota con ID " + id + " no encontrada");
        }

        Nota noti = notiOpt.get();
        noti.setTitulo(notiReqDTO.getTitulo());
        noti.setContenido(notiReqDTO.getContenido());
        noti.setArchived(notiReqDTO.getArchived());

        notiRepo.save(noti);

        return NoteResponseDTO.builder()
                .id(noti.getId())
                .titulo(noti.getTitulo())
                .contenido(noti.getContenido())
                .archived(noti.isArchived())
                .build();
    }


    @Override
    public void archiveNotas(Long id, boolean archived) {
        Nota noti = this.findNotas(id);
        if (noti != null) {
            noti.setArchived(archived);
            this.saveNotas(noti);
        }
    }
}
