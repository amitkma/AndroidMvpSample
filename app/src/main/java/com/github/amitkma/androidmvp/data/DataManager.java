package com.github.amitkma.androidmvp.data;

import com.github.amitkma.androidmvp.data.api.NoteServiceApi;
import com.github.amitkma.androidmvp.data.model.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit on 2/6/17.
 */

public class DataManager implements NoteServiceApi {

    private static DataManager sInstance;
    private List<Note> noteList;

    private DataManager() {
        noteList = new ArrayList<>();
    }

    public static DataManager getInstance() {
        if (sInstance == null) {
            sInstance = new DataManager();
        }
        return sInstance;
    }

    @Override
    public List<Note> addNote(Note note) {
        noteList.add(note);
        return noteList;
    }

    @Override
    public List<Note> removeNote(Note note) {
        noteList.remove(note);
        return noteList;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteList;
    }

    @Override
    public List<Note> removeAllNotes() {
        noteList.clear();
        return noteList;
    }

    public int getNoteListSize(){
        return noteList.size();
    }
}
