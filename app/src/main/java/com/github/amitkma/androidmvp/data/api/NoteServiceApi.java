package com.github.amitkma.androidmvp.data.api;

import com.github.amitkma.androidmvp.data.model.Note;

import java.util.List;

/**
 * Created by amit on 2/6/17.
 */

public interface NoteServiceApi {

    List<Note> addNote(Note note);

    List<Note> removeNote(Note note);

    List<Note> getAllNotes();

    List<Note> removeAllNotes();
}
