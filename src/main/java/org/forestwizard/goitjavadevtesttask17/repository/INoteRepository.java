package org.forestwizard.goitjavadevtesttask17.repository;

import org.forestwizard.goitjavadevtesttask17.data.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INoteRepository extends JpaRepository<Note, Long> {
    @Query(value = "SELECT * FROM NOTE_DB.NOTE WHERE title LIKE %:titleText%", nativeQuery = true)
    List<Note> findAllByNoteLike(@Param("titleText") String titleText);
}
