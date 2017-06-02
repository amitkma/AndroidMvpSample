package com.github.amitkma.androidmvp.data.model;

/**
 * Created by amit on 2/6/17.
 */

public class Note {
    private final int mId;
    private final String mNote;

    public Note(int mId, String mNote) {
        this.mId = mId;
        this.mNote = mNote;
    }

    public int getId() {
        return mId;
    }

    public String getNote() {
        return mNote;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Note note = (Note) obj;
        if(mNote != null ? !mNote.equals(note.getNote()) : note.getNote() != null) return false;

        return mId == note.getId();

    }

    @Override
    public int hashCode() {
        return mId * 53;
    }
}
