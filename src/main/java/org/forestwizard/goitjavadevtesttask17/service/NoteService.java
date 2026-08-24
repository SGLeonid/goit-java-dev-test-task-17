package org.forestwizard.goitjavadevtesttask17.service;

import lombok.RequiredArgsConstructor;
import org.forestwizard.goitjavadevtesttask17.data.Note;
import org.forestwizard.goitjavadevtesttask17.exception.DatabaseServiceException;
import org.forestwizard.goitjavadevtesttask17.repository.INoteRepository;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService implements ICrudService<Note, Long> {
    private final INoteRepository INoteRepository;

    public List<Note> listAll() {
        return INoteRepository.findAll();
    }

    public Note add(Note note) {
        return INoteRepository.save(note);
    }

    public void update(Note note) throws DatabaseServiceException {
        try {
            INoteRepository.save(note);
        } catch (IllegalArgumentException e) {
            throw new DatabaseServiceException("The given note is null", e);
        } catch (OptimisticLockingFailureException e) {
            throw new DatabaseServiceException("The note doesn't exist", e);
        }
    }

    public void deleteById(Long id) throws DatabaseServiceException {
        try {
            INoteRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw new DatabaseServiceException("The given note is null", e);
        } catch (OptimisticLockingFailureException e) {
            throw new DatabaseServiceException("The note doesn't exist", e);
        }
    }

    public Note getById(Long id) throws DatabaseServiceException {
        return INoteRepository.findById(id).orElseThrow(
                () -> new DatabaseServiceException("Note with requested ID not found")
        );
    }

    public List<Note> findByTitle(String title) {
        return INoteRepository.findAllByNoteLike(title);
    }
}
