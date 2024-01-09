package com.shahara.note.service;

import com.shahara.note.models.Note;
import com.shahara.note.repository.NoteRepository;
import org.springframework.stereotype.Service;

@Service
public class NoteService implements INoteService<Note> {
    private NoteRepository noteRepository;
    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void delete(Note note) {
        noteRepository.delete(note);
    }
}
