package com.shahara.note.api;

import com.shahara.note.models.Note;
import com.shahara.note.services.INoteService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/note")
public class NoteAPI {
    @Resource
    private INoteService iNoteService;


    @GetMapping("/find-all-notes")
    public ResponseEntity<Iterable<Note>> findAllCustomer() {
        List<Note> customers = (List<Note>) iNoteService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
