package com.shahara.note.models;

import jakarta.persistence.*;

@Entity
@Table(name = "note")
public class Note {
    @Id
    private int noteId;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "noteTypeId", nullable = false)
    private NoteType noteType;

    public Note() {
    }

    public Note(int noteId, String title, String content, NoteType noteType) {
        this.noteId = noteId;
        this.title = title;
        this.content = content;
        this.noteType = noteType;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int typeId) {
        this.noteId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NoteType getNoteType() {
        return noteType;
    }

    public void setNoteType(NoteType noteType) {
        this.noteType = noteType;
    }
}
