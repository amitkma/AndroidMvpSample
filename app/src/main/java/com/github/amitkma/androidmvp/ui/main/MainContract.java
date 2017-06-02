package com.github.amitkma.androidmvp.ui.main;

import com.github.amitkma.androidmvp.data.model.Note;
import com.github.amitkma.androidmvp.ui.base.MvpPresenter;
import com.github.amitkma.androidmvp.ui.base.MvpView;

import java.util.List;

/**
 * Created by amit on 1/6/17.
 */

public interface MainContract {

    interface View extends MvpView<Presenter> {

        void updateView(List<Note> items);
    }

    interface Presenter extends MvpPresenter{
        void addNote(String note);

        void removeNote(Note note);

        void getAllNotes();

        void clearAll();
    }
}
