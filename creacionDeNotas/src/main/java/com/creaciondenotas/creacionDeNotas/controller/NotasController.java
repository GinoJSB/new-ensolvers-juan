package com.creaciondenotas.creacionDeNotas.controller;

import com.creaciondenotas.creacionDeNotas.model.DTO.NotaReqDTO;
import com.creaciondenotas.creacionDeNotas.model.DTO.NoteResponseDTO;
import com.creaciondenotas.creacionDeNotas.model.Entity.Nota;
import com.creaciondenotas.creacionDeNotas.service.INotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotasController {

    @Autowired
    private INotasService notiServ;

    @GetMapping("/notas/dame")
    public List<Nota> getNotas() {
        return notiServ.getNotas();
    }

    @PostMapping("/notes")
    public String saveNotas(@RequestBody Nota noti) {
        notiServ.saveNotas(noti);
        return "La nota fue creada correctamente";
    }

    @DeleteMapping("/notes/{id}")
    public String deleteNotas(@PathVariable Long id) {
        notiServ.deleteNotas(id);
        return "La nota fue eliminada correctamente";
    }

    @PutMapping("/notas/{id}")
    public NoteResponseDTO updateNotas(@PathVariable Long id, @RequestBody NotaReqDTO notiReqDTO) {
        return notiServ.updateNote(id, notiReqDTO);
    }

    @PutMapping("/notes/{id}")
    public String archiveNotas(@PathVariable Long id, @RequestParam(required = true) boolean archived) {
        notiServ.archiveNotas(id, archived);
        return archived ? "La nota fue archivada correctamente" : "La nota fue desarchivada correctamente";
    }
}




