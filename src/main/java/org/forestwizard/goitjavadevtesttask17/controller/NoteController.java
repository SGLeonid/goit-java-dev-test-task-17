package org.forestwizard.goitjavadevtesttask17.controller;

import lombok.RequiredArgsConstructor;
import org.forestwizard.goitjavadevtesttask17.data.Note;
import org.forestwizard.goitjavadevtesttask17.exception.DatabaseServiceException;
import org.forestwizard.goitjavadevtesttask17.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private static final String LINK_REDIRECT = "/note/list";
    private static final String LINK_NOT_FOUND = "/note/not_found";
    private static final String TEMPLATE_NOTE_LIST = "/note/list";
    private static final String TEMPLATE_NOTE_EDIT = "/note/edit";
    private static final String TEMPLATE_NOT_FOUND = "/note/not_found";

    private final NoteService noteService;

    @GetMapping("list")
    public ModelAndView listAllNotes(@RequestParam(value = "title", required = false) String title) {
        List<Note> notes;

        if (title == null) {
            notes = noteService.listAll();
        } else {
            notes = noteService.findByTitle(title);
        }

        ModelAndView view = new ModelAndView(TEMPLATE_NOTE_LIST);
        view.addObject("notes", notes);
        view.addObject("search", title);
        return view;
    }

    @PostMapping("delete")
    public RedirectView deleteNote(@RequestParam Long id) {
        try {
            noteService.deleteById(id);
        } catch (DatabaseServiceException _) {
            return new RedirectView(LINK_NOT_FOUND);
        }

        return new RedirectView(LINK_REDIRECT);
    }

    @PostMapping("edit")
    public RedirectView postNote(@ModelAttribute Note note) {
        try {
            noteService.update(note);
        } catch (DatabaseServiceException _) {
            return new RedirectView(LINK_NOT_FOUND);
        }
        return new RedirectView(LINK_REDIRECT);
    }

    @GetMapping("edit")
    public ModelAndView editNote(@RequestParam Long id) {
        try {
            Note note = noteService.getById(id);
            ModelAndView view = new ModelAndView(TEMPLATE_NOTE_EDIT);
            view.addObject("note", note);
            return view;
        } catch (DatabaseServiceException _) {
            return notFound();
        }
    }

    @PostMapping("create")
    public RedirectView createNote() {
        Note note = new Note();
        note.setTitle("Untitled");
        noteService.add(note);
        return new RedirectView( TEMPLATE_NOTE_EDIT + "?id=" + note.getId());
    }

    @GetMapping("not_found")
    public ModelAndView notFound() {
        ModelAndView view = new ModelAndView(TEMPLATE_NOT_FOUND);
        view.setStatus(HttpStatus.NOT_FOUND);
        return view;
    }
}
