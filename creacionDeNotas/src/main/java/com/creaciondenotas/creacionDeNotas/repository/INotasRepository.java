package com.creaciondenotas.creacionDeNotas.repository;

import com.creaciondenotas.creacionDeNotas.model.Entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotasRepository extends JpaRepository <Note, Long>{
}
