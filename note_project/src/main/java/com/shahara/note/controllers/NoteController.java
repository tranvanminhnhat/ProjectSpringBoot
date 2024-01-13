package com.shahara.note.controllers;

import com.shahara.note.models.Note;
import com.shahara.note.services.INoteService;
import com.shahara.note.services.INoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {
    @Autowired
    private INoteService iNoteService;

    @Autowired
    private INoteTypeService iNoteTypeService;


    @PostMapping("/create-note")
    public ModelAndView save(@ModelAttribute("note") Note note){
        iNoteService.save(note);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("message", "Create successfully");
        return modelAndView;
    }
    @GetMapping("/create-note")
    public ModelAndView showCreateNoteForm(){
        ModelAndView modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("note", new Note());
        modelAndView.addObject("noteTypes", iNoteTypeService.findAll());
        return modelAndView;
    }



    public void delete(Note note){
        iNoteService.delete(note);
    }
}
