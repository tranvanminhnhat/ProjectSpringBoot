package com.shahara.note.controllers;

import com.shahara.note.models.Note;
import com.shahara.note.services.INoteService;
import com.shahara.note.services.INoteTypeService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class NoteController {
    @Resource
    private INoteService iNoteService;

    @Resource
    private INoteTypeService iNoteTypeService;


    @PostMapping("/create-note")
    public ModelAndView save(@ModelAttribute("note") Note note){
        iNoteService.save(note);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView = new ModelAndView("/note/create");
        modelAndView.addObject("noteTypes", iNoteTypeService.findAll());
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

    @GetMapping("/find-all-note")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/note/list");
        modelAndView.addObject("notes",iNoteService.findAll());
        return modelAndView;
    }

    @GetMapping("/delete-note/{id}")
    public ModelAndView delete(@PathVariable int id){
        iNoteService.remove(id);
        ModelAndView modelAndView = new ModelAndView("/note/list");
        modelAndView.addObject("notes", iNoteService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit-note/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        Optional<Note> note = iNoteService.findById(id);
        if (note.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/note/edit");
            modelAndView.addObject("note", note);
            modelAndView.addObject("noteTypes", iNoteTypeService.findAll());
            return modelAndView;
        }else {
            return null;
        }
    }

    @PostMapping("edit-note")
    public ModelAndView editNote(@ModelAttribute("note") Note note){
        iNoteService.save(note);
        ModelAndView modelAndView = new ModelAndView("/note/list");
        modelAndView.addObject("notes", iNoteService.findAll());
        return modelAndView;
    }

    @GetMapping("search-note")
    public ModelAndView searchNote(@RequestParam("keyword") String keyword){
        List<Note> notes = iNoteService.searchNote(keyword);
        ModelAndView modelAndView = new ModelAndView("/note/list");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }
}
