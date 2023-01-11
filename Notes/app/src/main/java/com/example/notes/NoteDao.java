package com.example.notes;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao //data access object
public interface NoteDao {
    @Query("INSERT INTO notes (contents) VALUES ('New Note') ") //These are the anotations provided by the room library we implemented.
    void create();
    /* whenever the create method will be called the Query written above will be used . or work. */

    @Query("SELECT * FROM notes")
    List<Note> getAllNotes();

    @Query("UPDATE notes SET contents =:contents WHERE id=:id")
    void save(String contents ,int id);

}
