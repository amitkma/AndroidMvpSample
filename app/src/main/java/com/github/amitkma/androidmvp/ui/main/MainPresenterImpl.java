package com.github.amitkma.androidmvp.ui.main;

import android.os.Handler;

import com.github.amitkma.androidmvp.data.DataManager;
import com.github.amitkma.androidmvp.data.model.Note;

/**
 * Created by amit on 1/6/17.
 */

public class MainPresenterImpl implements MainContract.Presenter {

    private final MainContract.View mView;
    private final DataManager mDataManager;

    public MainPresenterImpl(MainContract.View view, DataManager dataManager) {
        this.mView = view;
        mDataManager = dataManager;
        mView.setPresenter(this);
    }

    @Override
    public void addNote(String note) {
        if(note != null && note.length() > 0)
        mView.updateView(mDataManager.addNote(new Note(mDataManager.getNoteListSize() + 1, note)));
    }

    @Override
    public void removeNote(final Note note) {
        mView.updateView(mDataManager.removeNote(note));
    }

    @Override
    public void getAllNotes() {
        mView.showProgress();

        // Delay to simulate api as remote api.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.updateView(mDataManager.getAllNotes());
                mView.hideProgress();
            }
        }, 3000);
    }

    @Override
    public void clearAll() {
        mView.showProgress();

        // Delay to simulate api as remote api.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.updateView(mDataManager.removeAllNotes());
                mView.hideProgress();
            }
        }, 3000);
    }
}
