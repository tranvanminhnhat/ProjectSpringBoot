package com.shahara.note.repositories;

import com.shahara.note.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface NoteRepository extends JpaRepository<Note, Integer> {
}
