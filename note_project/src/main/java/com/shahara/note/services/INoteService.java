package com.shahara.note.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface INoteService<T> {
    void save(T t);
    void remove(int id);
    Optional<T> findById(int id);
    List<T> findAll();

    List<T> searchNote(String keyword);
}
