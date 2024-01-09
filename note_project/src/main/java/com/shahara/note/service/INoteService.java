package com.shahara.note.service;

public interface INoteService<T> {
    void save(T t);
    void delete(T t);
}
