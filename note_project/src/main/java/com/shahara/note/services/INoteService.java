package com.shahara.note.services;

import org.springframework.stereotype.Service;

@Service
public interface INoteService<T> {
    void save(T t);
    void delete(T t);
}
